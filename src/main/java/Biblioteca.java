import java.util.ArrayList;
import java.util.List;

public final class Biblioteca {
    private static Biblioteca instance;
    private ArrayList<Ejemplar> listaDeEjemplares = new ArrayList<>(); //En el UML aparece <Obra>
    private ArrayList<String> listaDeIndices = new ArrayList<>();
    private ArrayList<Lector> listaDeDeudores = new ArrayList<>();
    private ArrayList<Obra> listaObrasSolicitadasAluDoc = new ArrayList<>();
    private ArrayList<Obra> listaObrasSolicitadasPublico = new ArrayList<>();
    private ArrayList<Lector> listaLectoresConMultas = new ArrayList<>();
    private ArrayList<Obra> obras = new ArrayList<>(); //Relación con la clase Obra

    private Biblioteca(ArrayList<Ejemplar> listaDeEjemplares, ArrayList<String> listaDeIndices, ArrayList<Lector> listaDeDeudores, ArrayList<Obra> listaObrasSolicitadasAluDoc, ArrayList<Obra> listaObrasSolicitadasPublico, ArrayList<Lector> listaLectoresConMultas, ArrayList<Obra> obras){
        //No creo que sea necesario este try-catch
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.listaDeEjemplares = listaDeEjemplares;
        this.listaDeIndices = listaDeIndices;
        this.listaDeDeudores = listaDeDeudores;
        this.listaObrasSolicitadasAluDoc = listaObrasSolicitadasAluDoc;
        this.listaObrasSolicitadasPublico = listaObrasSolicitadasPublico;
        this.listaLectoresConMultas = listaLectoresConMultas;
        this.obras = obras;
    }

    public static Biblioteca getInstance(ArrayList<Ejemplar> listaDeEjemplares, ArrayList<String> listaDeIndices, ArrayList<Lector> listaDeDeudores, ArrayList<Obra> listaObrasSolicitadasAluDoc, ArrayList<Obra> listaObrasSolicitadasPublico, ArrayList<Lector> listaLectoresConMultas, ArrayList<Obra> obras) {
        if (instance == null) {
            instance = new Biblioteca(listaDeEjemplares, listaDeIndices, listaDeDeudores, listaObrasSolicitadasAluDoc, listaObrasSolicitadasPublico, listaLectoresConMultas, obras);
        }
        return instance;
    }
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
