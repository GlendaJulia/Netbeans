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
                <a href="<c:url value="agregar.htm"/>" class="btn btn-success">
                    Insertar
                </a>
                <a href="<c:url value="index.htm"/>" class="btn btn-success">
                    Buscar
                </a>
                <a href="<c:url value="salir.htm"/>" class="btn btn-danger">
                    Cerrar Sesion
                </a> 
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <td>Usuario</td>
                            <td>Clave</td>
                            <td>Nombres</td>
                            <td>Direccion</td>
                            <td>Telefono</td>
                            <td>Correo</td>
                            <td>Sexo</td>
                            <td>Opciones</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.usuario}"/></td>
                                <td><c:out value="${dato.clave}"/></td>
                                <td><c:out value="${dato.nombres}"/></td>
                                <td><c:out value="${dato.direccion}"/></td>
                                <td><c:out value="${dato.telefono}"/></td>
                                <td><c:out value="${dato.correo}"/></td>
                                <td><c:out value="${dato.sexo}"/></td>
                                <td>
                                    <a href="<c:url value="editar.htm?id=${dato.codigo}"/>"
                                       class="btn btn-primary">Editar</a>
                                    <a href="<c:url value="eliminar.htm?id=${dato.codigo}"/>"
                                       class="btn btn-secondary">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

