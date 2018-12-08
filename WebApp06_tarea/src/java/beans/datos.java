package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "datos")
@SessionScoped
public class datos implements Serializable {
        private String nombres;
    private String correo;
    private String telefono;
    private String depas;
    private String[] cursos;
    private String[] recibir;
    private String si_no;
private String[] departamentos = {"Dpto Informatica", "Dpto Pesada", "Dpto Procesos Mineros",
    "Dpto Electrotecnia", "Dpto Estudios Generales", "Dpto Docencia"};
private String[] materias = {"Matematica", "Fisica", "Quimica", "Programacion Orientada a Objetos",
    "Desarrollo en Android", "Desarrollo en IOS", "Informatica Aplicada",
    "Base de Datos", "Programacion en Moviles", "Des. Apps Empresariales", "Tecnologias Emergentes"};
private String[] informacion = {"Tecnologia",
                                    "Deportes",
                                    "Diplomados", "Becas", "Cultura"};
private String[] politicas = {"SI",  "NO"};

    public datos() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDepas() {
        return depas;
    }

    public void setDepas(String depas) {
        this.depas = depas;
    }

    public String[] getRecibir() {
        return recibir;
    }

    public void setRecibir(String[] recibir) {
        this.recibir = recibir;
    }

    public String getSi_no() {
        return si_no;
    }

    public void setSi_no(String si_no) {
        this.si_no = si_no;
    }

    public String[] getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(String[] departamentos) {
        this.departamentos = departamentos;
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    public String[] getInformacion() {
        return informacion;
    }

    public void setInformacion(String[] informacion) {
        this.informacion = informacion;
    }

    public String[] getPoliticas() {
        return politicas;
    }

    public void setPoliticas(String[] politicas) {
        this.politicas = politicas;
    }
    public String[] getCursos() {
        return cursos;
    }

    public void setCursos(String[] cursos) {
        this.cursos = cursos;
    }
}
