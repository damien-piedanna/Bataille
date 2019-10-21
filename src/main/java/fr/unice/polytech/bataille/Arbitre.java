package fr.unice.polytech.bataille;

import java.util.ArrayList;

public class Arbitre {
    private final int nbJoueurs;
    private ArrayList<Carte> cartes = new ArrayList<>();

    public Arbitre(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public void distribuerCarte() {

    }

    public void faireJouer(Joueur joueur) {
        joueur.jouerCarte();
    }

    public void definirVainqueur() {

    }
}
