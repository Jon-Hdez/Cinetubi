/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package uam.azc.adsi.cinetubi;

import uam.azc.adsi.cinetubi.modelo.Combo;
import uam.azc.adsi.cinetubi.modelo.ComboCatalog;
import uam.azc.adsi.cinetubi.modelo.SnackCatalog;

/**
 *
 * @author Jony
 */
public class CineTubi {

  public static void main(String[] args) {
    System.out.println("Hello World!");
    
    // Populate snack and combo catalog from data stored in the database
    SnackCatalog sCatalog = new SnackCatalog();
    sCatalog.fillCatalog();
    ComboCatalog cCatalog = new ComboCatalog();
    cCatalog.fillCatalog(sCatalog);
    
    for(Combo c: cCatalog.getCatalog()){
      System.out.println(c);
      System.out.println("\t"+c.getSnacks());
    }
  }
}
