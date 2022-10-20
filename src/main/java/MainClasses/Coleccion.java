package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

/**
 * La clase Coleccion plantea un tipo de obra.
 * Esta clase contiene un grupo de obras.
 */
public class Coleccion extends Obra {
    private String nombre;
    private int isbn;
    private ArrayList<Obra> obras;

    public Coleccion(String areaTematica, String titulo, String subtitulo,
                     String primerAutor, String segundoAutor, String tercerAutor,
                     String genero, String caracteristica, int isbn, String indice,
                     Biblioteca biblioteca, String nombre) {
        super(areaTematica, titulo, subtitulo, primerAutor, segundoAutor,
                tercerAutor, genero, caracteristica, indice);
        this.nombre = nombre;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleccion coleccion = (Coleccion) o;
        return nombre.equals(coleccion.nombre);
    }

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
}
