package MainClasses;

import Enum.Profesion;
import Enum.Sexo;
import Enum.TipoDocumento;

import java.time.LocalDate;

/**
 * La clase Publico propone un tipo de lector.
 */
public class Publico extends Lector{
    /**
     * Constructor de la clase Publico.
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
     */
    public Publico(String nombre, String apellido, TipoDocumento tipoDoc, int numDoc,
                   String correoElec, String numCel, LocalDate fechaNac, Sexo sexo,
                   String nacionalidad, String domicilio, int codigoPostal,
                   String departamento, String localidad) {
        super(nombre, apellido, tipoDoc, numDoc, correoElec, numCel, fechaNac, sexo,
                nacionalidad, domicilio, codigoPostal, departamento, localidad, Profesion.PUBLICO);
    }

}
