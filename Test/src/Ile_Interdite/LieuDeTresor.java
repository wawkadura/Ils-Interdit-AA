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
public class LieuDeTresor extends Tuile {
    private String type;

    public LieuDeTresor(Coordonnees C , String type) {
        super(C);
        this.type=type;
    }

    public String getType() {
        return type;
    }

}
