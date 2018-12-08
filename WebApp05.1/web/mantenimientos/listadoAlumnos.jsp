<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Alumnos</title>
    <link href="/WebApp05.1/css/estilo.css" type="text/css" rel="stylesheet"/>
  </head>
  <body>
    <h3>Listado de Alumnos</h3>
    <form method=POST action="/WebApp05.1/controladorPrincipal">
    <input type=HIDDEN name=accion value="NuevoEliminarAlumno">
    <table id="listado">
       <tr>
          <th>Sel.</th>
          <th>Codigo</th>
          <th>Nombre</th>
          <th>Direccion</th>
          <th>Email</th>
          <th>Telefono</th>
          <th>Celular</th>
          <th>Sexo</th>
          <th>Fec. Nacimiento</th>
          <th>Estado</th>
      </tr>
        <c:forEach items="${arrAlumnos}" var="alumno">
          <tr>
              <td><input type=checkbox name='xcod'
                    value=<c:out value='${alumno[0]}'/> > </td>
              <td><c:out value='${alumno[0]}'/></td>
              <td><a href="/WebApp05.1/controladorPrincipal?accion=modificarAlumno&xcod=
                       <c:out value='${alumno[0]}'/>">
                  <c:out value='${alumno[1]}' /></a></td>
              <td><c:out value='${alumno[2]}'/></td>
              <td><c:out value='${alumno[3]}'/></td>
          <td><c:out value='${alumno[4]}'/></td>
          <td><c:out value='${alumno[5]}'/></td>
          <td><c:out value='${alumno[6]}'/></td>
          <td><c:out value='${alumno[7]}'/></td>
          <td><c:out value='${alumno[8]}'/></td></tr>
        </c:forEach>
       </table>
       <br>
       <input type=submit name=boton value="Eliminar Registros">
       <input type=submit name=boton value="Nuevo Registro">
    </form>
  </body>
</html>
