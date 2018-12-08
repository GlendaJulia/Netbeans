<%-- 
    Document   : Resultados
    Created on : 04/11/2018, 06:29:40 PM
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
        <c:choose>
            <c:when test="${ope=='primos'}">
                <br>
                <br>
                <select> 
                    <c:forEach var="item" items="${list}"> 
                        <option>${item}</option> 
                    </c:forEach> 
                </select> 
            </c:when>
            <c:when test="${ope=='mult'}">
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
                                        <input type="checkbox" checked>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox">
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1>Hola jajaja :v</h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
