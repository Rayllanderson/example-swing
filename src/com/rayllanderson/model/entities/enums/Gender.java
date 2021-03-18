package com.rayllanderson.model.entities.enums;

public enum Gender {
    MASCULINO(0), FEMININO(1);

    private int code;

    private Gender(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Gender valueOf (int code){
        for (Gender g: Gender.values()) {
            if (g.getCode() == code) {
                return g;
            }
        }
        return null;
    }
}
