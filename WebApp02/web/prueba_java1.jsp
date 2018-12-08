<%-- 
    Document   : prueba_java1
    Created on : 20/08/2018, 12:30:56 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%! String cadena="Bienvenidos a JSP"; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Glenda Julia Merma Mayhua</h1>
        <%= cadena %>
        <br>
        <% System.out.println( cadena ); %>
    </body>
</html>

