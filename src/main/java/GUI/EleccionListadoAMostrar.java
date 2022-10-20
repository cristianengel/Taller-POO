package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EleccionListadoAMostrar extends JFrame{
    private JButton ejemplaresButton;
    private JButton deudoresButton;
    private JButton obrasSolicitadasPorAlumnosButton;
    private JButton obrasSolicitadasPorPublicoButton;
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
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuScreen mm = new MainMenuScreen();
                dispose();
            }
        });
        ejemplaresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMostrada listaMostrada = new ListaMostrada("Ejemplares");
                dispose();
            }
        });
        deudoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMostrada listaMostrada = new ListaMostrada("Deudores");
                dispose();
            }
        });
        obrasSolicitadasPorAlumnosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMostrada listaMostrada = new ListaMostrada("Alumnos y Docentes");
                dispose();
            }
        });
        obrasSolicitadasPorPublicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMostrada listaMostrada = new ListaMostrada("Publico");
                dispose();
            }
        });
        lectoresConMultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMostrada listaMostrada = new ListaMostrada("Lectores con Multas");
                dispose();
            }
        });
        obrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMostrada listaMostrada = new ListaMostrada("Obras");
                dispose();
            }
        });
    }
}
