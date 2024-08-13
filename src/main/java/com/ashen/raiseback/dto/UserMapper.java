package com.ashen.raiseback.dto;

import com.ashen.raiseback.model.User;
import com.ashen.raiseback.model.UserType;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getType().name(),  // Asumiendo que UserType es un enum
                user.getPublicKey(),
                user.getPassword()      // Incluye la contraseña
        );
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setType(UserType.valueOf(userDTO.getType().toUpperCase()));  // Asumiendo que UserType es un enum
        user.setPublicKey(userDTO.getPublicKey());
        user.setPassword(userDTO.getPassword());  // Incluye la contraseña
        return user;
    }
}
