package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.Libros.tipos.Editorial;

import java.io.*;
import java.util.ArrayList;

public class FileEditorialDAO implements EditorialDAO{
    public static final String DATABASE_FILE = "resources/database/editorial.txt";
    public static int NIF = 0;
    public static int NOMBRE = 1;
    private File file;

    public FileEditorialDAO() {
        this.file = new File(DATABASE_FILE);
    }

    @Override
    public ArrayList<Editorial> findAll() {
        ArrayList<Editorial> listaEditoriales = new ArrayList<>(); 
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            do {
                String register = bufferedReader.readLine();
                if (register == null){
                    break;
                } else if (!register.isBlank()) {
                    String[] fields = register.split(";");
                    String nif = fields[NIF];
                    String nombre = fields[NOMBRE];
                    Editorial editorial = new Editorial(nif, nombre);
                    listaEditoriales.add(editorial);
                }
            }while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listaEditoriales;
    }

    @Override
    public void save(Editorial editorial) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            do {
                String regester = bufferedReader.readLine();
                if (regester.isBlank()){
                    String nuevaEditorial = editorial.getNif() + ";" + editorial.getNombre();
                    bufferedWriter.write(nuevaEditorial);
                }
            }while (true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
