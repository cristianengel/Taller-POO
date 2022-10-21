package Enum;

import lombok.Getter;

@Getter

/**
 * Enumeración para diferenciar la condición del ejemplar
 */
public enum Condicion {
    DISPONIBLE("Disponible"),
    PRESTADO("Prestado"),
    RESERVADO("Reservado");

    private String condicion;

    /**
     * Constructor de la clase Condicion privado
     * para que solamente se creen objetos del tipo mencionados aquí.
     * @param condicion
     */
    private Condicion(String condicion) {
        this.condicion = condicion;
    }
}
