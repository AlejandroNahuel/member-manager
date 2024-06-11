package com.tridente.membermanager.service;

import com.tridente.membermanager.model.Rol;
import java.util.List;

public interface RolService {
    public List<Rol> getAllRoles();
    public Rol getRolById(int id);
    public void addRole(Rol rol);
    public void updateRol(int id, Rol rol);
    public void deleteRol(int id);
}
