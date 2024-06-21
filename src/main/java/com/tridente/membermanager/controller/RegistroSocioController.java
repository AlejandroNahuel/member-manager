package com.tridente.membermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tridente.membermanager.model.Socio;
import com.tridente.membermanager.service.SocioService;

@Controller
@RequestMapping("/socios")
public class RegistroSocioController {
    
    @Autowired
    private SocioService socioService;

    @ModelAttribute("socio")
    public Socio retornarSocio(){
        return new Socio();
    }

    @GetMapping
    public String formularioRegistro(){
        return "formulario-registro";
    }

    @PostMapping("/registro")
    public String registrarSocio(@ModelAttribute("socio") Socio socio){
        socioService.addSocio(socio);
        return "redirect:/socios?success";
    }
}
