import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
}
