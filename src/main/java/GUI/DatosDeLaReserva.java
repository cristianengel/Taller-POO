package GUI;

import Enum.Condicion;
import MainClasses.Biblioteca;
import MainClasses.Ejemplar;
import MainClasses.Lector;
import MainClasses.Reserva;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class DatosDeLaReserva extends JFrame{
    private static DatosDeLaReserva instance;
    private Biblioteca b = Biblioteca.getInstance();
    private JPanel datosDeLaReservaPanel;
    private JComboBox<Integer> comboBoxAnio;
    private JComboBox<Integer> comboBoxMes;
    private JComboBox<Integer> comboBoxDia;
    private JComboBox<Integer> comboBoxHora;
    private JComboBox<Integer> comboBoxMinutos;
    private JComboBox<Integer> comboBoxPlazo;
    private JButton seleccionarButton;
    private JButton ingresarButton;
    private JButton atrasButton;
    private JLabel ejemplarLabel;
    private JLabel lectorLabel;
    private JButton aceptarButton;
    private Lector lectorQueSolicita;
    private Ejemplar ejemplarAReserva;
    private boolean hayEjemplar = false;
    private boolean hayLector = false;

    public static DatosDeLaReserva getInstance() {
        if(instance == null) {
            instance = new DatosDeLaReserva();
        }
        return instance;
    }

    public static boolean getExistente() {
        return instance != null;
    }

    private DatosDeLaReserva() {
        setContentPane(datosDeLaReservaPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        comboBoxMes.setVisible(false);
        comboBoxDia.setVisible(false);
        comboBoxHora.setVisible(false);
        comboBoxMinutos.setVisible(false);


        for(int i = LocalDate.now().getYear(); i < LocalDate.now().plusYears(10).getYear(); i++) {
            comboBoxAnio.addItem(i);
        }
        for(int i = 1; i <= 12; i++) {
            comboBoxMes.addItem(i);
        }
        for(int i = 1; i <= 24; i++) {
            comboBoxHora.addItem(i);
        }
        for(int i = 1; i < 60; i++) {
            comboBoxMinutos.addItem(i);
        }
        for(int i = 1; i <= 31; i++) {
            comboBoxPlazo.addItem(i);
        }

        comboBoxAnio.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDias();
                comboBoxMes.setVisible(true);
            }
        });
        comboBoxMes.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDias();
                comboBoxDia.setVisible(true);
            }
        });
        comboBoxDia.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxHora.setVisible(true);
            }
        });
        comboBoxHora.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxMinutos.setVisible(true);
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrestamosYReservas pyr = new PrestamosYReservas();
                instance = null;
                dispose();
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarLector al = new AgregarLector("Reserva");
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!hayEjemplar || !hayLector) {
                    JOptionPane.showMessageDialog(null, "Hay datos faltantes.");
                    return;
                }
                LocalDateTime fechaHoraInicio = LocalDateTime.of(Integer.parseInt(Objects.requireNonNull(
                        comboBoxAnio.getSelectedItem()).toString()), Integer.parseInt(Objects.requireNonNull(
                                comboBoxMes.getSelectedItem()).toString()), Integer.parseInt(Objects.requireNonNull(
                                        comboBoxDia.getSelectedItem()).toString()), Integer.parseInt(
                                                Objects.requireNonNull(comboBoxHora.getSelectedItem()).toString()),
                        Integer.parseInt(Objects.requireNonNull(comboBoxMinutos.getSelectedItem()).toString()));
                LocalDateTime fechaHoraFin = fechaHoraInicio.plusDays(Integer.parseInt(
                        Objects.requireNonNull(comboBoxPlazo.getSelectedItem()).toString()));
                Reserva reserva = b.reservar(fechaHoraInicio, fechaHoraFin, ejemplarAReserva, lectorQueSolicita);
                b.getReservasEnCurso().add(reserva);
                for(int i = 0; i < b.getListaDeEjemplares().size(); i++) {
                    if(b.getListaDeEjemplares().get(i).equals(ejemplarAReserva)) {
                        b.getListaDeEjemplares().get(i).setCondicion(Condicion.RESERVADO);
                    }
                }
                instance = null;
                MainMenuScreen mm = new MainMenuScreen();
                dispose();
            }
        });
        seleccionarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaDeEjemplaresAReservar lear = new ListaDeEjemplaresAReservar();
            }
        });
    }

    public void mostrarDias() {
        int dias;
        if(comboBoxMes.getSelectedIndex() == 1) {
            if(chequeoBisiesto()) dias = 29; else dias = 28;
        } else if (comboBoxMes.getSelectedIndex() == 3 || comboBoxMes.getSelectedIndex() == 5 ||
                comboBoxMes.getSelectedIndex() == 8 || comboBoxMes.getSelectedIndex() == 10) {
            dias = 30;
        } else {
            dias = 31;
        }
        comboBoxDia.removeAllItems();
        for(int i = 1; i <= dias; i++) {
            comboBoxDia.addItem(i);
        }
    }

    public boolean chequeoBisiesto() {
        if(comboBoxAnio.getSelectedItem() == null) return false;
        return (Integer.parseInt(comboBoxAnio.getSelectedItem().toString()) % 4 == 0) &&
                ((Integer.parseInt(comboBoxAnio.getSelectedItem().toString()) % 100 != 0) ||
                        ((Integer.parseInt(comboBoxAnio.getSelectedItem().toString()) % 400 == 0)));
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
        ejemplarAReserva = ejemplar;
    }
}
