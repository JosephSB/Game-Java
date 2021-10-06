package com.mycompany.game;

public class settings {
    private int volumen=-2;
    private boolean lenguage=false;
    // true = español , false=ingles
    
    public void setVol(int vol){this.volumen = vol;}
    public int getVol(){return volumen;}

    public boolean getLenguage() {
        return lenguage;
    }

    public void setLenguage(boolean lenguage) {
        this.lenguage = lenguage;
    }
    
    
}
