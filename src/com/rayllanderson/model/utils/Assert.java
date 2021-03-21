package com.rayllanderson.model.utils;

public class Assert {

    /**
     * @throws IllegalArgumentException caso o campo esteja vazio
     */
    public static void notNull(String text, String field) throws IllegalArgumentException{
        if (text == null || text.isEmpty() || text.isBlank())
            throw new IllegalArgumentException(field + " não pode ser nulo ou vazio");

    }

    /**
     * @throws IllegalArgumentException caso o campo esteja vazio
     */
    public static void cpfIsValid (String cpf) throws IllegalArgumentException{
       Assert.notNull(cpf, "Cpf");
        boolean invalidCpf = cpf.replace(" ", "").length() < 14;
       if(invalidCpf){
           throw new IllegalArgumentException("Cpf inválido");
       }
    }

    public static <T> T  notNull(T reference, String field) throws IllegalArgumentException {
        if (reference == null )
            throw new IllegalArgumentException(field + " não pode ser nulo ou vazio");
        return reference;
    }
}
