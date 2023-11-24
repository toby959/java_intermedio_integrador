package org.tpi_arg_prog.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idservicio;
    private String nombre;
    private String problemas_relacionados; //es list de problemas?

//  `idservicio` INT NOT NULL AUTO_INCREMENT,
//  `nombre` VARCHAR(45) NOT NULL,
//  `problemas_relacionados` VARCHAR(45) NOT NULL,


}
