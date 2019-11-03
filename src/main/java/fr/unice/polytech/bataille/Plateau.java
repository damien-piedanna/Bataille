package fr.unice.polytech.bataille;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
    private ArrayList<Carte> cartesJouees = new ArrayList<>();
    private HashMap<Joueur, Carte> mainEnJeu = new HashMap<>();

    public Plateau() {
    }

    public ArrayList<Carte> getCartesJouees() {
        return cartesJouees;
    }

    public HashMap<Joueur, Carte> getMainEnJeu() {
        return mainEnJeu;
    }

    public ArrayList<Joueur> getJoueursEnJeu() {
        ArrayList<Joueur> joueursEnJeu = new ArrayList<>();
        for(Map.Entry<Joueur, Carte> entry : mainEnJeu.entrySet()) {
            joueursEnJeu.add(entry.getKey());
        }
        return joueursEnJeu;
    }

    public void addCarteEnJeu(Joueur joueur, Carte carte) {
        mainEnJeu.put(joueur, carte);
    }

    public void addCartesJouees(Carte carte) {
        cartesJouees.add(carte);
    }

    public void supprimerJoueurEnJeu(Joueur joueur) {
        mainEnJeu.remove(joueur);
    }
}
