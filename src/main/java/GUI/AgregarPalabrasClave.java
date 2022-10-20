package GUI;

import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarPalabrasClave extends JFrame {
    private final Biblioteca biblioteca = Biblioteca.getInstance();
    private JPanel agregarPalabrasClavePanel;
    private JList<String> list1;
    private JTextField textField1;
    private JButton agregarButton;
    private JButton eliminarSeleccionadaButton;
    private JButton atrasButton;
    private JButton buscarButton;

    public AgregarPalabrasClave() {
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        list1.setModel(listModel);
        setContentPane(agregarPalabrasClavePanel);
        setTitle("Gestor de Préstamos");
        setSize(450, 300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(textField1.getText());
                textField1.setText("");
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuScreen mm = new MainMenuScreen();
                dispose();
            }
        });

        eliminarSeleccionadaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(list1.getSelectedValue() == null || listModel.isEmpty()) return;
                listModel.removeElementAt(list1.getSelectedIndex());
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listModel.isEmpty()) return;
                String expresion = listModel.getElementAt(0);
                for (int i = 1; i < listModel.getSize(); i++) {
                    expresion += "|" + listModel.getElementAt(i);
                }
                ListaDeIndices ldi = new ListaDeIndices(expresion);
            }
        });
    }
}
