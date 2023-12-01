package org.repository;

import org.entity.Especialidad;
import org.entity.Tecnico;

import java.time.LocalDate;

public interface TecnicoRepositorie extends CrudRepositorie<Tecnico> {


    //a. Quién fue el técnico con más incidentes resueltos en los últimos N días (incluye el día de hoy)
    public Tecnico tecnicoMasIncidentes(int N);

    //b. Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días (incluye el día de hoy)
    public Tecnico tecnicoMasIncidentesEnEspecialidad(int N, Especialidad especialidad);

    //c. Quién fue el técnico que más rápido resolvió los incidentes (tiempo promedio de resolución de todos sus incidentes)
    public Tecnico tecnicoMasRapidoResolviendo();

// Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien fue le tecnico con mas incidentes resueltos en los ultimos N dias//
//    Tecnico NumeroDeEspecial(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien fue le tecnico con mas incidentes resueltos por especialidad//
//    Tecnico NumeroDeIncidentes(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien fue le tecnico con mas incidentes resueltos en menos tiempo//
//    Tecnico tecnicoMasRapido(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien es el tecnico mas rapido//


}
