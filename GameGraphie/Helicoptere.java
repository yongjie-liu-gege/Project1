package GameGraphie;

import GameGraphie.App;
import GameGraphie.Carte;

import java.awt.image.BufferedImage;
//Hériter de la classe de carte
public class Helicoptere extends Carte{
    public String name;
    //Initialisation image
    BufferedImage img;
    public Helicoptere(String helico){
        img= App.getImg("/Img/A7.jpg");
        //Donnez une coordonnée initiale
        this.x=200;
        this.y=200;
        this.name=helico;
    }
}
