/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author ADMIN
 */
public class Aviones {
    
    String TipodeAvion;
    String Identificador;
    String PasajeroMax;
    String PesoMax;
    String CargaMax;



public Aviones() {
    }

    public String getTipodeAvion() {
        return TipodeAvion;
    }

    public void setNombre(String TipodeAvion) {
        this.TipodeAvion = TipodeAvion;
    }
      public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String  Identificador) {
        this.Identificador = Identificador;
    }  
      public String getPasajeroMax() {
        return PasajeroMax;
    }

    public void setPasajeroMax(String PasajeroMax) {
        this.PasajeroMax = PasajeroMax;
    } 
    
       public String getPesoMax() {
        return PasajeroMax;
    }

    public void setPesoMax(String PesoMax) {
        this.PesoMax = PesoMax;
    } 
    
       public String getCargaMax() {
        return CargaMax;
    }

    public void setCargaMax(String CargaMax) {
        this.CargaMax = CargaMax;
    } 

    public void setTipodeAvion(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
