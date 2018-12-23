package br.com.douglasffilho.reactivespring.domain.enums;

import java.util.Arrays;

public enum Gender {
    M("Masculino"),
    F("Feminino"),
    U("Indefinido");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender of(String value) {
        return Arrays.stream(Gender.values())
            .filter(gender -> gender.value.equalsIgnoreCase(value))
            .findAny()
            .orElse(Gender.U);
    }

}
