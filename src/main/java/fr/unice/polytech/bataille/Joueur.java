package fr.unice.polytech.bataille;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Joueur {
    private String nom;
    private Plateau plateau;
    private Queue<Carte> cartes = new LinkedList<>();

    public Joueur(String nom) {
        this.nom = nom;
    }

    public void ajouterCarte(Carte nouvelleCarte) {
        cartes.add(nouvelleCarte);
    }

    public Carte jouerCarte() {
        return cartes.remove();
    }

    public void QuitterPartie() {

    }
}
