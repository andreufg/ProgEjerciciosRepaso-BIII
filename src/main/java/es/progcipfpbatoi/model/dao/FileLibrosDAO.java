package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.Libros.Libro;
import es.progcipfpbatoi.model.dto.Libros.tipos.Editorial;
import es.progcipfpbatoi.model.dto.Libros.tipos.LibroAcademico;
import es.progcipfpbatoi.model.dto.Libros.tipos.NivelEducativo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class FileLibrosDAO implements LibrosDAO{
    public static final String DATABASE_FILE = "resources/database/productos.txt";
    public static int TITULO = 0;
    public static int AUTOR = 1;
    public static int FECHA_PUBLICACION = 2;
    public static int EDITORIAL = 3;
    public static int NIVELE_DUCATIVO = 4;
    private File file;

    public FileLibrosDAO() {
        this.file = new File(DATABASE_FILE);
    }

    @Override
    public ArrayList<Libro> findAll() {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        try (FileReader fileReader = new FileReader(this.file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            do {
                String register = bufferedReader.readLine();
                if (register == null) {
                    break;
                } else if (!register.isBlank()) {
                    String[] fields = register.split(";");
                    String titulo = fields[TITULO];
                    String autor = fields[AUTOR];
                    LocalDate fechaPublicacion = LocalDate.parse(fields[FECHA_PUBLICACION]);
                    Editorial editorial = new Editorial(fields[EDITORIAL]);
                    if (Objects.equals(fields[NIVELE_DUCATIVO], "NO_EDUCATIVO")){
                        Libro libro = new Libro(titulo, autor, fechaPublicacion,editorial);
                        listaLibros.add(libro);
                    }else {
                        NivelEducativo nivelEducativo;
                        if (Objects.equals(fields[NIVELE_DUCATIVO], "ESO")) {
                            nivelEducativo = NivelEducativo.ESO;
                        } else if (Objects.equals(fields[NIVELE_DUCATIVO], "BACHILLERATO")) {
                            nivelEducativo = NivelEducativo.BACHILLERATO;
                        } else {
                            nivelEducativo = NivelEducativo.FP;
                        }
                        LibroAcademico libroAcademico = new LibroAcademico(titulo,autor,fechaPublicacion,editorial,nivelEducativo);
                        listaLibros.add(libroAcademico);
                    }
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaLibros;

    }

    @Override
    public Libro findAll(String titulo) {
        for (Libro libro :findAll()) {
            if (libro.getTitulo().equals(titulo)){
                return libro;
            }
        }
        return null;
    }

    @Override
    public void save(Libro libro) {
        try (FileReader fileReader = new FileReader(this.file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                FileWriter fileWriter = new FileWriter(this.file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            do {
                String register = bufferedReader.readLine();
                if (register == null) {
                    if (libro instanceof LibroAcademico){
                        String libroNuevo = libro.getTitulo() + ";" + libro.getAutor() + ";" + libro.getFechaPublicacion() +
                                libro.getEditorial().getNif() + ";" + ((LibroAcademico)libro).getNivelEducativo();
                        bufferedWriter.write(libroNuevo);
                        fileWriter.close();
                    }else {
                        String libroNuevo = libro.getTitulo() + ";" + libro.getAutor() + ";" + libro.getFechaPublicacion() +
                                libro.getEditorial().getNif() + ";" + "NO_ACADEMICO";
                        bufferedWriter.write(libroNuevo);
                        fileWriter.close();
                    }
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Libro libro) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,false))){
            for (Libro book:findAll()) {
                if (book.getTitulo().equals(libro.getTitulo())){
                    break;
                }else {
                    if (book instanceof LibroAcademico){
                        String libroNuevo = book.getTitulo() + ";" + book.getAutor() + ";" + book.getFechaPublicacion() +
                                book.getEditorial().getNif() + ";" + ((LibroAcademico)book).getNivelEducativo();
                        bufferedWriter.write(libroNuevo);
                    }else {
                        String libroNuevo = book.getTitulo() + ";" + book.getAutor() + ";" + book.getFechaPublicacion() +
                                book.getEditorial().getNif() + ";" + "NO_ACADEMICO";
                        bufferedWriter.write(libroNuevo);
                    }
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
