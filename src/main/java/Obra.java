import lombok.Getter;
import lombok.Setter;

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
}
