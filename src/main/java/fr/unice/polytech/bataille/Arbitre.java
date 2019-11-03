package fr.unice.polytech.bataille;

import java.util.*;

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

    public void faireJouer(Joueur joueur, int nbBataille) {
        if(nbBataille == 0 || plateau.getJoueursEnJeu().contains(joueur)) {
            Carte carteJoue = joueur.jouerCarte();
            System.out.println(joueur + " joue la carte " + carteJoue);
            plateau.addCarteEnJeu(joueur, carteJoue);
            plateau.addCartesJouees(carteJoue);
        }
    }

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
}
