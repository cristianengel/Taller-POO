package test;

import Enum.*;
import GUI.WelcomeScreen;
import MainClasses.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Clase para probar todos los métodos hechos
 */
public class TestMetodos {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstance();

        Edicion santillanacuartaedicion = new Edicion("Santillana", "Argentina", "4",
                2022, 7, 400, "Español",
                "Libro", false, "1234567891234");
        Edicion normaEdicionAniversario = new Edicion("Norma", "Argentina", "7",
                2022, 6, 562, "Español",
                "Libro", false, "3248743783343");
        //Obras de Prueba
        Obra elPrincipito = new Obra("Literatura infantil", "El Principito", "",
                "Antoine de Saint-Exupery", "","", "Fabula",
                "El principito es una narración corta del escritor francés Antoine de Saint-Exupéry, " +
                        "que trata de la historia de un pequeño príncipe que parte de su asteroide a una travesía " +
                        "por el universo, en la cual descubre la extraña forma en que los adultos ven la vida y " +
                        "comprende el valor del amor y la amistad.", "23784327",
                "27 capítulos", santillanacuartaedicion);

        Obra bibliaDeJava = new Obra("Informatica", "La Biblia de Java 2", "",
                "Steven Holzner","", "", "Didactico",
                "La biblia de Java 2 está diseñado para mostrarle toda la historia del lenguaje de" +
                        " programación Java, contiene no sólo toda la sintaxis de Java, desde la declaración de" +
                        " variables hasta temas de orientación a objetos avanzada, sino también el lenguaje Java" +
                        " en el mundo real.", "23443278",
                "Introduccion + 22 Capitulos + Apendice + Indice alfabetico", normaEdicionAniversario);



        //Ejemplares de Prueba
        Ejemplar principito1 = new Ejemplar("jkhdLgH",
                "Se trata de un niño que vivía en un planeta con una rosa de compañía. " +
                        "El planeta era muy pequeño y los días pasaban muy rápido. El Principito tiene la " +
                        "amenaza de los baobas que pueden estallar el planeta si los deja crecer. \n" +
                        "Es un libro interesante porque muchos niños se ven reflejados en él ya que los " +
                        "adultos muchas veces no les permiten seguir sus sueños.\n" + "Este libro tiene " +
                        "un buen mensaje para que los adultos reflexionen acerca de los sueños.",
                new ArrayList<String>(Arrays.asList("34", "1", "32")), LocalDate.of(2022, 7, 21),
                "Compra por Internet", elPrincipito);

        Ejemplar bibliaJava1 = new Ejemplar("gf34t3t",
                " La biblia de Java 2 está diseñado para mostrarle toda la historia del " +
                        "lenguaje de programación Java, contiene no sólo toda la sintaxis de Java, desde la" +
                        " declaración de variables hasta temas de orientación a objetos avanzada, sino también " +
                        "el lenguaje Java en el mundo real. Se cubrirán temas como permisos de acceso a applets, " +
                        "uso del visulizador de Java, creación de conexiones cliente / servidor sobre Internet, " +
                        "creación de Java Beans, conexión de bases de datos, multithread y Java Swing, la nueva y" +
                        " revolucionaria interfaz para la programación de clases Java. ",
                new ArrayList<String>(Arrays.asList("21", "1", "3")), LocalDate.of(2021, 12, 2),
                "Compra por Internet", bibliaDeJava);


        //Método para agregar los ejemplar de prueba a la biblioteca
        biblioteca.agregarEjemplar(principito1);
        biblioteca.agregarEjemplar(bibliaJava1);

        //Creacion de Lectores de prueba
        Docente isaias = new Docente("Isaias", "Reniero", TipoDocumento.DNI,
                15489630, "isa@gmail.com", "3454652000",
                LocalDate.of(1995,3,27), Sexo.MASCULINO, "Argentina",
                "Los Valles 540", 3200, "", "Concordia");
        Alumno cristian = new Alumno("Cristian", "Engel", TipoDocumento.DNI,
                87426555, "cris@gmail.com", "3454987467",
                LocalDate.of(2003,6, 5), Sexo.MASCULINO, "Argentina",
                "Quintana 5", 3200, "3b", "Concordia");
        Publico marcos = new Publico("Marcos", "Barboza", TipoDocumento.DNI,
                65984111, "marquitos@gmail.com", "3454020663",
                LocalDate.of(2000,11,19), Sexo.OTRO, "Bolivia",
                "Rocamora 789", 3200, "7", "Concordia");

        //Creación de una reserva
        Reserva r = new Reserva(LocalDateTime.now(),
                LocalDateTime.of(2023, 10, 20, 14,34), bibliaJava1, cristian);

        //biblioteca.registrarRetiroConReserva(r, TipoLectura.DOMICILIO, "Roberto");

        //Creación de un préstamo y su devolución

        Prestamo p = new Prestamo(TipoLectura.DOMICILIO,
                LocalDateTime.of(2002,10,15,14,34),
                "Roberto", principito1, marcos, false);

        //Devolucion d = new Devolucion(LocalDateTime.of(2002,10,25,14,34),
        //        principito1, marcos,"Roberto", p);

        System.out.println(biblioteca.getPrestamosEnCurso());
        WelcomeScreen ws = new WelcomeScreen();
    }
}
