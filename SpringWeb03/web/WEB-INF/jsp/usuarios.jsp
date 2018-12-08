<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link href="css/jquery-ui-1.10.0.custom.css" type="text/css"
              rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="css/crud.css" type="text/css" rel="stylesheet"/>

        <script src="js/jquery-1.9.0.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.10.0.custom.js" type="text/javascript">
        </script>
        <script src="js/crud.js" type="text/javascript"></script>

    </head>
    <body onload="pi_load()">
    <center><h1>Listado de Usuarios</h1></center>
        <table class="parainfo" style="margin: auto;width: 540px">
            <thead>
                <tr>
                    <td>Nombre</td>
                    <td>Clave</td>
                    <td>Estado</td>
                    <th class="crud">
                        <a href="#" class="ins"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="del"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="upd"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="f" items="${usuarios_list}">
                    <tr>
                        <td>${f.nombre}</td>
                        <td>${f.clave}</td>
                        <td colspan="2">${f.estado}</td>
                        <th>
                            <input type="checkbox" name="_del" 
                                   value="${f.codigo}"/>
                        </th>
                        <th>
                            <input type="radio" name="_upd" 
                                   value="${f.codigo}"/>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
