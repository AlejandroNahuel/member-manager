package com.tridente.membermanager.dao;

import com.tridente.membermanager.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioDAO extends JpaRepository<Socio, Integer>{
    public Socio findByDni(String dni);
}
