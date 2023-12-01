package org.repository;

public interface CrudRepositorie<T> {

        void create(T t);
        void update(T t);
        void delete(T t);  //Corrección avisada por Christian
        T retrieve(int id);  //Corrección avisada por Christian
        T retrieveAll();   //Corrección avisada por Christian
}
