<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set  var="nombre" value="Glenda"/>
        <c:set  var="apellido" value="Merma"/>
        <h1>hello world</h1>
        <c:out value="hola"/>
        <c:out value="${nombre}"/>
        <p>
        <c:out value="hola"/>
        <c:out value="${nombre} ${apellido}"/>
        <p>
        <c:set var="tabla" value="5" />
        Tabla del <c:out value="${tabla}"/>
        <br>
        <c:forEach var="contador" begin="1" end="10">
            <c:set var="producto" value="${contador*tabla}"/>
            <c:out value="${contador} x ${tabla} = ${producto}"/>
            <br>
        </c:forEach>

    </body>
</html>
