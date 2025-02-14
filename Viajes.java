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
public class Viajes {
    
    String Pais;
    String Ciudad;
    String HoradeSalida;
    String FechadeVuelo;
    String CostoBoleto;
    
      public Viajes() {
    }
    
      public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }
    
       public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    
       public String getHoradeSalida() {
        return HoradeSalida;
    }

    public void setHoradeSalida(String HoradeSalida) {
        this.HoradeSalida = HoradeSalida;
    }
    
       public String getFechadeVuelo() {
        return FechadeVuelo;
    }

    public void setFechadeVuelo(String FechadeVuelo) {
        this.FechadeVuelo = FechadeVuelo;
    }
    
       public String getCostoBoleto() {
        return CostoBoleto;
    }

    public void setCostoBoleto(String CostoBoleto) {
        this.CostoBoleto = CostoBoleto;
    }
    
    
}
