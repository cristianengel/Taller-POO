import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edicion {
    String editorial;
    String paisDeEdicion;
    int numeroDeEdicion;
    int anio;
    int volumenes;
    int paginas;
    String idioma;
    String formato;
    boolean esColeccion;

    public Edicion() {
    }

    public Edicion(String editorial, String paisDeEdicion, int numeroDeEdicion, int anio, int volumenes, int paginas, String idioma, String formato, boolean esColeccion) {
        this.editorial = editorial;
        this.paisDeEdicion = paisDeEdicion;
        this.numeroDeEdicion = numeroDeEdicion;
        this.anio = anio;
        this.volumenes = volumenes;
        this.paginas = paginas;
        this.idioma = idioma;
        this.formato = formato;
        this.esColeccion = esColeccion;
    }
}
