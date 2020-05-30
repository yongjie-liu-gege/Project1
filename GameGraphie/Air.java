package GameGraphie;

import java.awt.image.BufferedImage;
//Hériter de la classe de carte
public class Air extends Carte{
    //Initialisation image et artefact
    BufferedImage img;
    BufferedImage artefact;
    public Air(String air){
        img= App.getImg("/Img/A1.jpg");
        artefact=App.getImg("/Img/ArtefactAir.png");
        //Donnez une coordonnée initiale
        this.x=200;
        this.y=200;
        this.name=air;
        //Quantité d'Air
        this.numcarte=2;
    }
}
