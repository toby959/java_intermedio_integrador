package org.service;

import lombok.NoArgsConstructor;
import org.entity.Especialidad;
import org.entity.Tecnico;
import org.repository.ClasePersistencia;
import org.repository.TecnicoRepositorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
public class TecnicoService implements TecnicoRepositorie {


    @Override
    public void create(Tecnico tecnico) {
        EntityManager em=ClasePersistencia.EntityManejador();
        try{
            // Iniciar la transacción
            em.getTransaction().begin();

            // Persistir el cliente en la base de datos (esto también creará la tabla si no existe)
            em.persist(tecnico);
            // Commit de la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }


    }

    @Override
    public void update(Tecnico tecnico) {
        EntityManager em=ClasePersistencia.EntityManejador();
        try{
            // Iniciar la transacción
            em.getTransaction().begin();

            // actualiza el cliente en la base de datos (esto también creará la tabla si no existe)
            em.merge(tecnico);
            // Commit de la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }

    }

    @Override
    public void delete(Tecnico tecnico) {}

    @Override
    public Tecnico retrive(int id) {

        EntityManager em=ClasePersistencia.EntityManejador();

        Tecnico tecnicoRecuperado;

        try {
            // Utilizar el método find para buscar y recuperar un técnico por su ID
            tecnicoRecuperado = em.find(Tecnico.class,id);

            // Verificar si el técnico fue encontrado
            if (tecnicoRecuperado != null) {
                System.out.println("Técnico recuperado: " + tecnicoRecuperado);
            } else {
                System.out.println("Técnico no encontrado con el ID: " +id);
            }
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();

        }
        return tecnicoRecuperado;


    }

    public Tecnico retriveByDni(int dni){
        return null;
    }

    @Override
    public List<Tecnico> retriveAll() {
        String query="Select * from Cliente";
        EntityManager em=ClasePersistencia.EntityManejador();
        try{
           em.createQuery("SELECT * FROM Tecnico").getResultList();

        } finally {
            em.close();
        }

        return null;
    }


    //a. Quién fue el técnico con más incidentes resueltos en los últimos N días (incluye el día de hoy)
    @Override
    public Tecnico tecnicoMasIncidentes(int N) {
        //REVISAR:
        //dao
        //nombre de tablas
        //nombre de campos en tablas. Ejemplo: dateEnd en incidente


        //referencia: profesor, clase 8, 1:01 en video
        //EntityManager entityManager = dao.getEntityManager();
        //Pero con Hibernate:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager entityManager = emf.createEntityManager();

        String jpqlQuery =
                "SELECT t " +
                        "FROM Tecnico t " +
                        "JOIN t.incidentes i " +
                        "WHERE i.estado = 'ESTADO_CERRADO' " +
                        "  AND i.dateEnd BETWEEN :fechaInicioBusqueda AND :fechaFinalBusqueda " +
                        "GROUP BY t " +
                        "ORDER BY COUNT(i) DESC ";

        TypedQuery<Tecnico> query = entityManager.createQuery(jpqlQuery, Tecnico.class);

        LocalDate hoy = LocalDate.now();
        query.setParameter("fechaInicioBusqueda", hoy.minusDays(N));
        query.setParameter("fechaFinalBusqueda", hoy);

        try {
            List<Tecnico> result = query.getResultList();

            // El primer elemento de la lista de resultados (si se obtuvo) es el técnico con más incidentes resueltos en últimos N días
            Tecnico tecnicoMasResoluciones = result.isEmpty() ? null : result.get(0);

            return tecnicoMasResoluciones;

        } catch (Exception e) {
            System.out.println ("Error al solicitar ejecutar query SQL:");
            System.out.println (e);
            return null;

        } finally {
            entityManager.close();
        }
    }

    //b. Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días (incluye el día de hoy)
    // Se puede llegar a unificar el código con el método tecnicoMasIncidentes(int N), que es un caso que incluye todas las especialidades. Considear luego de que funcione cada una por separado.
    public Tecnico tecnicoMasIncidentesEnEspecialidad(int N, Especialidad especialidad){
        //REVISAR:
        //dao
        //nombre de tablas
        //nombre de campos en tablas. Ejemplo: dateEnd en incidente


        //referencia: profesor, clase 8, 1:01 en video
//        EntityManager entityManager = dao.getEntityManager();
        //Pero con Hibernate:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager entityManager = emf.createEntityManager();

        String jpqlQuery =
                "SELECT t\n" +
                        "FROM Tecnico t\n" +
                        "JOIN t.incidentes i\n" +
                        "WHERE i.especialidad = :especialidad\n" +
                        "  AND i.estado = 'ESTADO_CERRADO'\n" +
                        "  AND i.dateEnd BETWEEN :fechaInicioBusqueda AND :fechaFinalBusqueda\n" +
                        "GROUP BY t\n" +
                        "ORDER BY COUNT(i) DESC\n";

        TypedQuery<Tecnico> query = entityManager.createQuery(jpqlQuery, Tecnico.class);

        query.setParameter("especialidad", especialidad);

        LocalDate hoy = LocalDate.now();
        query.setParameter("fechaInicioBusqueda", hoy.minusDays(N));
        query.setParameter("fechaFinalBusqueda", hoy);

        try {
            List<Tecnico> result = query.getResultList();

            // El primer elemento de la lista de resultados (si se obtuvo) es el técnico con más incidentes resueltos en últimos N días
            Tecnico tecnicoMasResoluciones = result.isEmpty() ? null : result.get(0);

            return tecnicoMasResoluciones;

        } catch (Exception e) {
            System.out.println ("Error al solicitar ejecutar query SQL:");
            System.out.println (e);
            return null;

        } finally {
            entityManager.close();
        }
    }


    //c. Quién fue el técnico que más rápido resolvió los incidentes (tiempo promedio de resolución de todos sus incidentes)
    @Override
    public Tecnico tecnicoMasRapidoResolviendo(){
        //REVISAR:
        //dao
        //nombre de tablas
        //nombre de campos en tablas. Ejemplo: dateEnd en incidente


        //referencia: profesor, clase 8, 1:01 en video
        //EntityManager entityManager = dao.getEntityManager();
        //Pero con Hibernate:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager entityManager = emf.createEntityManager();

        //AVG(TIMESTAMPDIFF(SECOND, i.dateStart, i.dateEnd)) calcula el tiempo promedio de resolucion de incidentes para cada técnico
        String jpqlQuery =
                "SELECT t, AVG(TIMESTAMPDIFF(SECOND, i.dateStart, i.dateEnd)) as tiempoPromedioResolucion " +
                        "FROM Tecnico t " +
                        "JOIN t.incidentes i " +
                        "WHERE i.estado = 'ESTADO_CERRADO' " +
                        "GROUP BY t " +
                        "ORDER BY tiempoPromedioResolucion ASC";

        TypedQuery<Tecnico> query = entityManager.createQuery(jpqlQuery, Tecnico.class);

        try {
            List<Tecnico> result = query.getResultList();  //List<Object[]> resultList = query.getResultList();

            // El primer elemento de la lista de resultados (si se obtuvo) es el técnico más rápido
            Tecnico tecnicoMasRapido = result.isEmpty() ? null : result.get(0);

            return tecnicoMasRapido;

        } catch (Exception e) {
            System.out.println ("Error al solicitar ejecutar query SQL:");
            System.out.println (e);
            return null;

        } finally {
            entityManager.close();
        }
    }

//    @Override
//    public Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin) {
//        return null;
//    }
//
//    @Override
//    public Tecnico NumeroDeEspecial(LocalDate inicio, LocalDate fin) {
//        return null;
//    }
//
//    @Override
//    public Tecnico NumeroDeIncidentes(LocalDate inicio, LocalDate fin) {
//        return null;
//    }
//
//    @Override
//    public Tecnico tecnicoMasRapido(LocalDate inicio, LocalDate fin) {
//        return null;
//    }
}
