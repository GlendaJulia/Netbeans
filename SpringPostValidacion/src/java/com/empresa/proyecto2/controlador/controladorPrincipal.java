package com.empresa.proyecto2.controlador;

import com.empresa.proyecto2.DTO.formularioDTO;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controladorPrincipal {
    @RequestMapping(value = "formulario")
    public ModelAndView mostrar(){
        ModelAndView mav = new ModelAndView("formulario");
        formularioDTO form = new formularioDTO();
        mav.addObject("form", form);
        return mav;
    }
    
    @RequestMapping(value = "resultado", method = RequestMethod.POST)
    public ModelAndView resultado(@Valid @ModelAttribute("form") formularioDTO form, BindingResult rpta){
        if(rpta.hasErrors()){
            ModelAndView mav = new ModelAndView("formulario");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView("resultado");
        String sexo;
        switch(form.getSexo()){
            case "Masculino":
                sexo="Sr";
                break;
            case "Femenino":
                sexo="Srta";
                break;
            default:
                sexo="No definido";
                break;
        }
        mav.addObject("sexo", sexo);
        mav.addObject("form", form);
        return mav;
        }
    }
}
