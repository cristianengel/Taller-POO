package Enum;

import lombok.Getter;

@Getter

/**
 * Clase en la cuál se proponen los tipos de lectura que se pueden realizan
 * al momento de realizar un préstamo
 */
public enum TipoLectura {
    /* Tipo de lectura a domicilio al solicitar el préstamo de un ejemplar */
    DOMICILIO("Domicilio"),
    /* Tipo de lectura en sala al solicitar el préstamo de un ejemplar */
    SALA("Sala");

    private final String tipo;

    /**
     * Constructor privado, para que solamente se creen objetos del tipo mencionados aquí
     * @param tipo
     */
    private TipoLectura(String tipo) {
        this.tipo = tipo;
    }
}
