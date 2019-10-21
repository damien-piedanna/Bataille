package fr.unice.polytech.bataille;

public enum Carte {

    SEPT("7", 7),
    HUIT("8", 8),
    NEUF("9", 9),
    DIX("10", 10),
    AS("AS", 11);

    private String nom;
    private int value;

    Carte(String nom, int value) {
        this.nom = nom;
        this.value = value;
    }

    public String getNom() {
        return nom;
    }

    public int getValue() {
        return value;
    }

}
