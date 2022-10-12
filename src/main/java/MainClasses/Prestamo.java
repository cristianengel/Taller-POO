package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Prestamo {
    private String tipoLectura;
    private LocalDateTime fechaHoraInicio;
    private String funcionario;
    private int plazo;
    private LocalDateTime fechaHoraDevolucion;
    private int multa;
    private Ejemplar ejemplar; //Relación intermedia entre Ejemplar y Lector
    private Lector lector; //Relación intermedia entre Ejemplar y Lector

    public Prestamo(String tipoLectura, LocalDateTime fechaHoraInicio, String funcionario, int plazo, LocalDateTime fechaHoraDevolucion, int multa, Ejemplar ejemplar, Lector lector) {
        this.tipoLectura = tipoLectura;
        this.fechaHoraInicio = fechaHoraInicio;
        this.funcionario = funcionario;
        this.plazo = plazo;
        this.fechaHoraDevolucion = fechaHoraDevolucion;
        this.multa = multa;
        this.ejemplar = ejemplar;
        this.lector = lector;
    }

    public void aplicarMulta() {
        // TODO: 9/26/22
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;
        return plazo == prestamo.plazo && multa == prestamo.multa && tipoLectura.equals(prestamo.tipoLectura) && fechaHoraInicio.equals(prestamo.fechaHoraInicio) && funcionario.equals(prestamo.funcionario) && fechaHoraDevolucion.equals(prestamo.fechaHoraDevolucion) && ejemplar.equals(prestamo.ejemplar) && lector.equals(prestamo.lector);
    }

    @Override
    public String toString() {
        return "MainClasses.Prestamo{" +
                "Tipo de lectura='" + tipoLectura + '\'' +
                ", Fecha y hora de inicio del préstamo=" + fechaHoraInicio +
                ", Funcionario='" + funcionario + '\'' +
                ", Plazo=" + plazo +
                ", Fecha y hora de devolución=" + fechaHoraDevolucion +
                ", Multa=" + multa +
                ", MainClasses.Ejemplar=" + ejemplar +
                ", MainClasses.Lector=" + lector +
                '}';
    }
}
