<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>
    <body>
        <h1 align="center">Formulario de Login</h1>     
        <form:form modelAttribute="usua" align="center" action="resultado.htm" method="POST">
            <table>
                <tr>
                    <td><label for="formGroupExampleInput">Nombre:</label></td>
                    <td><form:input path="nombre" cssClass="form-control" id="formGroupExampleInput" /></td>
                    <td><form:errors path="nombre" style="color: red"/></td>
                </tr>
                <tr>
                    <td><label for="formGroupExampleInput">Clave: </label></td>
                    <td><form:input path="clave" cssClass="form-control" id="formGroupExampleInput" /></td>
                    <td><form:errors path="clave" style="color: red"/></td>
                </tr>
                <tr>
                    <td><label for="formGroupExampleInput">DNI:</label></td>
                    <td><form:input path="DNI" cssClass="form-control" id="formGroupExampleInput" /></td>
                    <td><form:errors path="DNI" style="color: red"/></td>
                </tr>
                <tr>
                    <td><label for="formGroupExampleInput">Correo: </label></td>
                    <td><form:input path="correo" cssClass="form-control" id="formGroupExampleInput" /></td>
                    <td><form:errors path="correo" style="color: red"/></td>
                </tr>
                <tr>
                    <td><label for="exampleFormControlSelect2">Tipo:</label></td>
                    <td><form:select path="tipo">
                <form:option value="" label="--- Select ---"/>
                <form:options items="${usua.tipos}" />
                </form:select></td>
                    <td><form:errors path="tipo" style="color: red"/></td>
                </tr>
                <tr>
                    <td><input align="center" type="submit" value="Solicitar nueva Tarjeta" class="btn btn-primary" /></td>
                </tr>
            </table>
            
        </form:form>
    </body>
</html>

