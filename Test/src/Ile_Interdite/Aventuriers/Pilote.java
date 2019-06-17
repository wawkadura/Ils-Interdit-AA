/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ile_Interdite.Aventuriers;

import Ile_Interdite.Aventuriers.Aventurier;
import Ile_Interdite.Coordonnees;
import Ile_Interdite.Grille;
import Ile_Interdite.Tuile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author peyrinfl
 */
public class Pilote extends Aventurier {

    private boolean utilise;

    public Pilote(String nom, Tuile tuile) {
        super(nom, tuile);
        setUtilise(false);
    }

    public boolean CompetanceUtiliser() {
        return utilise;
    }

    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
    }

    @Override
    public void deplacer(Grille g) {
        if (!CompetanceUtiliser()) {
            System.out.println(this.getTuile().getCoordonnee().afficherCoord());
            TreeMap<Coordonnees, Tuile> tuilesVoisines = g.getTuiles();
            ArrayList<Tuile> Choix = new ArrayList<>();
            int numero = 0;
            for (Tuile T : tuilesVoisines.values()) {
                if (!T.getCoordonnee().afficherCoord().equals(super.getTuile().getCoordonnee().afficherCoord())) {
                    if (!T.getEtat().equals("Manquante")) {
                        numero++;
                        System.out.print(numero + " - Tuile disponible aux coordonnées : " + T.getCoordonnee().afficherCoord());
                        System.out.print(" Contenant : ");
                        for (Aventurier A : T.getAventuriers()) {
                            System.out.print(A.getNom() + " ");
                        }
                        System.out.println(" , Etat : " + T.getEtat());
                        Choix.add(T);
                    }
                }
            }
            System.out.print("Sur quelle tuile de 1 à " + numero + " voulez-vous vous déplacer ? (0 pour annuler) : ");
            Scanner scn = new Scanner(System.in);

            int dir = scn.nextInt();
            while (dir < 0 || dir > numero) {
                System.out.print("Veuillez taper une tuile disponible de 1 à " + numero + " (0 pour annuler):");
                dir = scn.nextInt();
            }

            if (dir == 0) {
                System.out.println("Annulation du déplacement...");
            } else {
               // g.getTuiles().get(super.getTuile().getCoordonnee()).suppAventurier(this);
                super.setTuile(g.getTuiles().get(Choix.get(dir - 1).getCoordonnee()));
               // g.getTuiles().get(Choix.get(dir - 1).getCoordonnee()).addAventurier(this);
                super.setActions(super.getActions() - 1);
            }
            utilise=true;
        } else {
            super.deplacer(g);
        }

    }

    @Override
    public void Reset() {
        setActions(3);
        setUtilise(false);
        setTerminer(false);
    }

    @Override
    public String getFonction() {
        return "\u001B[34m"+"Pilote";
    }
}