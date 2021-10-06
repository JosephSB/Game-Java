package com.mycompany.game;
import static java.lang.Thread.sleep;

//clase ataque del jugador
public class Atack extends Thread{
    private javax.swing.JLabel ARMA;
    private int x,y;
    private int var;
    volatile boolean eje = true;
    
    @Override
    public void run(){
        ARMA.setVisible(true);
        while((var+300)>x  && eje== true){
            try{
                sleep((int)(100));
                ARMA.setLocation(x, y);
                x= x+20;
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        eje=false;
        ARMA.setVisible(false);
        ARMA.setLocation(0,0);
    }
    public boolean getEje() {
        return eje;
    }
    
    public void setParams(javax.swing.JLabel ARMA,javax.swing.JLabel Player){
        this.ARMA = ARMA;
        this.x = Player.getLocation().x;
        this.y = Player.getLocation().y;
        this.var=x;
    }
}
