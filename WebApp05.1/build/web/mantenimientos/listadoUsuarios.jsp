<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Usuarios</title>
    <link href="/WebApp05.1/css/estilo.css" type="text/css" rel="stylesheet"/>
  </head>
  <body>
    <h3>Listado de Usuarios</h3>
    <form method=POST action="/WebApp05.1/controladorPrincipal">
    <input type=HIDDEN name=accion value="NuevoEliminarUsuario">
    <table id="listado">
       <tr>
          <th>Sel.</th>
          <th>Codigo</th>
          <th>Nombre</th>
          <th>Clave</th>
          <th>Estado</th>
      </tr>
        <c:forEach items="${arrUsuarios}" var="usuario">
          <tr>
              <td><input type=checkbox name='xcod'
                    value=<c:out value='${usuario[0]}'/> > </td>
              <td><c:out value='${usuario[0]}'/></td>
              <td><a href="/WebApp05.1/controladorPrincipal?accion=modificarUsuario&xcod=
                       <c:out value='${usuario[0]}'/>">
                  <c:out value='${usuario[1]}' /></a></td>
              <td><c:out value='${usuario[2]}'/></td>
              <td><c:out value='${usuario[3]}'/></td></tr>
        </c:forEach>
       </table>
       <br>
       <input type=submit name=boton value="Eliminar Registros">
       <input type=submit name=boton value="Nuevo Registro">
    </form>
  </body>
</html>
