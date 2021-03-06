package fr.unice.polytech.bataille;

import java.util.ArrayList;


/**
 * ---------------------------------------------------------  *
 * Bataille - SI3                                             *
 *                                                            *
 * @author Damien Piedanna - damien.piedanna@univ-cotedazur.fr*
 * @author Xabi Merlo - xabi.merlo@univ-cotedazur.fr          *
 * @version Finale                                            *
 * ---------------------------------------------------------  *
 */

/**
 * Classe Jeu
 */
public class  Jeu {

    //Attributs
    private Plateau plateau = new Plateau();
    private Arbitre arbitre;
    private ArrayList<Joueur> joueurs;
    private int nbTours = 0;

    /**
     * Constructeur du jeu
     * @param nbJoueurs
     */
    public Jeu(int nbJoueurs) {
        joueurs = new ArrayList<>();
        for(int i = 0; i < nbJoueurs; i++) {
            joueurs.add(new Joueur("Joueur " + (i+1)));
        }
        arbitre = new Arbitre(joueurs, plateau);
    }

    /**
     * La liste des joueurs en jeu
     * @return la liste des joueurs en jeu
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    /**
     * Initialiser la partie (distribuer les cartes en fonction du nombre de joueurs)
     */
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
        loop();
    }

    /**
     * Enlever du jeu les joueurs qui n'ont plus de cartes
     */
    public void retirerJoueursSansCarte(){
        for(int i=0;i<joueurs.size();i++) {
            if (joueurs.get(i).nbCartes()==0){
                joueurs.remove(i);
                i--;
            }
        }
    }

    /**
     * Afficher ce qu'il s'est passé durant le tour
     * @param vainqueurs
     */
    public void afficherResultatsTour(ArrayList<Joueur> vainqueurs){
        System.out.println("Vainqueur du tour : " + vainqueurs.get(0));
        for(Carte carte : plateau.getCartesJouees()) {
            vainqueurs.get(0).ajouterCarte(carte);
        }
        plateau.getCartesJouees().clear();
        for(Joueur joueur : joueurs) {
            System.out.println(joueur+" a "+joueur.nbCartes()+" cartes.");
        }
    }

    /**
     * Loop principale du jeu, effectue les tours jusqu'à trouver un vainqueur
     */
    public void loop() {
        for(Joueur joueur : joueurs) {
            System.out.println(joueur+" a "+joueur.nbCartes()+" cartes.");
        }
        while (nbTours <= 100 && getJoueurs().size() > 1) {
            System.out.println("------------Tour "+nbTours+" -----------------------");
            tour();
            nbTours++;
        }
        while (getJoueurs().size() > 1){
            System.out.println("------------Tour "+nbTours+" -----------------------");
            tourNbCartes();
            nbTours++;
        }
        System.out.println("Vainqueur de la partie : "+getJoueurs().get(0));
    }

    /**
     * Jouer un tour
     */
    public void tour() {
        ArrayList<Joueur> vainqueurs;
        int nbBataille = 0;
        while(true) {
            for(Joueur joueur : joueurs) {
                if (joueur.nbCartes()>0)
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
        afficherResultatsTour(vainqueurs);
        retirerJoueursSansCarte();
    }

    /**
     * Jouer un tour et définir le vainqueur en fonction du nombre de cartes
     */
    public void tourNbCartes(){
        ArrayList<Joueur> vainqueurs;
        tour();
        vainqueurs=arbitre.definirVainqueurNbCartes();
        joueurs=vainqueurs;
    }

}
