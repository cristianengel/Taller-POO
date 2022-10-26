package MainClasses;

import Enum.Profesion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter

/**
 * La clase Obra expone los datos de las obras existentes en la
 * biblioteca.
 */
public class Obra {
    Biblioteca biblioteca = Biblioteca.getInstance();
    private String areaTematica;
    private String titulo;
    private String subtitulo;
    private String primerAutor;
    private String segundoAutor;
    private String tercerAutor;
    private String genero;
    private String caracteristica;
    private String codBarra;
    private String indice;
    private int vecesSolicitadaAluDoc = 0;
    private int vecesSolicitadaPublico = 0;
    private Edicion edicion;
    private ArrayList<Ejemplar> ejemplares = new ArrayList<Ejemplar>();

    /**
     * Constructor de la clase Obra.
     * @param areaTematica
     * @param titulo
     * @param subtitulo
     * @param primerAutor
     * @param segundoAutor
     * @param tercerAutor
     * @param genero
     * @param caracteristica
     * @param indice
     */
    public Obra(String areaTematica, String titulo, String subtitulo,
                String primerAutor, String segundoAutor, String tercerAutor,
                String genero, String caracteristica, String codBarra, String indice, Edicion edicion) {
        this.areaTematica = areaTematica;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.primerAutor = primerAutor;
        this.segundoAutor = segundoAutor;
        this.tercerAutor = tercerAutor;
        this.genero = genero;
        this.caracteristica = caracteristica;
        this.codBarra = codBarra;
        this.indice = indice;
        this.edicion = edicion;
    }

    /**
     * agregarSolicitud agrega una solicitud a uno de los contadores de solicitudes.
     * @param profesion
     */
    public void agregarSolicitud(Profesion profesion) {
        if(Objects.equals(profesion, Profesion.ALUMNO) || Objects.equals(profesion, Profesion.DOCENTE)) {
            this.vecesSolicitadaAluDoc += 1;
            if(!biblioteca.getListaObrasSolicitadasAluDoc().contains(this)) {
                biblioteca.getListaObrasSolicitadasAluDoc().add(this);
            }
        } else if (Objects.equals(profesion, Profesion.PUBLICO)) {
            this.vecesSolicitadaPublico += 1;
            if(!biblioteca.getListaObrasSolicitadasPublico().contains(this)) {
                biblioteca.getListaObrasSolicitadasPublico().add(this);
            }
        }
    }

    /**
     * equals verifica si son objetos de tipo Obra son iguales.
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obra obra)) return false;
        return  Objects.equals(areaTematica, obra.areaTematica) &&
                Objects.equals(titulo, obra.titulo) &&
                Objects.equals(subtitulo, obra.subtitulo) &&
                Objects.equals(primerAutor, obra.primerAutor) &&
                Objects.equals(segundoAutor, obra.segundoAutor) &&
                Objects.equals(tercerAutor, obra.tercerAutor) &&
                Objects.equals(genero, obra.genero) &&
                Objects.equals(caracteristica, obra.caracteristica) &&
                Objects.equals(indice, obra.indice);
    }

    /**
     * toString devuelve una cadena que representa la instancia de Obra.
     * @return
     */
    @Override
    public String toString() {
        return "-Obra: " + "\n" +
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

    /**
     * toStringReducido retorna un String con la información reducida de una obra.
     * @return
     */
    public String toStringReducido() {
        return "-Obra: " + "\n" +
                "   -Título=" + titulo + "\n" +
                "   -Género=" + genero;
    }
}
