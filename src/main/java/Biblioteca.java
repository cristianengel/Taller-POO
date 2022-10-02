import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    ArrayList<Ejemplar> listaDeEjemplares = new ArrayList<>();
    ArrayList<String> listaDeIndices = new ArrayList<>();
    ArrayList<Lector> listaDeDeudores = new ArrayList<>();
    ArrayList<Obra> listaObrasSolicitadasAluDoc = new ArrayList<>();
    ArrayList<Obra> listaObrasSolicitadasPublico = new ArrayList<>();
    ArrayList<Lector> listaLectoresConMultas = new ArrayList<>();

    public void agregarEjemplar(Ejemplar ejemplar){
        if(!listaDeEjemplares.contains(ejemplar)){
            listaDeEjemplares.add(ejemplar);
        } else {
            throw new RuntimeException("El ejemplar ya se encuentra en la biblioteca.");
        }
        // TODO: 10/1/22 aca se implementa la funcion agregarIndice()
    }

    public void removerEjemplar(Ejemplar ejemplar){
        if(listaDeEjemplares.contains(ejemplar)){
            listaDeEjemplares.remove(ejemplar);
        } else {
            throw new RuntimeException("El ejemplar no se encuentra en la biblioteca.");
        }
        // TODO: 10/1/22 se necesita saber si hay mas ejemplares en la biblioteca de la misma obra, para saber si eliminar el indice o dejarlo.
    }

    public List<Ejemplar> mostrarEjemplares() {
        if(listaDeEjemplares.size() > 0) {
            return listaDeEjemplares;
        } else {
            throw new RuntimeException("No hay ejemplares registrados.");
        }
    }

    public void agregarIndice(String indice) throws RuntimeException {
        if(!listaDeIndices.contains(indice)){
            listaDeIndices.add(indice);
        } else {
            throw new RuntimeException("El indice ya se encuentra registrado.");
        }
    }
}
