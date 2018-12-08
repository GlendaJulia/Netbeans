<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="/WebApp05.1/css/estilo.css" type="text/css" rel="stylesheet"/>
 </head>
 <body>
  <h3><c:out value='${titulo}'/></h3>
  
  <form name=mod_opcion method=POST action="/WebApp05.1/controladorPrincipal">
     <input type=hidden name=accion value='GRABAR_ALUMNO'>
     <input type=hidden name=operacion value='<c:out value='${operacion}'/>'>
     <input type=hidden name=xcod value="<c:out value='${registro[0]}'/>">
     <table id="editar">
        <tr><th>Codigo: </th>
            <td><c:out value='${registro[0]}'/> </td> </tr>
        <tr><th>Nombre: </th>
            <td><input name=xnom value="<c:out value='${registro[1]}'/>"
                size=40></td></tr>
        <tr><th>Direccion: </th>
            <td><input name=xdir value="<c:out value='${registro[2]}'/>" 
                size=15></td></tr>
        <tr><th>Email: </th>
            <td><input name=xema value="<c:out value='${registro[3]}'/>" 
                size=15></td></tr>
        <tr><th>Telefono: </th>
            <td><input name=xtel value="<c:out value='${registro[4]}'/>" 
                size=15></td></tr>
        <tr><th>Celular: </th>
            <td><input name=xcel value="<c:out value='${registro[5]}'/>" 
                size=15></td></tr>
        <tr><th>Sexo</th>
            <td><c:choose>
                  <c:when test="${registro[6]=='M'}">
                      <input type=radio name=xsex value=F>Femenino
                      <input type=radio name=xsex value=M checked>Masculino
                  </c:when>
                  <c:otherwise>
                      <input type=radio name=xsex value=F checked>Femenino
                      <input type=radio name=xsex value=M>Masculino
                  </c:otherwise>
                </c:choose>
            </td></tr>
        <tr><th>Fecha de Nacimiento: </th>
            <td><input name=xfec value="<c:out value='${registro[7]}'/>" 
                size=15></td></tr>
        <tr><th>Estado:</th>
            <td><c:choose>
                  <c:when test="${registro[8]=='X'}">
                      <input type=radio name=xest value=A>Activo
                      <input type=radio name=xest value=X checked>Inactivo
                  </c:when>
                  <c:otherwise>
                      <input type=radio name=xest value=A checked>Activo
                      <input type=radio name=xest value=X>Inactivo
                  </c:otherwise>
                </c:choose>
            </td></tr>
     </table>
     <br>

     <input type=submit name=boton value="GRABAR">
     <input type=submit name=boton value="CANCELAR">

   </form>
 </body>
</html>

