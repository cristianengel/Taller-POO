package GUI;

import MainClasses.Biblioteca;
import MainClasses.Devolucion;
import MainClasses.Prestamo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Objects;

public class InterfazDevolucion extends JFrame {
    private JPanel interfazDevolucionPanel;
    private JList list1;
    private JButton seleccionarButton;
    private JButton atrasButton;
    private JTextField textFieldFuncionario;
    DefaultListModel listModel = new DefaultListModel();
    Biblioteca b = Biblioteca.getInstance();

    public InterfazDevolucion() {
        list1.setModel(listModel);
        setContentPane(interfazDevolucionPanel);
        setTitle("Gestor de préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        for(int i = 0; i < b.getPrestamosEnCurso().size(); i++) {
            listModel.addElement(b.getPrestamosEnCurso().get(i));
        }
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list1.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione un ejemplar");
                    return;
                }
                Prestamo prestamoSeleccionado = (Prestamo) listModel.getElementAt(list1.getSelectedIndex());
                if(Objects.equals(textFieldFuncionario.getText(), "")) {
                    JOptionPane.showMessageDialog(null,
                            "Ingrese el funcionario a cargo de la devolución");
                    return;
                }
                Devolucion devolucion = new Devolucion(LocalDateTime.now(), prestamoSeleccionado.getEjemplar(),
                        prestamoSeleccionado.getLector(), textFieldFuncionario.getText(), prestamoSeleccionado);
                if(devolucion.getDiasAtrasados() > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Multa aplicada: " + devolucion.getDiasAtrasados() +
                                    " días de no poder solicitar préstamos");
                } else {
                    JOptionPane.showMessageDialog(null, "Entregado dentro del plazo.");
                    MainMenuScreen mm = new MainMenuScreen();
                    dispose();
                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrestamosYReservas pyr = new PrestamosYReservas();
                dispose();
            }
        });
    }
}
