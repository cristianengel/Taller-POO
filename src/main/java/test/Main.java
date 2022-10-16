package test;

import GUI.MainMenuScreen;
import GUI.WelcomeScreen;
import MainClasses.Biblioteca;
import MainClasses.Ejemplar;
import MainClasses.Obra;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca b = Biblioteca.getInstance();

        b.agregarEjemplar(new Ejemplar("ident12", 135441, "kjsdhf", "matematica", new ArrayList<String>(), LocalDate.of(2022, 11, 3), "qsy", new ArrayList<String>(), LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "kjsdbfksdjfnsdkjnfsd")));
        b.agregarEjemplar(new Ejemplar("ident1213", 873624, "idegsfib", "lengua", new ArrayList<String>(), LocalDate.of(2021, 7, 30), "nidea", new ArrayList<String>(), LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "rtrtgfrtgr")));
        b.agregarEjemplar(new Ejemplar("ident45", 981744, "lskdfhsdf", "ciencias", new ArrayList<String>(), LocalDate.of(2020, 2, 11), "me mataste", new ArrayList<String>(), LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "ateatrgtregega")));
        b.agregarEjemplar(new Ejemplar("ident4355", 245144, "kiasudf", "arte", new ArrayList<String>(), LocalDate.of(2022, 9, 24), "god", new ArrayList<String>(), LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "kjsdbfksdjfnsdkjnfsd")));

        WelcomeScreen ws = new WelcomeScreen();
    }

    public static void mainMenu() {
        MainMenuScreen mm = new MainMenuScreen();
    }
}
