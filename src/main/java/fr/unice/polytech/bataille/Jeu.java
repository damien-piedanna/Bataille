package fr.unice.polytech.bataille;

import java.util.ArrayList;

public class Jeu {

    private Plateau plateau = new Plateau();
    private Arbitre arbitre;
    private ArrayList<Joueur> joueurs;

    public Jeu(int nbJoueurs) {
        joueurs = new ArrayList<>();
        for(int i = 0; i < nbJoueurs; i++) {
            joueurs.add(new Joueur("Joueur " + (i+1)));
        }
        arbitre = new Arbitre(joueurs, plateau);
    }

    public void start() {
        int nbPaquets = arbitre.determinerNbPaquets();
        ArrayList<Carte> cartes = new ArrayList<>();
        for(int i = 0; i < nbPaquets*4; i++) {
            cartes.add(Carte.SEPT);
            cartes.add(Carte.HUIT);
            cartes.add(Carte.NEUF);
            cartes.add(Carte.DIX);
            cartes.add(Carte.AS);
        }
        arbitre.distribuerCartes(cartes);
        tour();
    }

    public void tour() {
        ArrayList<Joueur> vainqueurs;
        int nbBataille = 0;
        while(true) {
            for(Joueur joueur : joueurs) {
                arbitre.faireJouer(joueur, nbBataille);
            }
            vainqueurs = arbitre.definirVainqueur();
            for(Joueur joueur : joueurs) {
                if(!vainqueurs.contains(joueur)) {
                    plateau.supprimerJoueurEnJeu(joueur);
                }
            }
            if(plateau.getJoueursEnJeu().size() > 1) {
                nbBataille++;
                System.out.println("***** BATAILLE *****");
            } else {
                break;
            }
        }
        System.out.println("Vainqueur du tour : " + vainqueurs.get(0));
        for(Carte carte : plateau.getCartesJouees()) {
            vainqueurs.get(0).ajouterCarte(carte);
        }
    }

}
