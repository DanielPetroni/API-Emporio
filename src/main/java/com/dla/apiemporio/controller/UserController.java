package com.dla.apiemporio.controller;

import java.util.HashMap;

import com.dla.apiemporio.entity.Usuario;
import com.dla.apiemporio.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if (user == null || !Usuario.isValid(user) || user.getPasswordUser() == null) {
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody(required = false) Usuario user, @PathVariable("id") Long id) {
        if (user == null || Usuario.isValid(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        try {
            userService.updateUserById(id, user);
            HashMap<String, String> bodyResponse = new HashMap<String, String>();
            bodyResponse.put("message", "Usuário atualizado!");
            return new ResponseEntity<Object>(bodyResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        try {
            userService.deleteUserById(id);
            HashMap<String, String> bodyResponse = new HashMap<String, String>();
            bodyResponse.put("message", "Usuário deletado!");
            return new ResponseEntity<Object>(bodyResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
