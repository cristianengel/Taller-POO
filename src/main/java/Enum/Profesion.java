package Enum;

import lombok.Getter;



@Getter
public enum Profesion {
    /**
     * Enumeración para distinguir la profesión del lector
     */
    ALUMNO("Alumno"),
    DOCENTE("Docente"),
    PUBLICO("Publico");

    private String profesion;

    Profesion(String profesion) {
        this.profesion = profesion;
    }
}
