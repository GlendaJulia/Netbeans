<%-- 
    Document   : resultados
    Created on : 29/10/2018, 01:02:40 PM
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
        ${ope}
        <table border="1">
            <tr>
                <td colspan="3">Resultados</td>
            </tr>
            <tr>
                <td>Numero 1</td>
                <td>Numero 2</td>
                <td>Resultado</td>
            </tr>
            <tr>
                <td><c:out value="${num1}"/></td>
                <td><c:out value="${num2}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${ope=='sum'}">
                            <c:out value="Suma: ${num1+num2}"/>
                        </c:when>
                        <c:when test="${ope=='res'}">
                            <c:out value="Resta: ${num1-num2}"/>
                        </c:when>
                        <c:when test="${ope=='mul'}">
                            <c:out value="Multiplicacion: ${num1*num2}"/>
                        </c:when>
                        <c:when test="${ope=='div'}">
                            <c:out value="Division: ${num1/num2}"/>
                        </c:when>
                        <c:otherwise>
                            <c:out value="Operador incorrecto"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </body>
</html>
