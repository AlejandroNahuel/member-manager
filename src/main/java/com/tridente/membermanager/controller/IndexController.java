package com.tridente.membermanager.controller;

import com.tridente.membermanager.model.Usuario;
import com.tridente.membermanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    
    @Autowired
    UsuarioService usuarioService;
        
    @ModelAttribute("usuario")
    public Usuario retornarUsuario(){
        return new Usuario();
    }
    
    @GetMapping(value= "/login")
    public String login(){
        return "login";
    }
    
    @GetMapping(value="/")
    public String index(){
        return "index";
    }
    
    @GetMapping(value= "/registro")
    public String formularioRegistro(){
        return "registro";
    }
    
    @PostMapping(value="/registro")
    public String registroUsuario(@ModelAttribute("usuario") Usuario usuario){
        usuarioService.addUsuario(usuario);
        
        return "redirect:/registro?exito";
    }
    
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
