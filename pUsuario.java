/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class pUsuario extends MySQL{
    
          public pUsuario() {
        super();
    }

    public Usuario CargarDatos(Usuario Usuario) {
        try {
            Usuario = new Usuario();
            Usuario.setUsuario(rs.getString("usuario"));
            Usuario.setContraseña(rs.getString("contraseña"));
            Usuario.setTelefono(rs.getString("telefono"));
            

            return Usuario;
        } catch (SQLException ex) {
            Logger.getLogger(pUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Usuario;
    }

    

    public void GuardarAvion(Usuario Usuario) {
        try {
            boolean existe = false;
            existe = ExisteUsuario(Usuario);
            if (existe) {
                strSQL = "UPDATE usuario SET usuario = '" + Usuario.getUsuario()
                        + "' , contraseña = '" + Usuario.getContraseña()
                        + "' , telefono = '" + Usuario.getTelefono()
                        + "' where usuario = '" + Usuario.getUsuario() + "'";
                update(strSQL);

            } else {
                strSQL = "INSERT INTO Usuario (usuario,contraseña,telefono) VALUES ('" + Usuario.getUsuario()
                        + "' , '" + Usuario.getContraseña()
                        + "' , '" + Usuario.getTelefono()
                        + "')";
                update(strSQL);
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ExisteUsuario(Usuario Usuario) throws SQLException {
        boolean existe = false;
        String Query = "SELECT * FROM Usuario" + " where usuario = '" + Usuario.getUsuario() + "'";

        this.selecionar(Query);

        while (rs.next()) {
            existe = true;
        }
        rs.close();
        return existe;
    }

    public boolean BorrarUsuario(Usuario Usuario) {
        boolean existe = false;
        try {
            existe = ExisteUsuario(Usuario);
            if (existe) {
                strSQL = "delete Usuario where usuario = " + Usuario.getUsuario();
                update(strSQL);

            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public  Usuario BuscarUsuarioNoBorrada(Usuario Usuario) {
        Usuario U = null;
        this.selecionar("SELECT * "
                + " FROM Usuario "
                + " where usuario = " + Usuario.getUsuario());
        try {
            while (rs.next()) {
                U = this.CargarDatos(U);
            }
            rs.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return U;
    }

    public List<Usuario> Usuario(String nomAtributo, String valAtributo) {
        List<Usuario> Pasajeros = new ArrayList<Usuario>();
        Usuario U = null;
        this.selecionar("SELECT *"
                + " FROM Usuario where " + nomAtributo + " = '" + valAtributo + "'");
        try {
            while (rs.next()) {
                U = this.CargarDatos(U);

            }
            rs.close();
            Iterable<Usuario> Usuario = null;
            for (Usuario c : Usuario) {

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Pasajeros;
    }

    public List<Usuario> Usuario(String criterio) {
        List<Usuario> Usuario = new ArrayList<Usuario>();
        Usuario A = null;
        this.selecionar("SELECT * "
                + " FROM Usuario "
                + " ORDER BY " + criterio);
        try {
            while (rs.next()) {
                A = this.CargarDatos(A);
                Usuario.add((Usuario) A);
            }
            rs.close();
            for (Usuario c : Usuario) {

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Usuario;
    }

    public List<Usuario> Usuario() {
        List<Usuario> Usuario = new ArrayList<Usuario>();
        Usuario A = null;
        this.selecionar("SELECT *" + " FROM Usuario");
        try {
            while (rs.next()) {
                Usuario u;
                Usuario U = this.CargarDatos(A);
                Usuario.add((Usuario) A);
            }
            rs.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return Usuario;
}

    private void selecionar(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
