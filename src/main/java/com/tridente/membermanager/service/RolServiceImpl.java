package com.tridente.membermanager.service;

import com.tridente.membermanager.dao.RolDAO;
import com.tridente.membermanager.model.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolDAO rolDAO;
    
    @Override
    public List<Rol> getAllRoles() {
        return rolDAO.findAll();
    }

    @Override
    public Rol getRolById(int id) {
        return rolDAO.findById(id).orElse(null);
    }

    @Override
    public void addRole(Rol rol) {
        rolDAO.save(rol);
    }

    @Override
    public void updateRol(int id, Rol rol) {
        if(rolDAO.existsById(id)){
            rol.setId(id);
            rolDAO.save(rol);
        }
    }

    @Override
    public void deleteRol(int id) {
        if(rolDAO.existsById(id))
            rolDAO.deleteById(id);
    }
}
