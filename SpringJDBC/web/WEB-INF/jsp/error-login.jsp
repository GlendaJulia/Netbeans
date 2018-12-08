<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Acceso Denegado</title>
    </head>
    <body>
        <center>
            <div class="alert alert-primary" role="alert">
                <h1>Error de Acceso</h1>
                Las credenciales suministradas son incorrectas <br>
                Vuelva a autentificarse con las credenciales correctas <br>
                <a class="btn btn-danger" href="javascript:history.back(-1);" 
                    accesskey=""title="Regresar a la pagina anterior">Volver</a>
            </div>          
        </center>
    </body>
</html>
