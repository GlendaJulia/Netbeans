
package com.empresa.proyecto.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {
         
    @RequestMapping("resultados.htm")
    public ModelAndView resultados(HttpServletRequest variable){
        ModelAndView modelovista = new ModelAndView();
        modelovista.setViewName("resultados");
            String num1 = variable.getParameter("num1");
            String num2 = variable.getParameter("num2");
            String ope = variable.getParameter("ope");
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            List<String> list = getList(n1,n2);
            List<String> listas = numeros(12);
            modelovista.addObject("list",list);
            modelovista.addObject("listas",listas);
            modelovista.addObject("num1",num1);
            modelovista.addObject("ope",ope);
            return modelovista;
    }
    
    private List<String> numeros(int nume) {
    List<String> list = new ArrayList<String>();
    for (int x=0;x<=nume;x++) {
            list.add(Integer.toString(x));
    }
    return list;
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
