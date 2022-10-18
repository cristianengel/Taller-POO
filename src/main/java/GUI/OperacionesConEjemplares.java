package GUI;

import test.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionesConEjemplares extends JFrame {
    private JPanel opEjPanel;
    private JButton agregarEjemplarButton;
    private JButton eliminarEjemplarButton;
    private JButton atrasButton;

    public OperacionesConEjemplares() {
        setContentPane(opEjPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        agregarEjemplarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarEjemplar ae = new AgregarEjemplar();
                dispose();
            }

        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainMenu();
                dispose();
            }
        });
    }
}
