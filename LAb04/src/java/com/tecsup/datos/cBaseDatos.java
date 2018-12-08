package com.tecsup.datos;
import java.sql.*;
import java.util.*;

public class cBaseDatos {
    String driver  = "com.mysql.cj.jdbc.Driver";
    String url     = "jdbc:mysql://localhost:3306/practica01?useSSL=false&serverTimezone=UTC";
    String usuario = "root";
    String clave   = "DSISTecsup2";

    private Connection Conectar() {
        try {
            Class.forName(driver);
            Connection xcon = DriverManager.getConnection(url,usuario,clave);
            return xcon;
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
    public boolean validarUsuario(String xnom, String xcla, String xtip) {
        try {
            Connection xcon = this.Conectar();
            String sql = "select count(*) from usuarios where Nombre_usuario=? AND Clave_usuario=? AND Tipo_usuario=?";
            PreparedStatement ps=xcon.prepareStatement(sql);
            ps.setString(1, xnom );
            ps.setString(2, xcla );
            ps.setString(3, xtip );
            ResultSet rs = ps.executeQuery();
 	     rs.next();
            String cantidad = rs.getString(1);
            int xcant = Integer.parseInt( cantidad );
            if ( xcant > 0 )
                return true;
            xcon.close();
            return false;
        } catch (Exception ex ) {
            System.out.println(ex.toString());
        }
        return false;
    }
    public String codigo (String xnom) {
        try {
            String xcod="";
            Connection xcon = this.Conectar();
            String sql = "select codigo_usuario from usuarios where Nombre_usuario=?";
            PreparedStatement ps=xcon.prepareStatement(sql);
            ps.setString(1, xnom );
            ResultSet rs = ps.executeQuery();
 	     rs.next();
            String cantidad = rs.getString(1);
            xcon.close();
            return cantidad;
            
        } catch (Exception ex ) {
            System.out.println(ex.toString());
        }
        return "Holaa";
    }
}
