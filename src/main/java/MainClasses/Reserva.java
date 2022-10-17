package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Reserva {
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Ejemplar ejemplar; //Relación intermedia entre Lector y Ejemplar
    private Lector lector; //Relación intermedia entre Lector y Ejemplar

    public Reserva(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Ejemplar ejemplar, Lector lector) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.ejemplar = ejemplar;
        this.lector = lector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(fechaHoraInicio, reserva.fechaHoraInicio) && Objects.equals(fechaHoraFin, reserva.fechaHoraFin) && Objects.equals(ejemplar, reserva.ejemplar) && Objects.equals(lector, reserva.lector);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Fecha y hora del inicio de la reserva=" + fechaHoraInicio +
                ", Fecha y hora del fin de la reserva=" + fechaHoraFin +
                ", Ejemplar=" + ejemplar +
                ", Lector=" + lector +
                '}';
    }
}
