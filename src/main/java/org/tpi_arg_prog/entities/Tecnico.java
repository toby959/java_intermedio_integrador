package org.tpi_arg_prog.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtecnico;
    private String nombre;
    private String especialidades; //es list de especialidades
    private int medio_not_preferido;

//  `idtecnico` INT NOT NULL AUTO_INCREMENT,
//  `nombre` VARCHAR(45) NOT NULL,
//  `especialidades` VARCHAR(65) NULL,
//  `medio_not_preferido` INT NOT NULL,
//   PRIMARY KEY (`idtecnico`))

}
