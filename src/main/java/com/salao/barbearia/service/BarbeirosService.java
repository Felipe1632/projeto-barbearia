/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.service;

import com.salao.barbearia.model.BarbeirosBean;
import com.salao.barbearia.repository.BarbeirosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class BarbeirosService {
    
    @Autowired
    private BarbeirosDAO repository;
    
        public List<BarbeirosBean> lerTodos() {
        return repository.lerTodos();
    }
}
