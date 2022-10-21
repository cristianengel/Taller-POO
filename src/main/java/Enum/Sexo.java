package Enum;

import lombok.Getter;

@Getter

/**
 * La clase TipoSexo ofrece diferenciar tres tipos de identidad de género.
 */
public enum Sexo {
    /* Sexo masculino */
    MASCULINO("Masculino"),
    /* Sexo femenino */
    FEMENINO("Femenino"),
    /* Se considera de otro tipo de sexo o no prefiere decir */
    OTRO("Otro");

    private String sexo;

    /**
     * Constructor de la clase Sexo privado
     * para que solamente se creen objetos del tipo mencionados aquí.
     * @param sexo
     */
    private Sexo(String sexo) {
        this.sexo = sexo;
    }
}
