package com.rayllanderson.model.utils;

public class Assert {

    /**
     * @throws IllegalArgumentException caso o campo esteja vazio
     */
    public static void notNull(String text, String field) throws IllegalArgumentException{
        if (text == null || text.isEmpty() || text.isBlank())
            throw new IllegalArgumentException(field + " não pode ser nulo ou vazio");

    }
}
