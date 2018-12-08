
package com.empresa.proyecto2.DTO;

public class datosDTO {
    private Integer codigo;
    private String nombre;
    private String clave;
    private String dni;
    private String correo;
    private String tipo;

    public datosDTO(Integer codigo, String nombre, String clave, String dni, String correo, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.clave = clave;
        this.dni = dni;
        this.correo = correo;
        this.tipo = tipo;
    }
    public datosDTO(){
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
