/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ile_Interdite.Aventuriers;

/**
 *
 * @author wawve
 */
public class TresorsRecupere {
    private boolean La_Statue_du_Zéphyr=false;
    private boolean La_Pierre_Sacrée=false;
    private boolean Le_Cristal_Ardent=false;
    private boolean Le_Calice_de_Londe=false;
    
    public boolean isAllCollected(){
        return La_Statue_du_Zéphyr && La_Pierre_Sacrée && Le_Cristal_Ardent && Le_Calice_de_Londe;
    
    }
    public void tresorsCollecte(){
        System.out.println("Les Tresors Recupere :");
        if (La_Statue_du_Zéphyr){
        System.out.println("\t - La Statue du Zéphyr");}
        if (La_Pierre_Sacrée){
        System.out.println("\t - La Pierre Sacrée");}
        if (Le_Cristal_Ardent){
        System.out.println("\t - Le Cristal Ardent");}
        if (Le_Calice_de_Londe){
        System.out.println("\t - Le Calice de L'onde");}
    
    }
    public void setStatue(boolean La_Statue_du_Zéphyr) {
        this.La_Statue_du_Zéphyr = La_Statue_du_Zéphyr;
    }

    public void setPierre(boolean La_Pierre_Sacrée) {
        this.La_Pierre_Sacrée = La_Pierre_Sacrée;
    }

    public void setCristal(boolean Le_Cristal_Ardent) {
        this.Le_Cristal_Ardent = Le_Cristal_Ardent;
    }

    public void setCalice(boolean Le_Calice_de_Londe) {
        this.Le_Calice_de_Londe = Le_Calice_de_Londe;
    }
    
}