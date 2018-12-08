<%-- 
    Document   : OperacionesBasicas
    Created on : 20/08/2018, 09:04:08 PM
    Author     : USER
--%>
<%@page import="funciones.tecsup.pe.OperacionesBasicas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
     OperacionesBasicas obj = new OperacionesBasicas();
     int x=12; int y=3;
     int suma = obj.suma(x,y);
     int resta = obj.resta(x,y);
     float div = obj.division(x,y);
     int mult = obj.multiplicacion(x,y);
     out.print( "De los numeros " + x + "y" + y +"<p>");
     out.print( "Suma: " + suma + "<p>");
     out.print( "Resta: " + resta + "<p>");
     out.print( "Multiplicacion: " + mult + "<p>");
     out.print( "Division: " + div + "<p>");
  %>
    </body>
</html>
