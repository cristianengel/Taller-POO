package MainClasses;

import Enum.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

/**
 * Clase para gestión de los préstamos.
 */
public class Prestamo {
    Biblioteca b = Biblioteca.getInstance();
    private TipoLectura tipoLectura; //Lectura en sala o a domicilio
    private LocalDateTime fechaHoraInicio;
    private String funcionario; //Quien prestó el ejemplar
    private int plazo;
    private LocalDateTime fechaHoraDevolucion;
    private Ejemplar ejemplar; //Relación con Ejemplar
    private Lector lector; //Relación con Lector

    /**
     * Constructor de la clase Prestamo
     * @param tipoLectura
     * @param fechaHoraInicio
     * @param funcionario
     * @param ejemplar
     * @param lector
     * @param desdeReserva
     * @throws RuntimeException
     */
    public Prestamo(TipoLectura tipoLectura, LocalDateTime fechaHoraInicio,
                    String funcionario, Ejemplar ejemplar, Lector lector,
                    boolean desdeReserva) throws RuntimeException {
        /* Si la fecha del inicio del prestamo es anterior a la fecha con multas -> No se realiza el préstamo */
        if (fechaHoraInicio.isBefore(fechaHoraInicio.plusDays(lector.getMultas())))
            throw new RuntimeException("El lector aún tiene multas.");
        this.tipoLectura = tipoLectura;
        this.fechaHoraInicio = fechaHoraInicio;
        this.funcionario = funcionario;
        this.plazo = 4; //Los plazos se efectúan por un plazo maximo de 4 días

        /* A la fecha de devolución se le agrega la fecha de inicio del préstamo más el plazo (días) */
        this.fechaHoraDevolucion = fechaHoraInicio.plusDays(plazo);
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.ejemplar.setCondicion(Condicion.PRESTADO);
        this.ejemplar.setPrestamo(this);
        b.getPrestamosEnCurso().add(this);
        if(!desdeReserva) {
            this.ejemplar.agregarSolicitud();
            this.ejemplar.setVecesSolicitado(this.ejemplar.getVecesSolicitado() + 1);
            this.ejemplar.getObra().agregarSolicitud(this.lector.getProfesion());
        }
    }

    /**
     * cambiarPlazoDelPrestamo cambia el plazo de una devolución
     * (extender o acorta el plazo)
     * @param dias
     */
    public void cambiarPlazoDelPrestamo(int dias) {
        if (this.tipoLectura == TipoLectura.DOMICILIO) {
            this.plazo = dias;
        }
    }

    /**
     * equals verifica si son objetos de tipo Prestamo son iguales.
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;
        return plazo == prestamo.plazo &&
                tipoLectura.equals(prestamo.tipoLectura) &&
                fechaHoraInicio.equals(prestamo.fechaHoraInicio) &&
                funcionario.equals(prestamo.funcionario) &&
                fechaHoraDevolucion.equals(prestamo.fechaHoraDevolucion) &&
                ejemplar.equals(prestamo.ejemplar) &&
                lector.equals(prestamo.lector);
    }

    /**
     * toString devuelve una cadena que representa la instancia de Prestamo.
     * @return
     */
    @Override
    public String toString() {
        return "-Prestamo:" + "\n" +
                "   -Tipo de lectura=" + tipoLectura + "\n" +
                "   -Fecha y hora de inicio del préstamo=" + fechaHoraInicio + "\n" +
                "   -Funcionario que lo prestó=" + funcionario + "\n" +
                "   -Plazo=" + plazo + "\n" +
                "   -Fecha y hora de devolución=" + fechaHoraDevolucion + "\n" +
                "   -Ejemplar=" + ejemplar + "\n" +
                "   -Lector=" + lector;
    }

    /**
     * toStringReducido retorna un String con la información reducida de un préstamo.
     * @return
     */
    public String toStringReducido() {
        return "-Prestamo:" + "\n" +
                "   -Fecha y hora de devolución=" + fechaHoraDevolucion + "\n" +
                "   -Ejemplar=" + ejemplar + "\n" +
                "   -Lector=" + lector;
    }
}
