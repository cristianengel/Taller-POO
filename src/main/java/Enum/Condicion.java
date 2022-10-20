package Enum;

import lombok.Getter;


@Getter
public enum Condicion {
    /**
     * Enumeración para diferenciar la condición del ejemplar
     */
    DISPONIBLE("Disponible"),
    PRESTADO("Prestado"),
    RESERVADO("Reservado");

    private String condicion;

    Condicion(String condicion) {
        this.condicion = condicion;
    }
}
