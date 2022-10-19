package GUI;

import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListaDeIndices extends JFrame{
    Biblioteca b = Biblioteca.getInstance();
    DefaultListModel<String> listModel = new DefaultListModel<String>();
    private JPanel listaDeIndicesPanel;
    private JList<String> list1;
    private JButton atrasButton;


    public ListaDeIndices(String expresion) {
        list1.setModel(listModel);
        setContentPane(listaDeIndicesPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Pattern pattern = Pattern.compile(expresion, Pattern.CASE_INSENSITIVE);
        for(int i = 0; i < b.getListaDeIndices().size(); i++) {
            Matcher matcher = pattern.matcher(b.getListaDeIndices().get(i));
            if(matcher.find()) {
                listModel.addElement(b.getListaDeIndices().get(i));
            }
        }
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
