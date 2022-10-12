import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Biblioteca {
    private static Biblioteca instance;
    private final ArrayList<Ejemplar> listaDeEjemplares = new ArrayList<>(); //En el UML aparece <Obra>
    private final ArrayList<String> listaDeIndices = new ArrayList<>();
    private final ArrayList<Lector> listaDeDeudores = new ArrayList<>();
    private final ArrayList<Obra> listaObrasSolicitadasAluDoc = new ArrayList<>();
    private final ArrayList<Obra> listaObrasSolicitadasPublico = new ArrayList<>();
    private final ArrayList<Lector> listaLectoresConMultas = new ArrayList<>();
    private final ArrayList<Obra> obras = new ArrayList<>(); //Relación con la clase Obra

    private Biblioteca(){}

    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }
    public void agregarEjemplar(Ejemplar ejemplar){
        if(!listaDeEjemplares.contains(ejemplar)){
            listaDeEjemplares.add(ejemplar);
        } else {
            throw new RuntimeException("El ejemplar ya se encuentra en la biblioteca.");
        }
        agregarIndice(ejemplar.getObra().getIndice());
    }

    public void removerEjemplar(Ejemplar ejemplar){
        if(listaDeEjemplares.contains(ejemplar)){
            listaDeEjemplares.remove(ejemplar);
        } else {
            throw new RuntimeException("El ejemplar no se encuentra en la biblioteca.");
        }
        // se borran los índices y las obras de la biblioteca cuando no haya ejemplares disponibles.
        if(cantEjemplaresPorObra(ejemplar.getObra()) == 0) {
            listaDeIndices.remove(ejemplar.getObra().getIndice());
            obras.remove(ejemplar.getObra());
        }
    }

    public List<Ejemplar> mostrarEjemplares() {
        if(listaDeEjemplares.size() > 0) {
            return listaDeEjemplares;
        } else {
            throw new RuntimeException("No hay ejemplares registrados.");
        }
    }

    public void agregarIndice(String indice) throws RuntimeException {
        if (Objects.equals(indice, "")) throw new RuntimeException("Índice inválido.");
        if(!listaDeIndices.contains(indice)){
            listaDeIndices.add(indice);
        } else {
            throw new RuntimeException("El indice ya se encuentra registrado.");
        }
    }

    public void removerIndice(String indice) throws RuntimeException {
        if (Objects.equals(indice, "")) throw new RuntimeException("Índice inválido.");
        if(listaDeIndices.contains(indice)){
            listaDeIndices.remove(indice);
        } else {
            throw new RuntimeException("El indice no se encuentra en la biblioteca.");
        }
    }

    public List<String> mostrarIndices(){
        if(listaDeIndices.size() > 0) {
            return listaDeIndices;
        } else {
            throw new RuntimeException("No hay índices registrados.");
        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "Ejemplares=" + listaDeEjemplares +
                ", Índices=" + listaDeIndices +
                ", Deudores=" + listaDeDeudores +
                ", Obras solicitadas por alumnos y docentes=" + listaObrasSolicitadasAluDoc +
                ", Obras solicitadas por el público=" + listaObrasSolicitadasPublico +
                ", Lectores con multas=" + listaLectoresConMultas +
                ", Obras=" + obras +
                '}';
    }

    // Chequeo de disponibilidad de ejemplares de la misma obra
    public int cantEjemplaresPorObra(Obra obra){
        int cant = 0;
        for(int i = 0; i < listaDeEjemplares.toArray().length; i++) {
            if(listaDeEjemplares.get(i).getObra() == obra) {
                cant++;
            }
        }
        return cant;
    }
}
