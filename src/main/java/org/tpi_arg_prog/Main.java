package org.tpi_arg_prog;

import org.tpi_arg_prog.entities.repository.JpaTecnicoRespositorio;
import org.tpi_arg_prog.entities.repository.TecnicoRepositorio;
import org.tpi_arg_prog.entities.repository.dao.DAO;
import org.tpi_arg_prog.entities.repository.dao.JpaDAO;
import org.tpi_arg_prog.services.TecnicoService;

public class Main {

    static TecnicoService tecnicoService;

    public static void main(String[] args) {
        iniciar();
        System.out.println("Hello world!");
    }

    private static void iniciar() {
        DAO dao = new JpaDAO();
        TecnicoRepositorio tecnicoRepositorio = new JpaTecnicoRespositorio(dao);
        tecnicoService = new TecnicoService(tecnicoRepositorio);

        // Otros servicios


    }
}