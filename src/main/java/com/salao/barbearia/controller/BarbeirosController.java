/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.controller;

import com.salao.barbearia.model.BarbeirosBean;
import com.salao.barbearia.service.BarbeirosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping
    public List<BarbeirosBean> ListaBarbeiros(Model model) {
        return service.lerTodos();  
    }
}
