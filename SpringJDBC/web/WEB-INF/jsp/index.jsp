<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>

    <body>
        <div class="container">
             <div class="jumbotron">
                 <center><h1>PAGINA DE BUSQUEDA</h1></center>
             </div>
             
            <div class="panel panel-primary">
                <div class="panel-heading">Búsqueda de usuarios</div>
                <div class="panel-body">
                   
                    <form:form method="post" commandName="datos">
                           <center><h2>Ingrese el nombre del usuario a buscar</h2></center>
                            <p>
                                <form:label path="nombres">Nombres:</form:label>
                                <form:input path="nombres" cssClass="form-control" />
                            </p>
                           
                            <hr />
                            <input type="submit" value="Buscar" class="btn btn-success" />
                    </form:form> 
                            <div class="panel panel-heading">
                            <p> <a href="listado.htm">Listado de usuarios</a></p>     
                            </div>
                </div>
            </div>
        </div>
    </body>
</html>
