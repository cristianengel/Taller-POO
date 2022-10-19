package MainClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;

public class Devolucion {
    private LocalDateTime fechaHoraDevolucion; //Fecha y hora en que el ejemplar es devuelto
    private String funcionario; //Quien recibe el ejemplar
    private Prestamo prestamo; //Relación con la clase Prestamo
    private Lector lector; //Relación con la clase Lector
    private Ejemplar ejemplar; //Relación con la clase Ejemplar
    private int diasAtrasados = 0;

    public Devolucion(LocalDateTime fechaHoraDevolucion, Ejemplar ejemplar, Lector lector, String funcionario) {
        this.fechaHoraDevolucion = fechaHoraDevolucion;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.funcionario = funcionario;
        this.diasAtrasados = controlFechaDevolucion();
    }

    /**
     *
     * @return dias
     */

    public int controlFechaDevolucion() {
        //Si la fecha y hora a la que se devuelve el ejemplar es posterior a la hora y fecha que tenía que devolverse da true
        if (this.fechaHoraDevolucion.isAfter(prestamo.getFechaHoraDevolucion())) { //Esto aún no funciona
            LocalDate f1 = this.fechaHoraDevolucion.toLocalDate();
            LocalDate f2 = prestamo.getFechaHoraDevolucion().toLocalDate();
            return (int) DAYS.between(f1, f2);
        }
        return 0;
    }

    /**
     *
     * @param multa
     */
    public void aplicarMulta(int multa) {
        this.lector.setMultas(multa);
    }

    @Override
    public String toString() {
        return "🔹Devolucion:" + "\n" +
                "   -Fecha de la devolución=" + fechaHoraDevolucion + "\n" +
                "   -Funcionario=" + funcionario + "\n" +
                "   -Préstamo=" + prestamo + "\n" +
                "   -Lector=" + lector + "\n" +
                "   -Ejemplar=" + ejemplar + "\n" +
                "   -Días atrasados=" + diasAtrasados;
    }
}
