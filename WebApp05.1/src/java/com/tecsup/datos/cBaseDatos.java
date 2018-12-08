package com.tecsup.datos;
import java.sql.*;
import java.util.*;

public class cBaseDatos {
    String driver  = "com.mysql.cj.jdbc.Driver";
    String url     = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
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
    public boolean validarUsuario(String xnom, String xcla) {
        try {
            Connection xcon = this.Conectar();
            String sql = "select count(*) from t_usuarios where nombre=? AND " +
 				"clave=?";
            PreparedStatement ps=xcon.prepareStatement(sql);
            ps.setString(1, xnom );
            ps.setString(2, xcla );
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
    
    private Vector ResultSetToVector(ResultSet rs) throws SQLException {
    Vector vRows = new Vector();
    while(rs.next()) {
        Vector vCol = new Vector();
        int nroFields = rs.getMetaData().getColumnCount();
        for(int i=1 ; i <=nroFields; i++) {
            String strTmp = rs.getString(i);
            vCol.add(strTmp);
        }
        vRows.add(vCol);
    }
    return vRows;
    }
    
    public Vector buscarUsuario( String pNombre ) throws SQLException {
        String sql  = "select codigo, nombre, clave, estado " +
                "from t_usuarios where nombre like ?";
        Connection xcon = this.Conectar();
        PreparedStatement ps = xcon.prepareStatement(sql);
        ps.setString(1, "%" + pNombre + "%");
        ResultSet rs = ps.executeQuery();
        Vector vRet = ResultSetToVector(rs);
        rs.close();
        ps.close();
        xcon.close();
        return vRet;
     }

    public Vector getAreas() {
    Vector vRet = null;
    try {
        String sql = "select codigo,nombre,abreviatura,estado from areas2 order by codigo";
        Connection xcon = this.Conectar();
        Statement stm = xcon.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        vRet = ResultSetToVector(rs);
        rs.close();
        stm.close();
        xcon.close();
    } catch(SQLException e){
        e.printStackTrace();
    }
    return vRet;
    }
    
    protected String generarCodigo(String tabla, String campo) throws SQLException {
   String rpta = "";
   String sql = "select count(*) from " + tabla;
   Connection xcon = this.Conectar();
   Statement st = xcon.createStatement();
   ResultSet rs = st.executeQuery(sql);
   rs.next();
   int cant = Integer.parseInt(rs.getString(1).toString());
   if ( cant <= 0 )
       rpta = "1";
   else {
       sql = "select max(" + campo + ") from " + tabla;
       rs = st.executeQuery(sql);
       rs.next();
       cant = Integer.parseInt(rs.getString(1).toString()) + 1;
       rpta = "" + cant;
   }
   xcon.close();
   return rpta;
}

    public void grabarNuevaArea( String[] datos ) throws SQLException {
   String xcod = this.generarCodigo("areas2","codigo");
   String xnom = datos[0];
   String xabr = datos[1];
   String xest = datos[2];
   String sql = "insert into areas2 (codigo,nombre,abreviatura,estado) values (?,?,?,?) ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xcod);
   ps.setString(2, xnom);
   ps.setString(3, xabr);
   ps.setString(4, xest);
   ps.executeUpdate();
   xcon.close();
}
public Vector buscarArea( String pCodigo ) throws SQLException {
   String sql  = "select codigo, nombre, abreviatura, estado " +
           "from areas2 where codigo=?";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, pCodigo);
   ResultSet rs = ps.executeQuery();
   Vector vRet = ResultSetToVector(rs);
   rs.close();
   ps.close();
   xcon.close();
   Vector fila = (Vector)vRet.get(0);
   return fila;
}

public void modificarArea( String[] datos ) throws SQLException {
   String xcod = datos[0];
   String xnom = datos[1];
   String xabr = datos[2];
   String xest = datos[3];
   String sql = "update areas2 set nombre=?, abreviatura=?, estado=? where codigo=? ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xnom);
   ps.setString(2, xabr);
   ps.setString(3, xest);
   ps.setString(4, xcod);
   ps.executeUpdate();
   xcon.close();
}

public void eliminarAreas( String[] datos ) throws SQLException {
   boolean inicio;
   if ( datos.length <= 0 )
      return;
   String sql  = "DELETE FROM areas2 WHERE codigo in ( ";
   inicio = true;
   for( int xc = 0 ; xc < datos.length ; xc++ ) {
       if ( inicio )
         sql += "?";
       else
         sql += ",?";
       inicio = false;
   }
   sql += ")";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   for( int xc = 0 ; xc < datos.length ; xc++ ) 
      ps.setString(xc+1, datos[xc]);
   ps.executeUpdate();
   xcon.close();
}

public Vector getAlumnos() {
    Vector vRet = null;
    try {
        String sql = "select codigo,nombre,direccion,email,telefono,celular,sexo,fec_nac,estado from alumnos order by codigo";
        Connection xcon = this.Conectar();
        Statement stm = xcon.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        vRet = ResultSetToVector(rs);
        rs.close();
        stm.close();
        xcon.close();
    } catch(SQLException e){
        e.printStackTrace();
    }
    return vRet;
    }

    public void grabarNuevoAlumno( String[] datos ) throws SQLException {
   String xcod = this.generarCodigo("alumnos","codigo");
   String xnom = datos[0];
   String xdir = datos[1];
   String xema = datos[2];
   String xtel = datos[3];
   String xcel = datos[4];
   String xsex = datos[5];
   String xfec = datos[6];
   String xest = datos[7];
   String sql = "insert into alumnos (codigo,nombre,direccion,email,telefono,celular,sexo,fec_nac,estado) values (?,?,?,?,?,?,?,?,?) ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xcod);
   ps.setString(2, xnom);
   ps.setString(3, xdir);
   ps.setString(4, xema);
   ps.setString(5, xtel);
   ps.setString(6, xcel);
   ps.setString(7, xsex);
   ps.setString(8, xfec);
   ps.setString(9, xest);
   ps.executeUpdate();
   xcon.close();
}
public Vector buscarAlumno( String pCodigo ) throws SQLException {
   String sql  = "select codigo,nombre,direccion,email,telefono,celular,sexo,fec_nac,estado " +
           "from alumnos where codigo=?";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, pCodigo);
   ResultSet rs = ps.executeQuery();
   Vector vRet = ResultSetToVector(rs);
   rs.close();
   ps.close();
   xcon.close();
   Vector fila = (Vector)vRet.get(0);
   return fila;
}

public void modificarAlumno( String[] datos ) throws SQLException {
   String xcod = datos[0];
   String xnom = datos[1];
   String xdir = datos[2];
   String xema = datos[3];
   String xtel = datos[4];
   String xcel = datos[5];
   String xsex = datos[6];
   String xfec = datos[7];
   String xest = datos[8];
   String sql = "update alumnos set nombre=?, direccion=?, email=?, telefono=?, celular=?, sexo=?, fec_nac=?, estado=? where codigo=? ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xnom);
   ps.setString(2, xdir);
   ps.setString(3, xema);
   ps.setString(4, xtel);
   ps.setString(5, xcel);
   ps.setString(6, xsex);
   ps.setString(7, xfec);
   ps.setString(8, xest);
   ps.setString(9, xcod);
   ps.executeUpdate();
   xcon.close();
}

public void eliminarAlumnos( String[] datos ) throws SQLException {
   boolean inicio;
   if ( datos.length <= 0 )
      return;
   String sql  = "DELETE FROM alumnos WHERE codigo in ( ";
   inicio = true;
   for( int xc = 0 ; xc < datos.length ; xc++ ) {
       if ( inicio )
         sql += "?";
       else
         sql += ",?";
       inicio = false;
   }
   sql += ")";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   for( int xc = 0 ; xc < datos.length ; xc++ ) 
      ps.setString(xc+1, datos[xc]);
   ps.executeUpdate();
   xcon.close();
}

public Vector getCursos() {
    Vector vRet = null;
    try {
        String sql = "select codigo,nombre,costo,fec_ini,fec_fin,duracion,sesiones,capacidad,inscritos,estado from cursos order by codigo";
        Connection xcon = this.Conectar();
        Statement stm = xcon.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        vRet = ResultSetToVector(rs);
        rs.close();
        stm.close();
        xcon.close();
    } catch(SQLException e){
        e.printStackTrace();
    }
    return vRet;
    }

