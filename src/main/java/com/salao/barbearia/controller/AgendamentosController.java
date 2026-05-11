/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.controller;

import com.salao.barbearia.model.AgendamentosBean;
import com.salao.barbearia.service.AgendamentosService;
import com.salao.barbearia.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/agendamentos")
public class AgendamentosController {
    
    @Autowired
    private AgendamentosService service;
    
        @Autowired
    private TokenService tokenservice;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestHeader("Authorization") String auth, @RequestBody AgendamentosBean agendamentos) {
        String token = auth.replace("Bearer ", "");
        if(tokenservice.validarToken(token)) {
            service.adicionar(agendamentos);
            return ResponseEntity.status(201).body("Agendamento criado com sucesso!");
        } else {
            return null;
        }
    }

    @GetMapping("/dia")
    public ResponseEntity<List<AgendamentosBean>> listarPorDia() {
        List<AgendamentosBean> lista = service.listarAgendamentosDoDia();
        return ResponseEntity.ok(lista);
    }
}   

