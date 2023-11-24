package org.tpi_arg_prog.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproblema;
    private String descripcion;
    private int tiempo_max_resolucion;
    private String esp_requerida_resolver;


//  `idproblema` INT NOT NULL AUTO_INCREMENT,
//  `descripcion` VARCHAR(65) NOT NULL,
//  `tiempo_max_resolucion` INT NOT NULL,
//   `esp_requerida_resolver` VARCHAR(65) NOT NULL,
//    PRIMARY KEY (`idproblema`))

}
