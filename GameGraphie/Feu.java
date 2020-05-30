package GameGraphie;

import GameGraphie.App;
import GameGraphie.Carte;

import java.awt.image.BufferedImage;
//Hériter de la classe de carte
public class Feu extends Carte{
    public String name;
    //Initialisation image et artefact
    BufferedImage img;
    BufferedImage artefact;
    public Feu(String feu){
        img= App.getImg("/Img/A4.jpg");
        artefact=App.getImg("/Img/ArtefactFeu.png");
        //Donnez une coordonnée initiale
        this.x=200;
        this.y=200;
        this.name=feu;
        //Quantité d'Feu
        this.numcarte=2;
    }
}
