/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

/**
 *
 * @author Jony
 * @author José Vicente López López 2212002118
 */
public class Boleto {

  private int id;
  private int idFuncion;
  private int idVenta;
  private int idSala;
  private int numeroAsiento;

  public Boleto(int id, int idFuncion, int idVenta, int idSala, int numeroAsiento) {
    this.id = id;
    this.idFuncion = idFuncion;
    this.idVenta = idVenta;
    this.idSala = idSala;
    this.numeroAsiento = numeroAsiento;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdFuncion() {
    return idFuncion;
  }

  public void setIdFuncion(int idFuncion) {
    this.idFuncion = idFuncion;
  }

  public int getIdVenta() {
    return idVenta;
  }

  public void setIdVenta(int idVenta) {
    this.idVenta = idVenta;
  }

  public int getIdSala() {
    return idSala;
  }

  public void setIdSala(int idSala) {
    this.idSala = idSala;
  }

  public int getNumeroAsiento() {
    return numeroAsiento;
  }

  public void setNumeroAsiento(int numeroAsiento) {
    this.numeroAsiento = numeroAsiento;
  }

  @Override
  public String toString() {
    return "Boleto{" + "id=" + id + ", idFuncion=" + idFuncion + ", idVenta=" + idVenta + ", idSala=" + idSala + ", numeroAsiento=" + numeroAsiento + '}';
  }
}
