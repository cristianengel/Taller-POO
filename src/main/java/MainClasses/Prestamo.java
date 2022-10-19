package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Prestamo {
    private String tipoLectura; //Lectura en sala o a domicilio
    private LocalDateTime fechaHoraInicio;
    private String funcionario; //Quien prestó el ejemplar
    private int plazo;
    private LocalDateTime fechaHoraDevolucion;
    private Ejemplar ejemplar; //Relación con Ejemplar
    private Lector lector; //Relación con Lector

    public Prestamo(String tipoLectura, LocalDateTime fechaHoraInicio, String funcionario, Ejemplar ejemplar, Lector lector) {
        this.tipoLectura = tipoLectura;
        this.fechaHoraInicio = fechaHoraInicio;
        this.funcionario = funcionario;
        this.plazo = 4; //Los plazos se efectúan por un plazo maximo de 4 días
        this.fechaHoraDevolucion = fechaHoraInicio.plusDays(plazo); //A la fecha de devolución se le agrega la fecha de inicio del préstamo más el plazo (días)
        this.ejemplar = ejemplar;
        this.lector = lector;
    }

    /**
     * Método con el cuál podemos cambiar el plazo de devolución (extender o acorta el plazo)
     *
     * @param dias
     */
    public void cambiarPlazoDelPrestamo(int dias) {
        if (this.tipoLectura == "Para domicilio") {
            this.plazo = dias;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;
        return plazo == prestamo.plazo &&  tipoLectura.equals(prestamo.tipoLectura) && fechaHoraInicio.equals(prestamo.fechaHoraInicio) && funcionario.equals(prestamo.funcionario) && fechaHoraDevolucion.equals(prestamo.fechaHoraDevolucion) && ejemplar.equals(prestamo.ejemplar) && lector.equals(prestamo.lector);
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "Tipo de lectura='" + tipoLectura + '\'' +
                ", Fecha y hora de inicio del préstamo=" + fechaHoraInicio +
                ", Funcionario que lo presó='" + funcionario + '\'' +
                ", Plazo=" + plazo +
                ", Fecha y hora de devolución=" + fechaHoraDevolucion +
                ", Ejemplar=" + ejemplar +
                ", Lector=" + lector +
                '}';
    }
}
