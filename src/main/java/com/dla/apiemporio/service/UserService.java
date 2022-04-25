package com.dla.apiemporio.service;

import java.util.List;

import com.dla.apiemporio.entity.Usuario;
import com.dla.apiemporio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Usuario save(Usuario user) throws Exception {
        List<Usuario> userExist = userRepository.findByEmailUser(user.getEmailUser());
        if (userExist.size() > 0) {
            throw new Exception("Usuário já cadastrado!");
        }
        userRepository.save(user);
        return user;
    }

    public Usuario getUserById(Long id) {
        return userRepository.getById(id);
    }

    public void deleteUserById(Long id) throws Exception {
        Usuario produto = userRepository.getById(id);
        if (produto != null) {
            userRepository.deleteById(id);
        } else {
            throw new Exception("Usuário não encontrado!");
        }

    }

    public void updateUserById(Long id, Usuario user) throws Exception {
        Usuario produtoFinded = userRepository.getById(id);
        if (produtoFinded != null) {
            produtoFinded.setByObject(user);
            userRepository.save(produtoFinded);
        } else {
            throw new Exception("Usuário não encontrado!");
        }
    }
}
