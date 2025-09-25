package com.Poster.Cafe.Mapper;

import com.Poster.Cafe.DTO.UserDTO;
import com.Poster.Cafe.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //Из DTO в сущность
    public User toEntity(UserDTO userDTO) {

        User user = new User();

        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setPhone(userDTO.getPhone());

        return user;
    }

    //Из сущности в DTO
    public UserDTO toDTO(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setPhone(user.getPhone());

        return userDTO;
    }

}
