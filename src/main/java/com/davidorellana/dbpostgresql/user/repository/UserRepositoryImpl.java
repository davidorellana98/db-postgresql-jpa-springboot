package com.davidorellana.dbpostgresql.user.repository;

import com.davidorellana.dbpostgresql.user.model.data.User;
import com.davidorellana.dbpostgresql.user.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryDao {

    @Autowired
    @Lazy
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long idUser) {
        Optional<User> findUser = userRepository.findById(idUser);
        if (findUser.isPresent()) {
            return findUser.get();
        }
        return null;
    }

    @Override
    public User createUser(UserDto userDto) {
        User newUser = new User(userDto);
        return userRepository.save(newUser);
    }

    @Override
    public User updateUserById(Long idUser, UserDto userDto) {
        User userFound = findUserById(idUser);
        if (userFound != null) {
            userFound.setName(userDto.getName());
            userFound.setLastName(userDto.getLastName());
            userFound.setIdentificationCard(userDto.getIdentificationCard());
            userFound.setBirthDate(userDto.getBirthDate());
            userFound.setPhone(userDto.getPhone());
            userFound.setEmail(userDto.getEmail());
            return userRepository.save(userFound);
        }
        return null;
    }

    @Override
    public Boolean deleteUserById(Long idUser) {
        if (userRepository.existsById(idUser)) {
            userRepository.deleteById(idUser);
            return true;
        }
        return false;
    }
}
