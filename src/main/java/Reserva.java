import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Reserva {
    LocalDateTime fechaHoraInicio;
    LocalDateTime fechaHoraFin;

    public Reserva() {
    }

    public Reserva(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(fechaHoraInicio, reserva.fechaHoraInicio) && Objects.equals(fechaHoraFin, reserva.fechaHoraFin);
    }

}
