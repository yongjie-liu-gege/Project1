package GameGraphie;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class App{
    public static BufferedImage getImg(String path){
        try{
            //Essayez d'obtenir le chemin de l'image
            BufferedImage Img = ImageIO.read(App.class.getResource(path));
            //Retour  une image
            return    Img;
        }  catch (IOException e){
            //Sinon, lancez une erreur
            e.printStackTrace();
        }
        return null;
    }
}
