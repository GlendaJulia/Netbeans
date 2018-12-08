package biblioteca;

public class Biblioteca {
    private String codigoLibro;
    private int codigoUsuario;
    private String codigoPlan;
    private String contraseña;
    private String valorPrestamo;
    
    public Biblioteca(String codigoLibro, int codigoUsuario, String codigoPlan, String contraseña, String valorPrestamo){
        this.codigoLibro = codigoLibro;
        this.codigoUsuario = codigoUsuario;
        this.codigoPlan = codigoPlan;
        this.contraseña = contraseña;
        this.valorPrestamo = valorPrestamo;
    }
    public String Verificar(){
    if(codLibro(codigoLibro)&&codUsuario(codigoUsuario)&&codPlan(codigoPlan)&&Contraseña(contraseña)&&Prestamo(valorPrestamo)){
        return "Éxito de la operación";
    }else if (codLibro(codigoLibro)==false &&codUsuario(codigoUsuario)&&codPlan(codigoPlan)&&Contraseña(contraseña)&&Prestamo(valorPrestamo)){
        return "Código de libro erróneo";
    }
    else if(codLibro(codigoLibro)&&codUsuario(codigoUsuario)==false &&codPlan(codigoPlan)&&Contraseña(contraseña)&&Prestamo(valorPrestamo)){
        return "Código de usuario erróneo";
    }else if(codLibro(codigoLibro)&&codUsuario(codigoUsuario)&&codPlan(codigoPlan)==false &&Contraseña(contraseña)&&Prestamo(valorPrestamo)){
        return "Código de plan erróneo";
    }else if (codLibro(codigoLibro)&&codUsuario(codigoUsuario)&&codPlan(codigoPlan)&&Contraseña(contraseña)==false &&Prestamo(valorPrestamo)){
        return "Contraseña errónea";
    }else if (codLibro(codigoLibro)&&codUsuario(codigoUsuario)&&codPlan(codigoPlan)&&Contraseña(contraseña)&&Prestamo(valorPrestamo)==false){
        return "Tipo de préstamo erróneo";
    }else{
        return "Datos incorrectos";
    }
}
    public boolean codLibro(String codigoLibro){
        int tamaño = codigoLibro.length();
        return tamaño>4 && tamaño<6;
    }
    
    public boolean codUsuario(int codigoUsuario){
        return codigoUsuario>=100000 && codigoUsuario<=999999;
    }
    
    public boolean codPlan(String codigoPlan){
        int tamaño = codigoPlan.length();
        return tamaño==4;
    }
    public boolean Contraseña(String contraseña){
        int tamaño = contraseña.length();
        return tamaño==5;
    }
    
    public boolean Prestamo(String reserva){
        return reserva.equals("General") || reserva.equals("Reserva");
    }
}
