<%-- 
    Document   : login.jsp
    Created on : 02/09/2018, 09:22:28 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head><title>Identificacion</title></head>
  <body bgcolor=yellow>
    <center><H2>Identificacion de usuario</H2>
    <form method=post action="/WebApp03/ServletVerifica">
        <table>
            <tr><td>Codigo: </td>
                <td> <input name=xcod size=10> </td></tr>
            <tr><td>Clave:</td>
                <td><input type=password name=xcla size=10></td></tr>
            <tr><td colspan=2 align=center> <input type=submit value=ACEPTAR> </td>
        </table>
    </form></center>
  </body>
</html>

