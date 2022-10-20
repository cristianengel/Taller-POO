package MainClasses;

import java.time.LocalDate;
import Enum.*;

/**
 * La clase Publico propone un tipo de lector
 */
public class Publico extends Lector{
    public Publico(String nombre, String apellido, String tipoDoc, int numDoc,
                   String correoElec, String numCel, LocalDate fechaNac, Sexo sexo,
                   String nacionalidad, String domicilio, int codigoPostal,
                   String departamento, String localidad) {
        super(nombre, apellido, tipoDoc, numDoc, correoElec, numCel, fechaNac, sexo,
                nacionalidad, domicilio, codigoPostal, departamento, localidad, Profesion.PUBLICO);
    }

}
