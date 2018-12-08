<%-- 
    Document   : primos
    Created on : 04/11/2018, 05:59:12 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primos</title>
    </head>
    <body>
        <select> 
            <c:forEach var="item" items="${list}"> 
                <option>${item}</option> 
            </c:forEach> 
        </select> 
    </body>
</html>
