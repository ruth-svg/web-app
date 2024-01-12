/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.controller;

import com.gf.app.covid.entities.Sintomas;
import com.gf.app.covid.ln.SintomasLN;
import com.gf.app.covid.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rhtuf
 */
public class Controller implements ActionListener {

    private final Sintomas modelo;
    private final View vista;

    public Controller(Sintomas sintomas, View vista) throws SQLException {
        modelo = sintomas;
        this.vista = vista;
        this.vista.getInsertar().addActionListener(this);
        this.vista.getBorrar().addActionListener(this);
        this.vista.getActualizar().addActionListener(this);
        this.vista.getConsultar().addActionListener(this);

    }

    public void iniciarVista() {
        vista.setTitle("TEST COVID GF");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
//   

    @Override
    public void actionPerformed(ActionEvent evento) {

        modelo.setId(vista.getId());

        if (vista.getFiebre().isSelected()) {
            modelo.setFiebre(modelo.getFiebre() + 1);
        }

        if (vista.getTos().isSelected()) {
            modelo.setTos(modelo.getTos() + 1);
        }

        if (vista.getDiarrea().isSelected()) {
            modelo.setDiarrea(modelo.getDiarrea() + 1);
        }
        if (vista.getDolor().isSelected()) {
            modelo.setDolor(modelo.getDolor() + 1);
        }
        if (vista.getOlfato().isSelected()) {
            modelo.setOlfato(modelo.getOlfato() + 1);
        }

        if (evento.getSource() == vista.getInsertar()) {

            insertarSintomas();
        } else if (evento.getSource() == vista.getBorrar()) {

            borrarSintomas();
        } else if (evento.getSource() == vista.getActualizar()) {

            actualizarSintomas();
        } else if (evento.getSource() == vista.getConsultar()) {

            consultarSintomas();
        }
    }

    public void insertarSintomas() {

        try {
            //  ds = MyDataSourceFactory.getMySQLDataSource()
            //Llamada  a LN
            String mensaje = SintomasLN.insert(modelo);
            JOptionPane.showMessageDialog(null, mensaje + "\n ");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarSintomas() {

        try {
            //Llamada  a LN
            String mensaje = SintomasLN.delete(modelo);
            JOptionPane.showMessageDialog(null, mensaje + "\n ");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarSintomas() {

        try {
            //Llamada  a LN
            String mensaje = SintomasLN.update(modelo);
            JOptionPane.showMessageDialog(null, mensaje + "\n ");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarSintomas() {

        try {
            //Llamada  a LN
            Set<Sintomas> list = SintomasLN.select(modelo);
            for (Sintomas s : list) {
                JOptionPane.showMessageDialog(null, s.toString() + "\n ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
