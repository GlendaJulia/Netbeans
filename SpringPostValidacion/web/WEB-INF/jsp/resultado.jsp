<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
              crossorigin="anonymous">
        <title>Datos Recibidos</title>
    </head>
    <body>
        <center>
       <h1>Datos de Registro recibido</h1>
       <h3>Bienvenido (${sexo}) ${form.getNombre()} </h3>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Nombre:</label>
                    <Label class="form-control" id="formGroupExampleInput">${form.getNombre()}</label>
                </div>
                <div class="form-group col-md-4">
                     <label for="formGroupExampleInput">Apellido:</label>
                     <Label class="form-control" id="formGroupExampleInput">${form.getApellido()}</label>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Correo:</label>
                    <Label class="form-control" id="formGroupExampleInput">${form.getCorreo()}</label>
                </div>
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Clave</label>
                    <Label class="form-control" id="formGroupExampleInput">${form.getClave()}</label>
                </div>
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Edad:</label>
                    <Label class="form-control" id="formGroupExampleInput">${form.getEdad()}</label>
                </div>
            </div>
                <br>
            <div class="form-group">
                <a href="formulario.htm" class="btn btn-primary" >Realizar nuevo Registro</a>
            </div>
            </center>
    </body>
</html>


