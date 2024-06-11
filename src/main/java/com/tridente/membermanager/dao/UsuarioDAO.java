package com.tridente.membermanager.dao;

import com.tridente.membermanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{
    public Usuario findByEmail(String email);
    public boolean existsByEmail(String email);
}
