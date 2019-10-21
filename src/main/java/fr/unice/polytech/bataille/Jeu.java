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


}
