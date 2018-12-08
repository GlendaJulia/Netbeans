<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Cursos</title>
    <link href="/WebApp05.1/css/estilo.css" type="text/css" rel="stylesheet"/>
  </head>
  <body>
    <h3>Listado de Cursos</h3>
    <form method=POST action="/WebApp05.1/controladorPrincipal">
    <input type=HIDDEN name=accion value="NuevoEliminarCurso">
    <table id="listado">
       <tr>
          <th>Sel.</th>
          <th>Codigo</th>
          <th>Nombre</th>
          <th>Costo</th>
          <th>Fec. Inicio</th>
          <th>Fec. Fin</th>
          <th>Duracion</th>
          <th>Sesiones</th>
          <th>Capacidad</th>
          <th>Inscritos</th>
          <th>Estado</th>
      </tr>
        <c:forEach items="${arrCursos}" var="curso">
          <tr>
              <td><input type=checkbox name='xcod'
                    value=<c:out value='${curso[0]}'/> > </td>
              <td><c:out value='${curso[0]}'/></td>
              <td><a href="/WebApp05.1/controladorPrincipal?accion=modificarCurso&xcod=
                       <c:out value='${curso[0]}'/>">
                  <c:out value='${curso[1]}' /></a></td>
              <td><c:out value='${curso[2]}'/></td>
              <td><c:out value='${curso[3]}'/></td>
              <td><c:out value='${curso[4]}'/></td>
              <td><c:out value='${curso[5]}'/></td>
              <td><c:out value='${curso[6]}'/></td>
              <td><c:out value='${curso[7]}'/></td>
              <td><c:out value='${curso[8]}'/></td>
              <td><c:out value='${curso[9]}'/></td></tr>
        </c:forEach>
       </table>
       <br>
       <input type=submit name=boton value="Eliminar Registros">
       <input type=submit name=boton value="Nuevo Registro">
    </form>
  </body>
</html>
