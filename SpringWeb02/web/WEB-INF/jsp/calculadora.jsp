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
        <h1>Calculadora</h1>     
        <form:form modelAttribute="calcu" action="resultado.htm" method="POST">
            <div class="form-group" style="width: 250px;">
                <label for="formGroupExampleInput">Valor 1:</label>
                <form:input path="valor1" cssClass="form-control" id="formGroupExampleInput" />
                <form:errors path="valor1" style="color: red"/>
            </div>
            <div class="form-group" style="width: 250px;">
                <label for="formGroupExampleInput">Valor 2:</label>
                <form:input path="valor2" cssClass="form-control" id="formGroupExampleInput" />
                <form:errors path="valor2" style="color: red"/>
            </div>
            <div class="form-group" style="width: 250px;">
                <label for="exampleFormControlSelect2">Operacion:</label>
                <form:select path="operacion" cssClass="form-control" id="exampleFormControlSelect2">
                  <form:options items="${calcu.getOperaciones()}" />
                </form:select>
            </div>
            <input type="submit" value="Calcular" class="btn btn-primary" />
            <a href="index.jsp" class="btn btn-primary" >Volver a Index</a>
        </form:form>
    </body>
</html>

