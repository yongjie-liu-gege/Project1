package GameGraphie;

import GameGraphie.App;
import GameGraphie.Carte;

import java.awt.image.BufferedImage;
//Hériter de la classe de carte
public class Eau extends Carte{
    public String name;
    //Initialisation image et artefact
    BufferedImage img;
    BufferedImage artecfact;
    public Eau(String eau){
        img= App.getImg("/Img/A3.jpg");
        artecfact=App.getImg("/Img/ArtefactEau.png");
        //Donnez une coordonnée initiale
        this.x=200;
        this.y=200;
        this.name=eau;
        //Quantité d'Eau
        this.numcarte=2;
    }
}
