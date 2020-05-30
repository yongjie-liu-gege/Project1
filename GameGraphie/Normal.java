package GameGraphie;

import GameGraphie.App;
import GameGraphie.Carte;

import java.awt.image.BufferedImage;
//Hériter de la classe de carte
public class Normal extends Carte{
    //Initialisation image
    BufferedImage img;
    public Normal(String  normal){
        img= App.getImg("/Img/A6.jpg");
        //Donnez une coordonnée initiale
        this.x=200;
        this.y=200;
        this.name=normal;
    }
}
