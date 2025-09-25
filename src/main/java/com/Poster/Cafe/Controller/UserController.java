package com.Poster.Cafe.Controller;

import com.Poster.Cafe.DTO.UserDTO;
import com.Poster.Cafe.DTO.UserRoleDTO;
import com.Poster.Cafe.Service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Получить список всех пользователей
    //Адрес http://localhost:8080/api/users
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    //Зарегать пользователя
    //Адрес - http://localhost:8080/api/users
    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.regUser(userDTO);
    }

    //Удалить пользователя по id
    //Адрес - http://localhost:8080/api/users/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    //Обновить пользователя по id
    //Адрес - http://localhost:8080/api/users/{id}
    @PatchMapping("/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    //Сортировка по роли
    //Адрес - http://localhost:8080/api/users/role
    @PostMapping("/role")
    public List<UserDTO> getCertainRoleUsers(@RequestBody UserRoleDTO roleDTO) {
        return userService.sortRole(roleDTO);
    }

    //Найти пользователя по id
    //Адрес - http://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return userService.findById(id);
    }

}
