package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Biblioteca {
    private static Biblioteca instance;
    private final ArrayList<Ejemplar> listaDeEjemplares = new ArrayList<>(); //En el UML aparece Obra
    private final ArrayList<String> listaDeIndices = new ArrayList<>();
    private final ArrayList<Lector> listaDeDeudores = new ArrayList<>();
    private final ArrayList<Obra> listaObrasSolicitadasAluDoc = new ArrayList<>();
    private final ArrayList<Obra> listaObrasSolicitadasPublico = new ArrayList<>();
    private final ArrayList<Lector> listaLectoresConMultas = new ArrayList<>();
    private final ArrayList<Obra> obras = new ArrayList<>(); //Relación con la clase Obra
    public ArrayList<String> loginData = new ArrayList<>(); // Datos de inicio de sesión, guarda nombre de usuario y DNI del bibliotecario


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
        agregarObra(ejemplar.getObra());
    }

    private void agregarObra(Obra obra) {
        if(!obras.contains(obra)){
            obras.add(obra);
        }
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

    public void agregarIndice(String indice) throws RuntimeException {
        if (Objects.equals(indice, "")) throw new RuntimeException("Índice inválido.");
        if(!listaDeIndices.contains(indice)){
            listaDeIndices.add(indice);
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

    public List<Ejemplar> mostrarEjemplares() {
        if(listaDeEjemplares.size() > 0) {
            return listaDeEjemplares;
        } else {
            throw new RuntimeException("No hay ejemplares registrados.");
        }
    }

    public List<String> mostrarIndices(){
        if(listaDeIndices.size() > 0) {
            return listaDeIndices;
        } else {
            throw new RuntimeException("No hay índices registrados.");
        }
    }

    public List<Lector> mostrarDeudores(){
        if(listaDeDeudores.size() > 0) {
            return listaDeDeudores;
        } else {
            throw new RuntimeException("No hay deudores registrados.");
        }
    }

    public List<Obra> mostrarObras(){
        if(obras.size() > 0) {
            return obras;
        } else {
            throw new RuntimeException("No hay obras registradas.");
        }
    }
    
    public void solicitarPrestamo() {
        // TODO: 10/16/22  
    }
    
    public void reservar() {
        // TODO: 10/16/22  
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
