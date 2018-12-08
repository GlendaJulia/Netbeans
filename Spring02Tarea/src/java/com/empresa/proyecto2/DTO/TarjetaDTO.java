
package com.empresa.proyecto2.DTO;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class TarjetaDTO {
    @NotEmpty(message = "Este campo es obligatorio")
    private String clave;
    
    ///
    @NotEmpty(message = "Este campo es obligatorio")
    private String correo;
    
    
    @NotEmpty(message = "Este campo es obligatorio")
    private String nombre;
    
    private String[] tipos = {"Admin","Normal"}; 
    
    @NotEmpty(message = "Debe de seleccionar al menos una opcion")
    private String tipo;
    
    @NotEmpty(message = "Este campo es obligatorio")
    @Pattern(regexp = ".*([0-9]\\.?\\d*)", message = "Solo se permiten datos numericos")
    @Length(min = 1, max = 8)
    private String DNI;

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    
    
}
