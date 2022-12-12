package com.davidorellana.dbpostgresql.user.repository;

import com.davidorellana.dbpostgresql.user.model.data.User;
import com.davidorellana.dbpostgresql.user.model.dto.UserDto;
import org.apache.catalina.UserDatabase;

import java.util.List;

public interface UserRepositoryDao {

    List<User> getAllUsers();
    User findUserById(Long idUser);
    User createUser(UserDto userDto);
    User updateUserById(Long idUser, UserDto userDto);
    Boolean deleteUserById(Long idUser);
}
