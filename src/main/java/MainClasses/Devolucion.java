package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Devolucion {
    private LocalDateTime fechaHoraDevolucion; //Fecha y hora en que el ejemplar es devuelto
    private String funcionario; //Quien recibe el ejemplar
    private Prestamo prestamo; //Relación con la clase Prestamo
    private Lector lector; //Relación con la clase Lector

    public Devolucion(LocalDateTime fechaHoraDevolucion, String funcionario) {
        this.fechaHoraDevolucion = fechaHoraDevolucion;
        this.funcionario = funcionario;
    }

    public boolean controlFechaDevolucion() {
        //Si la fecha y hora a la que se devuelve el ejemplar es posterior a la hora y fecha que tenía que devolverse
        return this.fechaHoraDevolucion.isAfter(prestamo.getFechaHoraDevolucion());
    }

    /**
     *
     * @param multa
     */
    public void aplicarMulta(int multa) {
        if (controlFechaDevolucion() == true) {
            this.lector.setMultas(multa);
        }
    }
}
