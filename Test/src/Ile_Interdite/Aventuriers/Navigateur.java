/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ile_Interdite.Aventuriers;

import Ile_Interdite.Aventuriers.Aventurier;
import Ile_Interdite.Tuile;

/**
 *
 * @author peyrinfl
 */
public class Navigateur extends Aventurier {
    
    public Navigateur(String nom, Tuile tuile) {
        super(nom, tuile);
        super.setActions(4);
    }

    @Override
    public String getFonction() {
        return  "Navigateur";
    }
}
