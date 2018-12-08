package com.empresa.proyecto2.DTO;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class formularioDTO {
    @NotEmpty(message="Este campo no puede ser nulo")
    private String nombre;
    @NotEmpty(message="Este campo no puede ser nulo")
    @Email(message="Debe de ingresar una direccion de correo valida")
    private String correo;
    @NotEmpty(message="Este campo no puede ser nulo")
    @Pattern(regexp = ".*([0-9]\\.?\\d*)", message="Solo se permiten datos numericos")
    private String edad;
    @NotEmpty(message="Este campo no puede ser nulo")
    private String apellido;
    @NotEmpty(message="Este campo no puede ser nulo")
    private String sexo;
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,100})", message="Al menos debe de tener un numero y una letra en mayuscula y en minuscula, debe de contener mas de 8 caracteres")
    @NotEmpty(message="Este campo no puede ser nulo")
    private String clave;
    private String[] elementossexo = {"Elegir...","Masculino","Femenino"};

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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String[] getElementossexo() {
        return elementossexo;
    }

    public void setElementossexo(String[] elementossexo) {
        this.elementossexo = elementossexo;
    }

    
    
}
