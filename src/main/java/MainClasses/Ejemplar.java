package MainClasses;

import Enum.Condicion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter

/**
 * La clase Ejemplar ofrece la información requerida para realizar
 * las operaciones con los ejemplares.
 */
public class Ejemplar {
    private String identUnico;
    private String observaciones;
    private ArrayList<String> lugarFisico; // Ubicación (Pasillo, Estantería, Estante)
    private LocalDate fechaDadoDeBaja;
    private String motivoDadoDeBaja;
    private ArrayList<String> ubicacionFisicaDadoDeBaja = new ArrayList<>();
    private LocalDate fechaDeAdquisicion;
    private String formaDeAdquisicion;
    private Obra obra; //Relación con la clase Obra
    private Reserva reserva; //Relación con las clases Reserva
    private Prestamo prestamo; //Relación con las clases Prestamo
    private Condicion condicion; //Condición del ejemplar (Disponible / Prestado / Reservado)
    private int vecesSolicitado = 0;

    /**
     * Constructor de la clase Ejemplar.
     * @param identUnico
     * @param observaciones
     * @param lugarFisico
     * @param fechaDeAdquisicion
     * @param formaDeAdquisicion
     * @param obra
     */
    public Ejemplar(String identUnico, String observaciones,
                    ArrayList<String> lugarFisico, LocalDate fechaDeAdquisicion,
                    String formaDeAdquisicion, Obra obra) {
        this.identUnico = identUnico;
        this.lugarFisico = lugarFisico;
        this.observaciones = observaciones;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.formaDeAdquisicion = formaDeAdquisicion;
        this.obra = obra;
        this.condicion = Condicion.DISPONIBLE;
    }

    /**
     * agregarSolicitud agrega al contador de vecesSolicitado las veces
     * que se solicitó un ejemplar.
     */
    public void agregarSolicitud() {
        this.vecesSolicitado += 1;
    }

    /**
     * equals verifica si son objetos de tipo Ejemplar son iguales.
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ejemplar ejemplar)) return false;
        return Objects.equals(identUnico, ejemplar.identUnico) &&
                Objects.equals(observaciones, ejemplar.observaciones) &&
                Objects.equals(fechaDadoDeBaja, ejemplar.fechaDadoDeBaja) &&
                Objects.equals(motivoDadoDeBaja, ejemplar.motivoDadoDeBaja) &&
                Objects.equals(ubicacionFisicaDadoDeBaja, ejemplar.ubicacionFisicaDadoDeBaja) &&
                Objects.equals(fechaDeAdquisicion, ejemplar.fechaDeAdquisicion) &&
                Objects.equals(formaDeAdquisicion, ejemplar.formaDeAdquisicion) &&
                Objects.equals(obra, ejemplar.obra) &&
                Objects.equals(reserva, ejemplar.reserva) &&
                Objects.equals(prestamo, ejemplar.prestamo) &&
                Objects.equals(condicion, ejemplar.condicion);
    }

    /**
     * toStringReducido retorna un String con la información reducida de un ejemplar.
     * @return string
     */
    public String toStringReducido() {
        return "ID: " + identUnico + "  ||  " + "Título: " + obra.getTitulo();
    }

    /**
     * toString devuelve una cadena que representa la instancia de Ejemplar.
     * @return
     */
    @Override
    public String toString() {
        return "-Ejemplar: " + "\n" +
                "   -Identificador único=" + identUnico + "\n " + obra + "\n" +
                "   -Observaciones=" + observaciones + "\n" +
                "   -Ubicación física de dado de baja=" + ubicacionFisicaDadoDeBaja + "\n" +
                "   -Fecha de adquisición=" + fechaDeAdquisicion + "\n" +
                "   -Fecha de dado de baja=" + fechaDadoDeBaja + "\n" +
                "   -Motivo de dado de baja=" + motivoDadoDeBaja + "\n" +
                "   -Forma de adquisición=" + formaDeAdquisicion;
    }
}
