package test;

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

        // Obras de Prueba
        Obra elPrincipito = new Obra("Literatura infantil", "El Principito", "", "Antoine de Saint-Exupery", "","", "Fabula", "El principito es una narración corta del escritor francés Antoine de Saint-Exupéry, que trata de la historia de un pequeño príncipe que parte de su asteroide a una travesía por el universo, en la cual descubre la extraña forma en que los adultos ven la vida y comprende el valor del amor y la amistad.", "27 capítulos");
        Obra elPrincipe = new Obra("Politica", "El Pincipe", "", "Nicolas Maquiavelo", "", "", "Ensayo", "Su tema central es cómo los gobernantes del Renacimiento deberían actuar para prevalecer. Según el autor, un Estado fuerte requiere un líder capaz de defender su poder a toda costa.",  "\"\\n\" + \"El príncipe\\n\" + \"\\n\" + \"Capítulo I\\n\" + \"\\n\" + \"Cuántas clases de principados hay, y de qué modo ellos se adquieren\\n\" + \"Capítulo II\\n\" + \"\\n\" + \"De los príncipes hereditarios\\n\" + \"Capítulo III\\n\" + \"\\n\" + \"De los principados mixtos\\n\" + \"Capítulo IV\\n\" + \"\\n\" + \"Por qué ocupado el reino de Darío por Alejandro, no se rebeló contra los sucesores de éste después de su muerte\\n\" + \"Capítulo V\\n\" + \"\\n\" + \"De qué modo deben gobernarse las ciudades o principados que, antes de ocuparse por un nuevo príncipe, se gobernaban con sus leyes particulares\\n\" + \"Capítulo VI\\n\" + \"\\n\" + \"De las soberanías nuevas que uno adquiere con sus propias armas y valor\\n\" + \"Capítulo VII\\n\" + \"\\n\" + \"De los principados nuevos que se adquieren con las fuerzas ajenas y la fortuna\\n\" + \"Capítulo VIII\\n\" + \"\\n\" + \"De los que llegaron al principado por medio de maldades\\n\" + \"Capítulo IX\\n\" + \"\\n\" + \"Del principado civil\\n\" + \"Capítulo X\\n\" + \"\\n\" + \"Cómo deben medirse las fuerzas de todos los principados\\n\" + \"Capítulo XI\\n\" + \"\\n\" + \"De los principados eclesiásticos\\n\" + \"Capítulo XII\\n\" + \"\\n\" + \"Cuántas especies de tropas hay; y de los soldados mercenarios\\n\" + \"Capítulo XIII\\n\" + \"\\n\" + \"De los soldados auxiliares, mixtos y propios\\n\" + \"Capítulo XIV\\n\" + \"\\n\" + \"De las obligaciones del príncipe en lo concerniente al arte de la guerra\\n\" + \"Capítulo XV\\n\" + \"\\n\" + \"De las cosas por las que los hombres, y especialmente los príncipes, son alabados o censurados\\n\" + \"Capítulo XVI\\n\" + \"\\n\" + \"De la liberalidad y miseria (avaricia)\\n\" + \"Capítulo XVII\\n\" + \"\\n\" + \"De la severidad y clemencia, y si vale más ser amado que temido\\n\" + \"Capítulo XVIII\\n\" + \"\\n\" + \"De qué modo los príncipes deben guardar la fe dada\\n\" + \"Capítulo XIX\\n\" + \"\\n\" + \"El príncipe debe evitar ser despreciado y aborrecido\\n\" + \"Capítulo XX\\n\" + \"\\n\" + \"Si las fortalezas y otras muchas cosas que los príncipes hacen con frecuencia son útiles o perniciosas\\n\" + \"Capítulo XXI\\n\" + \"\\n\" + \"Cómo debe conducirse un príncipe para adquirir alguna consideración\\n\" + \"Capítulo XXII\\n\" + \"\\n\" + \"De los secretarios (o ministros) de los príncipes\\n\" + \"Capítulo XXIII\\n\" + \"\\n\" + \"Cuándo debe huirse de los aduladores\\n\" + \"Capítulo XXIV\\n\" + \"\\n\" + \"¿Por qué muchos príncipes de Italia perdieron sus estados?\\n\" + \"Capítulo XXV\\n\" + \"\\n\" + \"Cuánto dominio tiene la fortuna en las cosas humanas, y de qué modo podemos resistirle cuando es contraria\\n\" + \"Capítulo XXVI\\n\" + \"\\n\" + \"Exhortación a librar la Italia de los bárbaros\"");
        Obra principiosSistemasDeInformacion = new Obra("Administracion", "Principios de sistemas de informacion: un enfoque administrativo(9ed.)", "", "Ralph M. Stair", "George W. Reynolds", "", "Didactico", "Los autores presentan una visión global y el marco teórico de las versiones anteriores, pero con información actual, ejemplos y estudios de caso. A lo largo del desarrollo de los temas se cubren los principios básicos de los sistemas de información y su aplicación en el mundo real.",  "5 partes y un total de 14 capitulos");
        Obra bibliaDeJava = new Obra("Informatica", "La Biblia de Java 2", "", "Steven Holzner","", "", "Didactico", "La biblia de Java 2 está diseñado para mostrarle toda la historia del lenguaje de programación Java, contiene no sólo toda la sintaxis de Java, desde la declaración de variables hasta temas de orientación a objetos avanzada, sino también el lenguaje Java en el mundo real.",  "Introduccion + 22 Capitulos + Apendice + Indice alfabetico");
        Obra sistemasAdSistemasInf = new Obra("Administracion", "Sistemas administrativos y sistemas de información", "", "Jorge Roberto Volpentesta", "", "", "Didactico", "Este libro habla del conocimiento y de los elementos que lo nutren: los datos y la información. Pero lo hace desde una mirada dirigida a la gestión de las organizaciones y, dentro de ellas, las empresas en especial. Y si de gestión empresaria se trata, a ésta fácilmente puede asociársela con muchas acciones que están dirigidas a disminuir el riesgo del que habla el autor citado, cuyo pensamiento expone que ese riesgo deviene de un equilibrio dinámico entre poseer o no el conocimiento.", "Introducción\n" + "\n" + "Capítulo 1. Datos, información y conocimiento\n" + "\n" + "Capítulo 2. Conceptos sobre sistemas\n" + "\n" + "Capítulo 3. La organización como sistema\n" + "\n" + "Capítulo 4. El sistema administrativo\n" + "\n" + "Capítulo 5. El sistema de información\n" + "\n" + "Capítulo 6. El estudio de sistemas\n" + "\n" + "Capítulo 7. Actividades y herramientas para el estudio de sistemas\n" + "\n" + "Capítulo 8. Sistemas aplicados\n" + "\n" + "Capítulo 9. Metodologías del ciclo de vida ampliada\n" + "\n" + "Capítulo 10. Otras metodologías de estudio de sistemas\n" + "\n" + "\n" + "Bibliografía");

        // Ejemplares de Prueba
        Ejemplar principito1 = new Ejemplar("jkhdLH", 6985422, "Se trata de un niño que vivía en un planeta con una rosa de compañía. El planeta era muy pequeño y los días pasaban muy rápido. El Principito tiene la amenaza de los baobas que pueden estallar el planeta si los deja crecer. \n" + "Es un libro interesante porque muchos niños se ven reflejados en él ya que los adultos muchas veces no les permiten seguir sus sueños.\n" + "Este libro tiene un buen mensaje para que los adultos reflexionen acerca de los sueños.", new ArrayList<String>(Arrays.asList("34", "1", "32")), LocalDate.of(2022, 7, 21), "Compra por Internet", elPrincipito);
        Ejemplar principe1 = new Ejemplar("klhHlho", 1354414, "Su tema central es cómo los gobernantes del Renacimiento deberían actuar para prevalecer. Según el autor, un Estado fuerte requiere un líder capaz de defender su poder a toda costa.", new ArrayList<String>(Arrays.asList("2", "12", "32")), LocalDate.of(2022, 8, 26), "Compra a biblioteca Y", elPrincipe);
        Ejemplar principiosSistemasDeInformacion1 = new Ejemplar("peoNSWe", 8736245, "", new ArrayList<String>(Arrays.asList("1", "34", "6")), LocalDate.of(2020, 1, 24), "Compra por Internet", principiosSistemasDeInformacion);
        Ejemplar bibliaJava1 = new Ejemplar("rebarnu", 9817442, " La biblia de Java 2 está diseñado para mostrarle toda la historia del lenguaje de programación Java, contiene no sólo toda la sintaxis de Java, desde la declaración de variables hasta temas de orientación a objetos avanzada, sino también el lenguaje Java en el mundo real. Se cubrirán temas como permisos de acceso a applets, uso del visulizador de Java, creación de conexiones cliente / servidor sobre Internet, creación de Java Beans, conexión de bases de datos, multithread y Java Swing, la nueva y revolucionaria interfaz para la programación de clases Java. ", new ArrayList<String>(Arrays.asList("21", "1", "3")), LocalDate.of(2021, 12, 2), "Compra por Internet", bibliaDeJava);
        Ejemplar sistemasAdSistemasInf1 = new Ejemplar("kQbfGG", 2451442, "", new ArrayList<String>(Arrays.asList("3", "23", "43")), LocalDate.of(2021, 6, 20), "Compra a biblioteca X",  sistemasAdSistemasInf);

        // Método agregar ejemplar de prueba
        biblioteca.agregarEjemplar(principito1);
        biblioteca.agregarEjemplar(principe1);
        biblioteca.agregarEjemplar(principiosSistemasDeInformacion1);
        biblioteca.agregarEjemplar(bibliaJava1);
        biblioteca.agregarEjemplar(sistemasAdSistemasInf1);

        // Creacion de Lectores de prueba
        Docente isaias = new Docente("Isaias", "Reniero", "DNI", 15489630, "isa@gmail.com", "3454652000", LocalDate.of(1995,3,27), "Masculino", "Argentina", "Los Valles 540", 3200, "", "Concordia");
        Alumno cristian = new Alumno("Cristian", "Engel", "DNI", 87426555, "cris@gmail.com", "3454987467", LocalDate.of(2003,6, 5), "Masculino", "Argentina", "Quintana 5", 3200, "3b", "Concordia");
        Publico marcos = new Publico("Marcos", "Barboza", "DNI", 65984111, "marquitos@gmail.com", "3454020663", LocalDate.of(2000,11,19), "Masculino", "Bolivia", "Rocamora 789", 3200, "7", "Concordia");

        // Creación de un prestamo y su devolución
        Prestamo p = new Prestamo("Para domincilio", LocalDateTime.of(2002,10,15,14,34, 5), "Roberto", principe1, marcos);
        Devolucion d = new Devolucion(LocalDateTime.of(2002,10,19,14,34, 5), principe1, marcos,"Roberto");

        System.out.println(d.controlFechaDevolucion());
    }
}