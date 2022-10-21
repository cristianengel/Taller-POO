package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import Enum.*;

@Getter
@Setter

/**
 * La clase Biblioteca propone un lugar donde se registran los datos referidos a
 * los ejemplares, las obras, los deudores, los lectores y los índices.
 */
public class Biblioteca {
    private static Biblioteca instance;
    private final ArrayList<Ejemplar> listaDeEjemplares = new ArrayList<>();
    private final ArrayList<String> listaDeIndices = new ArrayList<>();
    private final ArrayList<Lector> listaDeDeudores = new ArrayList<>();
    private final ArrayList<Obra> listaObrasSolicitadasAluDoc = new ArrayList<>();
    private final ArrayList<Obra> listaObrasSolicitadasPublico = new ArrayList<>();
    private final ArrayList<Lector> listaLectoresConMultas = new ArrayList<>();
    private final ArrayList<Obra> obras = new ArrayList<>(); //Relación con la clase Obra
    private final ArrayList<Prestamo> prestamosEnCurso = new ArrayList<>(); // Lista de préstamos
    private final ArrayList<Reserva> reservas = new ArrayList<>(); // Lista de reservas

    private Biblioteca(){}

    /**
     * Método de instancia única.
     * Restringe la creación de objetos de tipo Biblioteca a un único objeto.
     * @return La instancia de tipo Biblioteca
     */
    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }

    /**
     * agregarEjemplar agrega a la lista de ejemplares el ejemplar.
     * Una vez agregado el ejemplar, si el ejemplar es nuevo, agrega el índice del ejemplar a la lista
     * de índices y agrega la obra correspondiente al ejemplar a la lista de obras.
     * @param ejemplar
     */
    public void agregarEjemplar(Ejemplar ejemplar){
        /* Si el el objeto de tipo Ejemplar no se encuentra en la lista de ejemplares */
        if(!listaDeEjemplares.contains(ejemplar)){
            listaDeEjemplares.add(ejemplar);
        } else {
            throw new RuntimeException("El ejemplar ya se encuentra en la biblioteca.");
        }
        agregarIndice(ejemplar.getObra().getIndice());
        agregarObra(ejemplar.getObra());
    }

    /**
     * agregarObra agrega la obra pasada por parámtro a la lista de obras.
     * @param obra
     */
    private void agregarObra(Obra obra) {
        if(!obras.contains(obra)){
            obras.add(obra);
        }
    }

    /**
     * removerEjemplar elimina de la lista de ejemplares el ejemplar pasado por parámetro.
     * @param ejemplar
     */
    public void removerEjemplar(Ejemplar ejemplar){
        if(listaDeEjemplares.contains(ejemplar)){
            listaDeEjemplares.remove(ejemplar);
        } else {
            throw new RuntimeException("El ejemplar no se encuentra en la biblioteca.");
        }
        //Se borran los índices y las obras de la biblioteca cuando no haya ejemplares disponibles.
        if(cantEjemplaresPorObra(ejemplar.getObra()) == 0) {
            listaDeIndices.remove(ejemplar.getObra().getIndice());
            obras.remove(ejemplar.getObra());
        }
    }

    /**
     * agregarIndice agrega a la lista de índices el índice pasado por parámetro.
     * @param indice
     * @throws RuntimeException
     */
    public void agregarIndice(String indice) throws RuntimeException {
        if (Objects.equals(indice, "")) throw new RuntimeException("Índice inválido.");
        if(!listaDeIndices.contains(indice)){
            listaDeIndices.add(indice);
        }
    }

    /**
     * removerIndice elimina de la lista de índices el índice pasado por parámetro.
     * @param indice
     * @throws RuntimeException
     */
    public void removerIndice(String indice) throws RuntimeException {
        if (Objects.equals(indice, "")) throw new RuntimeException("Índice inválido.");
        if(listaDeIndices.contains(indice)){
            listaDeIndices.remove(indice);
        } else {
            throw new RuntimeException("El indice no se encuentra en la biblioteca.");
        }
    }

    /**
     * mostrarEjemplares muestra los ejemplares presentes en la biblioteca.
     * @return listaDeEjemplares
     */
    public List<Ejemplar> mostrarEjemplares() {
        if(listaDeEjemplares.size() > 0) {
            return listaDeEjemplares;
        } else {
            throw new RuntimeException("No hay ejemplares registrados.");
        }
    }

    /**
     * mostrarIndices muestra los índices presentes en la biblioteca.
     * @return listaDeIndices
     */
    public List<String> mostrarIndices(){
        if(listaDeIndices.size() > 0) {
            return listaDeIndices;
        } else {
            throw new RuntimeException("No hay índices registrados.");
        }
    }

    /**
     * mostrarDeudores muestra los deudores que deben regresar algún ejemplar a la biblioteca.
     * @return listaDeDeudores
     */
    public List<Lector> mostrarDeudores(){
        if(listaDeDeudores.size() > 0) {
            return listaDeDeudores;
        } else {
            throw new RuntimeException("No hay deudores registrados.");
        }
    }

    /**
     * mostrarObras muestra las obras presentes en la biblioteca.
     * @return obras
     */
    public List<Obra> mostrarObras(){
        if(obras.size() > 0) {
            return obras;
        } else {
            throw new RuntimeException("No hay obras registradas.");
        }
    }

    /**
     * registrarRetiroConReserva registra el retiro de un ejemplar reservado
     * y modifica los registros de prestamosEnCurso y reservas.
     * @param reserva
     * @param tipoLectura
     * @param funcionario
     */
    public void registrarRetiroConReserva(Reserva reserva, TipoLectura tipoLectura, String funcionario) {
        if(LocalDateTime.now().isAfter(reserva.getFechaHoraInicio()) &&
            LocalDateTime.now().isBefore(reserva.getFechaHoraFin())) {
            reserva.getEjemplar().setCondicion(Condicion.PRESTADO);
            Prestamo prestamo = new Prestamo(tipoLectura, LocalDateTime.now(), funcionario,
                    reserva.getEjemplar(), reserva.getLector(), true);
            reservas.remove(reserva);
            prestamosEnCurso.add(prestamo);
        } else {
            throw new RuntimeException("El ejemplar no está reservado actualmente");
        }
    }

    /**
     * cantEjemplaresPorObra chequea la disponibilidad de ejemplares con la
     * obra pasada por parámetro.
     * @param obra
     * @return cant
     */
    public int cantEjemplaresPorObra(Obra obra){
        int cant = 0;
        for(int i = 0; i < listaDeEjemplares.toArray().length; i++) {
            if(listaDeEjemplares.get(i).getObra() == obra) {
                cant++;
            }
        }
        return cant;
    }

    @Override
    public String toString() {
        return "-Biblioteca: " + "\n" +
                "   -Ejemplares=" + listaDeEjemplares + "\n" +
                "   -Índices=" + listaDeIndices + "\n" +
                "   -Deudores=" + listaDeDeudores + "\n" +
                "   -Obras solicitadas por alumnos y docentes=" + listaObrasSolicitadasAluDoc + "\n" +
                "   -Obras solicitadas por el público=" + listaObrasSolicitadasPublico + "\n" +
                "   -Lectores con multas=" + listaLectoresConMultas + "\n" +
                "   -Obras=" + obras;
    }
}
