package MainClasses;

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
    private String indice;
    //private ArrayList<Edicion> ediciones = new ArrayList<Edicion>(); //Relación con la clase Edición
    private ArrayList<Ejemplar> ejemplares = new ArrayList<Ejemplar>(); //relación con la clase Ejemplar

    public Obra(String areaTematica, String titulo, String subtitulo, String primerAutor, String segundoAutor, String tercerAutor, String genero, String caracteristica, String indice) {
        this.areaTematica = areaTematica;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.primerAutor = primerAutor;
        this.segundoAutor = segundoAutor;
        this.tercerAutor = tercerAutor;
        this.genero = genero;
        this.caracteristica = caracteristica;
        this.indice = indice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obra obra)) return false;
        return  Objects.equals(areaTematica, obra.areaTematica) && Objects.equals(titulo, obra.titulo) && Objects.equals(subtitulo, obra.subtitulo) && Objects.equals(primerAutor, obra.primerAutor) && Objects.equals(segundoAutor, obra.segundoAutor) && Objects.equals(tercerAutor, obra.tercerAutor) && Objects.equals(genero, obra.genero) && Objects.equals(caracteristica, obra.caracteristica) && Objects.equals(indice, obra.indice);
    }

    @Override
    public String toString() {
        return "🔹Obra: " + "\n" +
                "   -Área temática='" + areaTematica + "\n" +
                "   -Título=" + titulo + "\n" +
                "   -Subtítulo=" + subtitulo + "\n" +
                "   -Primer autor=" + primerAutor + "\n" +
                "   -Segundo autor=" + segundoAutor + "\n" +
                "   -Tercer autor=" + tercerAutor + "\n" +
                "   -Género=" + genero + "\n" +
                "   -Característica=" + caracteristica + "\n" +
                "   -Índice=" + indice + "\n";
    }
}
