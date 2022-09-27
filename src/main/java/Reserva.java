import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
}
