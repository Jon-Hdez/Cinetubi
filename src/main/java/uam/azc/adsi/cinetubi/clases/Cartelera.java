/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.clases;

import java.util.List;

/**
 *
 * @author Jony
 */
public class Cartelera {
    
    private List<Funcion> catalogoFunciones;

    public Cartelera() {
    }

    
    public Cartelera(List<Funcion> catalogoFunciones) {
        this.catalogoFunciones = catalogoFunciones;
    }

    
    
    
    
    public List<Funcion> getCatalogoFunciones() {
        return catalogoFunciones;
    }

    public void setCatalogoFunciones(List<Funcion> catalogoFunciones) {
        this.catalogoFunciones = catalogoFunciones;
    }
    
    
}
