package GameGraphie;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class panel extends JPanel{
    BufferedImage pd;
    public panel(GameFrame gameFrame) {
        setBackground(Color.pink);

        pd = App.getImg("/Img/Blackground.jpg");
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(pd,0,0,null);
    }
}
