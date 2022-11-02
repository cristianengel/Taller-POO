package test;

import GUI.WelcomeScreen;
import MainClasses.Biblioteca;

/**
 * Clase creada para realizar la creación de objetos y la puesta en prueba de los métodos
 */
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        WelcomeScreen ws = new WelcomeScreen();
    }
}
