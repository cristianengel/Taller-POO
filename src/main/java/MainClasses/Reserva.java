package MainClasses;

import Enum.Condicion;
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
    private Ejemplar ejemplar; //Relación con la clase Ejemplar
    private Lector lector; //Relación con la clase Lector
    private Biblioteca biblioteca = Biblioteca.getInstance();


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

        this.biblioteca.registrarReserva(this);
        this.ejemplar.setCondicion(Condicion.RESERVADO);

        this.ejemplar.agregarSolicitud();
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

    /**
     * toString devuelve una cadena que representa la instancia de Reserva.
     * @return
     */
    @Override
    public String toString() {
        return "-Reserva: " + "\n" +
                "   -Fecha y hora del inicio de la reserva=" + fechaHoraInicio + "\n" +
                "   -Fecha y hora del fin de la reserva=" + fechaHoraFin + "\n" +
                "   -Ejemplar=" + ejemplar + "\n" +
                "   -Lector=" + lector;
    }
}
