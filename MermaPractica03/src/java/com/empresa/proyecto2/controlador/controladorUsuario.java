
package com.empresa.proyecto2.controlador;

import com.empresa.proyecto2.DTO.UsuarioDTO;
import com.empresa.proyecto2.DTO.conexion;
import java.util.List;
import javax.validation.Valid;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controladorUsuario {
    public controladorUsuario(){
        conexion xcon = new conexion();
        this.plantillaJDBC = new JdbcTemplate(xcon.conexion());
    }
    
    private JdbcTemplate plantillaJDBC;
    @RequestMapping(value = "formulario")
    public ModelAndView mostrar(){
        ModelAndView mav = new ModelAndView("formulario");
        UsuarioDTO usua = new UsuarioDTO();
        mav.addObject("usua", usua);
        return mav;
    }
    
    
    @RequestMapping(value="resultado", method = RequestMethod.POST)
    public ModelAndView resultado(@Valid @ModelAttribute("usua") UsuarioDTO usua,
            BindingResult rpta){
        if(rpta.hasErrors()){
            ModelAndView mav = new ModelAndView("formulario");
            return mav;
        }else{
            ModelAndView mvc = new ModelAndView();
            String sql;
            List datos;
            switch(usua.getTipo()){
            case "Admin":
                sql = "SELECT * from usuarios";
                datos = this.plantillaJDBC.queryForList(sql);
                mvc.addObject("datos", datos);
                break;
            case "Normal":
                sql = "SELECT * from usuarios where nombre='"+usua.getNombre()+"';";
                datos = this.plantillaJDBC.queryForList(sql);
                mvc.addObject("datos", datos);
                break;
            default:
                break;
        }
            mvc.setViewName("resultado");
            return mvc;
        }
    }
    
}
