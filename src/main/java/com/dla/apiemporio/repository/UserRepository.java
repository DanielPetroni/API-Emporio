package com.dla.apiemporio.repository;

import java.util.List;

import com.dla.apiemporio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEmailUser(String email);
}
