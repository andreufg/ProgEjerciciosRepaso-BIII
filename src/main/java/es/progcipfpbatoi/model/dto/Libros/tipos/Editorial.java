package es.progcipfpbatoi.model.dto.Libros.tipos;

public class Editorial {
    private String nombre;
    private String nif;

    public Editorial(String nif, String nombre) {
        this.nombre = nombre;
        this.nif = nif;
    }

    public Editorial(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }
}
