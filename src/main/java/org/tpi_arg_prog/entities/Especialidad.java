package org.tpi_arg_prog.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idespecialidad;
    private String nombre;

//  `idespecialidad` INT NOT NULL AUTO_INCREMENT,
//  `nombre` VARCHAR(45) NOT NULL,
//    PRIMARY KEY (`idespecialidad`))

}
