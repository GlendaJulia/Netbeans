<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
              crossorigin="anonymous">

        <title>Formulario Login</title>
    </head>
    <body style="margin: 0 80px 0 80px;">
    <center>
        <h1>Formulario de Registro</h1>
        <form:form modelAttribute="usua" action="resultado.htm" method="POST">
            <div class="form-row">
                
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Nombre:</label>
                    <form:input path="nombre" cssClass="form-control" id="formGroupExampleInput"
                                placeholder="Ingrese sus nombres"/>
                    <form:errors path="nombre" style="color:red;" />
                </div>
                <div class="form-group col-md-4">
                    <label for="formGroupExampleInput">Clave</label>
                    <form:password path="clave" cssClass="form-control" id="formGroupExampleInput"
                                   placeholder="Genere una clave"/>
                    <form:errors path="clave" style="color:red;" />
                </div>
                <div class="form-group col-md-4">
                     <label for="formGroupExampleInput">DNI:</label>
                     <form:input path="DNI" cssClass="form-control" id="formGroupExampleInput" 
                                 placeholder="Ingrese su DNI" />
                     <form:errors path="DNI" style="color:red;" />
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
                    <label for="exampleFormControlSelect2">Tipo:</label>
                    <form:select path="tipo" cssClass="form-control" id="exampleFormControlSelect2">
                      <form:option value="" label="--- Select ---"/>
                      <form:options items="${usua.getTipos()}" />
                    </form:select> 
                    <form:errors path="tipo" style="color:red;"/>
                </div>
            </div>
                <br>
            <div class="form-group">
                <input type="submit" value="Ingresar" class="btn btn-primary" />
                <a href="index.htm" class="btn btn-primary" >Volver a Index</a>
            </div>

        </form:form>
            </center>
    </body>
</html>
