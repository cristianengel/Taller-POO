package MainClasses;

import Enum.Profesion;
import Enum.Sexo;
import Enum.TipoDocumento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Alumno propone un tipo de lector.
 */
public class Alumno extends Lector{
    private ArrayList<String> carreras = new ArrayList<>();
    /**
     * Constructor de la clase Alumno.
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
    public Alumno(String nombre, String apellido, TipoDocumento tipoDoc, int numDoc,
                  String correoElec, String numCel, LocalDate fechaNac, Sexo sexo,
                  String nacionalidad, String domicilio, int codigoPostal,
                  String departamento, String localidad) {
        super(nombre, apellido, tipoDoc, numDoc, correoElec, numCel, fechaNac, sexo,
                nacionalidad, domicilio, codigoPostal, departamento, localidad, Profesion.ALUMNO);
    }

    /**
     * mostrarCarreras muestra las carreras que cursa el objeto de tipo Alumno.
     * @return carreras
     * @throws RuntimeException
     */
    public List<String> mostrarCarreras() throws RuntimeException{
        if(carreras.size() > 0){
            return carreras;
        } else {
            throw new RuntimeException("Este alumno no tiene ninguna carrera registrada.");
        }
    }

    /**
     * agregarCarrera agrega a la lista de carreras la carrera pasada por parámetro.
     * @param carrera
     * @throws RuntimeException
     */
    public void agregarCarrera(String carrera) throws RuntimeException {
        if(!carreras.contains(carrera)){
            carreras.add(carrera);
        } else {
            throw new RuntimeException("Ya existe una carrera con el mismo nombre");
        }
    }

    /**
     * removerCarrera elimina de la lista de carreras la carrera pasada por parámtro.
     * @param carrera
     * @throws RuntimeException
     */
    public void removerCarrera(String carrera) throws RuntimeException{
        if(carreras.contains(carrera)){
            carreras.remove(carrera);
        } else {
            throw new RuntimeException("No existe una carrera con el nombre especificado.");
        }
    }
}
