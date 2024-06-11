package com.tridente.membermanager.service;

import com.tridente.membermanager.model.Socio;
import java.util.List;

public interface SocioService {
    public List<Socio> getAllSocios();
    public Socio getSocioById(int id);
    public void addSocio(Socio socio);
    public void updateSocio(int id, Socio socio);
    public void deleteSocio(int id);
    public Socio getSocioByDni(String dni);
}
