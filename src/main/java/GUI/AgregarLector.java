package GUI;

import Enum.Profesion;
import Enum.Sexo;
import Enum.TipoDocumento;
import MainClasses.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AgregarLector extends JFrame{
    private JPanel agregarLectorPanel;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JComboBox<TipoDocumento> comboBoxTipoDoc;
    private JTextField textFieldDocumento;
    private JTextField textFieldCorreoElec;
    private JTextField textFieldNumTel;
    private JComboBox<Integer> comboBoxDia;
    private JComboBox<Integer> comboBoxMes;
    private JComboBox<Integer> comboBoxAnio;
    private JButton atrasButton;
    private JComboBox<Sexo> comboBoxGenero;
    private JTextField textFieldNacionalidad;
    private JTextField textFieldDomicilio;
    private JTextField textFieldCP;
    private JButton aceptarButton;
    private JTextField textFieldDepartamento;
    private JTextField textFieldLocalidad;
    private JComboBox<Profesion> comboBoxProfesion;
    private DatosDelPrestamo ddp;
    private DatosDeLaReserva ddlr;
    private final Biblioteca biblioteca = Biblioteca.getInstance();

    public AgregarLector(String tipo) {
        setContentPane(agregarLectorPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        comboBoxMes.setVisible(false);
        comboBoxDia.setVisible(false);
        comboBoxGenero.addItem(Sexo.MASCULINO);
        comboBoxGenero.addItem(Sexo.FEMENINO);
        comboBoxGenero.addItem(Sexo.OTRO);
        comboBoxTipoDoc.addItem(TipoDocumento.DNI);
        comboBoxTipoDoc.addItem(TipoDocumento.LC);
        comboBoxTipoDoc.addItem(TipoDocumento.LE);
        comboBoxProfesion.addItem(Profesion.ALUMNO);
        comboBoxProfesion.addItem(Profesion.DOCENTE);
        comboBoxProfesion.addItem(Profesion.PUBLICO);

        if(tipo == "Reserva") {
            ddlr = DatosDeLaReserva.getInstance();
        } else {
            ddp = DatosDelPrestamo.getInstance();
        }

        for(int i = LocalDate.now().getYear(); i >= 1900; i--) {
            comboBoxAnio.addItem(i);
        }
        for(int i = 1; i <= 12; i++) {
            comboBoxMes.addItem(i);
        }

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        comboBoxAnio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDias();
                comboBoxMes.setVisible(true);
            }
        });
        comboBoxMes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDias();
                comboBoxDia.setVisible(true);
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object lector = null;
                    switch (comboBoxProfesion.getItemAt(comboBoxProfesion.getSelectedIndex())) {
                        case ALUMNO -> {
                            lector = new Alumno(textFieldNombre.getText(), textFieldApellido.getText(),
                                    comboBoxTipoDoc.getItemAt(comboBoxTipoDoc.getSelectedIndex()),
                                    Integer.parseInt(textFieldDocumento.getText()),
                                    textFieldCorreoElec.getText(), textFieldNumTel.getText(),
                                    LocalDate.of((Integer) comboBoxAnio.getSelectedItem(),
                                            (Integer) comboBoxMes.getSelectedItem(), (Integer) comboBoxDia.getSelectedItem()),
                                    comboBoxGenero.getItemAt(comboBoxGenero.getSelectedIndex()),
                                    textFieldNacionalidad.getText(), textFieldDomicilio.getText(),
                                    Integer.parseInt(textFieldCP.getText()), textFieldDepartamento.getText(),
                                    textFieldLocalidad.getText());
                        }
                        case DOCENTE -> {
                            lector = new Docente(textFieldNombre.getText(), textFieldApellido.getText(),
                                    comboBoxTipoDoc.getItemAt(comboBoxTipoDoc.getSelectedIndex()),
                                    Integer.parseInt(textFieldDocumento.getText()),
                                    textFieldCorreoElec.getText(), textFieldNumTel.getText(),
                                    LocalDate.of((Integer) comboBoxAnio.getSelectedItem(),
                                            (Integer) comboBoxMes.getSelectedItem(), (Integer) comboBoxDia.getSelectedItem()),
                                    comboBoxGenero.getItemAt(comboBoxGenero.getSelectedIndex()),
                                    textFieldNacionalidad.getText(), textFieldDomicilio.getText(),
                                    Integer.parseInt(textFieldCP.getText()), textFieldDepartamento.getText(),
                                    textFieldLocalidad.getText());
                        }
                        case PUBLICO -> {
                            lector = new Publico(textFieldNombre.getText(), textFieldApellido.getText(),
                                    comboBoxTipoDoc.getItemAt(comboBoxTipoDoc.getSelectedIndex()),
                                    Integer.parseInt(textFieldDocumento.getText()),
                                    textFieldCorreoElec.getText(), textFieldNumTel.getText(),
                                    LocalDate.of((Integer) comboBoxAnio.getSelectedItem(),
                                            (Integer) comboBoxMes.getSelectedItem(), (Integer) comboBoxDia.getSelectedItem()),
                                    comboBoxGenero.getItemAt(comboBoxGenero.getSelectedIndex()),
                                    textFieldNacionalidad.getText(), textFieldDomicilio.getText(),
                                    Integer.parseInt(textFieldCP.getText()), textFieldDepartamento.getText(),
                                    textFieldLocalidad.getText());
                        }
                    }
                    if(DatosDelPrestamo.getExistente()) {
                        ddp.getIngresarDatosLectorLabel().setText("Lector: " + textFieldDocumento.getText());
                        ddp.obtenerLector((Lector) lector);
                        ddp.setHayLector(true);
                    }
                    if(DatosDeLaReserva.getExistente()) {
                        ddlr.getLectorLabel().setText("Lector: " + textFieldDocumento.getText());
                        ddlr.obtenerLector((Lector) lector);
                        ddlr.setHayLector(true);
                    }
                } catch(NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "Faltan rellenar campos");
                    return;
                }
                dispose();
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
        if((Integer.parseInt(comboBoxAnio.getSelectedItem().toString()) % 4 == 0) &&
                ((Integer.parseInt(comboBoxAnio.getSelectedItem().toString()) % 100 != 0) ||
                ((Integer.parseInt(comboBoxAnio.getSelectedItem().toString()) % 400 == 0)))) {
            return true;
        }
        return false;
    }
    // (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)) condicion año bisiesto

}
