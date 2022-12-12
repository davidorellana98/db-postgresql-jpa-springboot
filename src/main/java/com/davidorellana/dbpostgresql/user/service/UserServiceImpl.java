package com.davidorellana.dbpostgresql.user.service;

import com.davidorellana.dbpostgresql.user.model.data.User;
import com.davidorellana.dbpostgresql.user.model.dto.UserDto;
import com.davidorellana.dbpostgresql.user.repository.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Lazy
    private UserRepositoryDao userRepositoryDao;

    @Override
    public List<User> getAllUsers() {
        return userRepositoryDao.getAllUsers();
    }

    @Override
    public User findUserById(Long idUser) {
        return userRepositoryDao.findUserById(idUser);
    }

    @Override
    public User createUser(UserDto userDto) {
        return userRepositoryDao.createUser(userDto);
    }

    @Override
    public User updateUserById(Long idUser, UserDto userDto) {
        return userRepositoryDao.updateUserById(idUser, userDto);
    }

    @Override
    public Boolean deleteUserById(Long idUser) {
        return userRepositoryDao.deleteUserById(idUser);
    }
}
