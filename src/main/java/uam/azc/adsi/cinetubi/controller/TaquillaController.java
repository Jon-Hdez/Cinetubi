/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import uam.azc.adsi.cinetubi.dao.*;
import uam.azc.adsi.cinetubi.model.*;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

/**
 *
 * @author @author José Vicente López López 2212002118
 */
public class TaquillaController extends JPanel {

  private Map<String, List<Funcion>> funcionesMap;
  public Funcion res;
  public List<Integer> aux;
  DatabaseConnection dbConnection;
  PeliculaDAO peli;
  private Pelicula seleccion;
  private double subtotal;
  private Empleado empleado;

  public TaquillaController() {
    try {
      this.dbConnection = DatabaseConnection.getInstance();
    } catch (SQLException ex) {
      Logger.getLogger(TaquillaController.class.getName()).log(Level.SEVERE, null, ex);
    }
    peli = new PeliculaDAO(this.dbConnection.getConnection());
  }

public Funcion funciones(JPanel panelRecibido, JPanel panelDescripcion, JPanel panelAseintos, JPanel resumen) {
    FuncionesDAO f = new FuncionesDAO(dbConnection.getConnection());
    AsientosDAO asientos = new AsientosDAO();
    List<Funcion> funciones = f.getAllFuncion();
    JPanel panelPrincipal = new JPanel();
    panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)); // Panel principal en columna
    panelPrincipal.setBackground(Color.WHITE); // Fondo blanco

    funcionesMap = new HashMap<>();

    // Agrupar funciones por nombre de la película
    for (Funcion funcion : funciones) {
        String nombrePelicula = peli.searchMovie(funcion.getId_pelicula()).getTitulo();
        funcionesMap.computeIfAbsent(nombrePelicula, k -> new ArrayList<>()).add(funcion);
    }

    // Crear un panel por cada grupo de funciones con el mismo nombre de película
    for (Map.Entry<String, List<Funcion>> entry : funcionesMap.entrySet()) {
        String nombrePelicula = entry.getKey();
        List<Funcion> funcionesPorNombre = entry.getValue();

        // Crear un panel para la película
        JPanel panelPelicula = new JPanel();
        panelPelicula.setLayout(new BoxLayout(panelPelicula, BoxLayout.Y_AXIS));
        panelPelicula.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
            "<html><font color='rgb(0,102,102)'><b>Pelicula: " + nombrePelicula + "</b></font></html>", 
            TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.WHITE)); // Título en negritas y color (0,102,102)
        panelPelicula.setBackground(Color.WHITE); // Fondo blanco

        // Panel de horarios (español e inglés)
        JPanel panelHorarios = new JPanel(new GridLayout(0, 2)); // Dos columnas para los horarios
        panelHorarios.setBackground(Color.WHITE); // Fondo blanco

        // Separar funciones en Español e Inglés
        JPanel panelEspanol = new JPanel();
        panelEspanol.setLayout(new BoxLayout(panelEspanol, BoxLayout.Y_AXIS));
        panelEspanol.setBorder(BorderFactory.createTitledBorder("Español"));
        panelEspanol.setBackground(Color.WHITE); // Fondo blanco

        JPanel panelIngles = new JPanel();
        panelIngles.setLayout(new BoxLayout(panelIngles, BoxLayout.Y_AXIS));
        panelIngles.setBorder(BorderFactory.createTitledBorder("Inglés"));
        panelIngles.setBackground(Color.WHITE); // Fondo blanco

        // Añadir los horarios a los paneles correspondientes
        for (Funcion funcion : funcionesPorNombre) {
            JButton botonHorario = new JButton(funcion.getHorario());
            botonHorario.setBackground(new Color(0, 102, 102)); // Color del botón
            botonHorario.setForeground(Color.WHITE); // Texto del botón en blanco
            botonHorario.addActionListener((ActionEvent e) -> {
                // Acción al presionar el botón
                System.out.println("Función seleccionada: " + funcion +
                        "\nPelícula seleccionada: " + peli.searchMovie(funcion.getId_pelicula()));
                res = funcion;
                seleccion = peli.searchMovie(funcion.getId_pelicula());
                mostrarPelicula(seleccion, panelDescripcion);
                aux = mostrarAsientos(panelAseintos, asientos.asientosFuncion(funcion), resumen);
            });

            // Clasificar por idioma
            if (funcion.getIdioma().equalsIgnoreCase("Español")) {
                panelEspanol.add(botonHorario);
            } else if (funcion.getIdioma().equalsIgnoreCase("Inglés")) {
                panelIngles.add(botonHorario);
            }
        }

        // Añadir los paneles de horarios al panel de película
        panelHorarios.add(panelEspanol);
        panelHorarios.add(panelIngles);
        panelPelicula.add(panelHorarios);

        // Añadir el panel de la película al panel principal
        panelPrincipal.add(panelPelicula);
    }

    // Envolver el panel principal en un JScrollPane
    JScrollPane scrollPane = new JScrollPane(panelPrincipal);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // Limpiar el panel recibido antes de agregar el JScrollPane
    panelRecibido.removeAll();
    panelRecibido.setLayout(new BorderLayout()); // Usar BorderLayout para llenar todo el espacio
    panelRecibido.add(scrollPane, BorderLayout.CENTER); // Añadir el JScrollPane al JPanel recibido
    panelRecibido.revalidate(); // Actualizar el panel
    panelRecibido.repaint(); // Redibujar el panel

    return res;
}



    public void mostrarPelicula(Pelicula pelicula, JPanel panelRecibido) {
        // Limpiar el contenido del panel recibido
        panelRecibido.removeAll();

        // Cambiar el fondo a verde y el color de letra a blanco
        panelRecibido.setBackground(new Color(0, 102, 102));
        panelRecibido.setForeground(Color.WHITE);

        // Establecer el layout para el panel (opcional: BoxLayout para organizar en columnas)
        panelRecibido.setLayout(new BoxLayout(panelRecibido, BoxLayout.Y_AXIS));

        // Crear etiquetas con los atributos de la película
        JLabel tituloLabel = new JLabel("Título: " + pelicula.getTitulo());
        JLabel duracionLabel = new JLabel("Duración: " + pelicula.getDuracion() + " minutos");
        JLabel distribuidorLabel = new JLabel("Distribuidor: " + pelicula.getDistribuidor());
        JLabel clasificacionLabel = new JLabel("Clasificación: " + pelicula.getClasificacion());
        JLabel directorLabel = new JLabel("Director: " + pelicula.getDirector());
        JLabel paisLabel = new JLabel("País: " + pelicula.getPais());
        JLabel descripcionLabel = new JLabel("Descripción: " + pelicula.getDescripcion());

        // Cambiar el color del texto a blanco
        tituloLabel.setForeground(Color.WHITE);
        duracionLabel.setForeground(Color.WHITE);
        distribuidorLabel.setForeground(Color.WHITE);
        clasificacionLabel.setForeground(Color.WHITE);
        directorLabel.setForeground(Color.WHITE);
        paisLabel.setForeground(Color.WHITE);
        descripcionLabel.setForeground(Color.WHITE);

        // Añadir las etiquetas al panel
        panelRecibido.add(tituloLabel);
        panelRecibido.add(duracionLabel);
        panelRecibido.add(distribuidorLabel);
        panelRecibido.add(clasificacionLabel);
        panelRecibido.add(directorLabel);
        panelRecibido.add(paisLabel);
        panelRecibido.add(descripcionLabel);

        // Actualizar el panel
        panelRecibido.revalidate();
        panelRecibido.repaint();
    }

    public List<Integer> mostrarAsientos(JPanel panel, List<Integer> asientosOcupados, JPanel resumen) {
        // Si la lista de asientos ocupados es nula, inicializarla
        if (asientosOcupados == null) {
            asientosOcupados = new ArrayList<>();
        }

        List<Integer> nuevosAsientosOcupados = new ArrayList<>();

        // Limpiar el contenido del panel antes de añadir los asientos
        panel.removeAll();

        // Crear el panel para los asientos
        JPanel panelAsientos = new JPanel();

        // Si la lista de asientos ocupados está vacía, mostrar los asientos sin ocupación
        if (asientosOcupados.isEmpty()) {
            // Establecer el layout del panel para mostrar asientos disponibles (3 filas, 10 columnas)
            panelAsientos.setLayout(new GridLayout(6, 5, 10, 2));

            // Colores
            Color verdeOscuro = new Color(0, 102, 102);
            Color blanco = Color.WHITE;

            // Generar botones para los asientos disponibles
            for (int i = 1; i <= 30; i++) {
                JButton botonAsiento = new JButton(String.valueOf(i));
                botonAsiento.setBackground(blanco);
                botonAsiento.setForeground(verdeOscuro);

                // Acción al hacer clic en un asiento disponible
                botonAsiento.addActionListener((ActionEvent e) -> {
                    botonAsiento.setBackground(verdeOscuro);
                    botonAsiento.setForeground(blanco);
                    botonAsiento.setEnabled(false); // Desactivar el botón una vez seleccionado
                    nuevosAsientosOcupados.add(Integer.valueOf(botonAsiento.getText()));
                });

                // Añadir el botón al panel de asientos
                panelAsientos.add(botonAsiento);
            }
        } else {
            // Si hay asientos ocupados, mostrar asientos con ocupación (6 filas, 5 columnas)
            panelAsientos.setLayout(new GridLayout(6, 5, 10, 2));

            // Colores
            Color verdeOscuro = new Color(0, 102, 102);
            Color blanco = Color.WHITE;

            // Generar botones para los asientos
            for (int i = 1; i <= 30; i++) {
                JButton botonAsiento = new JButton(String.valueOf(i));

                // Verificar si el asiento está ocupado
                if (asientosOcupados.contains(i)) {
                    botonAsiento.setBackground(verdeOscuro);
                    botonAsiento.setForeground(blanco);
                    botonAsiento.setEnabled(false); // Desactivar botón si está ocupado
                } else {
                    botonAsiento.setBackground(blanco);
                    botonAsiento.setForeground(verdeOscuro);

                    // Acción al hacer clic en un asiento disponible
                    botonAsiento.addActionListener((ActionEvent e) -> {
                        botonAsiento.setBackground(verdeOscuro);
                        botonAsiento.setForeground(blanco);
                        botonAsiento.setEnabled(false); // Desactivar el botón una vez seleccionado
                        nuevosAsientosOcupados.add(Integer.valueOf(botonAsiento.getText()));
                    });
                }

                // Añadir el botón al panel de asientos
                panelAsientos.add(botonAsiento);
            }
        }

        // Crear el JScrollPane para los botones de asientos
        JScrollPane scrollPane = new JScrollPane(panelAsientos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        // Añadir el JScrollPane al panel principal
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Crear botón de terminar
        JButton botonTerminar = new JButton("Terminar");

        // Panel para el botón de terminar
        JPanel panelTerminar = new JPanel();
        panelTerminar.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTerminar.add(botonTerminar);

        // Añadir el panel de terminar en el panel principal
        panel.add(panelTerminar, BorderLayout.SOUTH);

        // Acción del botón terminar
        botonTerminar.addActionListener((e) -> {
            mostrarResumenVenta(resumen, res, peli.searchMovie(res.getId_pelicula()), aux);
        });

        // Devolver la lista de asientos recién ocupados
        return nuevosAsientosOcupados;
    }

    
    public void mostrarResumenVenta(JPanel resumen, Funcion funcion, Pelicula pelicula, List<Integer> boletos) {
        // Colores y estilo
        Color verdeOscuro = new Color(0, 102, 102);
        resumen.setBackground(verdeOscuro);

        // Fuente en itálicas y color blanco
        Font fuenteItalica = new Font("Arial", Font.ITALIC, 14);
        Color blanco = Color.WHITE;

        // Limpiar el resumen antes de agregar los componentes
        resumen.removeAll();
        resumen.setLayout(new GridLayout(5, 1, 5, 5)); // 8 líneas de información con un espacio entre ellas

        // Crear etiquetas con la información
        JLabel labelBoletos = new JLabel("Boletos: " + boletos.size());
        JLabel labelPelicula = new JLabel("Pelicula: " + pelicula.getTitulo());
        JLabel labelHorario = new JLabel("Horario: " + funcion.getHorario());
        JLabel labelIdioma = new JLabel("Idioma: " + funcion.getIdioma());
        JLabel labelSala = new JLabel("Sala: " + funcion.getSala());
        JLabel labelAsientos = new JLabel("Asientos: " + boletos.toString().replace("[", "").replace("]", ""));
        JLabel labelPrecioPorBoleto = new JLabel("Precio P/B: 70");

        // Cálculo del subtotal
        subtotal = boletos.size() * 70;
        JLabel labelSubtotal = new JLabel("Subtotal: " + subtotal);

        // Aplicar estilo a las etiquetas
        JLabel[] etiquetas = {labelBoletos, labelPelicula, labelHorario, labelIdioma, labelSala, labelAsientos, labelPrecioPorBoleto, labelSubtotal};
        for (JLabel etiqueta : etiquetas) {
          etiqueta.setForeground(blanco);
          etiqueta.setFont(fuenteItalica);
          resumen.add(etiqueta); // Añadir cada etiqueta al resumen
        }

        // Actualizar el resumen
        resumen.revalidate();
        resumen.repaint();
    }
  
    public String ventaActual() {
        // Crear un StringBuilder para construir la cadena de salida
        StringBuilder resumen = new StringBuilder();
        SalaDAO s=new SalaDAO();
        // Obtener información de la función
        if(seleccion==null){
            return "Error al buscar la pelicula";
        }
        String tituloPelicula = seleccion.getTitulo(); // Asumiendo que 'seleccion' tiene el método 'getTitulo()'
        String horario = res.getHorario(); // Obtener horario de la función
        int sala = s.asientosFuncion(res); // Obtener sala de la función

        // Calcular el precio total
        int precioPorBoleto = 70; // Precio por boleto
        int totalBoletos = aux.size(); // Cantidad de boletos seleccionados
        int totalPrecio = totalBoletos * precioPorBoleto;

        // Obtener los números de boletos seleccionados
        String boletosSeleccionados = String.join(aux.toString()); // Asumiendo que 'aux' es una lista de los números de boletos

        // Construir el resumen de la venta
        resumen.append("Resumen de la Venta:\n");
        resumen.append("Película: ").append(tituloPelicula).append("\n");
        resumen.append("Horario: ").append(horario).append("\n");
        resumen.append("Sala: ").append(sala).append("\n");
        resumen.append("Boletos seleccionados: ").append(aux.stream().map(String::valueOf).collect(Collectors.joining(", "))).append("\n");
        resumen.append("Total de boletos: ").append(totalBoletos).append("\n");
        resumen.append("Total: $").append(totalPrecio).append("\n");
        System.out.println(resumen.toString());

        // Devolver el resumen como un String
        return resumen.toString();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Map<String, List<Funcion>> getFuncionesMap() {
        return funcionesMap;
    }

    public Funcion getRes() {
        return res;
    }

    public List<Integer> getAux() {
        return aux;
    }

    public DatabaseConnection getDbConnection() {
        return dbConnection;
    }

    public PeliculaDAO getPeli() {
        return peli;
    }

    public Pelicula getSeleccion() {
        return seleccion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
