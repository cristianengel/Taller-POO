package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Lector {
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private int numDoc;
    private String correoElec;
    private String numCel;
    private LocalDate fechaNac;
    private String sexo;
    private String nacionalidad;
    private String domicilio;
    private int codigoPostal;
    private String departamento;
    private String localidad;
    private Reserva ejemplarReserva; //Relación con las clases Reserva y Ejemplar
    private Prestamo ejemplarPrestamo; //Relación con las clases Prestamo y Ejemplar
    private int multas;

    public Lector(String nombre, String apellido, String tipoDoc, int numDoc, String correoElec, String numCel, LocalDate fechaNac, String sexo, String nacionalidad, String domicilio, int codigoPostal, String departamento, String localidad) {
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
    }

    public void setMultas(int multas) {
        this.multas += multas;
    }

    public void puedeReservarOLevantar(LocalDateTime fecha) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lector lector)) return false;
        return numDoc == lector.numDoc && numCel == lector.numCel && codigoPostal == lector.codigoPostal && Objects.equals(nombre, lector.nombre) && Objects.equals(apellido, lector.apellido) && Objects.equals(tipoDoc, lector.tipoDoc) && Objects.equals(correoElec, lector.correoElec) && Objects.equals(fechaNac, lector.fechaNac) && Objects.equals(sexo, lector.sexo) && Objects.equals(nacionalidad, lector.nacionalidad) && Objects.equals(domicilio, lector.domicilio) && Objects.equals(departamento, lector.departamento) && Objects.equals(localidad, lector.localidad) && Objects.equals(ejemplarReserva, lector.ejemplarReserva) && Objects.equals(ejemplarPrestamo, lector.ejemplarPrestamo);
    }

    @Override
    public String toString() {
        return "Lector{" +
                "Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Tipo de documento='" + tipoDoc + '\'' +
                ", Número de documento=" + numDoc +
                ", Correo electrónico='" + correoElec + '\'' +
                ", Número de celular=" + numCel +
                ", Fecha de nacimiento=" + fechaNac +
                ", Sexo='" + sexo + '\'' +
                ", Nacionalidad='" + nacionalidad + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                ", Código postal=" + codigoPostal +
                ", Departamento='" + departamento + '\'' +
                ", Localidad='" + localidad + '\'' +
                ", Reserva=" + ejemplarReserva + '\'' +
                ", Prestamo=" + ejemplarPrestamo + '\'' +
                ", Cantidad de multas=" + multas +
                '}';
    }
}
