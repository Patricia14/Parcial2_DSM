package com.example.desafio1ejer3.Datos;

public class DatosFarmacia {

    private String key;
    private String nombre;
    private String correo;
    private String fecha;
    private String total;

    public DatosFarmacia(String nombre, String correo, String fecha,
                         String total) {
        this.nombre = nombre;
        this.correo = correo;
        this.fecha = fecha;
        this.total = total;

    }

    public DatosFarmacia(){

    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
