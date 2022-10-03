import java.util.ArrayList;
import java.util.List;

public class Alumno extends Lector{
    private ArrayList<String> carreras = new ArrayList<>();

    public List<String> mostrarCarreras() throws RuntimeException{
        if(carreras.size() > 0){
            return carreras;
        } else {
            throw new RuntimeException("Este alumno no tiene ninguna carrera registrada.");
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
}
