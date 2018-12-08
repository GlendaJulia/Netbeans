package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Named(value = "autosBeans")
@SessionScoped
public class autosBeans implements Serializable {

    private static final long serialVersionUID = 6081417964063918994L;
    
    public autosBeans() throws ClassNotFoundException {
        
    }
    
    private List<Autos> autos;
    private String usuario;
    private String clave;
    private String[] tipos = {"Administrador", "Cliente", "Invitado"};
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public List<Autos> getAutos(){
        return autos;
    }
    public void setAutos(List<Autos> autos){
        this.autos = autos;
    }
    public void llenarAutos() throws ClassNotFoundException{
        String[] marcas={"KIA","KIA RIO","KIA RIO CERATO","HYUNDAI","HYUNDAI SANTA FE", "HYUNDAI VELOSTER",
        "HYUNDAI TUCSON","TOYOTA","TOYOTA YARIS","TOYOTA CLASSIC", "SUBARU","HYUNDAI CRETA", "HYUNDAI I20",
        "HYUNDAI I30", "HYUNDAI I10","CHEVROLET","SPARK LITE", "KIA PIKANTO","SUSUKI ALTO","MAZDA"};
        String[] color={"Blanco","Gris","Naranja","Negro","Azul", "Verde",
        "Morado","Rojo","Guinda","Blanco","Gris","Naranja","Negro","Azul", "Verde",
        "Morado","Rojo","Guinda","Blanco","Naranja"};
        int[] velocidad={447,484,434,431,420,415,411,402,402,400,447,484,434,431,420,415,411,402,402,400};
        String[] fecha_fabri={"25 de agosto, 2003","04 de septiembre, 2008","02 de enero, 2000","18 de septiembre, 2018",
            "24 de julio, 2015", "02 de febrero, 2013","21 de julio, 2000","05 de junio, 2012","17 de marzo, 2012",
            "09 de octubre, 2001", "29 de agosto, 2017","01 de enero, 2019", "20 de mayo, 2011","05 de agosto, 2010",
            "17 de junio, 1999","21 de noviembre, 2002","27 de marzo, 2004", "03 de agosto, 2019","23 de enero, 2011","20 de julio, 2007"};
        List<Autos> cars = new ArrayList<Autos>();
        for(int i=0;i<marcas.length;i++){
            Autos car = new Autos();
            car.setCodigo(i);
            car.setNombre(marcas[i]);
            car.setColor(color[i]);
            car.setVelocidad(velocidad[i]);
            car.setFabricacion(fecha_fabri[i]);
            cars.add(car);
        }
        this.setAutos(cars);
    }
    
    public String loginProject() throws ClassNotFoundException{
        if(usuario.equals("admin") && clave.equals("123456") && tipo.equals("Administrador")){
            this.llenarAutos();
            HttpSession session = Sesion.getSession();
            session.setAttribute("username", usuario);
            session.setAttribute("tipo", tipo);
            return "home";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Credenciales invalidas","Intente logearse nuevamente"));
            return "index";
        }
    }
    
    public String logout(){
        HttpSession session = Sesion.getSession();
        session.invalidate();
        return "index";
    }
}
