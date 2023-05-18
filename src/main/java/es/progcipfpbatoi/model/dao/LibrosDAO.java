package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.Libros.Libro;

import java.util.ArrayList;

public interface LibrosDAO {
    ArrayList<Libro> findAll();
    ArrayList<Libro> findAll(String titulo);
    void save(Libro libro);
    void remove(Libro libro);
}
