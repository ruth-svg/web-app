/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.entities;

/**
 *
 * @author rhtuf
 */
public class Sintomas {
    
    private Integer id=0;
    private Integer fiebre=0;
    private Integer tos=0;
    private Integer diarrea=0;
    private Integer dolor=0;
    private Integer olfato=0;

    public Sintomas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFiebre() {
        return fiebre;
    }

    public void setFiebre(Integer fiebre) {
        this.fiebre = fiebre;
    }

    public Integer getTos() {
        return tos;
    }

    public void setTos(Integer tos) {
        this.tos = tos;
    }

    public Integer getDiarrea() {
        return diarrea;
    }

    public void setDiarrea(Integer diarrea) {
        this.diarrea = diarrea;
    }

    public Integer getDolor() {
        return dolor;
    }

    public void setDolor(Integer dolor) {
        this.dolor = dolor;
    }

    public Integer getOlfato() {
        return olfato;
    }

    public void setOlfato(Integer olfato) {
        this.olfato = olfato;
    }

    @Override
    public String toString() {
        return "Sintomas{" + "id=" + id + ", fiebre=" + fiebre + ", tos=" + tos + ", diarrea=" + diarrea + ", dolor=" + dolor + ", olfato=" + olfato + '}';
    }
    
    
    
}
