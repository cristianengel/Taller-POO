package GUI;

import Enum.TipoLectura;
import MainClasses.Biblioteca;
import MainClasses.Ejemplar;
import MainClasses.Lector;
import MainClasses.Prestamo;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class DatosDelPrestamo extends JFrame{
    private static DatosDelPrestamo instance;
    private Biblioteca biblioteca = Biblioteca.getInstance();
    private JPanel datosDelPrestamoPanel;
    private JComboBox<TipoLectura> comboBoxTipoDeLectura;
    private JTextField funcionario;
    private JButton elegirEjemplarButton;
    protected JLabel ejemplarLabel;
    private JButton atrasButton;
    private JLabel ingresarDatosLectorLabel;
    private JButton ingresarButton;
    private JButton aceptarButton;
    private Ejemplar ejemplarAPrestamo;
    private Lector lectorQueSolicita;
    private boolean hayEjemplar = false;
    private boolean hayLector = false;

    public static DatosDelPrestamo getInstance() {
        if (instance == null) {
            instance = new DatosDelPrestamo();
        }
        return instance;
    }

    private DatosDelPrestamo() {
        comboBoxTipoDeLectura.addItem(TipoLectura.DOMICILIO);
        comboBoxTipoDeLectura.addItem(TipoLectura.SALA);
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
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!hayEjemplar || !hayLector || Objects.equals(funcionario.getText(), "")) {
                    JOptionPane.showMessageDialog(null, "Hay datos faltantes.");
                    return;
                }
                Prestamo prestamo = new Prestamo((TipoLectura) comboBoxTipoDeLectura.getSelectedItem(), LocalDateTime.now(), funcionario.getText(), ejemplarAPrestamo, lectorQueSolicita, false);
                instance = null;
                dispose();
            }
        });
    }

    /**
     * Obtiene un lector para su uso en esta clase
     * @param lector
     */
    protected void obtenerLector(Lector lector) {
        lectorQueSolicita = lector;
    }

    /**
     * Obtiene un ejemplar para su uso en esta clase
     * @param ejemplar
     */
    protected void obtenerEjemplar(Ejemplar ejemplar) {
        ejemplarAPrestamo = ejemplar;
    }

}
