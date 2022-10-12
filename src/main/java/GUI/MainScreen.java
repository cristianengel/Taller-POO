package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JPanel mainPanel;
    private JButton verListadosButton;
    private JButton otrasOperacionesButton;

    public MainScreen() {
        setContentPane(mainPanel);
        setTitle("Gestor de Préstamos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        verListadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenManager.createListadosScreen();
                dispose();
            }
        });
        otrasOperacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 10/12/22
            }
        });
    }
}