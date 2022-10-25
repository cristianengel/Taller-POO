package GUI;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import javax.swing.*;


public class DatosDeLaReserva extends JFrame{
    private JPanel datosDeLaReservaPanel;
    private JDateChooser JDateChooser1;
    private JYearChooser JYearChooser1;

    public DatosDeLaReserva() {
        setContentPane(datosDeLaReservaPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createUIComponents() {
        JSpinner spinner = (JSpinner)JYearChooser1.getSpinner();
        ((javax.swing.JTextField)spinner.getEditor()).setEditable(true);
    }
}
