
package com.tecsup.prueba;

public class Utilidades {
    public int mayor(int a, int b, int c){
        if (a > b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        } else if (b > c) {
            return b;
        } else {
            return c;
        }
    }
    public int total(int[] arreglo){
        int rpta = 0;
        for (int contador = 0; contador < arreglo.length; contador++) {
            rpta += arreglo[contador];
        }
        return rpta;
    }
}
