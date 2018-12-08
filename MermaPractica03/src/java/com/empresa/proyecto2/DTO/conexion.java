
package com.empresa.proyecto2.DTO;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class conexion {
    public DriverManagerDataSource conexion(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/practica03?"+
                 "useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("DSISTecsup2");
        return dataSource;
                }
}
