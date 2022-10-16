package MainClasses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
public class Ejemplar {
    private String identUnico;
    private int codBarra;
    private String observaciones;
    private String areaDeReferencia;
    private ArrayList<String> lugarFisico = new ArrayList<>();

    private LocalDate fechaDadoDeBaja;
    private String motivoDadoDeBaja;
    private ArrayList<String> ubicacionFisicaDadoDeBaja = new ArrayList<>();

    private LocalDate fechaDeAdquisicion;
    private String formaDeAdquisicion;
    private Obra obra; //Relación con la clase Obra

    private Reserva lectorReserva; //Relación con las clases Reserva y Lector
    private Prestamo lectorPrestamo; //Relación con las clases Prestamo y Lector

    //Constructor sin reserva ni préstamo
    public Ejemplar(String identUnico, int codBarra, String observaciones, String areaDeReferencia, ArrayList<String> lugarFisico, LocalDate fechaDadoDeBaja, String motivoDadoDeBaja, ArrayList<String> ubicacionFisicaDadoDeBaja, LocalDate fechaDeAdquisicion, String formaDeAdquisicion, Obra obra) {
        this.identUnico = identUnico;
        this.codBarra = codBarra;
        this.observaciones = observaciones;
        this.areaDeReferencia = areaDeReferencia;
        this.lugarFisico = lugarFisico;
        this.fechaDadoDeBaja = fechaDadoDeBaja;
        this.motivoDadoDeBaja = motivoDadoDeBaja;
        this.ubicacionFisicaDadoDeBaja = ubicacionFisicaDadoDeBaja;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.formaDeAdquisicion = formaDeAdquisicion;
        this.obra = obra;
    }

    //Constructor con reserva
    public Ejemplar(String identUnico, int codBarra, String observaciones, String areaDeReferencia, LocalDate fechaDadoDeBaja, String motivoDadoDeBaja, ArrayList<String> ubicacionFisicaDadoDeBaja, LocalDate fechaDeAdquisicion, String formaDeAdquisicion, Obra obra, Reserva lectorReserva, Prestamo lectorPrestamo) {
        this.identUnico = identUnico;
        this.codBarra = codBarra;
        this.observaciones = observaciones;
        this.areaDeReferencia = areaDeReferencia;
        this.fechaDadoDeBaja = fechaDadoDeBaja;
        this.motivoDadoDeBaja = motivoDadoDeBaja;
        this.ubicacionFisicaDadoDeBaja = ubicacionFisicaDadoDeBaja;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.formaDeAdquisicion = formaDeAdquisicion;
        this.obra = obra;
        this.lectorReserva = lectorReserva;
    }

    //Constructor con préstamo
    public Ejemplar(String identUnico, int codBarra, String observaciones, String areaDeReferencia, ArrayList<String> lugarFisico, LocalDate fechaDadoDeBaja, String motivoDadoDeBaja, ArrayList<String> ubicacionFisicaDadoDeBaja, LocalDate fechaDeAdquisicion, String formaDeAdquisicion, Obra obra, Prestamo lectorPrestamo) {
        this.identUnico = identUnico;
        this.codBarra = codBarra;
        this.observaciones = observaciones;
        this.areaDeReferencia = areaDeReferencia;
        this.lugarFisico = lugarFisico;
        this.fechaDadoDeBaja = fechaDadoDeBaja;
        this.motivoDadoDeBaja = motivoDadoDeBaja;
        this.ubicacionFisicaDadoDeBaja = ubicacionFisicaDadoDeBaja;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.formaDeAdquisicion = formaDeAdquisicion;
        this.obra = obra;
        this.lectorPrestamo = lectorPrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ejemplar ejemplar)) return false;
        return codBarra == ejemplar.codBarra && Objects.equals(identUnico, ejemplar.identUnico) && Objects.equals(observaciones, ejemplar.observaciones) && Objects.equals(areaDeReferencia, ejemplar.areaDeReferencia) && Objects.equals(fechaDadoDeBaja, ejemplar.fechaDadoDeBaja) && Objects.equals(motivoDadoDeBaja, ejemplar.motivoDadoDeBaja) && Objects.equals(ubicacionFisicaDadoDeBaja, ejemplar.ubicacionFisicaDadoDeBaja) && Objects.equals(fechaDeAdquisicion, ejemplar.fechaDeAdquisicion) && Objects.equals(formaDeAdquisicion, ejemplar.formaDeAdquisicion) && Objects.equals(obra, ejemplar.obra) && Objects.equals(lectorReserva, ejemplar.lectorReserva) && Objects.equals(lectorPrestamo, ejemplar.lectorPrestamo);
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "Identificador único='" + identUnico + '\'' +
                ", Código de barra=" + codBarra +
                ", Observaciones='" + observaciones + '\'' +
                ", Área de referencia='" + areaDeReferencia + '\'' +
                ", Fecha de dado de baja=" + fechaDadoDeBaja +
                ", Motivo de dado de baja='" + motivoDadoDeBaja + '\'' +
                ", Ubicación física de dado de baja='" + ubicacionFisicaDadoDeBaja + '\'' +
                ", Fecha de adquisición=" + fechaDeAdquisicion + '\'' +
                ", Forma de adquisición='" + formaDeAdquisicion + '\'' +
                ", Obra=" + obra +
                '}';
    }
}
