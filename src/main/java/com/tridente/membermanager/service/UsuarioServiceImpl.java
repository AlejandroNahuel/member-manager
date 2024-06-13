package com.tridente.membermanager.service;

import com.tridente.membermanager.dao.UsuarioDAO;
import com.tridente.membermanager.model.Rol;
import com.tridente.membermanager.model.Usuario;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Autowired
    private RolService rolService;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.findAll();
    }

    @Override
    public Usuario getUsuarioById(int id) {
        return usuarioDAO.findById(id).orElse(null);
    }

    @Override
    public void addUsuario(Usuario usuario) {
        
        String passwordEncoded = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncoded);
        
        Rol rol = rolService.getRolById(2);
        
        usuario.setRoles(Arrays.asList(rol));
        
        usuarioDAO.save(usuario);
    }

    @Override
    public void updateUsuario(int id, Usuario usuario) {
        if(usuarioDAO.existsById(id)){
            usuario.setId(id);
            usuarioDAO.save(usuario);
        }
    }

    @Override
    public void deleteUsuario(int id) {
        if(usuarioDAO.existsById(id))
            usuarioDAO.deleteById(id);
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        if(usuarioDAO.existsByEmail(email))
            return usuarioDAO.findByEmail(email);
        return null;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByEmail(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        
        return new User(usuario.getEmail(), usuario.getPassword(), mapAuthorityRoles(usuario.getRoles()));
    }
    
    private Collection<? extends GrantedAuthority> mapAuthorityRoles(Collection<Rol> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }
}
