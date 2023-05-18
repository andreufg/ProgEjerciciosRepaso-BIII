package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.dao.EditorialDAO;
import es.progcipfpbatoi.model.dto.Libros.tipos.Editorial;

import java.util.ArrayList;

public class EditorialRepository implements EditorialDAO {
    EditorialDAO editorialDAO;

    public EditorialRepository(EditorialDAO editorialDAO) {
        this.editorialDAO = editorialDAO;
    }

    @Override
    public ArrayList<Editorial> findAll() {
        return editorialDAO.findAll();
    }

    @Override
    public void save(Editorial editorial) {
        editorialDAO.save(editorial);
    }
}
