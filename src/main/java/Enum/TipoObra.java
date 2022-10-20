package Enum;

import lombok.Getter;

@Getter

/**
 * La clase TipoObra propone los tipos de obras que pueden existir
 */
public enum TipoObra {
    LIBRO("Libro"),
    REVISTA("Revista"),
    ENSAYO("Ensayo"),
    TESIS("Tesis"),
    MANUAL("Manual");

    private String tipo;

    /**
     * Constructor privado, para que solamente se creen objetos del tipo mencionados aquí
     * @param tipo
     */
    private TipoObra(String tipo) {
        this.tipo = tipo;
    }
}
