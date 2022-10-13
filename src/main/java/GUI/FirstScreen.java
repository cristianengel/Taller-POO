package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class FirstScreen extends JFrame {
    private JPanel firstPanel;
    private JButton ingresarButton;

    public FirstScreen() {
        setContentPane(firstPanel);
        setTitle("Gestor de Préstamos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getFullScreenWindow();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenManager.createMainScreen();
                dispose();
            }
        });
    }
}
