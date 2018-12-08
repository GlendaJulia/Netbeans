package com.empresa.proyecto2.controlador;

import com.empresa.proyecto2.DTO.CalculadoraDTO;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controladorCalculadora {
    
    @RequestMapping(value = "index", method=RequestMethod.GET)
    public ModelAndView viewRegister(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    @RequestMapping(value="calculadora")
    public ModelAndView mostrar(){
        ModelAndView mav = new ModelAndView("calculadora");
        CalculadoraDTO calculadoraForm = new CalculadoraDTO();
        mav.addObject("calcu", calculadoraForm);
        return mav;
    }
    
    @RequestMapping(value="resultado", method = RequestMethod.POST)
    public ModelAndView resultado(@Valid @ModelAttribute("calcu") CalculadoraDTO calcu,
            BindingResult rpta){
        if(rpta.hasErrors()){
            ModelAndView mav = new ModelAndView("calculadora");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView("resultado");
            Double resultado = 0.0;
            switch(calcu.getOperacion()){
            case "suma" :
                resultado = Double.valueOf(calcu.getValor1())+Double.valueOf(calcu.getValor2());
                break;
            case "resta" :
                resultado = Double.valueOf(calcu.getValor1())-Double.valueOf(calcu.getValor2());
                break;
            case "multiplicacion" :
                resultado = Double.valueOf(calcu.getValor1())*Double.valueOf(calcu.getValor2());
                break;
            case "division" :
                resultado = Double.valueOf(calcu.getValor1())/Double.valueOf(calcu.getValor2());
                break;
        }
            mav.addObject("calcu", calcu);
            mav.addObject("rs",resultado);
            return mav;
        }
    }
    
    
}
