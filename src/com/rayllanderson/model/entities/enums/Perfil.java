package com.rayllanderson.model.entities.enums;

public enum Perfil {
    AUXILIAR(0), PREPOSTO(1);

    private int code;

    private Perfil(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Perfil valueOf (int code){
        for (Perfil g: Perfil.values()) {
            if (g.getCode() == code) {
                return g;
            }
        }
        return null;
    }
}
