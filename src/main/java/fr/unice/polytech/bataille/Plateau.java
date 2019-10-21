package fr.unice.polytech.bataille;

import java.util.ArrayList;

public class Plateau {
    private Arbitre arbitre;
    private ArrayList<Joueur> joueurs;

    public Plateau(int nbJoueurs) {
        for(int i = 0; i < nbJoueurs; nbJoueurs++) {
            joueurs.add(new Joueur("Joueur " + i));
        }
        arbitre = new Arbitre(nbJoueurs);

    }

    public void start() {

    }
}
