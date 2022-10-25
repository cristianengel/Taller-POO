package MainClasses;

import lombok.Getter;
import lombok.Setter;

import Enum.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;

@Getter
@Setter

/**
 * La clase Devolucion propone la acción de devolución de un ejemplar
 * y lo que conlleva
 */
public class Devolucion {
    Biblioteca b = Biblioteca.getInstance();
    private LocalDateTime fechaHoraDevolucion; //Fecha y hora en que el ejemplar es devuelto
    private String funcionario; //Bibliotecario que recibe el ejemplar
    private Prestamo prestamo; //Relación con la clase Prestamo
    private Lector lector; //Relación con la clase Lector
    private Ejemplar ejemplar; //Relación con la clase Ejemplar
    private int diasAtrasados = 0;

    /**
     * Constructor de la clase Devolucion, incluye la aplicación de la multa al lector en caso
     * de que entregue un ejemplar fuera de término.
     * @param fechaHoraDevolucion
     * @param ejemplar
     * @param lector
     * @param funcionario
     * @param prestamo
     */
    public Devolucion(LocalDateTime fechaHoraDevolucion, Ejemplar ejemplar, Lector lector,
                      String funcionario, Prestamo prestamo) {
        this.fechaHoraDevolucion = fechaHoraDevolucion;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.funcionario = funcionario;
        this.prestamo = prestamo;
        this.diasAtrasados = controlFechaDevolucion();
        if(this.diasAtrasados > 0){
            aplicarMulta(this.diasAtrasados);
        }
        this.ejemplar.setCondicion(Condicion.DISPONIBLE);
        this.ejemplar.setPrestamo(null);
        b.getPrestamosEnCurso().remove(this.prestamo);
    }

    /**
     * controlFechaDevolucion retorna los dias que se atrasó el lector en devolver un ejemplar.
     * Retorna 0 si lo entregó dentro del plazo.
     * @return dias
     */
    public int controlFechaDevolucion() {
        /* Si la fecha y hora a la que se devuelve el ejemplar es posterior
        a la hora y fecha que tenía que devolverse... */
        if (this.fechaHoraDevolucion.isAfter(this.prestamo.getFechaHoraDevolucion())) {
            LocalDate f1 = this.fechaHoraDevolucion.toLocalDate();
            LocalDate f2 = prestamo.getFechaHoraDevolucion().toLocalDate();
            return (int) DAYS.between(f2, f1);
        }
        return 0;
    }

    /**
     * aplicarMulta aplica la multa al lector y al lector lo agrega a la lista
     * de lectores con multa.
     * @param multa
     */
    public void aplicarMulta(int multa) {
        this.lector.setMultas(multa);
        b.agregarLectorConMultas(this.lector);
    }

    /**
     * toString devuelve una cadena que representa la instancia de Devolucion.
     * @return
     */
    @Override
    public String toString() {
        return "-Devolucion:" + "\n" +
                "   -Fecha de la devolución=" + fechaHoraDevolucion + "\n" +
                "   -Funcionario=" + funcionario + "\n" +
                "   -Préstamo=" + prestamo + "\n" +
                "   -Lector=" + lector + "\n" +
                "   -Ejemplar=" + ejemplar + "\n" +
                "   -Días atrasados=" + diasAtrasados;
    }

    /**
     * toStringReducido retorna un String con la información reducida de una devolución.
     * @return
     */
    public String toStringReducido() {
        return "-Devolucion:" + "\n" +
                "   -Fecha de la devolución=" + fechaHoraDevolucion + "\n" +
                "   -Funcionario=" + funcionario + "\n" +
                "   -Lector=" + lector + "\n" +
                "   -Ejemplar=" + ejemplar + "\n";
    }
}
