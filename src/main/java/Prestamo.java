import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Prestamo {
    String tipoLectura;
    LocalDateTime fechaHoraInicio;
    String funcionario;
    int plazo;
    LocalDateTime fechaHoraDevolucion;
    int multa;

    public Prestamo() {
    }

    public Prestamo(String tipoLectura, LocalDateTime fechaHoraInicio, String funcionario, int plazo, LocalDateTime fechaHoraDevolucion, int multa) {
        this.tipoLectura = tipoLectura;
        this.fechaHoraInicio = fechaHoraInicio;
        this.funcionario = funcionario;
        this.plazo = plazo;
        this.fechaHoraDevolucion = fechaHoraDevolucion;
        this.multa = multa;
    }

    public void aplicarMulta() {
        // TODO: 9/26/22
    }
}
