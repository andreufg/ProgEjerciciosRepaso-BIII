package es.progcipfpbatoi.model.dto.Libros.tipos;

import es.progcipfpbatoi.model.dto.Libros.Libro;

import java.time.LocalDate;

public class LibroAcademico extends Libro {
    NivelEducativo nivelEducativo;

    public LibroAcademico(String titulo, String autor, LocalDate fechaPublicacion, NivelEducativo nivelEducativo) {
        super(titulo, autor, fechaPublicacion);
        this.nivelEducativo = nivelEducativo;
    }
}
