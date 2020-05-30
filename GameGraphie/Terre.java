package GameGraphie;

import GameGraphie.App;
import GameGraphie.Carte;

import java.awt.image.BufferedImage;
//Hériter de la classe de carte
public class Terre extends Carte{
    //Initialisation image et artefact
    BufferedImage img;
    BufferedImage artefact;
    public Terre(String terre){
        img= App.getImg("/Img/A2.jpg");
        artefact=App.getImg("/Img/ArtefactTerre.png");
        //Donnez une coordonnée initiale
        this.x=200;
        this.y=200;
        this.name=terre;
        //Quantité d'Terre
        this.numcarte=2;
    }
}