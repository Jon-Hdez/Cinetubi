/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.clases;

/**
 *
 * @author Jony
 */
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String claveSocio;
    private boolean esSocio;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombre, String claveSocio, boolean esSocio) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.claveSocio = claveSocio;
        this.esSocio = esSocio;
    }

    
    
    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveSocio() {
        return claveSocio;
    }

    public void setClaveSocio(String claveSocio) {
        this.claveSocio = claveSocio;
    }

    public boolean isEsSocio() {
        return esSocio;
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }
    

    
}
