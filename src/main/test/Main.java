import GUI.ScreenManager;
import MainClasses.Biblioteca;
import MainClasses.Ejemplar;
import MainClasses.Obra;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca b = Biblioteca.getInstance();

        b.agregarEjemplar(new Ejemplar("ident12", 135441, "caca", "matematica", new ArrayList<String>(), LocalDate.of(2022, 11, 3), "qsy", "qsyyyyy", LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "kjsdbfksdjfnsdkjnfsd")));
        b.agregarEjemplar(new Ejemplar("ident1213", 135441, "caca", "matematica", new ArrayList<String>(), LocalDate.of(2022, 11, 3), "qsy", "qsyyyyy", LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "ateatrgtregega")));
        b.agregarEjemplar(new Ejemplar("ident45", 135441, "caca", "matematica", new ArrayList<String>(), LocalDate.of(2022, 11, 3), "qsy", "qsyyyyy", LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "ateatrgtregeega")));
        b.agregarEjemplar(new Ejemplar("ident4355", 135441, "caca", "matematica", new ArrayList<String>(), LocalDate.of(2022, 11, 3), "qsy", "qsyyyyy", LocalDate.of(2021, 7, 23), "jdfhe", new Obra("lunes", "nashee", "kjhfasjk", "yo", "papa", "mama", "masc dea", "oiejfiujsdhfufnsdf", 14143, "kjsdbfksdjfnsdkjnfsd")));

        ScreenManager.createFirstScreen();
    }
}
