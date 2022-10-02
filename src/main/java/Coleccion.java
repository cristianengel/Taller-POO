import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coleccion extends Obra {
    private String nombre;

    public Coleccion() {}

    public Coleccion(String nombre) {
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
        return "Coleccion{" +
                "nombre='" + nombre + '\'' +
                ", areaTematica='" + getAreaTematica() + '\'' +
                ", titulo='" + getTitulo() + '\'' +
                ", subtitulo='" + getSubtitulo() + '\'' +
                ", primerAutor='" + getPrimerAutor() + '\'' +
                ", segundoAutor='" + getSegundoAutor() + '\'' +
                ", tercerAutor='" + getTercerAutor() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", caracteristica='" + getCaracteristica() + '\'' +
                ", isbn=" + getIsbn() +
                ", indice='" + getIndice() + '\'' +
                '}';
    }
}
