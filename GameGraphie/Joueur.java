package GameGraphie;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Joueur{
    BufferedImage img;
    Random cd = new Random();
    private int a=cd.nextInt(5);
    private int b=cd.nextInt(6);
    int c=cd.nextInt(5);
    int x=200+a*100;//pour random la place X
    int y=200+b*80;//pour random la place Y
    int w=80;//width de joueur
    int h=80;//height de joueur
    int i;//pour fixer la place de joueur dans un tableau
    int j;//pour fixer la place de joueur dans un tableau
    int getCapacite;//pour caracteriser un joueur,il y a 5 caractere pour random donner 4 joueur
    int gagneAirCle=0;//2 gagneAircle dans un meme joueur pour avoir un artefactAir.
    int gagneEauCle=0;
    int gagneFeuCle=0;
    int gagneTerreCle=0;
    boolean utiliseCapaciteIngenieur=false;//pour verifier l'ingenieur qui peut assecher
    int restcapaciteIngenieur=2;//l'ingenieur peut just utiliser leur capacite 2 fois
    Boolean enleverEau=false;//pour verifier on peut enlever l'eau.
    Boolean obtenirCle=false;//pour recuperer la cle.
    int d,f;//mouseX,mouseY
    int k,m;//pour fixer la place de la souris dans un tableau

    Boolean Atoi;//pour verifier cest A lui se deplacer
    int restAction=3;//chaque joueur a 3 actions dans un tour.
    int joueurPlace[][]=new int[5][6];//losqu'on clic ce joueur,il deviens 1,cest A dire qu'il peut faire les chose,losqu'on clic l'eau,on peut directement enlever l'eau
    public Joueur(int m){//m est un numero pour caracteriser ce joueur
        this.m=getCapacite;
        img= App.getImg("/Img/J"+m+".png");//dessiner un joueur par rapport m
        i=(x-200)/100;
        j=(y-200)/80;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                joueurPlace[i][j]=0;
            }
        }


    }
    public  void action(int Ex,int Ey) {//cette fonction ,elle peut se  deplacer,aussi assecher l'eau
        if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] == 0) {//clic soit-meme,pour fixer,donc il faux clic deux fois pour se deplacer.
            joueurPlace[i][j] = 1;
            System.out.println( joueurPlace[i][j] +"baba");
        }else if ( Math.abs(Ex-(x+50))>50&&Math.abs(Ex-(x+50))<150&& Math.abs(Ey-(y+40))<40 && joueurPlace[i][j] == 1
                ||Math.abs(Ex-(x+50))<50 && Math.abs(Ey-(y+40))<120 &&Math.abs(Ey-(y+40))>40&& joueurPlace[i][j] == 1 ){//une action pour se deplacer
           joueurPlace[i][j]=0;
            this.x=Ex;
            this.y=Ey;
            i=(x-200)/100;
            j=(y-200)/80;
            this.x=200+i*100;
            this.y=200+j*80;
            restAction--;
            System.out.println("fois"+restAction);
        }else if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] ==1){//assecher l'eau losque l'eau est sur ce joueur.
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
            joueurPlace[i][j]=0;
        }else if(Math.abs(Ex-(x+50))<150&& Math.abs(Ey-(y+40))<40 && joueurPlace[i][j] == 0
                ||Math.abs(Ex-(x+50))<50 && Math.abs(Ey-(y+40))<120 && joueurPlace[i][j] == 0 ){
            //assecher l'eau losqu'il eau est en gauche ou A droit ou en haut ou en bas
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
        }
    }


    public void actionExplorateur(int Ex,int Ey){//presque meme avec fontion action(ex,ey), mais il peut se d´eplacer et ass´echer diagonalement.
        if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] == 0) {//clic soit-meme,pour fixer,donc il faux clic deux fois pour se deplacer.
            joueurPlace[i][j] = 1;
            System.out.println( joueurPlace[i][j] +"baba");
        }else if (Math.abs(Ex-(x+50))<150&& Math.abs(Ey-(y+40))<120 && joueurPlace[i][j] == 1){//une action pour se deplacer
            joueurPlace[i][j]=0;
            this.x=Ex;
            this.y=Ey;
            i=(x-200)/100;
            j=(y-200)/80;
            this.x=200+i*100;
            this.y=200+j*80;
            restAction--;
            System.out.println("fois"+restAction);
        }else if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] ==1){//assecher l'eau losque l'eau est sur ce joueur.
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
            joueurPlace[i][j]=0;
        }else if(Math.abs(Ex-(x+50))<150&& Math.abs(Ey-(y+40))<40 && joueurPlace[i][j] == 0
                ||Math.abs(Ex-(x+50))<50 && Math.abs(Ey-(y+40))<120 && joueurPlace[i][j] == 0 ){
            //assecher l'eau losqu'il eau est en gauche ou A droit ou en haut ou en bas
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
        }
    }


    public void recuper(int Ex,int Ey){//pour obtenir la cle
        if(Ex >= 740 && Ex <= 820 && Ey   >= 490 && Ey <= 520){
            this.obtenirCle=true;
            System.out.print(100);
        }
    }

    public void usecapaciteIngenieur(int Ex,int Ey){//pour utiliser  l'ingenieur d'une seule action
        this.d=Ex;
        this.f=Ey;
        this.k=(d-200)/100;
        this.m=(f-200)/80;
        utiliseCapaciteIngenieur=true;
    }

}
