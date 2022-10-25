package GUI;

import Enum.Condicion;
import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeEjemplaresAReservar extends JFrame{
    private JPanel listaEjemplaresAReservarPanel;
    private JList<String> list1;
    private JButton seleccionarButton;
    private JButton mostrarMasDatosButton;
    private JButton atrasButton;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    Biblioteca b = Biblioteca.getInstance();

    public ListaDeEjemplaresAReservar() {
        setContentPane(listaEjemplaresAReservarPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        list1.setModel(listModel);
        for(int i = 0; i < b.getListaDeEjemplares().size(); i++) {
            if(b.getListaDeEjemplares().get(i).getCondicion() == Condicion.DISPONIBLE) {
                listModel.addElement(b.getListaDeEjemplares().get(i).toStringReducido());
            }
        }
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosDeLaReserva ddlr = DatosDeLaReserva.getInstance();
                try {
                    ddlr.obtenerEjemplar(b.getListaDeEjemplares().get(list1.getSelectedIndex()));
                    ddlr.getEjemplarLabel().setText("Ejemplar: " + b.getListaDeEjemplares().get(list1.getSelectedIndex()).getIdentUnico());
                    ddlr.setHayEjemplar(true);
                    dispose();
                } catch (IndexOutOfBoundsException exception) {
                    JOptionPane.showMessageDialog(null, "Seleccione un ejemplar.");
                }
            }
        });
        mostrarMasDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                for(int i = 0; i < b.getListaDeEjemplares().size(); i++) {
                    if(b.getListaDeEjemplares().get(i).getCondicion() == Condicion.DISPONIBLE) {
                        listModel.addElement(b.getListaDeEjemplares().get(i).toString());
                    }
                }
            }
        });
    }
}
