package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Coleccion extends Obra {
    private String nombre;
    private int isbn;
    private ArrayList<Obra> obras;

    public Coleccion(String areaTematica, String titulo, String subtitulo, String primerAutor, String segundoAutor, String tercerAutor, String genero, String caracteristica, int isbn, String indice, Biblioteca biblioteca, String nombre) {
        super(areaTematica, titulo, subtitulo, primerAutor, segundoAutor, tercerAutor, genero, caracteristica, indice);
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
        return "Coleccion{" +
                "Nombre='" + nombre + '\'' +
                ", Área temática='" + getAreaTematica() + '\'' +
                ", Título='" + getTitulo() + '\'' +
                ", Subtítulo='" + getSubtitulo() + '\'' +
                ", Primer autor='" + getPrimerAutor() + '\'' +
                ", Segundo autor='" + getSegundoAutor() + '\'' +
                ", Tercer autor='" + getTercerAutor() + '\'' +
                ", Género='" + getGenero() + '\'' +
                ", Característica='" + getCaracteristica() + '\'' +
                ", ISBN=" + isbn + '\'' +
                ", Índice='" + getIndice() + '\'' +
                '}';
    }
}
