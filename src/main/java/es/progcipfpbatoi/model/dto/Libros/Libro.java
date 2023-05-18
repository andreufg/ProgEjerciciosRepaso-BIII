package es.progcipfpbatoi.model.dto.Libros;

import java.time.LocalDate;

public class Libro {
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public Libro(String titulo, String autor, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
