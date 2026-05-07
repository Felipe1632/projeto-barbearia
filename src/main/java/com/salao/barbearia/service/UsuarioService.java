/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.service;

import com.salao.barbearia.model.UsuarioBean;
import com.salao.barbearia.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO repository;
        
        public void cadastrar(UsuarioBean usuario){      
            repository.cadastrar(usuario);
     }
    

    public UsuarioBean logar(String email, String senha) {
        UsuarioBean user = repository.logar(email, senha);

        if (user.getEmail() == null) {
            throw new RuntimeException("Email ou senha inválidos");
        }

        return user;
    }
}
