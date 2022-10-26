package GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends JFrame {
    private JPanel mainMenuPanel;
    private JButton listadosButton;
    private JButton opEjButton;
    private JButton indicesButton;
    private JButton prestamosButton;
    private JButton salirButton;

    public MainMenuScreen(){
        setContentPane(mainMenuPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        opEjButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesConEjemplares oce = new OperacionesConEjemplares();
                dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        listadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EleccionListadoAMostrar elam = new EleccionListadoAMostrar();
                dispose();
            }
        });
        indicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarPalabrasClave apc = new AgregarPalabrasClave();
                dispose();
            }
        });
        prestamosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrestamosYReservas pyr = new PrestamosYReservas();
                dispose();
            }
        });
    }
}
