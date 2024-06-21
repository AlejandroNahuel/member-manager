package com.tridente.membermanager.controller;

import com.tridente.membermanager.model.Socio;
import com.tridente.membermanager.model.Usuario;
import com.tridente.membermanager.service.SocioService;
import com.tridente.membermanager.service.UsuarioService;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    private Socio socio;

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    SocioService socioService;
        
    @ModelAttribute("usuario")
    public Usuario retornarUsuario(){
        return new Usuario();
    }

    @ModelAttribute("socio")
    public Socio retornarSocio(){
        return new Socio();
    }
    
    @GetMapping(value= "/login")
    public String login(){
        return "login";
    }
    
    @GetMapping(value="/index")
    public String index(Model model){
        
        
        
        model.addAttribute("socio", this.socio);

        return "index";
    }
    
    @GetMapping(value="/")
    public String home(Model model){
        
        if(this.socio != null)
        
        model.addAttribute("socio", this.socio);

        return "index";
    }
    
    @GetMapping(value= "/registro")
    public String formularioRegistro(){
        return "registro";
    }
    
    @PostMapping(value="/registro")
    public String registroUsuario(Usuario usuario){
        
        usuarioService.addUsuario(usuario);
        
        return "redirect:/registro?exito";
    }
    
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/socios/buscar")
    public String buscarSocio(@ModelAttribute("socio") Socio socio){

        this.socio =  socioService.getSocioByDni(socio.getDni());

        this.socio.setMembershipExpired(this.socio.getFechaVenc().isBefore(LocalDate.now()));

        socioService.updateSocio(this.socio.getId(), this.socio);


        return "redirect:../";
    }
}
