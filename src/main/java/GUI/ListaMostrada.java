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
            if(b.getListaDeEjemplares().size() == 0) {
                JOptionPane.showMessageDialog(null, "La lista está vacía.");
                throw new RuntimeException("La lista está vacía");
            }
            for(int i = 0; i < b.getListaDeEjemplares().size(); i++) {
                listModel.addElement(b.getListaDeEjemplares().get(i).toString());
            }

        } else if(listaElegida == "Indices") {
            if(b.getListaDeIndices().size() == 0) {
                JOptionPane.showMessageDialog(null, "La lista está vacía.");
                throw new RuntimeException("La lista está vacía");
            }
            for(int i = 0; i < b.getListaDeIndices().size(); i++) {
                listModel.addElement(b.getListaDeIndices().get(i).toString());
            }

        } else if(listaElegida == "Deudores") {
            if(b.getListaDeDeudores().size() == 0) {
                JOptionPane.showMessageDialog(null, "La lista está vacía.");
                throw new RuntimeException("La lista está vacía");
            }
            for(int i = 0; i < b.getListaDeDeudores().size(); i++) {
                listModel.addElement(b.getListaDeDeudores().get(i).toString());
            }

        } else if(listaElegida == "Alumnos y Docentes") {
            if(b.getListaObrasSolicitadasAluDoc().size() == 0) {
                JOptionPane.showMessageDialog(null, "La lista está vacía.");
                throw new RuntimeException("La lista está vacía");
            }
            for(int i = 0; i < b.getListaObrasSolicitadasAluDoc().size(); i++) {
                listModel.addElement(b.getListaObrasSolicitadasAluDoc().get(i).toString());
            }
        } else if(listaElegida == "Publico") {
            if(b.getListaObrasSolicitadasPublico().size() == 0) {
                JOptionPane.showMessageDialog(null, "La lista está vacía.");
                throw new RuntimeException("La lista está vacía");
            }
            for(int i = 0; i < b.getListaObrasSolicitadasPublico().size(); i++) {
                listModel.addElement(b.getListaObrasSolicitadasPublico().get(i).toString());
            }

        } else if(listaElegida == "Lectores con Multas") {
            if (b.getListaLectoresConMultas().size() == 0) {
                JOptionPane.showMessageDialog(null, "La lista está vacía.");
                throw new RuntimeException("La lista está vacía");
            }
            for (int i = 0; i < b.getListaLectoresConMultas().size(); i++) {
                listModel.addElement(b.getListaLectoresConMultas().get(i).toString());
            }

        } else if(listaElegida == "Obras") {
            if(b.getObras().size() == 0) {
                JOptionPane.showMessageDialog(null, "La lista está vacía.");
                throw new RuntimeException("La lista está vacía");
            }
            for(int i = 0; i < b.getObras().size(); i++) {
                listModel.addElement(b.getObras().get(i).toString());
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
