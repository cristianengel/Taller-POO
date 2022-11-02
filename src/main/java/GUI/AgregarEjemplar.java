package GUI;


import MainClasses.Biblioteca;
import MainClasses.Edicion;
import MainClasses.Ejemplar;
import MainClasses.Obra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AgregarEjemplar extends JFrame{
    Biblioteca b = Biblioteca.getInstance();
    private static AgregarEjemplar instance;
    private JTextField pasillo;
    private JTextField estanteria;
    private JTextField estante;
    private JTextField observaciones;
    private JTextField areaTematica;
    private JTextField titulo;
    private JTextField subtitulo;
    private JTextField primerAutor;
    private JTextField segundoAutor;
    private JTextField tercerAutor;
    private JTextField genero;
    private JTextField caracteristica;
    private JTextField isbn;
    private JTextArea indice;
    private JButton agregarButton;
    private JPanel agregarEjemplarPanel;
    private JComboBox<String> comboBox1;
    private JButton atrasButton;
    private JTextField codBarra;
    private JLabel edicionLabel;
    private JButton ingresarEdicionButton;
    private Edicion edicion;

    public static AgregarEjemplar getInstance() {
        if(instance == null) {
            instance = new AgregarEjemplar();
        }
        return instance;
    }

    private AgregarEjemplar() {
        comboBox1.addItem("Compra por Internet");
        comboBox1.addItem("Compra a Biblioteca");
        comboBox1.addItem("Compra Particular");
        comboBox1.addItem("Otros");
        setContentPane(agregarEjemplarPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesConEjemplares oce = new OperacionesConEjemplares();
                dispose();
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.agregarEjemplar(new Ejemplar(generarIdentUnico(7), observaciones.getText(), new ArrayList<String>(Arrays.asList(pasillo.toString(), estanteria.toString(), estante.toString())), LocalDate.now(), Objects.requireNonNull(comboBox1.getSelectedItem()).toString(), new Obra(areaTematica.getText(), titulo.getText(), subtitulo.getText(), primerAutor.getText(), segundoAutor.getText(), tercerAutor.getText(), genero.getText(), caracteristica.getText(), codBarra.getText(), indice.getText(), edicion)));
                MainMenuScreen mm = new MainMenuScreen();
                instance = null;
                dispose();
            }
        });
        ingresarEdicionButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresarDatosEdicion ide = new IngresarDatosEdicion();
            }
        });
    }

    public void obtenerEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    /**
     * Devuelve un entero para utilización como código de barra, chequeando antes
     * que no se encuentre utilizado en algún otro ejemplar
     * @param size
     * @return int
     */

    /**
     * Devuelve un string para utilización como identificador único, chequeando antes
     * que no se encuentre utilizado en algún otro ejemplar
     * @param size
     * @return String
     */
    public String generarIdentUnico(int size) {
        String identUnico = getAlphaNumericString(size);
        for(int i = 0; i < b.getListaDeEjemplares().size(); i++){
            if(Objects.equals(b.getListaDeEjemplares().get(i).getIdentUnico(), identUnico)) {
                generarIdentUnico(size);
            }
        }
        return identUnico;
    }

    // funcion para crear un string aleatorio de longitud n
    public String getAlphaNumericString(int n) {
        // se elige caracter aleatorio de este string
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // se crea StringBuffer de alphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            // se genera un número aleatorio entre
            // 0 y la longitud de alphaNumericString
            int index
                    = (int)(alphaNumericString.length()
                    * Math.random());

            // se agrega caracter por caracter al final del string
            sb.append(alphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    // funcion para crear un string aleatorio de longitud n (solo números)
    public String getNumericString(int n) {
        // se elige caracter aleatorio de este string
        String numericString = "0123456789";

        // se crea StringBuffer de numericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            // se genera un número aleatorio entre
            // 0 y la longitud de numericString
            int index
                    = (int)(numericString.length()
                    * Math.random());

            // se agrega caracter por caracter al final del string
            sb.append(numericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
