<%-- 
    Document   : prueba_java2
    Created on : 20/08/2018, 12:58:16 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <h1>Hello World!</h1>
     <%
         int j = 0;
         while (j < 10 ) {
             out.print(j + "<p>");
             j++;
         }
     %>
</body>
</html>
