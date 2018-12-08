package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author USER
 */
@Named(value = "usuarios")
@RequestScoped
public class usuarios {

    int id;  
    String nombre;  
    String correo;  
    String clave;  
    String sexo;  

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    String direccion;

    public usuarios() {
    }
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
    
    //conexion a base de datos
    Connection connection;  
    public Connection getConnection(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");     
            connection=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC","root","DSISTecsup2");  
        }catch(Exception e){  
            System.out.println(e);  
        }  
        return connection;  
    }  
    
    //listar usuarios
    ArrayList usuariosListar ;  
    public ArrayList usuariosListar (){  
    try{  
        usuariosListar = new ArrayList();  
        connection = getConnection();  
        Statement stmt=getConnection().createStatement();    
        ResultSet rs=stmt.executeQuery("select * from usuarios");    
        while(rs.next()){  
        usuarios user = new usuarios();  
        user.setId(rs.getInt("id"));  
        user.setNombre(rs.getString("nombre"));  
        user.setCorreo(rs.getString("correo"));  
        user.setClave(rs.getString("clave"));  
        user.setSexo(rs.getString("sexo"));  
        user.setDireccion(rs.getString("direccion"));  
        usuariosListar.add(user);  
    }  
        connection.close();          
    }catch(Exception e){  
        System.out.println(e);  
    }  
    return usuariosListar;  
}
//mostrarSexo en formato largo
public String getMostrarSexo(char sexo){  
    if(sexo == 'M'){  
    return "Masculino";  
    }else 
    return "Femenino";  
   }

    //crear usuarios
public String insertarUsuario(){  
int result = 0;  
try{  
    connection = getConnection();  
    PreparedStatement stmt = connection.prepareStatement(  
    "insert into usuarios(nombre,correo,clave,sexo,direccion) values(?,?,?,?,?)");  
    stmt.setString(1, nombre);  
    stmt.setString(2, correo);  
    stmt.setString(3, clave);  
    stmt.setString(4, sexo);  
    stmt.setString(5, direccion);  
    result = stmt.executeUpdate();  
    connection.close();  
}catch(Exception e){  
    System.out.println(e);  
}  
if(result !=0)  
    return "index.xhtml?faces-redirect=true";  
else 
    return "crear.xhtml?faces-redirect=true";  
}

    public String editarUsuario(int id){  
usuarios user = null;  
System.out.println(id);  
try{  
    connection = getConnection();  
    Statement stmt=getConnection().createStatement();    
    ResultSet rs=stmt.executeQuery("select * from usuarios where id = "+(id));  
    rs.next();  
    user = new usuarios();  
    user.setId(rs.getInt("id"));  
    user.setNombre(rs.getString("nombre"));  
    user.setCorreo(rs.getString("correo"));  
    user.setSexo(rs.getString("sexo"));  
    user.setDireccion(rs.getString("direccion"));  
    user.setClave(rs.getString("clave"));    
    System.out.println(rs.getString("clave"));  
    sessionMap.put("editUser", user);  
    connection.close();  
}catch(Exception e){  
    System.out.println(e);  
}         
    return "/editar.xhtml?faces-redirect=true";  
}
 
    public String actualizarUsuario(usuarios u){  
//int result = 0;  
try{  
    connection = getConnection();    
    PreparedStatement stmt=connection.prepareStatement(  
    "update usuarios set nombre=?,correo=?,clave=?,sexo=?,direccion=? where id=?");    
    stmt.setString(1,u.getNombre());    
    stmt.setString(2,u.getCorreo());    
    stmt.setString(3,u.getClave());    
    stmt.setString(4,u.getSexo());    
    stmt.setString(5,u.getDireccion());    
    stmt.setInt(6,u.getId());    
    stmt.executeUpdate();  
    connection.close();  
}catch(Exception e){  
    System.out.println();  
}  
    return "/index.xhtml?faces-redirect=true";        
}
//eliminar usuario
public void eliminarUsuario(int id){  
try{  
    connection = getConnection();    
    PreparedStatement stmt = connection.prepareStatement("delete from usuarios where id = "+id);    
    stmt.executeUpdate();    
}catch(Exception e){  
    System.out.println(e);  
}  
}  

    
}
