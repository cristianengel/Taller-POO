package GUI;
import javax.swing.*;

public class MainMenuScreen extends JFrame {
    private JPanel mainMenuPanel;
    private JButton listadosButton;
    private JButton opEjButton;
    private JButton opInButton;
    private JButton prestamosButton;

    public MainMenuScreen(){
        setContentPane(mainMenuPanel);
        setTitle("Gestor de Préstamos");
        setSize(450,300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
