package com.timesheet.commons.domain;

public enum Authorities {
    USER,
    ADMIN;

    private Authorities() {
    }

    public static String[] names() {
        String[] names = new String[values().length];

        for(int index = 0; index < values().length; ++index) {
            names[index] = values()[index].name();
        }

        return names;
    }
}
