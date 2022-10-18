package GUI;

import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaMostrada extends JFrame{
    Biblioteca b = Biblioteca.getInstance();
    private JPanel listaMostradaPanel;
    private JList list1;
    private JButton atrasButton;

    public ListaMostrada(String listaElegida) {
        DefaultListModel listModel = new DefaultListModel();
        if(listaElegida == "Ejemplares") {
            for(int i = 0; i < b.getListaDeEjemplares().size(); i++) {
                listModel.addElement(b.getListaDeEjemplares().get(i).stringSimplificado());
            }
        }
        list1.setModel(listModel);
        setContentPane(listaMostradaPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EleccionListadoAMostrar elam = new EleccionListadoAMostrar();
                dispose();
            }
        });
    }
}
