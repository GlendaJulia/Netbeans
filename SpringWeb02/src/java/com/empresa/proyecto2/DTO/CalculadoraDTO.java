package com.empresa.proyecto2.DTO;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class CalculadoraDTO {
    @NotEmpty(message = "Este campo es obligatorio")
    @Pattern(regexp = ".*([0-9]\\.?\\d*)", message = "Solo se permiten datos numericos")
    @Length(min = 1, max = 6)
    private String valor1;
    @NotEmpty(message = "Este campo es obligatorio")
    @Pattern(regexp = ".*([0-9]\\.?\\d*)", message = "Solo se permiten datos numericos")
    @Length(min = 1, max = 6)
    private String valor2;
    private String operacion;
    private String[] operaciones = {"suma", "resta", "multiplicacion","division"};

    public CalculadoraDTO() {
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String[] getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(String[] operaciones) {
        this.operaciones = operaciones;
    }
    
    
    
    
}
