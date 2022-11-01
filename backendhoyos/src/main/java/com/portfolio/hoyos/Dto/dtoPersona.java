
package com.portfolio.hoyos.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {
    
    @NotBlank
    private String nombre;  
    @NotBlank
    private String apellido;
    @NotBlank
    private String acerca;
    @NotBlank
    private String img;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String acerca, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acerca = acerca;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
