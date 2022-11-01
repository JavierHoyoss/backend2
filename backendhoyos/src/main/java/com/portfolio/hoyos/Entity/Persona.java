package com.portfolio.hoyos.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String acerca;
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String acerca, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acerca = acerca;
        this.img = img;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
