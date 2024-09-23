package uam.azc.adsi.cinetubi.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.ArrayList;
import uam.azc.adsi.cinetubi.model.Funcion;
import uam.azc.adsi.cinetubi.model.Asiento;
import uam.azc.adsi.cinetubi.model.Sala;
import uam.azc.adsi.cinetubi.model.Boleto;

/**
 *
 * @author José Vicente López López 2212002118
 */
public class CinetubiDAO {

  private static final String DB_URL = "jdbc:mysql://localhost:3306/cinetubi";
  private static final String USER = "root";
  private static final String PASS = "root";

  public static ArrayList<Asiento> obtenerAsientos(int id_sala) {
    ArrayList<Asiento> asientos = new ArrayList<>();

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM asiento WHERE id_sala=" + id_sala + ";")) {

      while (rs.next()) {
        int idSala = rs.getInt("id_Sala");
        int numero = rs.getInt("numero");
        Asiento asiento = new Asiento(idSala, numero);
        asientos.add(asiento);
      }

      for (Asiento aux : asientos) {
        System.out.println(aux.toString() + "\n");
      }
    } catch (SQLException e) {
      System.err.println("Error tipo: " + e);
    }
    return asientos;
  }

  public static ArrayList<Funcion> obtenerFunciones(int idFuncion) {

    ArrayList<Funcion> funciones = new ArrayList<>();

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM funcion" + idFuncion + ";")) {

      while (rs.next()) {
        int id = rs.getInt("id");
        int idSala = rs.getInt("id_sala");
        int idPelicula = rs.getInt("id_pelicula");
        String horario = rs.getString("horarios");
        String idioma = rs.getString("idioma");
        Funcion funcion = new Funcion(id, idPelicula, horario, idSala, idioma);
        funciones.add(funcion);
      }

      for (Funcion aux : funciones) {
        System.out.println(aux.toString() + "\n");
      }
    } catch (SQLException e) {
      System.err.println("Error tipo: " + e);
    }
    return funciones;
  }

  public static ArrayList<Sala> obtenerSalas() {
    ArrayList<Sala> salas = new ArrayList<>();

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM sala where id in (select sala FROM funcion);")) {

      while (rs.next()) {
        int id = rs.getInt("id");
        String categoria = rs.getString("categoria");
        int capacidad = rs.getInt("capacidad");
        String estado = rs.getString("estado");
        Sala sala = new Sala(id, categoria, capacidad, estado);
        salas.add(sala);
      }
      for (Sala aux : salas) {
        System.out.println(aux.toString() + "\n");
      }
    } catch (SQLException e) {
      System.err.println("Error tipo: " + e);
    }
    return salas;
  }

  public static ArrayList<Boleto> obtenerBoletos() {
    ArrayList<Boleto> boletos = new ArrayList<>();

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM sala where id in (select sala FROM funcion);")) {

      while (rs.next()) {
        int id = rs.getInt("id");
        int id_funcion = rs.getInt(2);
        int id_venta = rs.getInt(3);
        int id_sala = rs.getInt(4);
        int numero_asiento = rs.getInt(5);
        Boleto boleto = new Boleto(id, id_funcion, id_venta, id_sala, numero_asiento);
        boletos.add(boleto);
      }
      for (Boleto aux : boletos) {
        System.out.println(aux.toString() + "\n");
      }
    } catch (SQLException e) {
      System.err.println("Error tipo: " + e);
    }
    return boletos;
  }

}
