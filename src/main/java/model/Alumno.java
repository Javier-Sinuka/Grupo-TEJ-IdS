package main.java.model;

public class Alumno {
    private String nombre_alumno;

    public Alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public Alumno() {
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }
}
