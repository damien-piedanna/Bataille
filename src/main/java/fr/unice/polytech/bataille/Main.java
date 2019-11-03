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
        int nbTours = 1;
        jeu.start();
        while (nbTours <= 100 && jeu.getJoueurs().size() > 1) {
            System.out.println("------------Tour "+nbTours+" -----------------------");
            jeu.tour();
            nbTours++;
        }
        while (jeu.getJoueurs().size() > 1){
            System.out.println("------------Tour "+nbTours+" -----------------------");
            jeu.tourNbCartes();
            nbTours++;
        }
        System.out.println("Vainqueur de la partie : "+jeu.getJoueurs().get(0));
    }
}