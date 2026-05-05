/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salao.barbearia.model;

/**
 *
 * @author Aluno
 */
public class BarbeirosBean {
    public Integer id_barbeiro;
    public String nome;
    public String especialidade;
    public Boolean ativo;

    public BarbeirosBean() {
    }

    public BarbeirosBean(Integer id_barbeiro, String nome, String especialidade, Boolean ativo) {
        this.id_barbeiro = id_barbeiro;
        this.nome = nome;
        this.especialidade = especialidade;
        this.ativo = ativo;
    }

    public Integer getId_barbeiro() {
        return id_barbeiro;
    }

    public void setId_barbeiro(Integer id_barbeiro) {
        this.id_barbeiro = id_barbeiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
