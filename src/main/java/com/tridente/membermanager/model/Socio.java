package com.tridente.membermanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "socios")
public class Socio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "dni")
    private String dni;
}
