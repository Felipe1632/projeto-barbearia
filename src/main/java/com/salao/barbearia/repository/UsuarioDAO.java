/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.repository;

import com.salao.barbearia.model.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class UsuarioDAO {
        public void cadastrar(UsuarioBean usuario) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("INSERT INTO usuario (nome, email, senha) VALUES (?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public UsuarioBean logar(String email, String senha) {
        UsuarioBean user = new UsuarioBean();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE usuario.email = ? AND usuario.senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            if(rs.next()) {
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
        
           public boolean existsByUsername(String email, String senha){
        String sql = "select 1 from usuario where email = ? and senha = ?";
       
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
           
            stmt.setString(1, email);
            stmt.setString(2, senha);
           
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
           
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