    public void grabarNuevoCurso( String[] datos ) throws SQLException {
   String xcod = this.generarCodigo("cursos","codigo");
   String xnom = datos[0];
   String xcos = datos[1];
   String xini = datos[2];
   String xfin = datos[3];
   String xdur = datos[4];
   String xses = datos[5];
   String xcap = datos[6];
   String xins = datos[7];
   String xest = datos[8];
   String sql = "insert into cursos (codigo,nombre,costo,fec_ini,fec_fin,duracion,sesiones,capacidad,inscritos,estado) values (?,?,?,?,?,?,?,?,?,?) ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xcod);
   ps.setString(2, xnom);
   ps.setString(3, xcos);
   ps.setString(4, xini);
   ps.setString(5, xfin);
   ps.setString(6, xdur);
   ps.setString(7, xses);
   ps.setString(8, xcap);
   ps.setString(9, xins);
   ps.setString(10, xest);
   ps.executeUpdate();
   xcon.close();
}
public Vector buscarCurso( String pCodigo ) throws SQLException {
   String sql  = "select codigo,nombre,costo,fec_ini,fec_fin,duracion,sesiones,capacidad,inscritos,estado " +
           "from cursos where codigo=?";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, pCodigo);
   ResultSet rs = ps.executeQuery();
   Vector vRet = ResultSetToVector(rs);
   rs.close();
   ps.close();
   xcon.close();
   Vector fila = (Vector)vRet.get(0);
   return fila;
}

