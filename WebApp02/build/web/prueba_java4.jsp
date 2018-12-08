<%-- 
    Document   : prueba_java4
    Created on : 20/08/2018, 01:16:01 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String si=" es numero primo"; %>
<%! String no=" no es numero primo"; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejercicio Propuesto 2</h1>
        <%
         int j = 16;
         int contador = 0;
         for(int x = 1; x <= j; x++){
            if((j % x) == 0){
                contador++;
            }
        }
        if(contador <= 2){
            out.print("El numero "+j+si);
        }else{
            out.print("El numero "+j+no);
        }
     %>
    </body>
</html>
