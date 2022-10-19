package GUI;

import test.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EleccionListadoAMostrar extends JFrame{
    private JButton ejemplaresButton;
    private JButton índicesButton;
    private JButton deudoresButton;
    private JButton obrasSolicitadasPorAlumnosButton;
    private JButton obrasSolicitadasPorPúblicoButton;
    private JButton lectoresConMultasButton;
    private JButton obrasButton;
    private JPanel eleccionListadoAMostrarPanel;
    private JButton atrasButton;

    public EleccionListadoAMostrar() {
        setContentPane(eleccionListadoAMostrarPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ejemplaresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMostrada listaMostrada = new ListaMostrada("Ejemplares");
                dispose();
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuScreen mm = new MainMenuScreen();
                dispose();
            }
        });
    }
}
