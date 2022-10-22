package MainClasses;

import Enum.Profesion;
import Enum.Sexo;
import Enum.TipoDocumento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Docente propone un tipo de lector.
 */
public class Docente extends Lector{
    private ArrayList<String> carreras = new ArrayList<>();
    private ArrayList<String> materias = new ArrayList<>();

    /**
     * Constructor de la clase Docente.
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
    public Docente(String nombre, String apellido, TipoDocumento tipoDoc, int numDoc,
                   String correoElec, String numCel, LocalDate fechaNac, Sexo sexo,
                   String nacionalidad, String domicilio, int codigoPostal,
                   String departamento, String localidad) {
        super(nombre, apellido, tipoDoc, numDoc, correoElec, numCel, fechaNac, sexo,
                nacionalidad, domicilio, codigoPostal, departamento, localidad, Profesion.DOCENTE);
    }

    /**
     * mostrarCarreras muestra las carreras en las que da clases el objeto de tipo docente.
     * @return carreras
     * @throws RuntimeException
     */
    public List<String> mostrarCarreras() throws RuntimeException{
        if(carreras.size() > 0){
            return carreras;
        } else {
            throw new RuntimeException("Este docente no tiene ninguna carrera registrada.");
        }
    }

    /**
     * agregarCarrera agrega la carrea pasada por parámetro a la lista de carreras.
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
     * removerCarrera elimina la carrera pasada por parámtro de la lista de carreras.
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

    /**
     * mostrarMaterias muestra las materias en la que el objeto de tipo Docente imparte las clases.
     * @return materias
     * @throws RuntimeException
     */
    public List<String> mostrarMaterias() throws RuntimeException{
        if(materias.size() > 0){
            return materias;
        } else {
            throw new RuntimeException("Este alumno no tiene ninguna materia registrada.");
        }
    }

    /**
     * agregarMateria agrega la materia pasada por parámetro a la lista de materias.
     * @param materia
     * @throws RuntimeException
     */
    public void agregarMateria(String materia) throws RuntimeException {
        if(!materias.contains(materia)){
            materias.add(materia);
        } else {
            throw new RuntimeException("Ya existe una materia con el mismo nombre");
        }
    }

    /**
     * removermateria elimina la materia pasada por parámetro de la lista de materias.
     * @param materia
     * @throws RuntimeException
     */
    public void removermateria(String materia) throws RuntimeException{
        if(materias.contains(materia)){
            materias.remove(materia);
        } else {
            throw new RuntimeException("No existe una materia con el nombre especificado.");
        }
    }
}
