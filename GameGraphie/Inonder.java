package GameGraphie;

import GameGraphie.App;
import GameGraphie.Carte;

import java.awt.image.BufferedImage;
import java.util.Random;
//Hériter de la classe de carte
public class Inonder extends Carte{
    BufferedImage img;
    int i,k;
    int nombreInonder=0;
    public Inonder(String inonder){
        img= App.getImg("/Img/Inonder.png");
        //Donnez une coordonnée initiale
        this.x=200;
        this.y=240;
        // la haute de l'image
        this.h=40;
        this.name=inonder;
        this.niveauEau=1;

    }
//Obtenez un nombre aléatoire
    Random cd = new Random();
//Obtenez des coordonnées aléatoires
    public void inonde(){
        Random cd = new Random();
            i = cd.nextInt(3);
            k = cd.nextInt(5);
    }
}
