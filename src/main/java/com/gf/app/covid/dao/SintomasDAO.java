/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.dao;

import com.gf.app.covid.entities.Sintomas;
import com.gf.app.covid.utils.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rhtuf
 */
public class SintomasDAO {

    public static int insert(Sintomas s) throws Exception {
        String sql = "INSERT INTO sintomas VALUES (?,?,?,?,?,?)";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setInt(2, s.getFiebre());
            ps.setInt(3, s.getTos());
            ps.setInt(4, s.getDiarrea());
            ps.setInt(5, s.getDolor());
            ps.setInt(6, s.getOlfato());
            return ps.executeUpdate();
        }
    }

    public static int update(Sintomas s) throws Exception {
        String sql = "UPDATE sintomas SET fiebre=?, tos=?, diarrea=?, dolor=?, olfato=? WHERE id=?";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getFiebre());
            ps.setInt(2, s.getTos());
            ps.setInt(3, s.getDiarrea());
            ps.setInt(4, s.getDolor());
            ps.setInt(5, s.getOlfato());
            ps.setInt(6, s.getId());
            return ps.executeUpdate();
        }
    }

    public static int delete(Sintomas s) throws Exception {
        String sql = "DELETE  FROM  sintomas  WHERE id= ?";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            return ps.executeUpdate();
        }
    }

    public static boolean selectId(Sintomas s) throws Exception {
        String sql = "SELECT * FROM sintomas WHERE id=?";
        boolean exist = false;
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
            }
        }
        return exist;
    }

    public static Set<Sintomas> select(Sintomas s) throws Exception {
        String sql = "SELECT * FROM sintomas";
        Set<Sintomas> list = new HashSet<>();
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sintomas sintomas = new Sintomas();
                sintomas.setId(rs.getInt(1));
                sintomas.setFiebre(rs.getInt(2));
                sintomas.setTos(rs.getInt(3));
                sintomas.setDiarrea(rs.getInt(4));
                sintomas.setDolor(rs.getInt(5));
                sintomas.setOlfato(rs.getInt(6));
                list.add(sintomas);
            }
        }
        return list;
    }

}
