package com.tridente.membermanager.dao;

import com.tridente.membermanager.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDAO extends JpaRepository<Rol, Integer>{
    
}
