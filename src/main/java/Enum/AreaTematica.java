package Enum;

import lombok.Getter;

@Getter

/**
 * La clase TipoAreaTematica propone las áreas temáticas que se pueden encontrar
 */
public enum AreaTematica {
    MATEMATICAS("Matemáticas"),
    PROGRAMACION("Programación"),
    CONTABILIDAD("Contabilidad"),
    ADMINISTRACION_EMPRESAS("Administración de empresas"),
    SISTEMAS_OPERATIVOS("Sistemas operativos"),
    METODOLOGIAS_INVESTIGACION("Metodologías de la investigación"),
    INFORMATICA("Informática"),
    PORTUGUES("Portugués");

    private String area;

    /**
     * Constructor privado, para que solamente se creen objetos del tipo mencionados aquí
     * @param area
     */
    private AreaTematica(String area) {
        this.area = area;
    }
}
