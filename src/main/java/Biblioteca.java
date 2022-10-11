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
        if(!listaDeIndices.contains(indice)){
            listaDeIndices.add(indice);
        } else {
            throw new RuntimeException("El indice ya se encuentra registrado.");
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

    // chequeo de disponibilidad de ejemplares de la misma obra
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
