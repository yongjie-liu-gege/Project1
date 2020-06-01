package GameGraphie;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;

public class GameFrame extends JFrame{
    private static boolean flag=true;
    public GameFrame(){
        //Définir le titre
        setTitle("L'Ile Interdite");
        //Définir la taille
        setSize(1000,915);
        //Définissez si la taille peut modifier
        setResizable(false);
        //Définir la méthode de sortie
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tool =Toolkit.getDefaultToolkit();
        Dimension d= tool.getScreenSize();
        setLocation((d.width-getWidth())/2,(d.height-getHeight())/2);
    }
    public static void main(String[] args){
        //Intialisation frame et panel
        GameFrame frame=new GameFrame();
        GamePanel panel= new GamePanel();
        JPanel control= new JPanel();
        //Utiliser la mothod de action
        panel.action();
        //Intialisation les boutons
        JButton recuperer=new JButton("récupérer");
        JButton fin=new JButton("fin du tour");
        JButton pasuse=new JButton("pause");
        JButton décollage=new JButton("décollage");
        JButton music = new JButton("Music");

        //Définir Layout de panel
        control.setLayout(null);

        //Définir la taille de  panel et bouton
        control.setPreferredSize(new Dimension(105,100));
        fin.setBounds(5,300,100,40);
        pasuse.setBounds(5,350,100,40);
        recuperer.setBounds(5,400,100,40);
        décollage.setBounds(5,450,100,40);
        music.setBounds(5, 650, 100, 100);

        control.setSize(50, 100);
        //Ajouter les bouton a panel
        control.add(recuperer);
        control.add(fin);
        control.add(décollage);
        control.add(pasuse);
        control.add(music);
        //Récrire les method de MouseListener (la condition de gagner)
        décollage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (panel.Joueurs.get(0).x==panel.Joueurs.get(1).x&&panel.Joueurs.get(1).x==panel.Joueurs.get(2).x&&panel.Joueurs.get(2).x==panel.Joueurs.get(3).x
                    &&panel.Joueurs.get(0).y==panel.Joueurs.get(1).y&&panel.Joueurs.get(1).y==panel.Joueurs.get(2).y&&panel.Joueurs.get(2).y==panel.Joueurs.get(3).y){
                    String x = "<html><body>" +  "<br/>"+"you are win   "+  "</body></html> ";
                    frame.remove(panel);
                    JLabel label = new JLabel(x);
                    label.setFont(new Font("Verdana", 1, 20));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setSize(panel.getSize());
                    frame.getContentPane().add(label);
                    frame.repaint();
                }else{JOptionPane.showMessageDialog(panel, "pas encore gagner");}
            }


            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        //Récrire les method de MouseListener (L'action de pause)
        pasuse.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int l = 0; l < panel.Joueurs.size(); l++) {
                    if (panel.Joueurs.get(l).Atoi && l < panel.Joueurs.size() - 1) {
                        panel.Joueurs.get(l).restAction = 0;
                        panel.Joueurs.get(l).Atoi = false;
                        panel.Joueurs.get(l + 1).Atoi = true;
                        break;

                    } else if (panel.Joueurs.get(l).Atoi && l == panel.Joueurs.size() - 1){
                        panel.Joueurs.get(l).restAction = 0;
                        panel.Joueurs.get(l).Atoi = false;
                        panel.Joueurs.get(0).Atoi = true;
                    }
                    else { System.out.println("skip");}
                }panel.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //Récrire les method de MouseListener (fin du tour)
        fin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Random cd = new Random();
                for (int i = 0; i <= 2; i++) {
                    panel.setQ(cd.nextInt(5));
                    panel.setW(cd.nextInt(6));
                    if (panel.niveauEAU[panel.getQ()][panel.getW()] < 1) {
                        panel.carteID[panel.getQ()][panel.getW()] = 2;
                        panel.niveauEAU[panel.getQ()][panel.getW()]++;
                    } else if (panel.niveauEAU[panel.getQ()][panel.getW()] == 1) {
                        panel.carteID[panel.getQ()][panel.getW()] = 3;
                        panel.niveauEAU[panel.getQ()][panel.getW()]++;
                    } else if (panel.niveauEAU[panel.getQ()][panel.getW()] == 2) {
                        i--;
                    }

                }
                panel.Ouvre=true;
                for(int o=0;o<panel.Joueurs.size();o++){
                    panel.Joueurs.get(o).restAction=3;
                }

                panel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}
            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });
        //Récrire les method de MouseListener (L'action de recuperer les cles)
        recuperer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int l = 0; l < panel.Joueurs.size(); l++) {
                    System.out.print(l);
                    if (panel.Joueurs.get(l).restAction > 0 && panel.Joueurs.get(l).Atoi) {
                        panel.Joueurs.get(l).obtenirCle=true;
                        if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.air.name) && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3 && panel.Joueurs.get(l).obtenirCle
                                || panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.eau.name) && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3 && panel.Joueurs.get(l).obtenirCle
                                || panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.feu.name) && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3 && panel.Joueurs.get(l).obtenirCle
                                || panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.terre.name) && panel.Joueurs.get(l).obtenirCle && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3) {
                            panel.Joueurs.get(l).obtenirCle = false;
                            panel.aqui = l;
                            if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.air.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.air.recuperCle++;
                                panel.Joueurs.get(l).gagneAirCle++;
                                panel.air.numcarte--;
                                panel.Joueurs.get(l).restAction--;
                            } else if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.eau.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.eau.recuperCle++;
                                panel.Joueurs.get(l).gagneEauCle++;
                                panel.eau.numcarte--;
                                panel.Joueurs.get(l).restAction--;
                            } else if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.feu.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.feu.recuperCle++;
                                panel.Joueurs.get(l).gagneFeuCle++;
                                panel.feu.numcarte--;
                                panel.Joueurs.get(l).restAction--;
                            } else if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.terre.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.terre.recuperCle++;
                                panel.Joueurs.get(l).gagneTerreCle++;
                                panel.terre.numcarte--;
                                panel.Joueurs.get(l).restAction--;
                            }
                        }
                    }if (panel.Joueurs.get(panel.aqui).restAction == 0 && panel.aqui <= panel.Joueurs.size() - 2) {
                        panel.Joueurs.get(panel.aqui + 1).Atoi = true;
                        panel.Joueurs.get(panel.aqui).Atoi = false;
                    } else if (panel.Joueurs.get(panel.aqui).restAction == 0 && panel.aqui == panel.Joueurs.size() - 1) {
                        panel.Joueurs.get(0).Atoi = true;
                        panel.Joueurs.get(panel.aqui).Atoi = false;
                    }
                }
                panel.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        music.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // changer l'etat de music
                if(flag==true){flag=false;}else {flag=true;}
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        // Définir la couleur d'arrière-plan
        control.setBackground(Color.lightGray);
        //Ajouter panel control et panel a frame
        frame.add(control,BorderLayout.EAST);
        frame.add(panel);
        // Fenêtre centrale
        frame.setLocationRelativeTo(null);
        //Fenêtre visible
        frame.setVisible(true);
        new Thread(() -> {
            while (true) {
                playMusic();
            }
        }).start();

    }
    static void playMusic() {

        //play music
        try {
            // setting file path
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("C:\\Users\\15242\\Desktop\\c学习课程\\5\\src\\Img\\Orbit.wav"));
            AudioFormat aif = ais.getFormat();
            final SourceDataLine sdl;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
            sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(aif);
            sdl.start();
            FloatControl fc = (FloatControl) sdl.getControl(FloatControl.Type.MASTER_GAIN);
            // value pour la music
            double value = 1.5;
            float dB = (float) (Math.log(value == 0.0 ? 0.0001 : value) / Math.log(10.0) * 20.0);
            fc.setValue(dB);
            int nByte = 0;
            int writeByte = 0;
            final int SIZE = 1024 * 64;
            byte[] buffer = new byte[SIZE];
            while (nByte != -1) {// play or pause etat

                if(flag) {

                    nByte = ais.read(buffer, 0, SIZE);

                    sdl.write(buffer, 0, nByte);

                }else {

                    nByte = ais.read(buffer, 0, 0);

                }

            }
            sdl.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
