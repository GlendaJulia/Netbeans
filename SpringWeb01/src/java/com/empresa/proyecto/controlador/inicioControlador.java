package com.empresa.proyecto.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


 @Controller
public class inicioControlador {
    @RequestMapping("inicio.htm")
    public ModelAndView inicio(){
        ModelAndView modelovista = new ModelAndView();
        modelovista.setViewName("inicio");
        return modelovista;
    }
    @RequestMapping("nosotros.htm")
    public ModelAndView nosotros(){
        ModelAndView modelovista = new ModelAndView();
        modelovista.setViewName("nosotros");
        return modelovista;
    }
    @RequestMapping("acercade.htm")
    public ModelAndView acercade(){
        ModelAndView modelovista = new ModelAndView();
        modelovista.setViewName("acercade");
        return modelovista;
    }
    @RequestMapping(value="resultados.htm")
    public ModelAndView resultados(HttpServletRequest variable){
        ModelAndView modelovista = new ModelAndView();
        modelovista.setViewName("resultados");
        String num1 = variable.getParameter("num1");
        String num2 = variable.getParameter("num2");
        String ope = variable.getParameter("ope");
        modelovista.addObject("num1",num1);
        modelovista.addObject("num2",num2);
        modelovista.addObject("ope",ope);
        return modelovista;
    }
    	@RequestMapping(value="primos.htm")
	public ModelAndView primos(HttpServletRequest variable) {
            ModelAndView modelovista = new ModelAndView();
            modelovista.setViewName("primos");
            String num1 = variable.getParameter("num1");
            String num2 = variable.getParameter("num2");
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            List<String> list = getList(n1,n2);
            modelovista.addObject("list",list);
            return modelovista;
	}
    
  public boolean esPrimo(int numero){
  int contador = 2;
  boolean primo=true;
  while ((primo) && (contador!=numero)){
    if (numero % contador == 0)
      primo = false;
    contador++;
  }
  return primo;
}
  private List<String> getList(int inicio, int fin) {
     List<String> list = new ArrayList<String>();
    for (int x=inicio;x<=fin;x++) {
        if (esPrimo(x)){
            list.add(Integer.toString(x));
        }
    }
    return list;

    }
}
