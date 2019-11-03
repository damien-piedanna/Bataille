package fr.unice.polytech.bataille;

import java.util.LinkedList;
import java.util.Queue;

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
 * Classe Joueur
 */
public class Joueur {

    //Attributs
    private String nom;
    private Plateau plateau;
    private Queue<Carte> cartes = new LinkedList<>();

    /**
     * Constructeur de la classe joueur
     * @param nom
     */
    public Joueur(String nom) {
        this.nom = nom;
    }

    /**
     * Ajouter une carte au paquet de cartes du joueur
     * @param nouvelleCarte
     */
    public void ajouterCarte(Carte nouvelleCarte) {
        cartes.add(nouvelleCarte);
    }

    /**
     * Jouer une carte (la retourner et l'enlever du paquet)
     * @return carte
     */
    public Carte jouerCarte() {
        return cartes.remove();
    }

    /**
     * Retourner le nombre de cartes du paquet
     * @return le nombre de cartes du paquet
     */
    public int nbCartes(){ return cartes.size(); }


    /**
     * Afficher le nom du joueur
     * @return le nom du joueur
     */
    @Override
    public String toString() {
        return nom;
    }
}
