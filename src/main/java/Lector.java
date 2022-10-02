import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Lector {
    String nombre;
    String apellido;
    String tipoDoc;
    int numDoc;
    String correoElec;
    int numCel;
    LocalDate fechaNac;
    String sexo;
    String nacionalidad;
    String domicilio;
    int codigoPostal;
    String departamento;
    String localidad;

    public Lector() {
    }

    public Lector(String nombre, String apellido, String tipoDoc, int numDoc, String correoElec, int numCel, LocalDate fechaNac, String sexo, String nacionalidad, String domicilio, int codigoPostal, String departamento, String localidad) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return numDoc == lector.numDoc && numCel == lector.numCel && codigoPostal == lector.codigoPostal && nombre.equals(lector.nombre) && apellido.equals(lector.apellido) && tipoDoc.equals(lector.tipoDoc) && correoElec.equals(lector.correoElec) && fechaNac.equals(lector.fechaNac) && sexo.equals(lector.sexo) && nacionalidad.equals(lector.nacionalidad) && domicilio.equals(lector.domicilio) && departamento.equals(lector.departamento) && localidad.equals(lector.localidad);
    }

    public String toString() {
        return "Lector{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tipoDoc='" + tipoDoc + '\'' +
                ", numDoc=" + numDoc +
                ", correoElec='" + correoElec + '\'' +
                ", numCel=" + numCel +
                ", fechaNac=" + fechaNac +
                ", sexo='" + sexo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", departamento='" + departamento + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
