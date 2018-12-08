package funciones.tecsup.pe;

public class OperacionesDiversas {
    public double raiz_cuadrada(double a){
        double r = Math.pow(a, (1.0/2.0));
        return r;
    }
    public double raiz_cubica(double a){
        double r = Math.pow(a, (1.0/3.0));
        return r;
    }
    public double potencia(int a, int b){
        double r = Math.pow(a, b);
        return r;
    }
    public double absoluto(int a){
        double r = Math.abs(a);
        return r;
    }
}
