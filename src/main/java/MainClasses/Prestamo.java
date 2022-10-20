package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import Enum.TipoLectura;

/**
 * Creación de los getters y setters mediante la importaación de lombok
 */
@Getter
@Setter
public class Prestamo {
    private TipoLectura tipoLectura; //Lectura en sala o a domicilio
    private LocalDateTime fechaHoraInicio;
    private String funcionario; //Quien prestó el ejemplar
    private int plazo;
    private LocalDateTime fechaHoraDevolucion;
    private Ejemplar ejemplar; //Relación con Ejemplar
    private Lector lector; //Relación con Lector

    public Prestamo(TipoLectura tipoLectura, LocalDateTime fechaHoraInicio, String funcionario, Ejemplar ejemplar, Lector lector) throws RuntimeException {
        //Si la fecha del inicio del prestamo anterior a la fecha con multas -> No se realiza el préstamo
        if (fechaHoraInicio.isBefore(fechaHoraInicio.plusDays(lector.getMultas()))) throw new RuntimeException("El lector aún tiene multas.");
        this.tipoLectura = tipoLectura;
        this.fechaHoraInicio = fechaHoraInicio;
        this.funcionario = funcionario;
        this.plazo = 4; //Los plazos se efectúan por un plazo maximo de 4 días
        this.fechaHoraDevolucion = fechaHoraInicio.plusDays(plazo); //A la fecha de devolución se le agrega la fecha de inicio del préstamo más el plazo (días)
        this.ejemplar = ejemplar;
        this.lector = lector;

        this.ejemplar.agregarSolicitud();
        contadorEjemplarSolicitado(ejemplar);
    }

    /**
     * Método con el cuál podemos cambiar el plazo de devolución (extender o acorta el plazo)
     * @param dias
     */
    public void cambiarPlazoDelPrestamo(int dias) {
        if (this.tipoLectura == TipoLectura.DOMICILIO) {
            this.plazo = dias;
        }
    }

    /**
     *
     * @param ejemplar
     */
    public void contadorEjemplarSolicitado(Ejemplar ejemplar) {
        // TODO: 10/20/22
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;
        return plazo == prestamo.plazo &&  tipoLectura.equals(prestamo.tipoLectura) && fechaHoraInicio.equals(prestamo.fechaHoraInicio) && funcionario.equals(prestamo.funcionario) && fechaHoraDevolucion.equals(prestamo.fechaHoraDevolucion) && ejemplar.equals(prestamo.ejemplar) && lector.equals(prestamo.lector);
    }

    @Override
    public String toString() {
        return "-Prestamo:" + "\n" +
                "   -Tipo de lectura=" + tipoLectura + "\n" +
                "   -Fecha y hora de inicio del préstamo=" + fechaHoraInicio + "\n" +
                "   -Funcionario que lo presó=" + funcionario + "\n" +
                "   -Plazo=" + plazo + "\n" +
                "   -Fecha y hora de devolución=" + fechaHoraDevolucion + "\n" +
                "   -Ejemplar=" + ejemplar + "\n" +
                "   -Lector=" + lector;
    }
}
