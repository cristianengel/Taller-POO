package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Edicion {
    private String editorial;
    private String paisDeEdicion;
    private int numeroDeEdicion;
    private int anio;
    private int volumenes;
    private int paginas;
    private String idioma;
    private String formato;
    private boolean esColeccion;
    private int isbn;
    private Obra obra; //Relación con la clase Obra

    public Edicion(String editorial, String paisDeEdicion, int numeroDeEdicion, int anio, int volumenes, int paginas, String idioma, String formato, boolean esColeccion, int isbn, Obra obra) {
        this.editorial = editorial;
        this.paisDeEdicion = paisDeEdicion;
        this.numeroDeEdicion = numeroDeEdicion;
        this.anio = anio;
        this.volumenes = volumenes;
        this.paginas = paginas;
        this.idioma = idioma;
        this.formato = formato;
        this.esColeccion = esColeccion;
        this.isbn = isbn;
        this.obra = obra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edicion edicion)) return false;
        return numeroDeEdicion == edicion.numeroDeEdicion && anio == edicion.anio && volumenes == edicion.volumenes && paginas == edicion.paginas && esColeccion == edicion.esColeccion && Objects.equals(editorial, edicion.editorial) && Objects.equals(paisDeEdicion, edicion.paisDeEdicion) && Objects.equals(idioma, edicion.idioma) && Objects.equals(formato, edicion.formato) && Objects.equals(isbn, edicion.isbn) && Objects.equals(obra, edicion.obra);
    }

    @Override
    public String toString() {
        return "Edición{" +
                "Editorial='" + editorial + '\'' +
                ", País de edición='" + paisDeEdicion + '\'' +
                ", Número de edición=" + numeroDeEdicion +
                ", Año=" + anio +
                ", Volumenes=" + volumenes +
                ", Páginas=" + paginas +
                ", Idioma='" + idioma + '\'' +
                ", Formato='" + formato + '\'' +
                ", ¿Es colección?=" + esColeccion +
                ", ISBN=" + isbn +
                ", Obra=" + obra +
                '}';
    }
}
