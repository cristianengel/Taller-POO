package Enum;

import lombok.Getter;

@Getter

/**
 * La clase TipoObra propone los tipos de obras que pueden existir.
 */
public enum TipoObra {
    LIBRO("Libro"),
    REVISTA("Revista"),
    ENSAYO("Ensayo"),
    TESIS("Tesis"),
    MANUAL("Manual"),
    BOLETIN("Boletín"),
    COLLECION("Colleción"),
    COMPENDIO("Compendio"),
    DIARIO("Diario"),
    DICCIONARIO("Diccionario"),
    DOCUMENTAL("Documental"),
    ENCICLOPEDIA("Enciclopedia"),
    INVESTIGACION("Investigación"),
    MONOGRAFIA("Monografía"),
    PUBLICACION_MENSUAL("Publicación mensual");

    private String tipo;

    /**
     * Constructor de la clase TipoObra privado
     * para que solamente se creen objetos del tipo mencionados aquí.
     * @param tipo
     */
    private TipoObra(String tipo) {
        this.tipo = tipo;
    }
}
