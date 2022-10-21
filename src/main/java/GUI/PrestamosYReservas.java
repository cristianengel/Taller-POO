package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrestamosYReservas extends JFrame{
    private JPanel prestamosYReservasPanel;
    private JButton solicitarPrestamoButton;
    private JButton reservarButton;
    private JButton atrasButton;
    private JButton devolverButton;

    public PrestamosYReservas() {
        setContentPane(prestamosYReservasPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuScreen mm = new MainMenuScreen();
                dispose();
            }
        });
        solicitarPrestamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosDelPrestamo ddp = DatosDelPrestamo.getInstance();
                dispose();
            }
        });
        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 10/21/22  
            }
        });
        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 10/21/22  
            }
        });
    }
}
