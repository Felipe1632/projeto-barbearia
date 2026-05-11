/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.controller;

import com.salao.barbearia.model.UsuarioBean;
import com.salao.barbearia.service.TokenService;
import com.salao.barbearia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody UsuarioBean usuario){
        service.cadastrar(usuario);
        String token = tokenService.gerarToken();
        return "Usuario cadastrado com sucesso Token: " + token;
    }
    
    @PostMapping("/logar")
    public UsuarioBean logar(@RequestBody UsuarioBean loginRequest) {
        String token = tokenService.gerarToken();
        return service.logar(loginRequest.getEmail(), loginRequest.getSenha(), token);
    }
}
