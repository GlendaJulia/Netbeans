<%-- 
    Document   : resultado
    Created on : 04/11/2018, 07:00:36 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla de multiplicar</h1>
        <table border="1">
            <tr>
                <th>Operacion</th>
                <th>Respuesta</th>
                <th>P/I</th>
            </tr>
            <c:forEach var="item" 
                       items="${listas}">
                <tr>
                    <td><b>${item}*${num1}</b></td>
                    <td><b>${item*num1}</b></td>
                    <td>
                        <c:choose>
                            <c:when test="${item*num1%2==0}">
                                <input type="checkbox" disabled="true">
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" disabled="false">
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
