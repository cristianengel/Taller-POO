package GUI;



import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AgregarEjemplar extends JFrame{
    Biblioteca b = Biblioteca.getInstance();
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
    private JComboBox comboBox1;

    public AgregarEjemplar() {
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
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codBarra = generarCodBarra(7);
                String identUnico = generarIdentUnico(7);
                // TODO: 10/18/22  
            }
        });

    }

    /**
     * Devuelve un entero para utilización como código de barra, chequeando antes
     * que no se encuentre utilizado en algún otro ejemplar
     * @param size
     * @return int
     */
    public int generarCodBarra(int size) {
        int codBarra = Integer.parseInt(getNumericString(size));
        for(int i = 0; i < b.getListaDeEjemplares().size(); i++){
            if(Objects.equals(b.getListaDeEjemplares().get(i).getCodBarra(), codBarra)) {
                generarCodBarra(size);
            }
        }
        return codBarra;
    }

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
