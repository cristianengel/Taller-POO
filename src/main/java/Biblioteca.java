import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private ArrayList<Ejemplar> listaDeEjemplares = new ArrayList<>(); //En el UML aparece <Obra>
    private ArrayList<String> listaDeIndices = new ArrayList<>();
    private ArrayList<Lector> listaDeDeudores = new ArrayList<>();
    private ArrayList<Obra> listaObrasSolicitadasAluDoc = new ArrayList<>();
    private ArrayList<Obra> listaObrasSolicitadasPublico = new ArrayList<>();
    private ArrayList<Lector> listaLectoresConMultas = new ArrayList<>();
    private ArrayList<Obra> obras = new ArrayList<>(); //Relación con la clase Obra

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
