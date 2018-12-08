<%--validacion de sesion--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
HttpSession misession= (HttpSession) request.getSession();
  String usuario= (String) misession.getAttribute("usuario");  
if(misession == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/LAb04/index.html'>Loguearse</a>");
      return;
  }
  if(misession.getAttribute("usuario") == null){
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a href='/LAb04/index.html'>Loguearse</a>");
      return;
  }    
%>

<%
  String driver = "com.mysql.cj.jdbc.Driver";
  String url    = "jdbc:mysql://localhost:3306/practica01?useSSL=false&serverTimezone=UTC";
  String user   = "root";
  String pass   = "DSISTecsup2";
  
  Class.forName(driver);
  Connection xcon = DriverManager.getConnection(url, user, pass);
  
  String sql = "SELECT U.Nombre_usuario, C.Nombre_curso, C.Nota_curso FROM cursos C, usuarios U WHERE U.codigo_usuario = C.Codigo_usuario";
  Statement stm = xcon.createStatement();
  ResultSet rs = stm.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                text-align: center;
            }
            table#listado {
    background-color: #AAAAAA;
    color: #0000BB;
    font: 12px/14px Arial;
    border-style: solid;
    border-width:3px;
    border-color:black;
}

table#listado th {
    background-color: #333333;
    color: #FFFFFF;
    font: 15px/25px Arial;
    font-weight:bold;
    padding-left: 5px;
    padding-right: 5px;
}

table#listado td {
    background-color: #FFFFFF;
    color: #0000FF;
    font: 13px/16px Arial;
    padding: 2px;
 }
 table#editar {
    background-color: #BBBBBB;
    color: #0000BB;
    font: 12px/18px Arial;
    font-weight: bold;
    border-style: solid;
    border-width:3px;
    border-color:#000000;
}

table#editar th {
    background-color: #444444;
    color: #FFFFFF;
    font: 16px/25px Arial;
    font-weight:bolder;
    text-align: left;
    padding-left: 5px;
    padding-right: 10px;
}

table#editar td {
    background-color: #FFFFFF;
    color: #0000BB;
    font: 12px/18px Arial;
    font-weight: bold;
    border-style: solid;
    border-width: 1px;
    border-color: #666666;
    padding:7px;
}
        </style>
    </head>
    <body bgcolor=green>
        
        <h3>Usuario Logeado: <b><% out.print(usuario); %></b></h3>
        <h3><a href="/LAb04/ServletSesion">Cerrar Sesion</a></h3>
        <h2>Listado de Alumnos</h2>
        <table id="listado">
        <tr>
            <td style='text-align:center;width:250px;font-weight: bold;'>NOMBRE</td>
            <td style='text-align:center;width:100px;font-weight: bold;'>CURSO</td>
            <td style='text-align:center;width:100px;font-weight: bold;'>NOTA</td></tr>
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

