package com.Poster.Cafe.Service;

import com.Poster.Cafe.DTO.UserDTO;
import com.Poster.Cafe.DTO.UserRoleDTO;
import com.Poster.Cafe.Entity.User;
import com.Poster.Cafe.Mapper.UserMapper;
import com.Poster.Cafe.Repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Получить всех пользователей
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user-> userMapper.toDTO(user))
                .collect(Collectors.toList());

    }

    //Зарегистрировать пользователя
    public UserDTO regUser(UserDTO userDTO) {

        if(userDTO != null && userDTO.getLogin() != null && userDTO.getPassword() != null && userDTO.getRole() != null && userDTO.getPhone() != null) {

            User newUser = new User();

            newUser = userMapper.toEntity(userDTO);
            userRepository.save(newUser);
            LOGGER.info("New user registered with Login: {} , Role: {}", userDTO.getLogin(), userDTO.getRole());
        }

        else{

            LOGGER.error("User data incorrect: {}" , userDTO);

        }

        return userDTO;

    }

    //Обновить пользователя
    public UserDTO updateUser(int id,UserDTO userDTO) {

        User user = userRepository.findById(id);

        if(userDTO != null){

            if(userDTO.getLogin() != null){
                user.setLogin(userDTO.getLogin());
                LOGGER.info("Поле Login было успешно обновлено: {}", userDTO.getLogin());
            }
            else {
                LOGGER.error("Ошибка обновления поля Login: {}", userDTO.getLogin());
            }

            if(userDTO.getPassword() != null){
                user.setPassword(userDTO.getPassword());
                LOGGER.info("Поле Password было успешно обновлено: {}", userDTO.getPassword());
            }
            else{
                LOGGER.error("Ошибка обновления поля Password: {}", userDTO.getPassword());
            }

            if(userDTO.getRole() != null){
                user.setRole(userDTO.getRole());
                LOGGER.info("Поле Role было успешно обновлено: {}", userDTO.getRole());
            }
            else{
                LOGGER.error("Ошибка обновления поля Role: {}", userDTO.getRole());
            }

            if(userDTO.getPhone() != null){
                user.setPhone(userDTO.getPhone());
                LOGGER.info("Поле Phone было успешно обновлено: {}", userDTO.getPhone());
            }
            else{
                LOGGER.error("Ошибка обновления поля Phone: {}", userDTO.getPhone());
            }

            userRepository.save(user);

        }

        return userMapper.toDTO(userRepository.findById(id));

    }

    //Удалить пользователя
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    //Сортировка по роли пользователя
    public List<UserDTO> sortRole(UserRoleDTO userRoleDTO){

        List<User> users = userRepository.findByRole(userRoleDTO.getRole());

        return users.stream()
                .filter(user -> user.getRole().equals(userRoleDTO.getRole()))
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());

    }

    //Найти пользователя по id
    public UserDTO findById(int id) {

        return userMapper.toDTO(userRepository.findById(id));

    }

}
