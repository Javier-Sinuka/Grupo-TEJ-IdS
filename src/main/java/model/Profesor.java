package main.java.model;

public class Profesor {
    private String nombre_profesor;

    public Profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public Profesor() {
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }
}
