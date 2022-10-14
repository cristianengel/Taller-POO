package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listados extends JFrame{
    private JComboBox<String> comboBox1;
    private JPanel listadosPanel;
    private JButton nextButton;

    public Listados() {
        comboBox1.addItem("Ejemplares");
        comboBox1.addItem("Índices");
        comboBox1.addItem("Deudores");
        comboBox1.addItem("Obras");
        comboBox1.addItem("Obras solicitadas por alumnos/docentes");
        comboBox1.addItem("Obras solicitadas por público general");
        comboBox1.addItem("Lectores con multas");
        setContentPane(listadosPanel);
        setTitle("Gestor de Préstamos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem() == "Ejemplares") {
                    ScreenManager.createMostrarListaScreen("Ejemplares");
                } else if (comboBox1.getSelectedItem() == "Índices") {
                    ScreenManager.createMostrarListaScreen("Índices");
                } else if (comboBox1.getSelectedItem() == "Deudores") {
                    ScreenManager.createMostrarListaScreen("Deudores");
                } else if (comboBox1.getSelectedItem() == "Obras") {
                    ScreenManager.createMostrarListaScreen("Obras");
                }
                dispose();
            }
        });
    }
}
