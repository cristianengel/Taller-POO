import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ejemplar ejemplar)) return false;
        return codBarra == ejemplar.codBarra && Objects.equals(identUnico, ejemplar.identUnico) && Objects.equals(observaciones, ejemplar.observaciones) && Objects.equals(areaDeReferencia, ejemplar.areaDeReferencia) && Objects.equals(lugarFisico, ejemplar.lugarFisico) && Objects.equals(fechaDadoDeBaja, ejemplar.fechaDadoDeBaja) && Objects.equals(motivoDadoDeBaja, ejemplar.motivoDadoDeBaja) && Objects.equals(ubicacionFisicaDadoDeBaja, ejemplar.ubicacionFisicaDadoDeBaja) && Objects.equals(fechaDeAdquisicion, ejemplar.fechaDeAdquisicion) && Objects.equals(formaDeAdquisicion, ejemplar.formaDeAdquisicion);
    }

    public String toString() {
        return "Ejemplar{" +
                "identUnico='" + identUnico + '\'' +
                ", codBarra=" + codBarra +
                ", observaciones='" + observaciones + '\'' +
                ", areaDeReferencia='" + areaDeReferencia + '\'' +
                ", lugarFisico=" + lugarFisico +
                ", fechaDadoDeBaja=" + fechaDadoDeBaja +
                ", motivoDadoDeBaja='" + motivoDadoDeBaja + '\'' +
                ", ubicacionFisicaDadoDeBaja='" + ubicacionFisicaDadoDeBaja + '\'' +
                ", fechaDeAdquisicion=" + fechaDeAdquisicion +
                ", formaDeAdquisicion='" + formaDeAdquisicion + '\'' +
                '}';
    }
}
