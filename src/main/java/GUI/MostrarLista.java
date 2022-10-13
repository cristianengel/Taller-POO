package GUI;

import MainClasses.Biblioteca;

import javax.swing.*;

public class MostrarLista extends JFrame{
    private JList listaMostrada;
    private JPanel mostrarListaPanel;

    public MostrarLista() {
        Biblioteca b = Biblioteca.getInstance();

        //Debes crear un DefaultListModel
        /*DefaultListModel lista = new DefaultListModel();
        for(int i = 0;i < b.getListaDeEjemplares().toArray().length;i++) {
            lista.addElement(b.getListaDeEjemplares().get(i));
        }
        listaMostrada.setModel(lista);*/

        setContentPane(mostrarListaPanel);
        setTitle("Gestor de préstamos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
