package com.davidorellana.dbpostgresql.user.controller;

import com.davidorellana.dbpostgresql.user.model.data.User;
import com.davidorellana.dbpostgresql.user.model.dto.UserDto;
import com.davidorellana.dbpostgresql.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> listAllUsers = userService.getAllUsers();
        if (listAllUsers.isEmpty()) {
            return new ResponseEntity("There are no users to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(listAllUsers, HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> findUserById(@PathVariable Long idUser) {
        User userById = userService.findUserById(idUser);
        if (userById != null) {
            return new ResponseEntity<>(userById, HttpStatus.OK);
        }
        return new ResponseEntity("That user id does not exist!", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        User userValidation = userService.createUser(userDto);
        if (userValidation != null) {
            return new ResponseEntity("Created user!", HttpStatus.CREATED);
        }
        return new ResponseEntity("User not created!", HttpStatus.CONFLICT);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<User> updateUserById(@PathVariable Long idUser, @RequestBody @Valid UserDto userDto) {
        User userUpdated = userService.updateUserById(idUser, userDto);
        if (userUpdated != null){
            return new ResponseEntity("Updated user!", HttpStatus.OK);
        }

        return new ResponseEntity("User not updated by id not found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity deleteUserById(@PathVariable Long idUser) {
        Boolean isDeletedUserById = userService.deleteUserById(idUser);
        if (isDeletedUserById) {
            return new ResponseEntity("Deleted user!", HttpStatus.OK);
        }
        return new ResponseEntity("The user does not exist to be deleted!", HttpStatus.NOT_FOUND);
    }
}
