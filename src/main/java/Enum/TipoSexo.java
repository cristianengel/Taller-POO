package Enum;

/**
 * Clase Enum para diferenciar tres tipos de identidad de genero
 */
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
     * Constructor privado, para que solamente se creen objetos del tipo mencionados aquí
     * @param sexo
     */
    TipoSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Devuelve un String del tipo de sexo seleccionado
     * @return String
     */
    public String getGenero() {
        return sexo;
    }
}
