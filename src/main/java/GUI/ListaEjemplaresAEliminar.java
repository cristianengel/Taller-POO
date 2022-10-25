package GUI;

import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaEjemplaresAEliminar extends JFrame{
    Biblioteca b = Biblioteca.getInstance();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList list1;
    private JButton atrasButton;
    private JButton darDeBajaButton;
    private JPanel listaEjemplaresAEliminarPanel;

    public ListaEjemplaresAEliminar() {
        if(b.getListaDeEjemplares().size() == 0) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            throw new RuntimeException("La lista está vacía");
        }
        for(int i = 0; i < b.getListaDeEjemplares().size(); i++) {
            listModel.addElement(b.getListaDeEjemplares().get(i).toStringReducido());
        }
        list1.setModel(listModel);
        setContentPane(listaEjemplaresAEliminarPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesConEjemplares oce = new OperacionesConEjemplares();
                dispose();
            }
        });
        darDeBajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.removerEjemplar(b.getListaDeEjemplares().get(list1.getSelectedIndex()));
                MainMenuScreen mm = new MainMenuScreen();
                dispose();
            }
        });
    }
}
