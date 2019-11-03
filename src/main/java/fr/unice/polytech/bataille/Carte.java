package fr.unice.polytech.bataille;

/**
 * ---------------------------------------------------------  *
 * Bataille - SI3                                             *
 *                                                            *
 * @author Damien Piedanna - damien.piedanna@univ-cotedazur.fr*
 * @author Xabi Merlo - xabi.merlo@univ-cotedazur.fr          *
 * @version Finale                                            *
 * ---------------------------------------------------------  *
 */

/**
 * Classe Enumere Carte
 */
public enum Carte {

    SEPT("7", 7),
    HUIT("8", 8),
    NEUF("9", 9),
    DIX("10", 10),
    AS("AS", 11);

    private String nom;
    private int value;

    /**
     * Constructeur d'une carte
     * @param nom
     * @param value
     */
    Carte(String nom, int value) {
        this.nom = nom;
        this.value = value;
    }

    /**
     * Accesseur du nom de la carte
     * @return nom de la carte
     */
    public String getNom() {
        return nom;
    }

    /**
     * Accesseur de la valeur de la carte
     * @return la valeur de la carte
     */
    public int getValue() {
        return value;
    }

}
