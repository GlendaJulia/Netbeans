<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
              crossorigin="anonymous">

        <title>Formulario Registro</title>
    </head>
    <body style="margin: 0 80px 0 80px;">
    <center>
        <h1>Formulario de Registro</h1>
        <form:form modelAttribute="form" action="resultado.htm" method="POST">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="exampleFormControlSelect2">Sexo:</label>
                    <form:select path="sexo" cssClass="form-control" id="exampleFormControlSelect2">
                      <form:options items="${form.getElementossexo()}" />
                    </form:select> 
                </div>
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Nombre:</label>
                    <form:input path="nombre" cssClass="form-control" id="formGroupExampleInput"
                                placeholder="Ingrese sus nombres"/>
                    <form:errors path="nombre" style="color:red;" />
                </div>
                <div class="form-group col-md-4">
                     <label for="formGroupExampleInput">Apellido:</label>
                     <form:input path="apellido" cssClass="form-control" id="formGroupExampleInput" 
                                 placeholder="Ingrese sus apellidos" />
                     <form:errors path="apellido" style="color:red;" />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Correo:</label>
                    <form:input path="correo" cssClass="form-control" id="formGroupExampleInput"
                                placeholder="Ingrese su correo"/>
                    <form:errors path="correo" style="color:red;" />
                </div>
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Clave</label>
                    <form:password path="clave" cssClass="form-control" id="formGroupExampleInput"
                                   placeholder="Genere una clave"/>
                    <form:errors path="clave" style="color:red;" />
                </div>
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Edad:</label>
                    <form:input path="edad" cssClass="form-control" id="formGroupExampleInput"
                                placeholder="Ingrese su edad"/>
                    <form:errors path="edad" style="color:red;" />
                </div>
            </div>
                <br>
            <div class="form-group">
                <input type="submit" value="Enviar" class="btn btn-primary" />
                <a href="index.htm" class="btn btn-primary" >Volver a Index</a>
            </div>

        </form:form>
            </center>
    </body>
</html>

