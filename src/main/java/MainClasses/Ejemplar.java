package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import Enum.Condicion;

@Getter
@Setter

/**
 * La clase Ejemplar ofrece la información requerida para realizar
 * las operaciones con los ejemplares
 */
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
    private Condicion condicion; // Condición del ejemplar (Disponible / Prestado / Reservado)
    private int vecesSolicitado = 0;

    public Ejemplar(String identUnico, int codBarra, String observaciones,
                    ArrayList<String> lugarFisico, LocalDate fechaDeAdquisicion,
                    String formaDeAdquisicion, Obra obra) {
        this.identUnico = identUnico;
        this.codBarra = codBarra;
        this.lugarFisico = lugarFisico;
        this.observaciones = observaciones;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.formaDeAdquisicion = formaDeAdquisicion;
        this.obra = obra;
        this.condicion = Condicion.DISPONIBLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ejemplar ejemplar)) return false;
        return codBarra == ejemplar.codBarra &&
                Objects.equals(identUnico, ejemplar.identUnico) &&
                Objects.equals(observaciones, ejemplar.observaciones) &&
                Objects.equals(fechaDadoDeBaja, ejemplar.fechaDadoDeBaja) &&
                Objects.equals(motivoDadoDeBaja, ejemplar.motivoDadoDeBaja) &&
                Objects.equals(ubicacionFisicaDadoDeBaja, ejemplar.ubicacionFisicaDadoDeBaja) &&
                Objects.equals(fechaDeAdquisicion, ejemplar.fechaDeAdquisicion) &&
                Objects.equals(formaDeAdquisicion, ejemplar.formaDeAdquisicion) &&
                Objects.equals(obra, ejemplar.obra) &&
                Objects.equals(reserva, ejemplar.reserva) &&
                Objects.equals(prestamo, ejemplar.prestamo);
    }

    /**
     * Agrega al contador de veces solicitado
     */
    public void agregarSolicitud() {
        this.vecesSolicitado += 1;
    }

    @Override
    public String toString() {
        return "-Ejemplar: " + "\n" +
                "   -Identificador único=" + identUnico + "\n" +
                "   -Código de barra=" + codBarra + "\n" +
                "   -Observaciones=" + observaciones + "\n" +
                "   -Ubicación física de dado de baja=" + ubicacionFisicaDadoDeBaja + "\n" +
                "   -Fecha de adquisición=" + fechaDeAdquisicion + "\n" +
                "   -Fecha de dado de baja=" + fechaDadoDeBaja + "\n" +
                "   -Motivo de dado de baja=" + motivoDadoDeBaja + "\n" +
                "   -Forma de adquisición=" + formaDeAdquisicion + "\n" + obra;
    }

    public String stringSimplificado() {
        return "ID: " + identUnico + "  ||  " + "Título: " + obra.getTitulo();
    }
}
