import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Obra {
    String areaTematica;
    String titulo;
    String subtitulo;
    String primerAutor;
    String segundoAutor;
    String tercerAutor;
    String genero;
    String caracteristica;
    int isbn;
    String indice;

    public Obra() {
    }

    public Obra(String areaTematica, String titulo, String subtitulo, String primerAutor, String segundoAutor, String tercerAutor, String genero, String caracteristica, int isbn, String indice) {
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obra obra)) return false;
        return isbn == obra.isbn && Objects.equals(areaTematica, obra.areaTematica) && Objects.equals(titulo, obra.titulo) && Objects.equals(subtitulo, obra.subtitulo) && Objects.equals(primerAutor, obra.primerAutor) && Objects.equals(segundoAutor, obra.segundoAutor) && Objects.equals(tercerAutor, obra.tercerAutor) && Objects.equals(genero, obra.genero) && Objects.equals(caracteristica, obra.caracteristica) && Objects.equals(indice, obra.indice);
    }

}
