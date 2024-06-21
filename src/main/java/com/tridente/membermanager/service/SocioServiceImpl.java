package com.tridente.membermanager.service;

import com.tridente.membermanager.dao.SocioDAO;
import com.tridente.membermanager.model.Socio;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SocioServiceImpl implements SocioService{
    
    @Autowired
    private SocioDAO socioDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Socio> getAllSocios() {
        return socioDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Socio getSocioById(int id) {
        return socioDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void addSocio(Socio socio) {
        
        LocalDate fechaPago = LocalDateTime.now().toLocalDate();

        socio.setFechaPago(fechaPago);

        socio.setFechaVenc(fechaPago.plusDays(30));
        
        socioDAO.save(socio);
    }

    @Override
    @Transactional
    public void updateSocio(int id, Socio socio) {
        if(socioDAO.existsById(id)){
            socio.setId(id);
            socioDAO.save(socio);
        }
    }

    @Override
    @Transactional
    public void deleteSocio(int id) {
        if(socioDAO.existsById(id))
            socioDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Socio getSocioByDni(String dni) {
        return socioDAO.findByDni(dni);
    }
}
