package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listados extends JFrame{
    private JComboBox comboBox1;
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
                ScreenManager.createMostrarListaScreen();
                dispose();
            }
        });
    }
}
