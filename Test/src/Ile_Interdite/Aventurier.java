/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ile_Interdite;

/**
 *
 * @author peyrinfl
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class Aventurier {

    private String nom;
    private int actions = 3;
    private Tuile tuile;
    private ArrayList<CarteTrésor> cartesEnMain = new ArrayList<>();
    private boolean terminer = false;

    Aventurier(String nom, Tuile tuile) {
        this.setNom(nom);
        this.tuile = tuile;
        tuile.addAventurier(this);
    }

    public String getNom() {
        return nom;
    }

    public Tuile getTuile() {
        return tuile;
    }

    public int getActions() {
        return actions;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    public void deplacer(Grille g) {
        System.out.println(this.getTuile().getCoordonnee().afficherCoord());
        TreeMap<Coordonnees, Tuile> tuilesVoisines = g.getTuilesVoisines(getTuile());
        ArrayList<Tuile> Choix = new ArrayList<>();

        int numero = 0;
        for (Tuile T : tuilesVoisines.values()) {
            if (!T.getEtat().equals("manquant")) {
                numero++;
                System.out.print(numero + " - Tuile disponible au coordonnees : " + T.getCoordonnee().afficherCoord());
                System.out.print(" Contenant : ");
                for (Aventurier A : T.getAventuriers()) {
                    System.out.print(A.getNom() + " ");
                }
                System.out.println(" , Etat : " + T.getEtat());
                Choix.add(T);
            }
        }
        System.out.print("Sur quelle Tuile de 1 à " + numero + " voulez vous vous deplacer ? (0 pour annuler) : ");
        Scanner scn = new Scanner(System.in);

        int dir = scn.nextInt();
        while (dir < 0 || dir > numero) {
            System.out.print("Veuillez tapper une tuile Disponible de 1 à " + numero + " (0 pour annuler):");
            dir = scn.nextInt();
        }

        if (dir == 0) {
            System.out.println("Annulation du deplacement...");
        } else {
            // g.getTuiles().get(this.tuile.getCoordonnee()).suppAventurier(this);
            setTuile(g.getTuiles().get(Choix.get(dir - 1).getCoordonnee()));
            // g.getTuiles().get(Choix.get(dir - 1).getCoordonnee()).addAventurier(this);
            this.actions = this.actions - 1;
        }

    }

    public void assecher(Grille g) {

        System.out.println(this.getTuile().getCoordonnee().afficherCoord());
        TreeMap<Coordonnees, Tuile> tuilesVoisines = g.getTuilesVoisines(getTuile());
        ArrayList<Tuile> Choix = new ArrayList<>();
        tuilesVoisines.put(getTuile().getCoordonnee(), getTuile());
        int numero = 0;
        for (Tuile T : tuilesVoisines.values()) {
            if (!T.getEtat().equals("manquant") && T.getEtat().equals("innonder")) {
                numero++;
                System.out.print(numero + " - Tuile au coordonnees : " + T.getCoordonnee().afficherCoord());
                System.out.print(" Contenant : ");
                for (Aventurier A : T.getAventuriers()) {
                    System.out.print(A.getNom() + " ");
                }
                System.out.println(" , Etat : " + T.getEtat());
                Choix.add(T);
            }

        }
        if (!Choix.isEmpty()) {
            System.out.print("Quelle Tuile de 1 à " + numero + " voulez vous assecher ? (0 pour annuler) : ");
            Scanner scn = new Scanner(System.in);

            int dir = scn.nextInt();
            while (dir < 0 || dir > numero) {
                System.out.print("Veuillez tapper une tuile innonder de 1 à " + numero + " (0 pour annuler):");
                dir = scn.nextInt();
            }

            if (dir == 0) {
                System.out.println("Annulation de l'assechement...");
            } else {
                // g.getTuiles().get(this.tuile.getCoordonnee()).suppAventurier(this);
                g.getTuiles().get(Choix.get(dir - 1).getCoordonnee()).setEtat(0);
                // g.getTuiles().get(Choix.get(dir - 1).getCoordonnee()).addAventurier(this);
                this.actions = this.actions - 1;
            }
        } else {
            System.out.println("aucune tuile voisine peux etre assecher");
        }

    }

    public void donner(CarteTrésor carte, Aventurier joueur) {

    }

    public void setTuile(Tuile tuile) {
        if (this.tuile.getAventuriers().contains(this)) {
            this.tuile.suppAventurier(this);
        }
        this.tuile = tuile;
        tuile.addAventurier(this);
    }

    public void gagnerTresor(Tuile tuile) {

    }

    public boolean isTourTerminer() {
        return terminer;
    }

    public void tourTermine() {

        setTerminer(true);
        System.out.println("Tour de " + getNom() + " Terminer ! ");
    }

    public void setTerminer(boolean tourTerminer) {
        this.terminer = tourTerminer;
    }

    public void Reset() {
        setActions(3);
        setTerminer(false);
    }

    public String getFonction() {
        return null;
    }

}
