package es.progcipfpbatoi.model.dto.Libros.tipos;

import es.progcipfpbatoi.model.dto.Libros.Libro;

import java.time.LocalDate;

public class LibroAcademico extends Libro {
    NivelEducativo nivelEducativo;

    public LibroAcademico(String titulo, String autor, LocalDate fechaPublicacion, Editorial editorial,NivelEducativo nivelEducativo) {
        super(titulo, autor, fechaPublicacion, editorial);
        this.nivelEducativo = nivelEducativo;
    }

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }
}
