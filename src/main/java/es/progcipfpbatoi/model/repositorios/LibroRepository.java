package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.dao.LibrosDAO;
import es.progcipfpbatoi.model.dto.Libros.Libro;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LibroRepository implements LibrosDAO {
    private LibrosDAO librosDAO;

    public LibroRepository(LibrosDAO librosDAO) {
        this.librosDAO = librosDAO;
    }

    @Override
    public ArrayList<Libro> findAll() throws FileNotFoundException {
        return librosDAO.findAll();
    }

    @Override
    public Libro findAll(String titulo) {
        return librosDAO.findAll(titulo);
    }

    @Override
    public void save(Libro libro) {
        librosDAO.save(libro);
    }

    @Override
    public void remove(Libro libro) {
        librosDAO.remove(libro);
    }
}
