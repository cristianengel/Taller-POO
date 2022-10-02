import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
public class Obra {
    private String areaTematica;
    private String titulo;
    private String subtitulo;
    private String primerAutor;
    private String segundoAutor;
    private String tercerAutor;
    private String genero;
    private String caracteristica;
    private int isbn;
    private String indice;
    private Biblioteca biblioteca; //Relación con la clase Biblioteca
    private ArrayList<Edicion> ediciones = new ArrayList<>(); //Relación con la clase Edición
    private ArrayList<Ejemplar> ejemplares = new ArrayList<>(); //relación con la clase Ejemplar

    public Obra() {
    }

    public Obra(String areaTematica, String titulo, String subtitulo, String primerAutor, String segundoAutor, String tercerAutor, String genero, String caracteristica, int isbn, String indice, Biblioteca biblioteca) {
        this.areaTematica = areaTematica;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.primerAutor = primerAutor;
        this.segundoAutor = segundoAutor;
        this.tercerAutor = tercerAutor;
        this.genero = genero;
        this.caracteristica = caracteristica;
        this.isbn = isbn;
        this.indice = indice;
        this.biblioteca = biblioteca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obra obra)) return false;
        return isbn == obra.isbn && Objects.equals(areaTematica, obra.areaTematica) && Objects.equals(titulo, obra.titulo) && Objects.equals(subtitulo, obra.subtitulo) && Objects.equals(primerAutor, obra.primerAutor) && Objects.equals(segundoAutor, obra.segundoAutor) && Objects.equals(tercerAutor, obra.tercerAutor) && Objects.equals(genero, obra.genero) && Objects.equals(caracteristica, obra.caracteristica) && Objects.equals(indice, obra.indice) && Objects.equals(biblioteca, obra.biblioteca);
    }

    @Override
    public String toString() {
        return "Obra{" +
                "areaTematica='" + areaTematica + '\'' +
                ", titulo='" + titulo + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                ", primerAutor='" + primerAutor + '\'' +
                ", segundoAutor='" + segundoAutor + '\'' +
                ", tercerAutor='" + tercerAutor + '\'' +
                ", genero='" + genero + '\'' +
                ", caracteristica='" + caracteristica + '\'' +
                ", isbn=" + isbn +
                ", indice='" + indice + '\'' +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
