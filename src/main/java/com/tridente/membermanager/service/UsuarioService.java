package com.tridente.membermanager.service;

import com.tridente.membermanager.model.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService{
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuarioById(int id);
    public void addUsuario(Usuario usuario);
    public void updateUsuario(int id, Usuario usuario);
    public void deleteUsuario(int id);
    public Usuario getUsuarioByEmail(String email);
}
