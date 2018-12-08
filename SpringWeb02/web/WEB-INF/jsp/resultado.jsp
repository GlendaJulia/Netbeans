<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <h1>Resultado de ${calcu.getOperacion()}</h1>     
            <div class="form-group" style="width: 250px;">
                <label for="formGroupExampleInput">Valor 1:</label>
                <Label class="form-control" id="formGroupExampleInput">${calcu.getValor1()}</label>
            </div>
            <div class="form-group" style="width: 250px;">
                <label for="formGroupExampleInput">Valor 2: </label>
                <Label class="form-control" id="formGroupExampleInput">${calcu.getValor2()}</label>
            </div>
            <div class="form-group" style="width: 250px;">
                <label for="exampleFormControlSelect2">Resultado:</label>
                <Label class="form-control" id="formGroupExampleInput">${rs}</label>
            </div>
            <a href="calculadora.htm" class="btn btn-primary">Realizar otra operacion</a>
    </body>
</html>


