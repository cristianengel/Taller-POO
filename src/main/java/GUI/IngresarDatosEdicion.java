package GUI;

import MainClasses.Edicion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresarDatosEdicion extends JFrame{
    private JTextField editorial;
    private JTextField paisDeEdicion;
    private JTextField numeroDeEdicion;
    private JComboBox<Integer> comboBoxVolumenes;
    private JTextField paginas;
    private JTextField idioma;
    private JTextField formato;
    private JCheckBox esColeccionCheckBox;
    private JTextField isbn;
    private JButton aceptarButton;
    private JButton atrasButton;
    private JPanel ingresoDatosEdicionPanel;
    private JTextField anioDeEdicion;
    private AgregarEjemplar ae = AgregarEjemplar.getInstance();

    public IngresarDatosEdicion() {
        setContentPane(ingresoDatosEdicionPanel);
        setTitle("Gestor de préstamos");
        setSize(450, 300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        for(int i = 0; i <= 100; i++) {
            comboBoxVolumenes.addItem(i);
        }

        atrasButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Edicion edicion = new Edicion(editorial.getText(), paisDeEdicion.getText(), numeroDeEdicion.getText(),
                        Integer.parseInt(anioDeEdicion.getText()),
                        Integer.parseInt(comboBoxVolumenes.getSelectedItem().toString()),
                        Integer.parseInt(paginas.getText()), idioma.getText(), formato.getText(),
                        esColeccionCheckBox.isSelected(), isbn.getText());
                ae.obtenerEdicion(edicion);
                dispose();
            }
        });
    }
}
