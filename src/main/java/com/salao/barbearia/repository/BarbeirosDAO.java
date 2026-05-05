/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.repository;

import com.salao.barbearia.model.BarbeirosBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BarbeirosDAO {
        public List<BarbeirosBean> lerTodos() {
        List<BarbeirosBean> dados = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM barbeiros");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                BarbeirosBean barbeiro = new BarbeirosBean();
                barbeiro.setId_barbeiro(rs.getInt("id_barbeiro"));
                barbeiro.setNome(rs.getString("nome"));
                barbeiro.setEspecialidade(rs.getString("especialidade"));
                barbeiro.setAtivo(rs.getBoolean("ativo"));
                dados.add(barbeiro);              

            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        return dados;
    }                
}
