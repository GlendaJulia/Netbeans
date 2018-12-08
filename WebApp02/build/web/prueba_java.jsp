<%-- 
    Document   : prueba_java
    Created on : 20/08/2018, 01:33:40 PM
    Author     : USER
--%>

<%@page import="com.tecsup.prueba.Calculo"%>
<%@page import="com.tecsup.prueba.Utilidades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
     Calculo obj = new Calculo();
     Utilidades obj2 = new Utilidades();
     int men = obj.menor(10,20);
     int may = obj.mayor(10,20);
     int mayor3 = obj2.mayor(12,14,17);
     int[] arri = {1,2,3,4,5,6};
     int suma = obj2.total(arri);
     out.print( "Menor: " + men + "<p>");
     out.print( "Mayor: " + may + "<p>");
     out.print( "Mayor de tres numeros: " + mayor3 + "<p>");
     out.print( "Total de la suma: " + suma + "<p>");
     System.out.print( "Mayor de tres numeros: " + mayor3);
     System.out.print( "Total de la suma: " + suma);
  %>
    </body>
</html>
