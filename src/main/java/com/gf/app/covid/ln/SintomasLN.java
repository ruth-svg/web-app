/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.ln;

import com.gf.app.covid.dao.SintomasDAO;
import com.gf.app.covid.entities.Sintomas;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author rhtuf
 */
public class SintomasLN {

    public static String insert(Sintomas s) throws SQLException, Exception {

        if (!SintomasDAO.selectId(s)) {

//if (SintomasDAO.insert(s)>0)
            SintomasDAO.insert(s);
            return "Los resultados del test se han guardado correctamente.";
        } else {
            return "El test ya existe.";
        }

    }

    public static String delete(Sintomas s) throws SQLException, Exception {

        if (SintomasDAO.selectId(s)) {
            SintomasDAO.delete(s);
            return "Los resultados del test se han eliminado correctamente.";
        } else {
            return "El test no existe.";
        }

    }

    public static String update(Sintomas s) throws SQLException, Exception {

        if (SintomasDAO.selectId(s)) {
            //if (SintomasDAO.update(s)>0)
            SintomasDAO.update(s);
            return "Los resultados del test se han actualizado correctamente.";
        } else {
            return "El test no existe.";
        }

    }

    public static Set<Sintomas> select(Sintomas s) throws SQLException, Exception {
        Set<Sintomas> list;
        list = SintomasDAO.select(s);
        return list;

    }

}
