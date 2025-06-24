package com.bingo.bingo.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getDecrypterPassword(String cedtra){
        try{
            return jdbcTemplate.execute((java.sql.Connection con) -> {
                try(java.sql.Statement setupStmt = con.createStatement()){
                    setupStmt.execute("set encryption password '0r13nt3'");
                }

                String sql = "select decrypt_char(clave) from gener02 where cedtra = ?";
                try(java.sql.PreparedStatement ps = con.prepareStatement(sql)){
                    ps.setString(1, cedtra.trim());
                    try(java.sql.ResultSet rs = ps.executeQuery()){
                        if(rs.next()){
                            return rs.getString(1);
                        }
                    }
                }
                return null;

            });
        }catch(Exception e){
            System.out.println("Error al desencriptar la clave para la cedula "+ cedtra + ": "  + e.getMessage());
            return null;
        }
    }
}
