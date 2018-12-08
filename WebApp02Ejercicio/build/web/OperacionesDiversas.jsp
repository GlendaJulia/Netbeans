<%-- 
    Document   : OperacionesDiversas
    Created on : 20/08/2018, 09:04:39 PM
    Author     : USER
--%>
<%@page import="funciones.tecsup.pe.OperacionesDiversas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
     OperacionesDiversas obj = new OperacionesDiversas();
     double x=25; double y=343; int z=-6; int g=3;
     double r2 = obj.raiz_cuadrada(x);
     double r3 = obj.raiz_cubica(y);
     double pot = obj.potencia(z,g);
     double abs = obj.absoluto(z);
     out.print( "Raiz cuadrada de " + x +" es: "+r2+ "<p>");
     out.print( "Raiz cubica de " + y +" es: "+r3+ "<p>");
     out.print( "El numero " + z +" elevado a "+g+" es: "+pot+ "<p>");
     out.print( "El Valor Absoluto de " + z +" es: "+abs+ "<p>");
  %>
    </body>
</html>
