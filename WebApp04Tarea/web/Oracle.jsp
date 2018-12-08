<%-- 
    Document   : Oracle
    Created on : 09/09/2018, 10:11:15 PM
    Author     : USER
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
  String driver = "oracle.jdbc.driver.OracleDriver";
  String url    = "jdbc:oracle:thin:@localhost:1521:XE";
  String user   = "usr_Merma";
  String pass   = "DSISTecsup2";
  
  Class.forName(driver);
  Connection xcon = DriverManager.getConnection(url, user, pass);
  
  String sql = "select * from usr_Merma";
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
