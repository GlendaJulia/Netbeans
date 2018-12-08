<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%--validacion de sesion--%>
<%
HttpSession misession= (HttpSession) request.getSession();
  String usuario= (String) misession.getAttribute("usuario");
  String estado= (String) misession.getAttribute("estado");
  String glen ="";
  if(estado.equals("A")){
      glen ="Activo";
  }else if (estado.equals("X")){
      glen = "Inactivo";
  }else{
      glen = "No tiene estado";
  }
  
if(misession == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/WebApp04/login.jsp'>Loguearse</a>");
      return;
  }
  if(misession.getAttribute("usuario") == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/WebApp04/login.jsp'>Loguearse</a>");
      return;
  }
    
%>

<%
  String driver = "com.mysql.cj.jdbc.Driver";
  String url    = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
  String user   = "root";
  String pass   = "DSISTecsup2";
  
  Class.forName(driver);
  Connection xcon = DriverManager.getConnection(url, user, pass);
  
  String sql = "select * from areas";
  Statement stm = xcon.createStatement();
  ResultSet rs = stm.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
      .table-striped>tbody>tr:nth-child(odd)>td, 
      .table-striped>tbody>tr:nth-child(odd)>th {
       background-color: #ff0;
      }
      .table-striped>tbody>tr:nth-child(even)>td, 
      .table-striped>tbody>tr:nth-child(even)>th {
       background-color: #ccc;
      }
      .table-striped>thead>tr>th {
         background-color: #eee;
      }
    </style>
    </head>
    <body>
        
        <h3>Usuario Logeado: <b><% out.print(usuario); %></b></h3>
        <h4>Estado: <b><% out.print(glen); %></b></h4>
        <h3><a href="/WebApp04/ServletSesion">Cerrar Sesion</a></h3>
        <h2>Listado de Tabla Areas</h2>
        <table border="1" class="table table-striped">
        <tr>
            <td style='text-align:center;width:100px;font-weight: bold;'>COD</td>
            <td style='text-align:center;width:250px;font-weight: bold;'>NOMBRE</td>
            <td style='text-align:center;width:100px;font-weight: bold;'>ESTADO</td></tr>
        <%
        while( rs.next() ) {
           out.print("<tr>");
           out.print("<td>"+rs.getString(1)+"</td>");
           out.print("<td>"+rs.getString(2)+"</td>");
           out.print("<td>"+rs.getString(3)+"</td>");
           out.print("</tr>");
        }    
       %>
       </table>
    </body>
</html>

