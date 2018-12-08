<%-- 
    Document   : prueba_java3
    Created on : 20/08/2018, 01:07:23 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String cadena="El numero mayor es: "; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejercicio Propuesto 1</h1>
        <%
         int j = 3;
         int i = 5;
         if (i > j ) {
             out.print(cadena + i);
         }else{
             out.print(cadena + j);
         }
     %>
    </body>
</html>
