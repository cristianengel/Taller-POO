package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

/**
 * La clase Coleccion se plantea un tipo de obra.
 * Esta clase contiene un grupo de obras.
 */
public class Coleccion extends Obra {
    private String nombre;
    private String isbn;
    private String codBarra;
    private ArrayList<Obra> obras;

    /**
     * Constructor de la clase Coleccion.
     * @param areaTematica
     * @param titulo
     * @param subtitulo
     * @param primerAutor
     * @param segundoAutor
     * @param tercerAutor
     * @param genero
     * @param caracteristica
     * @param isbn
     * @param indice
     * @param biblioteca
     * @param nombre
     */
    public Coleccion(String areaTematica, String titulo, String subtitulo,
                     String primerAutor, String segundoAutor, String tercerAutor,
                     String genero, String caracteristica, String codBarra, String indice,
                     Biblioteca biblioteca, String nombre, Edicion edicion, String isbn) {
        super(areaTematica, titulo, subtitulo, primerAutor, segundoAutor,
                tercerAutor, genero, caracteristica, codBarra, indice, edicion);
        this.nombre = nombre;
        this.isbn = isbn;
        this.codBarra = codBarra;
    }

    /**
     * equals compara si dos objetos de tipo Coleccion son iguales.
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleccion coleccion = (Coleccion) o;
        return nombre.equals(coleccion.nombre);
    }

    /**
     * toString devuelve una cadena que representa la instancia de Coleccion.
     * @return
     */
    @Override
    public String toString() {
        return "-Coleccion: " +
                "   -Nombre='" + nombre + "\n" +
                "   -Área temática='" + getAreaTematica() + "\n" +
                "   -Título=" + getTitulo() + "\n" +
                "   -Subtítulo=" + getSubtitulo() + "\n" +
                "   -Primer autor=" + getPrimerAutor() + "\n" +
                "   -Segundo autor=" + getSegundoAutor() + "\n" +
                "   -Tercer autor=" + getTercerAutor() + "\n" +
                "   -Género=" + getGenero() + "\n" +
                "   -Característica=" + getCaracteristica() + "\n" +
                "   -ISBN=" + isbn + "\n" +
                "   -Índice=" + getIndice() + "\n";
    }

    /**
     * toStringReducido retorna un String con la información reducida de una colección.
     * @return
     */
    public String toStringReducido() {
        return "-Coleccion: " +
                "   -Nombre='" + nombre + "\n" +
                "   -Área temática='" + getAreaTematica() + "\n" +
                "   -Título=" + getTitulo() + "\n" +
                "   -Género=" + getGenero() + "\n";
    }
}
