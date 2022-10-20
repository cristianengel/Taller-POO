package Enum;

import lombok.Getter;

@Getter

/**
 * La clase Profesion propone distinguir la profesión del lector
 */
public enum Profesion {
    ALUMNO("Alumno"),
    DOCENTE("Docente"),
    PUBLICO("Público");

    private String profesion;

    private Profesion(String profesion) {
        this.profesion = profesion;
    }
}
