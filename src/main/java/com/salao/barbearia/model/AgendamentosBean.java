/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.model;

import java.sql.Timestamp;

/**
 *
 * @author Aluno
 */
public class AgendamentosBean {
    public Integer id_agendamento;
    public Timestamp data_hora;
    public Integer id_cliente;
    public Integer id_barbeiro;
    public Integer id_servico;
    public String status;
    
    public String nome_barbeiro;
    public String especialidade_barbeiro;

    public AgendamentosBean() {
    }

    public AgendamentosBean(Integer id_agendamento, Timestamp data_hora, Integer id_cliente, Integer id_barbeiro, Integer id_servico, String status) {
        this.id_agendamento = id_agendamento;
        this.data_hora = data_hora;
        this.id_cliente = id_cliente;
        this.id_barbeiro = id_barbeiro;
        this.id_servico = id_servico;
        this.status = status;
    }

    public Integer getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(Integer id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_barbeiro() {
        return id_barbeiro;
    }

    public void setId_barbeiro(Integer id_barbeiro) {
        this.id_barbeiro = id_barbeiro;
    }

    public Integer getId_servico() {
        return id_servico;
    }

    public void setId_servico(Integer id_servico) {
        this.id_servico = id_servico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        public String getNome_barbeiro() {
        return nome_barbeiro;
    }
    public void setNome_barbeiro(String nome_barbeiro) {
        this.nome_barbeiro = nome_barbeiro;
    }
    public String getEspecialidade_barbeiro() {
        return especialidade_barbeiro;
    }
    public void setEspecialidade_barbeiro(String especialidade_barbeiro) {
        this.especialidade_barbeiro = especialidade_barbeiro;
    }
    
}
