package com.empresa.proyecto.DAO;

import com.empresa.proyecto.DTO.usuariosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class usuariosDAOImple implements usuariosDAO{
    
    private JdbcTemplate jdbcTemplate;
    public void setConexion(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<usuariosDTO> usuariosListar() {
        String sql = "SELECT "
                + "codigo,"
                + "nombre,"
                + "clave,"
                + "estado "
                + "FROM t_usuarios "
                + "ORDER BY codigo";
        RowMapper mapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum)
                    throws SQLException {

                usuariosDTO p = new usuariosDTO();
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setClave(rs.getString(3));
                p.setEstado(rs.getString(4));

                return p;
            }
        };
        List<usuariosDTO> list = jdbcTemplate.query(sql, mapper);
        return list;
    }      
}

