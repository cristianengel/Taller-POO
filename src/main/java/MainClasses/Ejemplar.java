package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
public class Ejemplar {
    private String identUnico;
    private int codBarra;
    private String observaciones;
    private ArrayList<String> lugarFisico; // Pasillo, Estantería, Estante

    private LocalDate fechaDadoDeBaja;
    private String motivoDadoDeBaja;
    private ArrayList<String> ubicacionFisicaDadoDeBaja = new ArrayList<>();

    private LocalDate fechaDeAdquisicion;
    private String formaDeAdquisicion;
    private Obra obra; //Relación con la clase Obra
    private Edicion edicion;

    private Reserva reserva; //Relación con las clases Reserva y Lector
    private Prestamo prestamo; //Relación con las clases Prestamo y Lector

    public Ejemplar(String identUnico, int codBarra, String observaciones, ArrayList<String> lugarFisico, LocalDate fechaDeAdquisicion, String formaDeAdquisicion, Obra obra) {
        this.identUnico = identUnico;
        this.codBarra = codBarra;
        this.lugarFisico = lugarFisico;
        this.observaciones = observaciones;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.formaDeAdquisicion = formaDeAdquisicion;
        this.obra = obra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ejemplar ejemplar)) return false;
        return codBarra == ejemplar.codBarra && Objects.equals(identUnico, ejemplar.identUnico) && Objects.equals(observaciones, ejemplar.observaciones) &&  Objects.equals(fechaDadoDeBaja, ejemplar.fechaDadoDeBaja) && Objects.equals(motivoDadoDeBaja, ejemplar.motivoDadoDeBaja) && Objects.equals(ubicacionFisicaDadoDeBaja, ejemplar.ubicacionFisicaDadoDeBaja) && Objects.equals(fechaDeAdquisicion, ejemplar.fechaDeAdquisicion) && Objects.equals(formaDeAdquisicion, ejemplar.formaDeAdquisicion) && Objects.equals(obra, ejemplar.obra) && Objects.equals(reserva, ejemplar.reserva) && Objects.equals(prestamo, ejemplar.prestamo);
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "Identificador único='" + identUnico + '\'' +
                ", Código de barra=" + codBarra +
                ", Observaciones='" + observaciones + '\'' +
                ", Fecha de dado de baja=" + fechaDadoDeBaja +
                ", Motivo de dado de baja='" + motivoDadoDeBaja + '\'' +
                ", Ubicación física de dado de baja='" + ubicacionFisicaDadoDeBaja + '\'' +
                ", Fecha de adquisición=" + fechaDeAdquisicion + '\'' +
                ", Forma de adquisición='" + formaDeAdquisicion + '\'' +
                ", Obra=" + obra +
                '}';
    }

    public String stringSimplificado() {
        return "ID: " + identUnico + "  ||  " + "Título: " + obra.getTitulo();
    }
}
