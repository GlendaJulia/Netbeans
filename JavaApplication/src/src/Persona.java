package src;

public class Persona {
    private String usuario;
    private String contraseña;
    private int sizeUsuario;
    private int sizePass;
    
    public Persona(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.sizeUsuario = usuario.length();
        this.sizePass = contraseña.length();
    }
    public boolean Verificar(){
    assert (sizeUsuario>1) && (sizePass>1);
    return (sizeUsuario>=6) && (sizePass>=10);
}
}
