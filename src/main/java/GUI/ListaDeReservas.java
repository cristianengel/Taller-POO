package GUI;

import Enum.TipoLectura;
import MainClasses.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeReservas extends JFrame{
    private JPanel panel1;
    private JList list1;
    private JButton seleccionarButton;
    private JButton atrasButton;
    private JComboBox comboBoxTipoLectura;
    private JTextField funcionario;
    DefaultListModel listModel = new DefaultListModel();
    Biblioteca b = Biblioteca.getInstance();

    public ListaDeReservas() {
        comboBoxTipoLectura.addItem(TipoLectura.DOMICILIO);
        comboBoxTipoLectura.addItem(TipoLectura.SALA);
        list1.setModel(listModel);
        setContentPane(panel1);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        for(int i = 0; i < b.getReservasEnCurso().size(); i++) {
            listModel.addElement(b.getReservasEnCurso().get(i));
        }
        seleccionarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                b.registrarRetiroConReserva(b.getReservasEnCurso().get(list1.getSelectedIndex()), (TipoLectura) comboBoxTipoLectura.getSelectedItem(), funcionario.getText());
                MainMenuScreen mm = new MainMenuScreen();
                dispose();
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                PrestamosYReservas pyr = new PrestamosYReservas();
                dispose();
            }
        });
    }
}
