package com.mycompany.game;
import static java.lang.Thread.sleep;

// clase zombie
public class Zombies extends Thread{
    public int puntajeMax;
    private javax.swing.JLabel Zombie1;
    private javax.swing.JLabel Zombie2;
    private javax.swing.JLabel Zombie3;
    private javax.swing.JLabel arma;
    private Game g;
    
    private int score=0;
    private int vida=100;
    
    //punto principal del zombie
    int cont=0, x1=640, x2=20;
    int cont2=0, xZ2=640, yZ2=20;
    int cont3=0, xZ3=640, yZ3=20;
    
    @Override
    public void run(){
        Zombie1.setVisible(true);
        while(score<puntajeMax && g.getVida() > 0){
            try{
                sleep((int)(100));
                Zombie1.setLocation(x1, x2);
                Zombie2.setLocation(xZ2,yZ2);
                Zombie3.setLocation(xZ3,yZ3);
                x1= x1-10;
                xZ2= xZ2-10;
                xZ3= xZ3-10;
                colicion();
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
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("termino el hilo");
        if(score>=puntajeMax){
            g.songWIN(true);
            g.animateWin();
            score=0;
            vida=100;
        }else if(g.getVida() <= 0){
            g.songWIN(false);
            g.animateFail();
            score=0;
            vida=100;
        }
        posicionarZombie(1);
        posicionarZombie(2);
        posicionarZombie(3);
        Zombie1.setVisible(false);
        Zombie2.setVisible(false);
        Zombie3.setVisible(false);
    }
    
    public void colicion(){
       //puntos del arma
        int Px1=arma.getLocation().x;
        int Py1 = arma.getLocation().y;
        int Px2=arma.getLocation().x + 60;
        int Py2 = arma.getLocation().y +60;
        //Puntos secundarios de los zombies
        
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
        } 
    }
    
    public void setParams(Game g, javax.swing.JLabel Zombie,javax.swing.JLabel Zombie2,javax.swing.JLabel Zombie3,javax.swing.JLabel arma, int puntajemax){
        this.g= g;
        this.Zombie1 = Zombie;
        this.Zombie2 = Zombie2;
        this.Zombie3 = Zombie3;
        this.arma = arma;
        this.puntajeMax = puntajemax;
    }
}
