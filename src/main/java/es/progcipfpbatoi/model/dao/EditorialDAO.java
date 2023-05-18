package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.Libros.tipos.Editorial;

import java.util.ArrayList;

public interface EditorialDAO {
    ArrayList<Editorial> findAll();
    void save(Editorial editorial);
    void remove(Editorial editorial);
}