public void modificarCurso( String[] datos ) throws SQLException {
   String xcod = datos[0];
   String xnom = datos[1];
   String xcos = datos[2];
   String xini = datos[3];
   String xfin = datos[4];
   String xdur = datos[5];
   String xses = datos[6];
   String xcap = datos[7];
   String xins = datos[8];
   String xest = datos[9];
   String sql = "update cursos set nombre=? ,costo=? ,fec_ini=? ,fec_fin=? ,duracion=? ,sesiones=? ,capacidad=? ,inscritos=? , estado=? where codigo=? ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xnom);
   ps.setString(2, xcos);
   ps.setString(3, xini);
   ps.setString(4, xfin);
   ps.setString(5, xdur);
   ps.setString(6, xses);
   ps.setString(7, xcap);
   ps.setString(8, xins);
   ps.setString(9, xest);
   ps.setString(10, xcod);
   ps.executeUpdate();
   xcon.close();
}

public void eliminarCursos( String[] datos ) throws SQLException {
   boolean inicio;
   if ( datos.length <= 0 )
      return;
   String sql  = "DELETE FROM cursos WHERE codigo in ( ";
   inicio = true;
   for( int xc = 0 ; xc < datos.length ; xc++ ) {
       if ( inicio )
         sql += "?";
       else
         sql += ",?";
       inicio = false;
   }
   sql += ")";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   for( int xc = 0 ; xc < datos.length ; xc++ ) 
      ps.setString(xc+1, datos[xc]);
   ps.executeUpdate();
   xcon.close();
}

public Vector getUsuarios() {
    Vector vRet = null;
    try {
        String sql = "select codigo,Nombre,Clave,Estado from t_usuarios order by codigo";
        Connection xcon = this.Conectar();
        Statement stm = xcon.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        vRet = ResultSetToVector(rs);
        rs.close();
        stm.close();
        xcon.close();
    } catch(SQLException e){
        e.printStackTrace();
    }
    return vRet;
    }

public void grabarNuevoUUsuario( String[] datos ) throws SQLException {
   String xcod = this.generarCodigo("t_usuarios","codigo");
   String xnom = datos[0];
   String xcla = datos[1];
   String xest = datos[2];
   String sql = "insert into t_usuarios (codigo,Nombre,Clave,Estado) values (?,?,?,?) ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xcod);
   ps.setString(2, xnom);
   ps.setString(3, xcla);
   ps.setString(4, xest);
   ps.executeUpdate();
   xcon.close();
}
public boolean grabarNuevoUsuario( String[] datos ) {       
        try {
            String xcod;
            xcod = this.generarCodigo("t_usuarios","codigo");
            String xnom = datos[0];
            String xcla = datos[1];
            String xest = datos[2];
            String sql = "insert into t_usuarios (codigo,nombre,clave,estado) values (?,?,?,?) ";
            Connection xcon = this.Conectar();
            PreparedStatement ps = xcon.prepareStatement(sql);
            ps.setString(1, xcod);
            ps.setString(2, xnom);
            ps.setString(3, xcla);
            ps.setString(4, xest);
            ps.executeUpdate();
            xcon.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }        
     }

public Vector buscarUUsuario( String pCodigo ) throws SQLException {
   String sql  = "select codigo, Nombre, Clave, Estado " +
           "from t_usuarios where codigo=?";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, pCodigo);
   ResultSet rs = ps.executeQuery();
   Vector vRet = ResultSetToVector(rs);
   rs.close();
   ps.close();
   xcon.close();
   Vector fila = (Vector)vRet.get(0);
   return fila;
}



public void modificarUsuario( String[] datos ) throws SQLException {
   String xcod = datos[0];
   String xnom = datos[1];
   String xcla = datos[2];
   String xest = datos[3];
   String sql = "update t_usuarios set Nombre=?, Clave=?, Estado=? where codigo=? ";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   ps.setString(1, xnom);
   ps.setString(2, xcla);
   ps.setString(3, xest);
   ps.setString(4, xcod);
   ps.executeUpdate();
   xcon.close();
}

public void eliminarUsuarios( String[] datos ) throws SQLException {
   boolean inicio;
   if ( datos.length <= 0 )
      return;
   String sql  = "DELETE FROM t_usuarios WHERE codigo in ( ";
   inicio = true;
   for( int xc = 0 ; xc < datos.length ; xc++ ) {
       if ( inicio )
         sql += "?";
       else
         sql += ",?";
       inicio = false;
   }
   sql += ")";
   Connection xcon = this.Conectar();
   PreparedStatement ps = xcon.prepareStatement(sql);
   for( int xc = 0 ; xc < datos.length ; xc++ ) 
      ps.setString(xc+1, datos[xc]);
   ps.executeUpdate();
   xcon.close();
}

public boolean modificarUsuarios( String[] datos ) throws SQLException {
        try {
            String xcod = datos[0];
            String xnom = datos[1];
            String xcla = datos[2];
            String xest = datos[3];
            String sql = "update t_usuarios set nombre=?, clave=?, estado=? where codigo=? ";
            Connection xcon = this.Conectar();
            PreparedStatement ps = xcon.prepareStatement(sql);
            ps.setString(1, xnom);
            ps.setString(2, xcla);
            ps.setString(3, xest);
            ps.setString(4, xcod);
            ps.executeUpdate();
            xcon.close();
            return true;
        } catch (SQLException ex){
            return false;
        }
    }

}
