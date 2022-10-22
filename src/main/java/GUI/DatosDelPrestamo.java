package GUI;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class DatosDelPrestamo extends JFrame{
    private static DatosDelPrestamo instance;
    private JPanel datosDelPrestamoPanel;
    private JComboBox comboBoxTipoDeLectura;
    private JTextField funcionario;
    private JButton elegirEjemplarButton;
    protected JLabel ejemplarLabel;
    private JButton atrasButton;
    private JLabel ingresarDatosLectorLabel;
    private JButton ingresarButton;

    public static DatosDelPrestamo getInstance() {
        if (instance == null) {
            instance = new DatosDelPrestamo();
        }
        return instance;
    }

    private DatosDelPrestamo() {
        setContentPane(datosDelPrestamoPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        elegirEjemplarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaDeEjemplares lde = new ListaDeEjemplares();
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrestamosYReservas pyr = new PrestamosYReservas();
                dispose();
                instance = null;
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarLector al = new AgregarLector();
            }
        });
    }
}
