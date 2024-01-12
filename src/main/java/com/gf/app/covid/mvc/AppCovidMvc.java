/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.gf.app.covid.mvc;

import com.gf.app.covid.controller.Controller;
import com.gf.app.covid.entities.Sintomas;
import com.gf.app.covid.view.View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rhtuf
 */
public class AppCovidMvc {

    public static void main(String[] args) {
        // TODO code application logic here
        Sintomas modelo = new Sintomas();
        View vista = new View();
        Controller controlador;
        try {
            controlador = new Controller(modelo, vista);
            controlador.iniciarVista();
        } catch (SQLException ex) {
            Logger.getLogger(AppCovidMvc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
