package com.mycompany.game;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;


//clase parecida a zombie
public class Zombies2 extends Thread{
    public int puntajeMax;
    private javax.swing.JLabel Zombie1;
    private javax.swing.JLabel ZombieBoss;
    private javax.swing.JLabel Zombie2;
    private javax.swing.JLabel Zombie3;
    private javax.swing.JLabel fuego;
    private javax.swing.JLabel arma;
    private javax.swing.JLabel Player;
    private Nivel2_BossFinal g;
    
    private int score=0;
    private int vida=100;
    private int vidaBoss=1100;
    
    int contfuego=0;
    boolean ejecutando_fuego = false;
    boolean ejecutando_Boss = false;
    boolean ejecutando_juego = true;
    boolean ejecutando_juegoFinal = false;
    boolean boss_vencido = false;
    int Fuegox = 640, Fuegoy=20;
    
    //punto principal del zombie
    int cont=0, x1=640, x2=20;
    int cont2=0, xZ2=640, yZ2=20;
    int cont3=0, xZ3=640, yZ3=20;
    int cont4=0;
    //posicion del boss final 
    int Bossx = 640, Bossy= -15;
    
    @Override
    public void run(){
        Zombie1.setVisible(true);
        while(boss_vencido !=true && g.getVida() > 0){
            try{
                sleep((int)(100));
                Player.setOpaque(false);
                if(ejecutando_juego == true){
                    Zombie1.setLocation(x1, x2);
                    Zombie2.setLocation(xZ2,yZ2);
                    Zombie3.setLocation(xZ3,yZ3);
                    fuego.setLocation(Fuegox, Fuegoy);
                    Fuegox = Fuegox-20;
                    x1= x1-10;
                    xZ2= xZ2-10;
                    xZ3= xZ3-10;
                    colicion();
                }
                if(ejecutando_fuego == false){
                    contfuego++;
                }
                if(ejecutando_juegoFinal == true){
                    Fuegox = Fuegox-20;
                    fuego.setLocation(Fuegox, Fuegoy);
                    cont4++;
                    ZombieBoss.setLocation(Bossx, Bossy);
                    if(cont4 > 5){
                        cont4=0;
                        ZombieBoss.setLocation(Bossx-10, Bossy-10);
                    }
                    colicionBossFinal();
                }
                if(vidaBoss <=0){
                    boss_vencido = true;
                }
                if(ejecutando_Boss == true){
                    if(Bossx>=450){
                        Bossx = Bossx-1;
                        ZombieBoss.setLocation(Bossx, Bossy);
                    }else if( Bossx == 449){
                        Bossx = Bossx-1;
                        g.mostarVidaBoss();
                        
                        posicionarZombie(4);
                        fuego.setLocation(Fuegox, Fuegoy);
                        fuego.setVisible(true);
                        contfuego=0;
                        ejecutando_fuego = false;
                        ejecutando_juegoFinal = true;
                        
                        g.musicaFondo_nivel2.close();
                        g.songBossFinal(true);
                    }
                }
                if(contfuego == 5){
                    fuego.setVisible(true);
                    ejecutando_fuego = true;
                    posicionarZombie(4);
                    fuego.setLocation(Fuegox, Fuegoy);
                    g.songfuego(true);
                    contfuego = 0;
                }
                if(Fuegox<0){
                    ejecutando_fuego = false;
                }
                if(x1 < 0){
                    posicionarZombie(1);
                    vida = vida -10;
                    g.setVida(vida);
                }else if(xZ2< 0){
                    posicionarZombie(2);
                    vida = vida -10;
                    g.setVida(vida);
                }
                else if(xZ3< 0){
                    posicionarZombie(3);
                    vida = vida -10;
                    g.setVida(vida);
                }
                if(score>=puntajeMax && cont3 == 0){
                    cont3++;
                    ZombieBoss.setVisible(true);
                    ZombieBoss.setLocation(Bossx, Bossy);
                    ejecutando_Boss = true;
                    ejecutando_juego=false;
                    fuego.setVisible(false);
                    posicionarZombie(1);
                    posicionarZombie(2);
                    posicionarZombie(3);
                    Zombie1.setVisible(false);
                    Zombie2.setVisible(false);
                    Zombie3.setVisible(false);
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("termino el hilo");
        if(g.getVida() <= 0){
            JOptionPane.showMessageDialog(null, "PERDISTE, VUELVE A INTENTARLO :( ");
        }else if(boss_vencido == true){
            JOptionPane.showMessageDialog(null, "GANASTE, FELICITACIONES :) ");
        }
        TerminarJuego();
    }
    
    public void TerminarJuego(){
        g.setVisible(false);
        Init i = new Init();
        i.setVisible(true);
        i.pantallacreditos();
        g.song_boss_final.close();
    }
    public void colicionBossFinal(){
        int Px1=arma.getLocation().x;
        int Py1 = arma.getLocation().y;
        //Puntos del player
        int Playerx = Player.getLocation().x;
        int Playery = Player.getLocation().y;
        int Playerx2 = Player.getLocation().x+60;
        int Playery2 = Player.getLocation().y+60;
        
        if(Playerx>Fuegox && Fuegox+60 >Playerx && Playery > Fuegoy && Fuegoy +60 > Playery ){
            //colicion del fuego
            posicionarZombie(4);
            vida = vida -10;
            g.setVida(vida);
        }else if(Fuegox > Playerx && Playerx2 > Fuegox && Fuegoy > Playery && Playery2 > Fuegoy ){
            //colicion del fuego
            posicionarZombie(4);
            vida = vida -10;
            g.setVida(vida); 
            contfuego = 0;
            ejecutando_fuego = false;
            Player.setOpaque(true);
        }else if(Px1 > 449 && Px1 < 480 && Py1>30){
            //System.out.println(Px1);
            //System.out.println(ZombieBoss.getLocation().x);
            vidaBoss = vidaBoss-10;
            g.setVidaBoss(vidaBoss);
        }
    }
    
    public void colicion(){
       //puntos del arma
        int Px1=arma.getLocation().x;
        int Py1 = arma.getLocation().y;
        int Px2=arma.getLocation().x + 60;
        int Py2 = arma.getLocation().y +60;
        //Puntos del player
        int Playerx = Player.getLocation().x;
        int Playery = Player.getLocation().y;
        int Playerx2 = Player.getLocation().x+60;
        int Playery2 = Player.getLocation().y+60;
        
        //antigua condicion de colicion
        /*arma.getLocation().x < xZ3 && arma.getLocation().x+100 > xZ3*/  
        if(x1 > Px1 && Px2 > x1 && x2 > Py1 && Py2 >x2){
            posicionarZombie(1);
            score = score+20;
            g.setScore(score);
            if(cont2 == 0){
                moverZombie(1);
                moverZombie(2);
                cont2++;
           }
        }else if(Px1>x1 && x1+60 > Px1 && Py1 > x2 && x2+60 > Py1 ){
            posicionarZombie(1);
            score = score+20;
            g.setScore(score);
            if(cont2 == 0){
                moverZombie(1);
                moverZombie(2);
                cont2++;
           }
        }else if( xZ2 > Px1 && Px2 > xZ2 && yZ2 > Py1 && Py2 >yZ2){
            posicionarZombie(2);
            score = score+20;
            g.setScore(score);
        }else if(Px1>xZ2 && xZ2+60 > Px1 && Py1 > yZ2 && yZ2+60 > Py1){
            posicionarZombie(2);
            score = score+20;
            g.setScore(score);
        }else if(xZ3 > Px1 && Px2 > xZ3 && yZ3 > Py1 && Py2 >yZ3){
            posicionarZombie(3);
            score = score+20;
            g.setScore(score);
        }else if(Px1>xZ3 && xZ3+60 > Px1 && Py1 > yZ3 && yZ3+60 > Py1){
            posicionarZombie(3);
            score = score+20;
            g.setScore(score);
        }else if(Playerx>Fuegox && Fuegox+60 >Playerx && Playery > Fuegoy && Fuegoy +60 > Playery ){
            //colicion del fuego
            posicionarZombie(4);
            vida = vida -10;
            g.setVida(vida);
        }else if(Fuegox > Playerx && Playerx2 > Fuegox && Fuegoy > Playery && Playery2 > Fuegoy ){
            //colicion del fuego
            posicionarZombie(4);
            vida = vida -10;
            g.setVida(vida); 
            contfuego = 0;
            ejecutando_fuego = false;
            Player.setOpaque(true);
        }
        
    }
    
    public void moverZombie(int n){
        if(n == 1){
            Zombie2.setVisible(true);
            posicionarZombie(2);
        }else if(n == 2){
            Zombie3.setVisible(true);
            posicionarZombie(3);  
        }
    }
    
    public void posicionarZombie(int n){
        if(n == 1){
            x1=(int) Math.round(620 + (Math.random()*(720-620)));
            x2=(int) Math.round(20 + (Math.random()*(210-20)));
        } else if(n == 2){
            xZ2=(int) Math.round(620 + (Math.random()*(720-620)));
            yZ2=(int) Math.round(20 + (Math.random()*(210-20)));
        } else if(n == 3){
            xZ3=(int) Math.round(620 + (Math.random()*(720-620)));
            yZ3=(int) Math.round(20 + (Math.random()*(210-20)));
        } else if(n==4){
            //posiciona en x, y al fuego
            Fuegox = (int) Math.round(620 + (Math.random()*(720-620)));
            Fuegoy=(int) Math.round(20 + (Math.random()*(210-20)));
        }
    }
    
    public void setParams(Nivel2_BossFinal g, javax.swing.JLabel Zombie,javax.swing.JLabel Zombie2,javax.swing.JLabel Zombie3,javax.swing.JLabel arma, int puntajemax,javax.swing.JLabel fuego,javax.swing.JLabel Player,javax.swing.JLabel ZombieBoss){
        this.g= g;
        this.Zombie1 = Zombie;
        this.Zombie2 = Zombie2;
        this.Zombie3 = Zombie3;
        this.arma = arma;
        this.puntajeMax = puntajemax;
        this.fuego = fuego;
        this.Player= Player;
        this.ZombieBoss = ZombieBoss;
    }
}
