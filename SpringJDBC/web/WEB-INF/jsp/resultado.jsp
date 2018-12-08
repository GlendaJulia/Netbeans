<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <c:choose>
    <c:when test="${msm.equals('vacio')}">
       <div class="jumbotron">
                 <center><h1>No se encontró ninguna coincidencia con lo buscado.</h1></center>
             </div>
        <br />
    </c:when>    
    <c:otherwise>
            <div class="row">
              
                </div>
            <p></p>
            <table class="table table-bordered table-striped table-hover">
                
                <thead>
                    <tr>
                       <th>Usuario</th>
                        <th>Clave</th>
                        <th>Nombres</th>
                        <th>Direccion</th>
                        <th>Teléfono</th>
                        <th>Correo</th>   
                        <th>Sexo</th>
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
                        </tr>
                        
                    </c:forEach>
                </tbody>
                
                
            </table>
       
    </c:otherwise>
</c:choose>
        </div>
        <a href="<c:url value="index.htm"/>" class="btn btn-success">
                    Volver a realizar la busqueda
                </a>
    </body>
</html>
