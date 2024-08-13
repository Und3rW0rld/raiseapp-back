package com.ashen.raiseback.controller;

import com.ashen.raiseback.dto.LoginDTO;
import com.ashen.raiseback.dto.UserDTO;
import com.ashen.raiseback.dto.UserMapper;
import com.ashen.raiseback.model.Entrepreneur;
import com.ashen.raiseback.model.Investor;
import com.ashen.raiseback.model.User;
import com.ashen.raiseback.model.UserType;
import com.ashen.raiseback.service.EntrepreneurService;
import com.ashen.raiseback.service.InvestorService;
import com.ashen.raiseback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private final EntrepreneurService entrepreneurService;
    private final InvestorService investorService;

    @Autowired
    public UserController(UserService userService, EntrepreneurService entrepreneurService, InvestorService investorService){
        this.userService = userService;
        this.entrepreneurService = entrepreneurService;
        this.investorService = investorService;
    }

    @GetMapping("/test")
    public String test(){
        return"hola user controller";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        // Validar si el email ya está registrado
        if (userService.existsByEmail(userDTO.getEmail()) != null) {
            return new ResponseEntity<>("Email already in use.", HttpStatus.BAD_REQUEST);
        }

        // Convertir el UserDTO a una entidad User
        User user = UserMapper.toEntity(userDTO);

        // Validaciones de campos
        if (user.getName().isEmpty()) {
            return new ResponseEntity<>("Error: the name is empty.", HttpStatus.BAD_REQUEST);
        }
        if (user.getEmail().isEmpty()) {
            return new ResponseEntity<>("Error: the email is empty.", HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword().isEmpty()) {
            return new ResponseEntity<>("Error: the password is empty.", HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword().length() < 6) {
            return new ResponseEntity<>("Error: the password must be at least 6 characters.", HttpStatus.BAD_REQUEST);
        }
        if (user.getType() != UserType.ENTREPRENEUR && user.getType() != UserType.INVESTOR) {
            return new ResponseEntity<>("Error: User Type is not correct.", HttpStatus.BAD_REQUEST);
        }

        // Guardar el nuevo usuario en la base de datos
        userService.createUser(user);

        // Crear entidad correspondiente y guardar en la base de datos
        if (user.getType() == UserType.ENTREPRENEUR) {
            Entrepreneur entrepreneur = new Entrepreneur();
            entrepreneur.setUser(user);
            entrepreneurService.createEntrepreneur(entrepreneur);
        } else if (user.getType() == UserType.INVESTOR) {
            Investor investor = new Investor();
            investor.setUser(user);
            investorService.createInvestor(investor);
        }

        // Devolver una respuesta exitosa
        return new ResponseEntity<>("User registered successfully.", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody LoginDTO loginDTO ){
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        User user = userService.existsByEmail(email);

        if (user == null) {
            return new ResponseEntity<>("User with that email not found.", HttpStatus.NOT_FOUND);
        }else if (!user.getPassword().equals(password)){
            return new ResponseEntity<>("Password is incorrect.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            boolean deleted = userService.deleteUserById(id);
            if (!deleted) {
                return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
