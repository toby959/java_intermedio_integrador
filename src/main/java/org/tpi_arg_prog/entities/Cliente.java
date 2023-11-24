    package org.tpi_arg_prog.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcliente;
    private String razon_social;
    private String cuit;
    private String servicios_contratados;
    private int incidente_idincidente;
    private int incidente_problema_idproblema;

//  `idcliente` INT NOT NULL AUTO_INCREMENT,
//  `razon_social` VARCHAR(45) NOT NULL,
//  `cuit` VARCHAR(45) NOT NULL,
//  `servicios_contratados` VARCHAR(65) NOT NULL,
//  `incidente_idincidente` INT NOT NULL,
//            `incidente_problema_idproblema` INT NOT NULL,
//    PRIMARY KEY (`idcliente`),
//    INDEX `fk_cliente_incidente1_idx` (`incidente_idincidente` ASC, `incidente_problema_idproblema` ASC) VISIBLE,
//    CONSTRAINT `fk_cliente_incidente1`
//    FOREIGN KEY (`incidente_idincidente` , `incidente_problema_idproblema`)
//    REFERENCES `empresaSoluciones`.`incidente` (`idincidente` , `problema_idproblema`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION)

}
