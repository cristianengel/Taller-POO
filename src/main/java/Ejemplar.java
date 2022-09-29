import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
public class Ejemplar {
    String identUnico;
    int codBarra;
    String observaciones;
    String areaDeReferencia;
    ArrayList<String> lugarFisico = new ArrayList<>();

    LocalDate fechaDadoDeBaja;
    String motivoDadoDeBaja;
    String ubicacionFisicaDadoDeBaja;

    LocalDate fechaDeAdquisicion;
    String formaDeAdquisicion;

    public Ejemplar() {
    }

    public Ejemplar(String identUnico, int codBarra, String observaciones, String areaDeReferencia, ArrayList<String> lugarFisico, LocalDate fechaDadoDeBaja, String motivoDadoDeBaja, String ubicacionFisicaDadoDeBaja, LocalDate fechaDeAdquisicion, String formaDeAdquisicion) {
        this.identUnico = identUnico;
        this.codBarra = codBarra;
        this.observaciones = observaciones;
        this.areaDeReferencia = areaDeReferencia;
        this.lugarFisico = lugarFisico;
        this.fechaDadoDeBaja = fechaDadoDeBaja;
        this.motivoDadoDeBaja = motivoDadoDeBaja;
        this.ubicacionFisicaDadoDeBaja = ubicacionFisicaDadoDeBaja;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.formaDeAdquisicion = formaDeAdquisicion;
    }
}
