import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coleccion extends Obra {
    String nombre;

    public Coleccion() {
    }

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

}
