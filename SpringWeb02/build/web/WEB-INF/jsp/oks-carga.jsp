<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h3>El archivo fue cargado correctamente</h3>
    <b>Nombre de Archivo:</b> ${nombreArchivo}
    <br/>
    <b>Tamaño de Archivo:</b> ${tamañoArchivo}
    <br/>
    <b>Imagen Cargada: </b>
    <img src="${pageContext.request.contextPath}/resources/images/${nombreArchivo}"/> 
    <br />
    <a href="index.jsp" >Volver a Index</a>
</body>
</html>

