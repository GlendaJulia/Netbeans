
package com.empresa.proyecto.controlador;

import com.empresa.proyecto.clases.conexion;
import com.empresa.proyecto.clases.datosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.Valid;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controladorPrincipal {
    private JdbcTemplate plantillaJDBC;
    
    public controladorPrincipal(){
        conexion xcon = new conexion();
        this.plantillaJDBC = new JdbcTemplate(xcon.conexion());
        
    }
    @RequestMapping(value = "listado")
    public ModelAndView listado(){
        ModelAndView mvc = new ModelAndView();
        String sql = "SELECT * from datos";
        List datos = this.plantillaJDBC.queryForList(sql);
        mvc.addObject("datos", datos);
        mvc.setViewName("listado");
        return mvc;
    }
    
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView buscar(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        mav.addObject("datos", new datosDTO());
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView buscar (@ModelAttribute("datos") datosDTO d ){
        String nom= d.getNombres();
        ModelAndView mvc = new ModelAndView();
        String sql ="SELECT * FROM datos where nombres like '%"+nom+"%'";
        List datos= this.plantillaJDBC.queryForList(sql);
        String msm="vacio";
        if(!datos.isEmpty()){
            mvc.addObject("datos",datos);
            mvc.setViewName("resultado");
            return mvc;
        }else{
         mvc.addObject("msm",msm);
         mvc.setViewName("resultado");
        return mvc;}
    }
    
    @RequestMapping(value = "agregar", method = RequestMethod.GET)
    public ModelAndView agregar(){
        ModelAndView mvc = new ModelAndView();
        mvc.addObject("datos", new datosDTO());
        mvc.setViewName("agregar");
        return mvc;
    }
    
    @RequestMapping(value = "agregar", method=RequestMethod.POST)
    public ModelAndView agregar
        (
                @Valid
                @ModelAttribute("datos") datosDTO d,
                BindingResult result,
                SessionStatus status
        ){
            if(result.hasErrors()){
            ModelAndView mav = new ModelAndView("agregar");
            return mav;
        }else{
               this.plantillaJDBC.update(
             "insert into datos(usuario,clave,nombres,direccion,telefono,correo, sexo) "
                    + "values(?,?,?,?,?,?,?)",
                    d.getUsuario(),d.getClave(),d.getNombres(),d.getDireccion(),
                    d.getTelefono(),d.getCorreo(),d.getSexo()
            );
        return new ModelAndView("redirect:/listado.htm"); 
            }
    }
        
    public datosDTO seleccionarUsuario(int id){
        final datosDTO datos = new datosDTO();
        String consulta = "SELECT * FROM datos WHERE codigo="+ id;
        return (datosDTO) plantillaJDBC.query(
                consulta, new ResultSetExtractor<datosDTO>(){
                    public datosDTO extractData(ResultSet rs) throws SQLException, DataAccessException{
                        if(rs.next()){
                            datos.setUsuario(rs.getString("usuario"));
                            datos.setClave(rs.getString("clave"));
                            datos.setNombres(rs.getString("nombres"));
                            datos.setDireccion(rs.getString("direccion"));
                            datos.setTelefono(rs.getString("telefono"));
                            datos.setCorreo(rs.getString("correo"));
                            datos.setSexo(rs.getString("sexo"));
                        }
                        return datos;
                    }
                }
        );
    }
    
    @RequestMapping(value="editar", method=RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        datosDTO datos=this.seleccionarUsuario(id);
        mav.addObject("datos",new datosDTO(id,datos.getUsuario(),
                datos.getClave(), datos.getNombres(), datos.getDireccion(),
                datos.getTelefono(), datos.getCorreo(), datos.getSexo()));
        mav.setViewName("editar");
        return mav;
    }
    
    @RequestMapping(value="editar", method=RequestMethod.POST)
    public ModelAndView editar(
            @Valid
            @ModelAttribute("datos") datosDTO d,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ){
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView("editar");
            return mav;
        }else{
            int id=Integer.parseInt(request.getParameter("id"));
        this.plantillaJDBC.update(
                "update datos "
                + "set usuario=?, "
                + "clave=?, "
                + "nombres=?, "
                + "direccion=?, "
                + "telefono=?, "
                + "correo=?, "
                + "sexo=?"
                + " where "
                + "codigo=?",
            d.getUsuario(),d.getClave(),d.getNombres(),d.getDireccion(),
            d.getTelefono(),d.getCorreo(),d.getSexo(),id);
        return new ModelAndView("redirect:/listado.htm");
        }
    }
    
    @RequestMapping(value="eliminar", method=RequestMethod.GET)
    public ModelAndView eliminar(
            @ModelAttribute("datos") datosDTO d,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ){
        int id=Integer.parseInt(request.getParameter("id"));
        this.plantillaJDBC.update(
                "delete from datos"
                + " where "
                + "codigo=?",id);
        return new ModelAndView("redirect:/listado.htm");
    }
    
    @RequestMapping(value="salir", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth!=null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/index.htm";
    }
    
    @RequestMapping(value="acceso-denegado", method = RequestMethod.GET)
    public ModelAndView accessDenied (){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails){
            userDetails = (UserDetails) principal;
        }
        String usuarioLogin = userDetails.getUsername();
        
        ModelAndView model = new ModelAndView();
        model.addObject("usuario",usuarioLogin);
        model.setViewName("acceso-denegado");
        return model;
    }
    
    @RequestMapping(value="login", method= RequestMethod.GET)
    public String login(ModelMap model){
        return "login";
    }
    
    @RequestMapping(value="error-login.htm", method=RequestMethod.GET)
    public ModelAndView loginError(){
        ModelAndView mvc = new ModelAndView();
        mvc.setViewName("error-login");
        return mvc;
    }
}
