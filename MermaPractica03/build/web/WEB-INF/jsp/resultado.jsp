<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>LISTADO JDBC</title>
    </head>
    <body>
        <center><h1>Listado de Datos</h1></center>
        <div class="container">
            <div class="row">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <td>Nombre</td>
                            <td>Clave</td>
                            <td>DNI</td>
                            <td>Correo</td>
                            <td>Tipo</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.nombre}"/></td>
                                <td><c:out value="${dato.clave}"/></td>
                                <td><c:out value="${dato.dni}"/></td>
                                <td><c:out value="${dato.correo}"/></td>
                                <td><c:out value="${dato.tipo}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="form-group">
                <a href="formulario.htm" class="btn btn-primary" >Cerrar Sesion</a>
            </div>
        </div>
    </body>
</html>
