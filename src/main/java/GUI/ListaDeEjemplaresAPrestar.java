package GUI;

import Enum.Condicion;
import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeEjemplaresAPrestar extends JFrame{
    private JPanel listaDeEjemplaresPanel;
    private JList<String> list1;
    private JButton seleccionarButton;
    private JButton atrasButton;
    private JButton mostrarMasDatosButton;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    Biblioteca b = Biblioteca.getInstance();
    
    public ListaDeEjemplaresAPrestar() {
        setContentPane(listaDeEjemplaresPanel);
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
                DatosDelPrestamo ddp = DatosDelPrestamo.getInstance();
                try {
                    ddp.obtenerEjemplar(b.getListaDeEjemplares().get(list1.getSelectedIndex()));
                    ddp.getEjemplarLabel().setText("Ejemplar: " + b.getListaDeEjemplares().get(list1.getSelectedIndex()).getIdentUnico());
                    ddp.setHayEjemplar(true);
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
