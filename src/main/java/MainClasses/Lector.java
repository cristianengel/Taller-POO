package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import Enum.*;

@Getter
@Setter

/**
 * La clase Lector expone toda la información necesaria de los lectores
 * que solicitan un préstamo de un ejemplar.
 */
public class Lector {
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private int numDoc;
    private String correoElec;
    private String numCel;
    private LocalDate fechaNac;
    private Sexo sexo;
    private String nacionalidad;
    private String domicilio;
    private int codigoPostal;
    private String departamento;
    private String localidad;
    private Reserva ejemplarReserva; //Relación con las clases Reserva y Ejemplar
    private Prestamo ejemplarPrestamo; //Relación con las clases Prestamo y Ejemplar
    private int multas;
    private Profesion profesion;

    /**
     * Constructor de la clase Lector.
     * @param nombre
     * @param apellido
     * @param tipoDoc
     * @param numDoc
     * @param correoElec
     * @param numCel
     * @param fechaNac
     * @param sexo
     * @param nacionalidad
     * @param domicilio
     * @param codigoPostal
     * @param departamento
     * @param localidad
     * @param profesion
     */
    public Lector(String nombre, String apellido, String tipoDoc, int numDoc,
                  String correoElec, String numCel, LocalDate fechaNac, Sexo sexo,
                  String nacionalidad, String domicilio, int codigoPostal,
                  String departamento, String localidad, Profesion profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.correoElec = correoElec;
        this.numCel = numCel;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.codigoPostal = codigoPostal;
        this.departamento = departamento;
        this.localidad = localidad;
        this.profesion = profesion;
    }

    /**
     * setMultas hace que al atributo multas se le suma la cantidad de
     * días que no puede reservar o levantar un ejemplar el objeto de tipo Lector.
     * @param dias
     */
    public void setMultas(int dias) {
        this.multas += dias;
    }

    /**
     * equals que devuelve un true o false si dos objetos de tipo Lector son iguales.
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lector lector)) return false;
        return numDoc == lector.numDoc && numCel == lector.numCel &&
                codigoPostal == lector.codigoPostal &&
                Objects.equals(nombre, lector.nombre) &&
                Objects.equals(apellido, lector.apellido) &&
                Objects.equals(tipoDoc, lector.tipoDoc) &&
                Objects.equals(correoElec, lector.correoElec) &&
                Objects.equals(fechaNac, lector.fechaNac) &&
                Objects.equals(sexo, lector.sexo) &&
                Objects.equals(nacionalidad, lector.nacionalidad) &&
                Objects.equals(domicilio, lector.domicilio) &&
                Objects.equals(departamento, lector.departamento) &&
                Objects.equals(localidad, lector.localidad) &&
                Objects.equals(ejemplarReserva, lector.ejemplarReserva) &&
                Objects.equals(ejemplarPrestamo, lector.ejemplarPrestamo);
    }

    /**
     * toString devuelve una cadena que representa la instancia de Lector.
     * @return
     */
    @Override
    public String toString() {
        return "-Lector:" + "\n" +
                "   -Nombre=" + nombre + "\n" +
                "   -Apellido=" + apellido + "\n" +
                "   -Tipo de documento=" + tipoDoc + "\n" +
                "   -Número de documento=" + numDoc + "\n" +
                "   -Correo electrónico=" + correoElec + "\n" +
                "   -Número de celular=" + numCel + "\n" +
                "   -Fecha de nacimiento=" + fechaNac + "\n" +
                "   -Sexo=" + sexo + "\n" +
                "   -Nacionalidad=" + nacionalidad + "\n" +
                "   -Domicilio=" + domicilio + "\n" +
                "   -Código postal=" + codigoPostal + "\n" +
                "   -Departamento=" + departamento + "\n" +
                "   -Localidad=" + localidad + "\n" +
                "   -Reserva=" + ejemplarReserva + "\n" +
                "   -Prestamo=" + ejemplarPrestamo + "\n" +
                "   -Cantidad de multas=" + multas;
    }
}
