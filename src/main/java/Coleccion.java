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
}
