/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.service;

import com.salao.barbearia.model.AgendamentosBean;
import com.salao.barbearia.repository.AgendamentosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentosService {
    @Autowired
    private AgendamentosDAO repository;


    public void adicionar(AgendamentosBean agendamento) {
        repository.adicionar(agendamento);
    }

    // Chama o DAO para listar agendamentos do dia
    public List<AgendamentosBean> listarAgendamentosDoDia() {
        return repository.lerPorDia();
    }

}
