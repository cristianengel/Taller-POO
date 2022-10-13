package MainClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coleccion extends Obra {
    private String nombre;

    public Coleccion(String areaTematica, String titulo, String subtitulo, String primerAutor, String segundoAutor, String tercerAutor, String genero, String caracteristica, int isbn, String indice, Biblioteca biblioteca, String nombre) {
        super(areaTematica, titulo, subtitulo, primerAutor, segundoAutor, tercerAutor, genero, caracteristica, isbn, indice, biblioteca);
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleccion coleccion = (Coleccion) o;
        return nombre.equals(coleccion.nombre);
    }

    public String toString() {
        return "MainClasses.Coleccion{" +
                "Nombre='" + nombre + '\'' +
                ", Área temática='" + getAreaTematica() + '\'' +
                ", Título='" + getTitulo() + '\'' +
                ", Subtítulo='" + getSubtitulo() + '\'' +
                ", Primer autor='" + getPrimerAutor() + '\'' +
                ", Segundo autor='" + getSegundoAutor() + '\'' +
                ", Tercer autor='" + getTercerAutor() + '\'' +
                ", Género='" + getGenero() + '\'' +
                ", Característica='" + getCaracteristica() + '\'' +
                ", ISBN=" + getIsbn() +
                ", Índice='" + getIndice() + '\'' +
                '}';
    }
}
