<%-- 
    Document   : index
    Created on : 10/09/2018, 12:28:42 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <title>Identificacion</title>
  </head>
  <body bgcolor=pink>
    <center><H2>Identificacion de usuario</H2>
    <form method=post action="/WebApp05.1/ServletVerifica">
        <table>
            <tr><td>Nombre: </td>
                <td> <input type=text name=xnom size=10> </td></tr>
            <tr><td>Clave:</td>
                <td><input type=password name=xcla size=10></td></tr>
            <tr><td colspan=2 align=center> <input type=submit value=ACEPTAR> </td>
        </table>
    </form></center>
  </body>
</html>

