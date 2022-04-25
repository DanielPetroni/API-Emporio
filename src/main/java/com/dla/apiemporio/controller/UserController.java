package com.dla.apiemporio.controller;

import com.dla.apiemporio.entity.Usuario;
import com.dla.apiemporio.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public Usuario create(@RequestBody(required = false) Usuario user) {
        if (user == null || !Usuario.isValid(user) || user.getPasswordUser() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
            try {
                user.setEmailUser(user.getEmailUser().toLowerCase());
                userService.save(user);
                return user;
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
            }
    }

    @GetMapping("/{id}")
    public Usuario getUser(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            userService.deleteUserById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void update(@RequestBody(required = false) Usuario user, @PathVariable("id") Long id) {
        if (user == null || Usuario.isValid(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        try {
            userService.updateUserById(id, user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
