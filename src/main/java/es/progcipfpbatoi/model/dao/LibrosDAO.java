package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.Libros.Libro;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface LibrosDAO {
    ArrayList<Libro> findAll() throws FileNotFoundException;
    Libro findAll(String titulo);
    void save(Libro libro);
    void remove(Libro libro);
}
