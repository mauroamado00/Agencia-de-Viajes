/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Aviones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class pAviones extends MySQL {
    
       public pAviones() {
        super();
    }

    public Aviones CargarDatos(Aviones Aviones) {
        try {
            Aviones = new Aviones();
            Aviones.setTipodeAvion(rs.getString("tipodeavion"));
            Aviones.setIdentificador(rs.getString("identificador"));
            Aviones.setPesoMax(rs.getString("pesomax"));
            Aviones.setCargaMax(rs.getString("cargamax"));

            return Aviones;
        } catch (SQLException ex) {
            Logger.getLogger(pAviones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Aviones;
    }

    

    public void GuardarAvion(Aviones Aviones) {
        try {
            boolean existe = false;
            existe = ExisteAviones(Aviones);
            if (existe) {
                strSQL = "UPDATE pasajeros SET tipodeavion = '" + Aviones.getTipodeAvion()
                        + "' , identificador = '" + Aviones.getIdentificador()
                        + "' , pesomax = '" + Aviones.getPesoMax()
                        + "' , cargamax = '" + Aviones.getCargaMax()
                        + "' where tipodeavion = '" + Aviones.getTipodeAvion() + "'";
                update(strSQL);

            } else {
                strSQL = "INSERT INTO Pasajeros (tipodeavion,identificador,pesomax,cargamax) VALUES ('" + Aviones.getTipodeAvion()
                        + "' , '" + Aviones.getIdentificador()
                        + "' , '" + Aviones.getPesoMax()
                        + "' , '" + Aviones.getCargaMax()
                        + "')";
                update(strSQL);
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pAviones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ExisteAviones(Aviones Aviones) throws SQLException {
        boolean existe = false;
        String Query = "SELECT * FROM Aviones" + " where tipodeavion = '" + Aviones.getTipodeAvion() + "'";

        this.selecionar(Query);

        while (rs.next()) {
            existe = true;
        }
        rs.close();
        return existe;
    }

    public boolean BorrarAviones(Aviones Aviones) {
        boolean existe = false;
        try {
            existe = ExisteAviones(Aviones);
            if (existe) {
                strSQL = "delete Aviones where tipodeavion = " + Aviones.getTipodeAvion();
                update(strSQL);

            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Aviones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public  Aviones BuscarAvionesNoBorrada(Aviones Aviones) {
        Aviones A = null;
        this.selecionar("SELECT * "
                + " FROM Aviones "
                + " where tipodeavion = " + Aviones.getTipodeAvion());
        try {
            while (rs.next()) {
                A = this.CargarDatos(A);
            }
            rs.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return A;
    }

    public List<Aviones> Aviones(String nomAtributo, String valAtributo) {
        List<Aviones> Pasajeros = new ArrayList<Aviones>();
        Aviones A = null;
        this.selecionar("SELECT *"
                + " FROM Aviones where " + nomAtributo + " = '" + valAtributo + "'");
        try {
            while (rs.next()) {
                A = this.CargarDatos(A);

            }
            rs.close();
            Iterable<Aviones> Aviones = null;
            for (Aviones c : Aviones) {

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Pasajeros;
    }

    public List<Aviones> Aviones(String criterio) {
        List<Aviones> Aviones = new ArrayList<Aviones>();
        Aviones A = null;
        this.selecionar("SELECT * "
                + " FROM Aviones "
                + " ORDER BY " + criterio);
        try {
            while (rs.next()) {
                A = this.CargarDatos(A);
                Aviones.add((Aviones) A);
            }
            rs.close();
            for (Aviones c : Aviones) {

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Aviones;
    }

    public List<Aviones> Pasajeros() {
        List<Aviones> Aviones = new ArrayList<Aviones>();
        Aviones A = null;
        this.selecionar("SELECT *" + " FROM Aviones");
        try {
            while (rs.next()) {
                Aviones a;
                A = this.CargarDatos(A);
                Aviones.add((Aviones) A);
            }
            rs.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Aviones;
}

    private void selecionar(String Query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

