/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.controller;

import com.salao.barbearia.model.BarbeirosBean;
import com.salao.barbearia.service.BarbeirosService;
import com.salao.barbearia.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
@RequestMapping("/barbeiros")
public class BarbeirosController {
    @Autowired
    private BarbeirosService service;
    
    @Autowired
    private TokenService tokenservice;
    
    @GetMapping
    public List<BarbeirosBean> lerTodos(
            @RequestHeader("Authorization") String auth){
        String token = auth.replace("Bearer ", "");
        if(tokenservice.validarToken(token)) {
            return service.lerTodos();
        } else {
            return null;
        }
    }
}
