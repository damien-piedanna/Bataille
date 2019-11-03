package fr.unice.polytech.bataille;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
 * Classe Plateau
 */
public class Plateau {
    //Attributs
    private ArrayList<Carte> cartesJouees = new ArrayList<>();
    private HashMap<Joueur, Carte> mainEnJeu = new HashMap<>();

    /**
     * Constructeur par defaut de la classe plateau
     */
    public Plateau() {
    }

    /**
     * Accesseur de la liste de cartes jouees
     * @return la liste de cartes jouees
     */
    public ArrayList<Carte> getCartesJouees() {
        return cartesJouees;
    }

    /**
     * Accesseur de la liste de la main en jeu
     * @return la liste de la main en jeu
     */
    public HashMap<Joueur, Carte> getMainEnJeu() {
        return mainEnJeu;
    }

    /**
     * Accesseur de la liste des joueurs en jeu
     * @return la liste des joueurs en jeu
     */
    public ArrayList<Joueur> getJoueursEnJeu() {
        ArrayList<Joueur> joueursEnJeu = new ArrayList<>();
        for(Map.Entry<Joueur, Carte> entry : mainEnJeu.entrySet()) {
            joueursEnJeu.add(entry.getKey());
        }
        return joueursEnJeu;
    }

    /**
     * Ajouter une carte en jeu
     * @param joueur
     * @param carte
     */
    public void addCarteEnJeu(Joueur joueur, Carte carte) {
        mainEnJeu.put(joueur, carte);
    }

    /**
     * Ajouter une carte qui a ete joue
     * @param carte
     */
    public void addCartesJouees(Carte carte) {
        cartesJouees.add(carte);
    }

    /**
     * Supprimer un joueur en jeu
     * @param joueur
     */
    public void supprimerJoueurEnJeu(Joueur joueur) {
        mainEnJeu.remove(joueur);
    }
}
