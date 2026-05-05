/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.repository;

import com.salao.barbearia.model.AgendamentosBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AgendamentosDAO {
        public void adicionar(AgendamentosBean agendamentos) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO agendamentos (data_hora, id_barbeiro, status)"
                    + "VALUES (?,?,?)");
            stmt.setTimestamp(1, agendamentos.getData_hora());
            stmt.setInt(2, agendamentos.getId_barbeiro());
            stmt.setString(3, agendamentos.getStatus());
            
            stmt.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
        
    public List<AgendamentosBean> lerPorDia() {
    List<AgendamentosBean> dados = new ArrayList<>();
    try {
        Connection conn = Conexao.conectar();

        String sql = "SELECT id_agendamento, data_hora, id_cliente, " +
                     "id_barbeiro, id_servico, status, " +
                     "nome AS nome_barbeiro, especialidade AS especialidade_barbeiro " +
                     "FROM agendamentos a " +
                     "INNER JOIN barbeiros b ON id_barbeiro = id_barbeiro " +
                     "WHERE DATE(data_hora) = CURDATE()";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            AgendamentosBean ag = new AgendamentosBean();
            ag.setId_agendamento(rs.getInt("id_agendamento"));
            ag.setData_hora(rs.getTimestamp("data_hora"));
            ag.setId_cliente(rs.getInt("id_cliente"));
            ag.setId_barbeiro(rs.getInt("id_barbeiro"));
            ag.setId_servico(rs.getInt("id_servico"));
            ag.setStatus(rs.getString("status"));
            ag.setNome_barbeiro(rs.getString("nome_barbeiro")); 
            ag.setEspecialidade_barbeiro(rs.getString("especialidade_barbeiro"));
            dados.add(ag);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dados;
}
}
