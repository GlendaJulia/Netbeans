package beans;

public class Autos {
    private Integer codigo;
    private String nombre;
    private String color;
    private Integer velocidad;
    private String fabricacion;
    
    public Autos(){
    }
    public Autos(Integer codigo, String nombre, String color, Integer velocidad,
            String fabricacion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.velocidad = velocidad;
        this.fabricacion = fabricacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public String getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(String fabricacion) {
        this.fabricacion = fabricacion;
    }
}
