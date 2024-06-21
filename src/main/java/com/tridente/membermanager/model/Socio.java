package com.tridente.membermanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
@Table(name = "socios")
public class Socio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private int id;
    
    @Column(name = "nombre")
    private String name;
    
    @Column(name = "apellido")
    private String lastname;
    
    @Column(name = "dni")
    private String dni;

    @Column(name="fecha_pago")
    private LocalDate fechaPago;

    @Column(name="fecha_vencimiento")
    private LocalDate fechaVenc;

    @Column(name = "cuota_vencida")
    private boolean membershipExpired;
}
