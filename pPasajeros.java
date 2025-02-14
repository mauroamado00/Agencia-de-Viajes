/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Pasajeros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class pPasajeros extends MySQL {
       

    public pPasajeros() {
        super();
    }

    public Pasajeros CargarDatos(Pasajeros Pasajeros) {
        try {
            Pasajeros = new Pasajeros();
            Pasajeros.setNombredelPasajero(rs.getString("nombredelpasajero"));
            Pasajeros.setNumerodeAsiento(rs.getString("numerodeasiento"));
            Pasajeros.setMarcadeAvion(rs.getString("marcadeavion"));
            Pasajeros.setNombredelPasajero(rs.getString("pasaporte"));
            Pasajeros.setNombredelPasajero(rs.getString("NombredelPasajero"));

            return Pasajeros;
        } catch (SQLException ex) {
            Logger.getLogger(pPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Pasajeros;
    }

    

    public void GuardarPersona(Pasajeros Pasajeros) {
        try {
            boolean existe = false;
            existe = ExistePasajeros(Pasajeros);
            if (existe) {
                strSQL = "UPDATE pasajeros SET nombredelpasajero = '" + Pasajeros.getNombredelPasajero()
                        + "' , numerodeasiento = '" + Pasajeros.getNumerodeAsiento()
                        + "' , marcadeavion = '" + Pasajeros.getMarcadeAvion()
                        + "' , pasaporte = '" + Pasajeros.getPasaporte()
                        + "' where nombredelpasajero = '" + Pasajeros.getNombredelPasajero() + "'";
                update(strSQL);

            } else {
                strSQL = "INSERT INTO Pasajeros (nombredelpasajero,numerodeasiento,marcadeavion,pasaporte) VALUES ('" + Pasajeros.getNombredelPasajero()
                        + "' , '" + Pasajeros.getNumerodeAsiento()
                        + "' , '" + Pasajeros.getMarcadeAvion()
                        + "' , '" + Pasajeros.getPasaporte()
                        + "')";
                update(strSQL);
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ExistePasajeros(Pasajeros Pasajeros) throws SQLException {
        boolean existe = false;
        String Query = "SELECT * FROM Pasajeros" + " where nombre = '" + Pasajeros.getNombredelPasajero() + "'";

        this.selecionar(Query);

        while (rs.next()) {
            existe = true;
        }
        rs.close();
        return existe;
    }

    public boolean BorrarPasajeros(Pasajeros Pasajeros) {
        boolean existe = false;
        try {
            existe = ExistePasajeros(Pasajeros);
            if (existe) {
                strSQL = "delete Pasajeros where nombre = " + Pasajeros.getNombredelPasajero();
                update(strSQL);

            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Pasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public  Pasajeros BuscarPasajeroNoBorrada(Pasajeros Pasajeros) {
        Pasajeros P = null;
        this.selecionar("SELECT * "
                + " FROM Pasajeros "
                + " where nombredelpasajero = " + Pasajeros.getNombredelPasajero());
        try {
            while (rs.next()) {
                P = this.CargarDatos(P);
            }
            rs.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return P;
    }

    public List<Pasajeros> Pasajeros(String nomAtributo, String valAtributo) {
        List<Pasajeros> Pasajeros = new ArrayList<Pasajeros>();
        Pasajeros P = null;
        this.selecionar("SELECT *"
                + " FROM Pasajeros where " + nomAtributo + " = '" + valAtributo + "'");
        try {
            while (rs.next()) {
                P = this.CargarDatos(P);

            }
            rs.close();
            for (Pasajeros c : Pasajeros) {

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Pasajeros;
    }

    public List<Pasajeros> Persona(String criterio) {
        List<Pasajeros> Pasajeros = new ArrayList<Pasajeros>();
        Pasajeros P = null;
        this.selecionar("SELECT * "
                + " FROM Pasajeros "
                + " ORDER BY " + criterio);
        try {
            while (rs.next()) {
                P = this.CargarDatos(P);
                Pasajeros.add((Pasajeros) P);
            }
            rs.close();
            for (Pasajeros c : Pasajeros) {

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Pasajeros;
    }

    public List<Pasajeros> Pasajeros() {
        List<Pasajeros> Pasajeros = new ArrayList<Pasajeros>();
        Pasajeros P = null;
        this.selecionar("SELECT *" + " FROM Pasajeros");
        try {
            while (rs.next()) {
                Pasajeros p;
                P = this.CargarDatos(P);
                Pasajeros.add((Pasajeros) P);
            }
            rs.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Pasajeros;
}   

    private void selecionar(String Query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
        
        