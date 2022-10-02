import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;
        return plazo == prestamo.plazo && multa == prestamo.multa && Objects.equals(tipoLectura, prestamo.tipoLectura) && Objects.equals(fechaHoraInicio, prestamo.fechaHoraInicio) && Objects.equals(funcionario, prestamo.funcionario) && Objects.equals(fechaHoraDevolucion, prestamo.fechaHoraDevolucion);
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "tipoLectura='" + tipoLectura + '\'' +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", funcionario='" + funcionario + '\'' +
                ", plazo=" + plazo +
                ", fechaHoraDevolucion=" + fechaHoraDevolucion +
                ", multa=" + multa +
                '}';
    }
}
