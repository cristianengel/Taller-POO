package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter

/**
 * La clase Reserva ofrece lo necesario para realizar las reservas
 * de los ejemplares.
 */
public class Reserva {
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Ejemplar ejemplar; //Relación intermedia entre Lector y Ejemplar
    private Lector lector; //Relación intermedia entre Lector y Ejemplar

    /**
     * Constructor de la clase Reserva.
     * @param fechaHoraInicio
     * @param fechaHoraFin
     * @param ejemplar
     * @param lector
     */
    public Reserva(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Ejemplar ejemplar, Lector lector) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.ejemplar = ejemplar;
        this.lector = lector;

        this.ejemplar.getObra().agregarSolicitud(this.lector.getProfesion());
    }

    /**
     * equals verifica si son objetos de tipo Reserva son iguales.
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(fechaHoraInicio, reserva.fechaHoraInicio) &&
                Objects.equals(fechaHoraFin, reserva.fechaHoraFin) &&
                Objects.equals(ejemplar, reserva.ejemplar) &&
                Objects.equals(lector, reserva.lector);
    }

    @Override
    public String toString() {
        return "-Reserva: " + "\n" +
                "   -Fecha y hora del inicio de la reserva=" + fechaHoraInicio + "\n" +
                "   -Fecha y hora del fin de la reserva=" + fechaHoraFin + "\n" +
                "   -Ejemplar=" + ejemplar + "\n" +
                "   -Lector=" + lector;
    }
}
