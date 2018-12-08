/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Named;
//import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bladimir
 */
@Named(value = "usuarios")
@RequestScoped
public class usuarios {

    private int id;
    private String nombre;
    private String clave;

    public usuarios() throws ClassNotFoundException {
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

    //validar usuario
    public boolean validarUsuario(String xnom, String xcla) {
        try {
            connection = getConnection();
            String sql = "select count(*) from usuarios where nombre=? AND clave=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, xnom);
            ps.setString(2, xcla);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String cantidad = rs.getString(1);
            int xcant = Integer.parseInt(cantidad);
            if (xcant > 0) {
                return true;
            }
            connection.close();
            return false;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return false;
    }

    //login
    public String loginProject() throws ClassNotFoundException {
        //if(nombre.equals(usuariosListar.get(0).toString()) && clave.equals(usuariosListar.get(1).toString())){
        try {
            if (validarUsuario(nombre, clave)) {
                HttpSession session = Sesion.getSession();
                session.setAttribute("username", nombre);
                return "home.html";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales invalidas", "Intenet logarse nuevamente"));
                return "index";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales invalidas", "Intenet logarse nuevamente"));
            return "index";
        }
    }

}
