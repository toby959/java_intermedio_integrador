package org.tpi_arg_prog.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "incidente")
public class Indidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idincidente;
    private String cliente;  //este es el id de cliente: int
    private String servicio_afectado;
    private String descripcion_problema;
    private String tipo_problema;
    private String tecnico_asignado; //esto es id de tecnico: int
    private int tiempo_estimado_resolucion; //esto es time
    private int estado_abierto_resuelto; //esto debe ser un enum; es la base para patrón state
    private String comentarios_resolucion;
    private int tecnico_idtecnico;
    private int problema_idproblema;
    private int servicio_idservicio;
    private String ;
    private String ;

//  `idincidente` INT NOT NULL AUTO_INCREMENT,
//  `cliente` VARCHAR(45) NOT NULL,
//  `servicio_afectado` VARCHAR(65) NOT NULL,
//  `descripcion_problema` VARCHAR(65) NOT NULL,
//  `tipo_problema` VARCHAR(65) NOT NULL,
//  `tecnico_asignado` VARCHAR(45) NOT NULL,
//  `tiempo_estimado_resolucion` INT NOT NULL,
//            `estado_abierto_resuelto` TINYINT NOT NULL,
//            `comentarios_resolucion` VARCHAR(65) NOT NULL,
//  `tecnico_idtecnico` INT NOT NULL,
//            `problema_idproblema` INT NOT NULL,
//            `servicio_idservicio` INT NOT NULL,
//    PRIMARY KEY (`idincidente`, `problema_idproblema`, `servicio_idservicio`),
//    INDEX `fk_incidente_tecnico1_idx` (`tecnico_idtecnico` ASC) VISIBLE,
//    INDEX `fk_incidente_problema1_idx` (`problema_idproblema` ASC) VISIBLE,
//    INDEX `fk_incidente_servicio1_idx` (`servicio_idservicio` ASC) VISIBLE,
//    CONSTRAINT `fk_incidente_tecnico1`
//    FOREIGN KEY (`tecnico_idtecnico`)
//    REFERENCES `empresaSoluciones`.`tecnico` (`idtecnico`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION,
//    CONSTRAINT `fk_incidente_problema1`
//    FOREIGN KEY (`problema_idproblema`)
//    REFERENCES `empresaSoluciones`.`problema` (`idproblema`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION,
//    CONSTRAINT `fk_incidente_servicio1`
//    FOREIGN KEY (`servicio_idservicio`)
//    REFERENCES `empresaSoluciones`.`servicio` (`idservicio`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION)

}
