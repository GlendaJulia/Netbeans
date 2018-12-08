package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "datos")
@SessionScoped
public class datos implements Serializable {
    private String usuario;
    private String clave;
    private String descripcion;
    private String[] cursos;
    private String sexo;
    private String clase;
    private String[] profesores;
    private String horario;
private String[] materias = {"Desarrolo de Aplicaciones Web",
                                    "Desarrollo de Aplicaciones Moviles",
                                    "Aplicaciones Empresariales",
                                    "Pruebas de Testeo"};
private String[] docentes = {"Dennis Apaza",
                                    "Jose Carpio",
                                    "Favio Naquira",
                                    "Juan Suarez"};
private String[] genero = {"Femenino",
                                    "Masculino",
                                    "Prefiere no decir"};

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String[] getProfesores() {
        return profesores;
    }

    public void setProfesores(String[] profesores) {
        this.profesores = profesores;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String[] getDocentes() {
        return docentes;
    }

    public void setDocentes(String[] docentes) {
        this.docentes = docentes;
    }

    public String[] getGenero() {
        return genero;
    }

    public void setGenero(String[] genero) {
        this.genero = genero;
    }

    public String[] getClasse() {
        return classe;
    }

    public void setClasse(String[] classe) {
        this.classe = classe;
    }

    public String[] getHoras() {
        return horas;
    }

    public void setHoras(String[] horas) {
        this.horas = horas;
    }
private String[] classe = {"A112",
                                    "B302", "C2", "G6"};
private String[] horas = {"11:00 am",
                                    "12:00 m", "01:00 pm", "02:00 pm"};
    public String[] getCursos() {
        return cursos;
    }

    public void setCursos(String[] cursos) {
        this.cursos = cursos;
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    public datos() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
