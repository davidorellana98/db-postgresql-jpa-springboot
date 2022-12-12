package com.davidorellana.dbpostgresql.user.service;

import com.davidorellana.dbpostgresql.user.model.data.User;
import com.davidorellana.dbpostgresql.user.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User findUserById(Long idUser);
    User createUser(UserDto userDto);
    User updateUserById(Long idUser, UserDto userDto);
    Boolean deleteUserById(Long idUser);
}
