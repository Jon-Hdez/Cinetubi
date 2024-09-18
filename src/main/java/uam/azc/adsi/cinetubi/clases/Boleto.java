/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.clases;

/**
 *
 * @author Jony
 */
class Boleto {
    
    private Funcion funcion;
    private int numAsiento;
    private double precio;

    public Boleto() {
    }

    public Boleto(Funcion funcion, int numAsiento, double precio) {
        this.funcion = funcion;
        this.numAsiento = numAsiento;
        this.precio = precio;
    }

    
    
    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
