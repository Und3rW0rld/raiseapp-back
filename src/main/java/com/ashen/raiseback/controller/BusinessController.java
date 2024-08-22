package com.ashen.raiseback.controller;


import com.ashen.raiseback.model.Business;
import com.ashen.raiseback.model.Entrepreneur;
import com.ashen.raiseback.model.User;
import com.ashen.raiseback.service.BusinessService;
import com.ashen.raiseback.service.EntrepreneurService;
import com.ashen.raiseback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class BusinessController {



    @Value("${server.port}")
    private String port;
    private final BusinessService businessService;
    private final UserService userService;
    private final EntrepreneurService entrepreneurService;


    @Autowired
    public BusinessController(BusinessService businessService, UserService userService, EntrepreneurService entrepreneurService){
        this.businessService = businessService;
        this.userService = userService;
        this.entrepreneurService = entrepreneurService;
    }

    @GetMapping("/businesses")
    public ResponseEntity<?> getAllBusiness () {
        List<Business> businessList = businessService.getAllBusiness();
        return new ResponseEntity<>(businessList, HttpStatus.OK);
    }

    @GetMapping("/businesses/{id}/average-score")
    public ResponseEntity<?> getAverageScore(@PathVariable("id") Long id) {
        Optional<Business> businessOptional = businessService.getBusinessById(id);

        if ( businessOptional.isPresent() ){
            Business business = businessOptional.get();
            Double averageScore = business.getAverageScore();
            return ResponseEntity.ok(averageScore);
        }

        return new ResponseEntity<>("Business with id given not found", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/business/{id}/value")
    public ResponseEntity<?> getValue( @PathVariable("id") long id ){
        Optional<Business> businessOptional = businessService.getBusinessById(id);

        if ( businessOptional.isPresent() ){
            Business business = businessOptional.get();
            Double value = business.getValue();
            return ResponseEntity.ok(value);
        }

        return new ResponseEntity<>("Business with id given not found", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/business/user/{id}")
    public ResponseEntity<?> getBusinessUserId( @PathVariable (name="id") long userId){
        Optional<Entrepreneur> entrepreneurOptional = entrepreneurService.getEntrepreneurByUserId(userId);

        if (entrepreneurOptional.isEmpty()) {
            return new ResponseEntity<>("Entrepreneur with given id was not found", HttpStatus.BAD_REQUEST);
        }

        Entrepreneur entrepreneur = entrepreneurOptional.get();

        List<Business> businesses = this.businessService.getBusinessByEntrepreneurId(entrepreneur.getId());

        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }


    @PostMapping("/businesses/create")
    public ResponseEntity<String> createBusiness(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("contact_message") String contactMessage,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("facebook") String facebook,
            @RequestParam("instagram") String instagram,
            @RequestParam("city") String city,
            @RequestParam("address") String address,
            @RequestParam("wallet_key") String walletKey,
            @RequestParam("mainImage") MultipartFile mainImage,
            @RequestParam("additionalImages") MultipartFile[] additionalImages,
            @RequestParam("user_id") long userId) {

        Optional<Entrepreneur> entrepreneurOptional = entrepreneurService.getEntrepreneurByUserId(userId);

        if (entrepreneurOptional.isEmpty()) {
            return new ResponseEntity<>("Entrepreneur with given id was not found", HttpStatus.BAD_REQUEST);
        }

        Entrepreneur entrepreneur = entrepreneurOptional.get();

        try {
            // Guardar la imagen principal
            String mainImagePath = saveImage(mainImage);

            // Guardar las imágenes adicionales
            List<String> additionalImagePaths = new ArrayList<>();
            for (MultipartFile image : additionalImages) {
                additionalImagePaths.add(saveImage(image));
            }

            // Crear el objeto Business y asignar los valores
            Business business = new Business();
            business.setName(name);
            business.setDescription(description);
            business.setContact_message(contactMessage);
            business.setEmail(email);
            business.setPhone(phone);
            business.setFacebook(facebook);
            business.setInstagram(instagram);
            business.setCity(city);
            business.setAddress(address);
            business.setWallet_key(walletKey);
            business.setImage(mainImagePath);
            business.setImages(additionalImagePaths);
            business.setEntrepreneur(entrepreneur);

            // Guardar el objeto Business en la base de datos (debes implementar el servicio correspondiente)
            businessService.createBusiness(business);

            return new ResponseEntity<>(business+"Business created successfully.", HttpStatus.CREATED);

        } catch (IOException e) {
            return new ResponseEntity<>("Error uploading images", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private String saveImage(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new IOException("Failed to store empty file");
        }

        // Definir la ruta donde se guardará la imagen
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path path = Paths.get("uploads/" + fileName);

        // Crear la carpeta de destino si no existe
        Files.createDirectories(path.getParent());

        // Guardar la imagen
        Files.write(path, image.getBytes());

        // Devolver la URL completa de la imagen
        return "http://localhost:" + port + "/api/v1/uploads/" + fileName;
    }


}
