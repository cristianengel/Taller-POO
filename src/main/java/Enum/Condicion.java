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

    private Condicion(String condicion) {
        this.condicion = condicion;
    }
}
