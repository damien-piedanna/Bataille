package fr.unice.polytech.bataille;

import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
    private ArrayList<Carte> cartesJouees;
    private HashMap<Joueur, Carte> cartesEnJeu;

    public Plateau() {

    }

    public ArrayList<Carte> getCartesJouees() {
        return cartesJouees;
    }

    public HashMap<Joueur, Carte> getCartesEnJeu() {
        return cartesEnJeu;
    }
}
