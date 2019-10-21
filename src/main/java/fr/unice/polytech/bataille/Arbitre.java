package fr.unice.polytech.bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Arbitre {
    private ArrayList<Joueur> joueurs;
    private Plateau plateau;


    public Arbitre(ArrayList<Joueur> joueurs, Plateau plateau) {
        this.joueurs = joueurs;
        this.plateau = plateau;
    }

    public int determinerNbPaquets() {
        return Math.round((float)joueurs.size()/2);
    }

    public void distribuerCartes(ArrayList<Carte> cartes) {
        Collections.shuffle(cartes);
        int i = 0;
        while (i < cartes.size()-joueurs.size()) {
            for(Joueur joueur : joueurs) {
                joueur.ajouterCarte(cartes.get(i++));
            }
        }
    }

    public void faireJouer(Joueur joueur) {
        joueur.jouerCarte();
    }

    public void definirVainqueur() {

    }
}
