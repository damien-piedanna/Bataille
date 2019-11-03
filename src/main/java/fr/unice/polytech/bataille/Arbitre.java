package fr.unice.polytech.bataille;

import java.util.*;

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
 * Classe Arbitre
 */
public class Arbitre {

    //Attributs
    private ArrayList<Joueur> joueurs;
    private Plateau plateau;


    /**
     * Constructeur de la classe Arbitre
     * @param joueurs
     * @param plateau
     */
    public Arbitre(ArrayList<Joueur> joueurs, Plateau plateau) {
        this.joueurs = joueurs;
        this.plateau = plateau;
    }

    /**
     * Determiner le nombre de paquets a utiliser en fonction du nombre de joueurs
     * @return le nombre de paquets a utiliser
     */
    public int determinerNbPaquets() {
        return Math.round((float)joueurs.size()/2);
    }

    /**
     * Distribuer les cartes aux joueurs
     * @param cartes a distribuer
     */
    public void distribuerCartes(ArrayList<Carte> cartes) {
        Collections.shuffle(cartes);
        int i = 0;
        while (i < cartes.size()-joueurs.size()) {
            for(Joueur joueur : joueurs) {
                joueur.ajouterCarte(cartes.get(i++));
            }
        }
    }

    /**
     * Faire jouer les joueurs
     * @param joueur
     * @param nbBataille
     */
    public void faireJouer(Joueur joueur, int nbBataille) {
        if(nbBataille == 0 || plateau.getJoueursEnJeu().contains(joueur)) {
            Carte carteJoue = joueur.jouerCarte();
            System.out.println(joueur + " joue la carte " + carteJoue);
            plateau.addCarteEnJeu(joueur, carteJoue);
            plateau.addCartesJouees(carteJoue);
        }
    }

    /**
     * Definir le ou les vainqueurs du tour (ceux qui ont la plus grosse carte)
     * @return les joueurs vainqueurs
     */
    public ArrayList<Joueur> definirVainqueur() {
        ArrayList<Joueur> vainqueurs = new ArrayList<>();
        HashMap<Joueur, Carte> mainEnJeu = plateau.getMainEnJeu();

        TreeMap<Integer, Integer> slicedHand = new TreeMap<>();
        for(Map.Entry<Joueur, Carte> entry : plateau.getMainEnJeu().entrySet()) {
            Carte carte = entry.getValue();
            slicedHand.merge(carte.getValue(), 1, Integer::sum);
        }
        int nbJoueurBataille = 1;
        int meilleurValeurCarte = 1;

        //Quelle est la meilleur valeur et combien de personne l'ont ?
        for (int key : slicedHand.keySet()){
            if (slicedHand.get(key) > nbJoueurBataille) {
                meilleurValeurCarte = key;
                nbJoueurBataille = slicedHand.get(key);
            }
        }


        if(nbJoueurBataille > 1) { //Bataille
            for(Map.Entry<Joueur, Carte> entry : mainEnJeu.entrySet()) {
                Joueur joueur = entry.getKey();
                Carte carte  = entry.getValue();
                if(meilleurValeurCarte == carte.getValue()) {
                    vainqueurs.add(joueur);
                }
            }
        } else { //Pas Bataille
            for(Map.Entry<Joueur, Carte> entry : mainEnJeu.entrySet()) {
                Joueur joueur = entry.getKey();
                Carte carte  = entry.getValue();
                if(carte.getValue() > meilleurValeurCarte) {
                    vainqueurs.clear();
                    vainqueurs.add(joueur);
                    meilleurValeurCarte = carte.getValue();
                }
            }
        }
        return vainqueurs;
    }

    /**
     * Definir le vainqueur en fonction du nombre de cartes
     * @return les vainqueurs qui ont le plus grand nombre de cartes
     */
    public ArrayList<Joueur> definirVainqueurNbCartes() {
        ArrayList<Joueur> vainqueurs = new ArrayList<>();
        int nbCartesMax=0;
        for (Joueur joueur : plateau.getJoueursEnJeu()){
            int nbCartes=joueur.nbCartes();
            if (nbCartesMax<nbCartes)
                nbCartesMax=nbCartes;
        }
        for (Joueur joueur : plateau.getJoueursEnJeu()){
            if (joueur.nbCartes()==nbCartesMax)
                vainqueurs.add(joueur);
        }
        return vainqueurs;
    }
}
