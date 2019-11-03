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
 * Classe Main du projet
 */
public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu(5);
        jeu.start();
    }
}