package MainClasses;

import Enum.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
    private final ArrayList<Prestamo> prestamosEnCurso = new ArrayList<>(); //Lista de préstamos
    private final ArrayList<Reserva> reservasEnCurso = new ArrayList<>(); //Lista de reservas

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
     * @throws RuntimeException
     */
    public void agregarEjemplar(Ejemplar ejemplar) throws RuntimeException {
        /* Si el el objeto de tipo Ejemplar no se encuentra en la lista de ejemplares */
        if(!listaDeEjemplares.contains(ejemplar)){
            listaDeEjemplares.add(ejemplar);
        } else {
            throw new RuntimeException("El ejemplar ya se encuentra en la biblioteca.");
        }
        agregarIndice(ejemplar.getObra().getIndice());
        agregarObra(ejemplar.getObra());
        ejemplar.getObra().getEjemplares().add(ejemplar);
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
     * @throws RuntimeException
     */
    public void removerEjemplar(Ejemplar ejemplar) throws RuntimeException {
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
     * @throws RuntimeException
     */
    public List<Lector> mostrarDeudores() throws RuntimeException {
        if(listaDeDeudores.size() > 0) {
            return listaDeDeudores;
        } else {
            throw new RuntimeException("No hay deudores registrados.");
        }
    }

    /**
     * mostrarObras muestra las obras presentes en la biblioteca.
     * @return obras
     * @throws RuntimeException
     */
    public List<Obra> mostrarObras() throws RuntimeException {
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
     * @throws RuntimeException
     */
    public void registrarRetiroConReserva(Reserva reserva, TipoLectura tipoLectura, String funcionario)
            throws RuntimeException {
        if(LocalDateTime.now().isAfter(reserva.getFechaHoraInicio()) &&
            LocalDateTime.now().isBefore(reserva.getFechaHoraFin())) {
            reserva.getEjemplar().setCondicion(Condicion.PRESTADO);
            Prestamo prestamo = this.solicitarPrestamo(tipoLectura, LocalDateTime.now(), funcionario,
                    reserva.getEjemplar(), reserva.getLector(), true);
            reservasEnCurso.remove(reserva);
        } else {
            throw new RuntimeException("El ejemplar no está reservado actualmente");
        }
    }

    /**
     * solicitarPrestamo genera un nuevo préstamo.
     * @param tipoLectura
     * @param fechaHoraInicio
     * @param funcionario
     * @param ejemplar
     * @param lector
     * @param desdeReserva
     * @return Prestamo
     */
    public Prestamo solicitarPrestamo(TipoLectura tipoLectura, LocalDateTime fechaHoraInicio,
                                  String funcionario, Ejemplar ejemplar, Lector lector,
                                  boolean desdeReserva) {
        ejemplar.setCondicion(Condicion.PRESTADO);
        Prestamo prestamo = new Prestamo(tipoLectura, fechaHoraInicio, funcionario,
                ejemplar, lector, desdeReserva);
        return prestamo;
    }

    /**
     * reservar genera una nueva reserva para un ejemplar.
     * @param fechaHoraInicio
     * @param fechaHoraFin
     * @param ejemplar
     * @param lector
     * @return Reserva
     */
    public Reserva reservar(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
                            Ejemplar ejemplar, Lector lector) {
        ejemplar.setCondicion(Condicion.RESERVADO);
        return new Reserva(fechaHoraInicio, fechaHoraFin, ejemplar, lector);
    }

    /**
     * devolver genera los datos para realizar una devolución.
     * @param fechaHoraDevolucion
     * @param ejemplar
     * @param lector
     * @param funcionario
     * @param prestamo
     * @return Devolucion
     */
    public Devolucion devolver(LocalDateTime fechaHoraDevolucion, Ejemplar ejemplar, Lector lector,
                               String funcionario, Prestamo prestamo) {
        ejemplar.setCondicion(Condicion.DISPONIBLE);
        return new Devolucion(fechaHoraDevolucion, ejemplar, lector, funcionario, prestamo);
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

    /**
     * identificarLugarEjemplar permite identificar el lugar físico donde se encuentra el ejemplar
     * dentro de la biblioteca con el identificador único de este.
     * @param identUnico
     * @return ubicacion
     */
    public String identificarLugarEjemplar(String identUnico) {
        String ubicacion = "";
        for(int i = 0; i < listaDeEjemplares.toArray().length; i++) {
            if (listaDeEjemplares.get(i).getIdentUnico() == identUnico) {
                ubicacion = String.valueOf(listaDeEjemplares.get(i).getLugarFisico());
                break;
            }
        }
        return ubicacion;
    }

    /**
     * obrasDeUnaEditorial devuelve un listado de obras dada una editorial determinada
     * @param editorial
     * @return obrasEdi
     */
    public ArrayList<Obra> obrasDeUnaEditorial(String editorial) {
        ArrayList<Obra> obrasEdi = null;
        for(int i = 0; i < obras.toArray().length; i++) {
            if (obras.get(i).getEdicion().getEditorial() == editorial) {
                obrasEdi.add(obras.get(i));
            }
        }
        return obrasEdi;
    }

    /**
     * agregarLectorConMultas agrega un objeto de tipo lector a la lista de
     * lectores con multas.
     * @param lector
     * @throws RuntimeException
     */
    public void agregarLectorConMultas(Lector lector) throws RuntimeException {
        /* Si el el objeto de tipo Lector no se encuentra en la lista de lectoresConMultas */
        if(!listaLectoresConMultas.contains(lector)){
            listaLectoresConMultas.add(lector);
        } else {
            throw new RuntimeException("El lector ya se encuentra en la lista.");
        }
    }

    /**
     * mostrarLectoresConMultas devuelve la lista de los lectores con multas.
     * @return listaLectoresConMultas
     * @throws RuntimeException
     */
    public List<Lector> mostrarLectoresConMultas() throws RuntimeException {
        if(listaLectoresConMultas.size() > 0) {
            ordenarLectoresConMultas();
            return listaLectoresConMultas;
        } else {
            throw new RuntimeException("No hay lectores registrados.");
        }
    }

    /**
     * ordenarLectoresConMultas ordena la lista de lectores con multas
     * de mayor a menor para obtner el ranking de lectores con más multas.
     */
    public void ordenarLectoresConMultas() {
        listaLectoresConMultas.sort(Comparator.comparing(Lector::getMultas).reversed());
    }

    /**
     * lectoresConMultasPeriodoTiempo devuelve un listado de lectores que tuvieron multas en
     * cierto periodo de tiempo.
     * @param inicio
     * @param fin
     * @return lectores
     */
    public ArrayList<Lector> lectoresConMultasPeriodoTiempo(LocalDate inicio, LocalDate fin) {
        ArrayList<Lector> lectores = null;
        for(int i = 0; i < listaLectoresConMultas.toArray().length; i++) {
            //En fechaDevolucion se guarda la fecha en el cual el ejemplar fue devuelto
            LocalDate fechaDevolucion = listaLectoresConMultas.get(i).getDevolucion().getFechaHoraDevolucion().toLocalDate();
            //En diasDeMultas se guarda la fecha en el cual el ejemplar fue devuelto más los días de multas
            LocalDate diasDeMultas = listaLectoresConMultas.get(i).getDevolucion().getFechaHoraDevolucion().
                    toLocalDate().plusDays(listaLectoresConMultas.get(i).getMultas());
            if ((inicio.isEqual(fechaDevolucion) || inicio.isAfter(fechaDevolucion)) &&
                    (fin.isEqual(diasDeMultas) || fin.isBefore(diasDeMultas))) {
                lectores.add(listaLectoresConMultas.get(i));
            }
        }
        return lectores;
    }

    /**
     * registrarReserva guarda en la lista de reservas la reserva ejecutada.
     * @param r
     */
    public void registrarReserva(Reserva r) {
        if(!reservasEnCurso.contains(r)){
            reservasEnCurso.add(r);
        }
    }

    /**
     * mostrarReservas devuelve la lista de todas las reservas vigentes.
     * @return reservas
     * @throws RuntimeException
     */
    public ArrayList<Reserva> mostrarReservas() throws RuntimeException {
        if(reservasEnCurso.size() > 0) {
            return reservasEnCurso;
        } else {
            throw new RuntimeException("No hay reservas registradas.");
        }
    }

    /**
     * reservasAPartirFecha muestra las obras que se encuentran reservadas
     * a partir de una fecha determinada.
     * @param fecha
     * @return reservasFecha
     */
    public ArrayList<Reserva> reservasAPartirFecha(LocalDate fecha) {
        ArrayList<Reserva> reservasFecha = null;
        for(int i = 0; i < listaLectoresConMultas.toArray().length; i++) {
            //En fechaReserva se guarda la fecha en el cual se inició la reserva de un ejemplar
            LocalDate fechaReserva = reservasEnCurso.get(i).getFechaHoraInicio().toLocalDate();
            if (fecha.isEqual(fechaReserva) || fecha.isAfter(fechaReserva)) {
                reservasFecha.add(reservasEnCurso.get(i));
            }
        }
        return reservasFecha;
    }

    /**
     * ejemplaresDisponibles retorna una lista de ejemplares disponibles para préstamo
     * para un área de referencia determinada.
     * @param area
     * @return ejemplares
     */
    public ArrayList<Ejemplar> ejemplaresDisponiblesArea(String area) {
        ArrayList<Ejemplar> ejemplares = null;
        for(int i = 0; i < listaDeEjemplares.toArray().length; i++) {
            if ((listaDeEjemplares.get(i).getObra().getAreaTematica() == area) &&
                    (listaDeEjemplares.get(i).getCondicion() == Condicion.DISPONIBLE)) {
                ejemplares.add(listaDeEjemplares.get(i));
            }
        }
        return ejemplares;
    }

    /**
     * mostrarObrasSolicitadasAluDoc muestra un listado de las obras más solicitadas
     * por alumnos y docentes.
     * @return listaObrasSolicitadasAluDoc
     * @throws RuntimeException
     */
    public List<Obra> mostrarObrasSolicitadasAluDoc() throws RuntimeException {
        if(listaObrasSolicitadasAluDoc.size() > 0) {
            return listaObrasSolicitadasAluDoc;
        } else {
            throw new RuntimeException("No hay obras registradas.");
        }
    }

    /**
     * mostrarObrasSolicitadasPublico un listado de las obras más solicitadas
     * por el público en general.
     * @return listaObrasSolicitadasPublico
     * @throws RuntimeException
     */
    public List<Obra> mostrarObrasSolicitadasPublico() throws RuntimeException {
        if(listaObrasSolicitadasPublico.size() > 0) {
            return listaObrasSolicitadasPublico;
        } else {
            throw new RuntimeException("No hay obras registradas.");
        }
    }

    /**
     * toString devuelve una cadena que representa la instancia de Biblioteca.
     * @return String
     */
    @Override
    public String toString() {
        return "-Biblioteca: " + "\n" +
                "   -Ejemplares=" + listaDeEjemplares + "\n" +
                "   -Obras=" + obras;
    }
}
