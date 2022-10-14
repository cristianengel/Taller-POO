package GUI;

import MainClasses.Biblioteca;

import javax.swing.*;

public class MostrarLista extends JFrame{
    private JList listaMostrada;
    private JPanel mostrarListaPanel;
    private JButton button1;

    public MostrarLista(String item) {
        Biblioteca b = Biblioteca.getInstance();

        DefaultListModel lista = new DefaultListModel();

        if(item == "Ejemplares") {
            for(int i = 0;i < b.getListaDeEjemplares().toArray().length;i++) {
                lista.addElement(b.mostrarEjemplares().get(i));
            }
            listaMostrada.setModel(lista);
        } else if (item == "Índices") {
            for(int i = 0;i < b.getListaDeIndices().toArray().length;i++) {
                lista.addElement(b.mostrarIndices().get(i));
            }
            listaMostrada.setModel(lista);
        } else if (item == "Deudores") {
            for(int i = 0;i < b.getListaDeDeudores().toArray().length;i++) {
                lista.addElement(b.mostrarDeudores().get(i));
            }
            listaMostrada.setModel(lista);
        } else if (item == "Obras") {
            for(int i = 0;i < b.getObras().toArray().length;i++) {
                lista.addElement(b.mostrarObras().get(i));
            }
            listaMostrada.setModel(lista);
        }

        setContentPane(mostrarListaPanel);
        setTitle("Gestor de préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
