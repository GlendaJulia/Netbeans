/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.inject.Named;
//import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bladimir
 */
@Named(value = "personas")
@RequestScoped
public class personas {

    int codigo_persona;
    String codigo_usuario;
    String nombre;
    String apellido;
    String celular;
    String correo;
    String dni;
    String usuario;
    String clave;

    public personas() {
    }

    public int getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(int codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public String getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(String codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    //conexion a base de datos
    Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cancha?useSSL=false&serverTimezone=UTC", "root", "tecsup");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    //crear usuarios
    public String insertarPersona() {
        int result = 0;
        try {
            connection = getConnection();
            
            PreparedStatement stmt1 = connection.prepareStatement(
                    "insert into usuarios(nombre, clave) values(?,?)");
            stmt1.setString(1, usuario);
            stmt1.setString(2, clave);
            result = stmt1.executeUpdate();
            
            Statement stmt2 = getConnection().createStatement();
            ResultSet rs = stmt2.executeQuery("select codigo_usuario from usuarios where nombre = '" + usuario + "' AND clave = '" + clave +"'");
            //String clave = rs.next().toString();
            rs.first();
            String id = rs.getString(1);
            System.out.println(id + "CACAAACCAACCAACACCAACACACACCACACACACACAACC");
            
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into personas(codigo_usuario,nombre,apellido,celular,correo,dni) values(?,?,?,?,?,?)");
            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, celular);
            stmt.setString(5, correo);
            stmt.setString(6, dni);
            result = stmt.executeUpdate();
            
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result != 0) {
            return "index.xhtml?faces-redirect=true";
        } else {
            return "crear.xhtml?faces-redirect=true";
        }
    }

    //crear usuarios
    /*public String insertarUsuario() throws ClassNotFoundException {
        int result = 0;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into usuarios(nombre,clave) values(?,?)");
            stmt.setString(1, nombre);
            stmt.setString(2, clave);
            result = stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result != 0) {
            return "index.xhtml?faces-redirect=true";
        } else {
            return "crear.xhtml?faces-redirect=true";
        }
    }*/
}
