package GUI;

public class ScreenManager {
    public static FirstScreen createFirstScreen() {
        return new FirstScreen();
    }

    public static MainScreen createMainScreen() {
        return new MainScreen();
    }

    public static Listados createListadosScreen() {
        return new Listados();
    }

    public static MostrarLista createMostrarListaScreen() {
        return new MostrarLista();
    }
}
