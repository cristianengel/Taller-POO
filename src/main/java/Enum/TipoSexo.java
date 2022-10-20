package Enum;

import lombok.Getter;

/**
 * Clase Enum para diferenciar tres tipos de identidad de genero
 */
@Getter
public enum TipoSexo {
    /**
     * Sexo masculino
     */
    MASCULINO("Masculino"),
    /**
     * Sexo femenino
     */
    FEMENINO("Femenino"),
    /**
     * Se considera de otro tipo de sexo o no prefiere decir
     */
    OTRO("Otro");

    private String sexo;

    /**
     *
     * @param sexo
     */
    TipoSexo(String sexo) {
        this.sexo = sexo;
    }
}
