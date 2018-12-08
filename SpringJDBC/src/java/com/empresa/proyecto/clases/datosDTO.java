
package com.empresa.proyecto.clases;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class datosDTO {
    private Integer codigo;
    @NotEmpty(message = "Este campo es obligatorio")
    private String usuario;
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,100})", message="Al menos debe de tener un numero y una letra en mayuscula y en minuscula, debe de contener mas de 8 caracteres")
    @NotEmpty(message="Este campo no puede ser nulo")
    private String clave;
    @NotEmpty(message = "Este campo es obligatorio")
    private String nombres;
    @NotEmpty(message = "Este campo es obligatorio")
    private String direccion;
    @NotEmpty(message = "Este campo es obligatorio")
    @Pattern(regexp = ".*([0-9]\\.?\\d*)", message = "Solo se permiten datos numericos")
    private String telefono;
    @NotEmpty(message="Este campo no puede ser nulo")
    @Email(message="Debe de ingresar una direccion de correo valida")
    private String correo;
    @NotEmpty(message = "Debe de seleccionar al menos una opcion")
    private String sexo;
    private String[] sexos = {"M","F"};

    public datosDTO(Integer codigo, String usuario, String clave, String nombres, String direccion, String telefono, String correo, String sexo) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.clave = clave;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo =sexo;
    }
    public datosDTO(){
        
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String[] getSexos() {
        return sexos;
    }

    public void setSexos(String[] sexos) {
        this.sexos = sexos;
    }
    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
