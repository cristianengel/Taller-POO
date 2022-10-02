import java.util.ArrayList;
import java.util.List;

public class Docente extends Lector{
    ArrayList<String> carreras = new ArrayList<>();
    ArrayList<String> materias = new ArrayList<>();

    public List<String> mostrarCarreras() throws RuntimeException{
        if(carreras.size() > 0){
            return carreras;
        } else {
            throw new RuntimeException("Este docente no tiene ninguna carrera registrada.");
        }
    }

    public void agregarCarrera(String carrera) throws RuntimeException {
        if(!carreras.contains(carrera)){
            carreras.add(carrera);
        } else {
            throw new RuntimeException("Ya existe una carrera con el mismo nombre");
        }
    }

    public void removerCarrera(String carrera) throws RuntimeException{
        if(carreras.contains(carrera)){
            carreras.remove(carrera);
        } else {
            throw new RuntimeException("No existe una carrera con el nombre especificado.");
        }
    }

    public List<String> mostrarMaterias() throws RuntimeException{
        if(materias.size() > 0){
            return materias;
        } else {
            throw new RuntimeException("Este alumno no tiene ninguna materia registrada.");
        }
    }

    public void agregarMateria(String materia) throws RuntimeException {
        if(!materias.contains(materia)){
            materias.add(materia);
        } else {
            throw new RuntimeException("Ya existe una materia con el mismo nombre");
        }
    }

    public void removermateria(String materia) throws RuntimeException{
        if(materias.contains(materia)){
            materias.remove(materia);
        } else {
            throw new RuntimeException("No existe una materia con el nombre especificado.");
        }
    }
}
