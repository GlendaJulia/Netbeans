<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <div style="width:1000px; padding-left: 40%; padding-top: 10%;"
             <h1><b>Autentificarse</b></h1>
             <form class="form-group" action="<c:url value='j_spring_security_check'/>" method="POST">
                <div class="form-group">
                    <label for="exampleDropdownFormEmail2">Usuario</label>
                    <input type="text" class="form-control" id="exampleDropdownFormEmail2" 
                           name="usuario" placeholder="usuario">
                </div>
                <div class="form-group">
                    <label for="exampleDropdownFormPassword2">Clave</label>
                    <input type="password" class="form-control" id="exampleDropdownFormPassword2" 
                           name="clave" placeholder="clave">
                </div>
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                <button type="submit" class="btn btn-primary">Ingresar</button>
            </form>
        </div>
    </body>
</html>
