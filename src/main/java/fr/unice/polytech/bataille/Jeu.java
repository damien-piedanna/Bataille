package fr.unice.polytech.bataille;

import java.util.ArrayList;

public class Jeu {

    private Plateau plateau = new Plateau();
    private Arbitre arbitre;
    private ArrayList<Joueur> joueurs;

    public Jeu(int nbJoueurs) {
        joueurs = new ArrayList<>();
        for(int i = 0; i < nbJoueurs; i++) {
            joueurs.add(new Joueur("Joueur " + i));
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
    }
    
}
