package Enum;

import lombok.Getter;

@Getter
public enum TipoDocumento {
    DNI("dni"),
    LC("libreta cívica"),
    LE("libreta de enrolamiento");

    String tipo;

    private TipoDocumento(String tipo) {
        this.tipo = tipo;
    }
}
