/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.WS;

import com.tecsup.datos.cBaseDatos;
import java.sql.SQLException;
import java.util.Vector;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author USER
 */
@Path("usuarios")
public class usuariosRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of usuariosRest
     */
    public usuariosRest() {
    }

    /**
     * Retrieves representation of an instance of com.tecsup.WS.usuariosRest
     * @return an instance of java.lang.String
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsuarios() throws JSONException {
        JSONArray listaJSON = new JSONArray();
        cBaseDatos datos = new cBaseDatos();
        Vector listaUsuarios = datos.getUsuarios();
        for(int i=0; i<listaUsuarios.size();i++){
            Vector usuarios = (Vector) listaUsuarios.get(i);
            JSONObject obj = new JSONObject();
            obj.put("codigo",usuarios.get(0));
            obj.put("nombre",usuarios.get(1));
            obj.put("clave",usuarios.get(2));
            obj.put("estado",usuarios.get(3));
            listaJSON.put(obj);
        }
        return listaJSON.toString();
    }
    
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public String validaUsuarios(@QueryParam("nombre") String pnombre,
                                @QueryParam("clave") String pclave) throws JSONException {
        JSONArray listaJSON = new JSONArray();
        cBaseDatos datos = new cBaseDatos();
        boolean verificaUsuario = datos.validarUsuario(pnombre, pclave);
        JSONObject obj = new JSONObject();
        obj.put("login", verificaUsuario);
        listaJSON.put(obj);
        return listaJSON.toString();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Path("consult")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarUsuarios(@QueryParam("nombre") String pnombre) 
            throws JSONException, SQLException {
        JSONArray listaJSON = new JSONArray();
        cBaseDatos datos = new cBaseDatos();
        Vector datosUsuarios = datos.buscarUsuario(pnombre);
        for (int i = 0; i < datosUsuarios.size(); i++) {         
            Vector usuarios = (Vector) datosUsuarios.get(i);
            JSONObject obj = new JSONObject();
            obj.put("codigo", usuarios.get(0));
            obj.put("nombre", usuarios.get(1));
            obj.put("clave", usuarios.get(2));
            obj.put("estado", usuarios.get(3));            
            listaJSON.put(obj);            
        }
        return listaJSON.toString();
    }
    
    @PUT
    @Path("edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public String modificarUsuarios(
            @QueryParam("codigo") String pcodigo,
            @QueryParam("nombre") String pnombre,
            @QueryParam("clave") String pclave,
            @QueryParam("estado") String pestado) 
            throws JSONException, SQLException{
        JSONArray listaJSON = new JSONArray();
        cBaseDatos datos = new cBaseDatos();
        String[] recibido = new String[4];
        recibido[0] = pcodigo;
        recibido[1] = pnombre;
        recibido[2] = pclave;
        recibido[3] = pestado;
        boolean estadoGuardar = datos.modificarUsuarios(recibido);
        JSONObject obj = new JSONObject();
        obj.put("status", estadoGuardar);
        listaJSON.put(obj);
        return listaJSON.toString();
    }
    
    @PUT
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String agregarUsuarios(@QueryParam("nombre") String pnombre,
            @QueryParam("clave") String pclave,
            @QueryParam("estado") String pestado) 
            throws JSONException{
        JSONArray listaJSON = new JSONArray();
        cBaseDatos datos = new cBaseDatos();
        String[] recibido = new String[3];
        recibido[0] = pnombre;
        recibido[1] = pclave;
        recibido[2] = pestado;
        boolean estadoGuardar = datos.grabarNuevoUsuario(recibido);
        JSONObject obj = new JSONObject();
        obj.put("status", estadoGuardar);
        listaJSON.put(obj);
        return listaJSON.toString();
    }
@PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String actualizarUsuarios(@QueryParam("codigo")String codigo,@QueryParam("nombre") String pnombre,
            @QueryParam("clave") String pclave,
            @QueryParam("estado") String pestado)
            throws JSONException, SQLException{
        JSONArray listaJSON = new JSONArray();
        cBaseDatos datos = new cBaseDatos();
        String[] recibido = new String[4];
        recibido[0]=codigo;
        recibido[1] = pnombre;
        recibido[2] = pclave;
        recibido[3] = pestado;
        datos.modificarUsuario(recibido);
       return "usuario actualizado";
    }
    @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public String eliminarUsuarios(@QueryParam("codigo") String codigo ) 
            throws JSONException, SQLException{
        JSONArray listaJSON = new JSONArray();
        cBaseDatos datos = new cBaseDatos();
        String[] recibido = new String[3];     
        recibido[0] = codigo;
        datos.eliminarUsuarios(recibido);
        return "usuario se eliminó";
    }

}
