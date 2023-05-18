package es.progcipfpbatoi.model.dto.Libros;

import es.progcipfpbatoi.model.dao.EditorialDAO;
import es.progcipfpbatoi.model.dto.Libros.tipos.Editorial;
import es.progcipfpbatoi.model.dto.Libros.tipos.NivelEducativo;

import java.time.LocalDate;

public class Libro {
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private Editorial editorial;

    public Libro(String titulo, String autor, LocalDate fechaPublicacion, Editorial editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Editorial getEditorial() {
        return editorial;
    }
}
