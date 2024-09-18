/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.modelo;

import java.util.List;

/**
 *
 * @author Jony
 */
public class Venta {
    private int idVenta;
    private List<Boleto> listaBoletos;
    private double subTotal;
    private double totalImpuestos;

    public Venta() {
    }

    public Venta(int idVenta, List<Boleto> listaBoletos, double subTotal, double totalImpuestos) {
        this.idVenta = idVenta;
        this.listaBoletos = listaBoletos;
        this.subTotal = subTotal;
        this.totalImpuestos = totalImpuestos;
    }

    
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }


    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(double totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public List<Boleto> getListaBoletos() {
        return listaBoletos;
    }

    public void setListaBoletos(List<Boleto> listaBoletos) {
        this.listaBoletos = listaBoletos;
    }
    
    
}
