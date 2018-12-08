package com.empresa.proyecto2.controlador;

import com.empresa.proyecto.DAO.usuariosDAO;
import com.empresa.proyecto.DAO.usuariosDAOImple;
import com.empresa.proyecto2.DTO.TarjetaDTO;
import com.empresa.proyecto2.DTO.usuariosDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controladorTarjeta {
    private usuariosDAO usuariosDAO;
    public void setUsuariosDAOImple(usuariosDAOImple usuariosDAOImple) {
        this.usuariosDAO = usuariosDAOImple;
    }
    
    //metodo para listar usuarios
    private ModelAndView grilla() {
        List<usuariosDTO> list = usuariosDAO.usuariosListar();
        ModelAndView mav = new ModelAndView("usuarios");
        mav.addObject("usuarios_list", list);
        return mav;
    }
    
    @RequestMapping(value = "usuarios",params = "accion=list")
    public ModelAndView usuariosListar() {
        ModelAndView mav = grilla();
        return mav;
    }
    
    
    
    
    @RequestMapping(value="tarjeta")
    public ModelAndView mostrar(){
        ModelAndView mav = new ModelAndView("tarjeta");
        TarjetaDTO tarjetaForm = new TarjetaDTO();
        mav.addObject("usua", tarjetaForm);
        return mav;
    }
    
    
    @RequestMapping(value="resultado", method = RequestMethod.POST)
    public ModelAndView resultado(HttpServletRequest variable, @Valid @ModelAttribute("usua") TarjetaDTO usua,
            BindingResult rpta ){
        if(rpta.hasErrors()){
            ModelAndView mav = new ModelAndView("tarjeta");
            TarjetaDTO tarjetaForm = new TarjetaDTO();
            String tipo = variable.getParameter("ope");
            mav.addObject("usua", tarjetaForm);
            return mav;
        }else{
            ModelAndView mav = new ModelAndView("resultado");
            return mav;
        }
    }
}






