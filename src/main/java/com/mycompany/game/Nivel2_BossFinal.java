package com.mycompany.game;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class Nivel2_BossFinal extends javax.swing.JFrame {
    int cont=0;
    public int puntajeMax = 750;
    public int score = 0; 
    public int Nivel = 1; 
    public int vida = 100;
    public int vidaBoss = 1100;
    //posicion del player
    private static int x=0; 
    private static int y=0;
    //clase ataque
    private int contAtacks=0;
    Atack[] atack = new Atack[1000];
    
    //CONSTRUCTOR
    public Nivel2_BossFinal() {
        initComponents();
        ZombieBoss.setVisible(false);
        ARMA.setVisible(false);
        VidaBossFinal.setVisible(false);
    }
    
    //funcion ataque
    public void atack(){
        atack[contAtacks] = new Atack();
        atack[contAtacks].setParams(ARMA, Player);
        atack[contAtacks].start();
    }
    //funciones otras
    public void setVida(int vida){
        this.vida = vida;
        ProgressVida.setValue(vida);
    }
    
    public void setScore(int score) {
        this.score = score;
        Score.setText(Integer.toString(score));
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public void setVidaBoss(int vidaBoss){
        this.vidaBoss = vidaBoss;
        VidaBossFinal.setValue(vidaBoss);
    }
    public int getVidaBoss(){
        return this.vidaBoss;
    }
    public void mostarVidaBoss(){
        VidaBossFinal.setVisible(true);
    }
    
    //funcion inicio de zombies 
    public void initZombies(){
        //ZombieBoss.setLocation(400,100);
        Zombies2 z1 = new Zombies2();
        z1.setParams(this,Zombie1,Zombie2,Zombie3,ARMA, puntajeMax, fuego, Player,ZombieBoss);
        z1.start();
    }
    //FUNCIONES DE SONIDO
    Clip musicaFondo_nivel2;
    public void songPrincipal(boolean op){
        try{
            if(op == true){
                musicaFondo_nivel2 = AudioSystem.getClip();
                musicaFondo_nivel2.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/SongNivel2.wav")));
                FloatControl gainControl = (FloatControl) musicaFondo_nivel2.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-2.0f);
                musicaFondo_nivel2.start();
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            System.out.println (new File (".").getAbsolutePath ());
        }
    }
    //funcion sonido bola de fuego
    Clip song_bola_fuego;
    public void songfuego(boolean op){
        try{
            if(op == true){
                song_bola_fuego = AudioSystem.getClip();
                song_bola_fuego.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/songBolaFuego.wav")));
                FloatControl gainControl = (FloatControl) song_bola_fuego.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-2.0f);
                song_bola_fuego.start();
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            System.out.println (new File (".").getAbsolutePath ());
        }
    }
    //funcion sonido boss final
    Clip song_boss_final;
    public void songBossFinal(boolean op){
        try{
            if(op == true){
                song_boss_final = AudioSystem.getClip();
                song_boss_final.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/songBossFinal.wav")));
                FloatControl gainControl = (FloatControl) song_boss_final.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-2.0f);
                song_boss_final.start();
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            System.out.println (new File (".").getAbsolutePath ());
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Level = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        LabelVida = new javax.swing.JLabel();
        LabelScore = new javax.swing.JLabel();
        LabelLevel = new javax.swing.JLabel();
        ProgressVida = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        VidaBossFinal = new javax.swing.JProgressBar();
        ZombieBoss = new javax.swing.JLabel();
        ARMA = new javax.swing.JLabel();
        Zombie2 = new javax.swing.JLabel();
        Player = new javax.swing.JLabel();
        Zombie1 = new javax.swing.JLabel();
        Zombie3 = new javax.swing.JLabel();
        fuego = new javax.swing.JLabel();
        Banner = new javax.swing.JLabel();
        Escenario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 510));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        Level.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        Level.setForeground(new java.awt.Color(255, 255, 255));
        Level.setText("2(FINAL)");
        getContentPane().add(Level);
        Level.setBounds(630, 10, 90, 40);

        Score.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        Score.setForeground(new java.awt.Color(255, 255, 255));
        Score.setText("0");
        getContentPane().add(Score);
        Score.setBounds(540, 10, 40, 40);

        LabelVida.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        LabelVida.setForeground(new java.awt.Color(255, 255, 255));
        LabelVida.setText("VIDA: ");
        getContentPane().add(LabelVida);
        LabelVida.setBounds(480, 40, 90, 40);

        LabelScore.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        LabelScore.setForeground(new java.awt.Color(255, 255, 255));
        LabelScore.setText("SCORE: ");
        getContentPane().add(LabelScore);
        LabelScore.setBounds(480, 10, 90, 40);

        LabelLevel.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        LabelLevel.setForeground(new java.awt.Color(255, 255, 255));
        LabelLevel.setText("LEVEL: ");
        getContentPane().add(LabelLevel);
        LabelLevel.setBounds(580, 10, 90, 40);

        ProgressVida.setBackground(new java.awt.Color(255, 0, 102));
        ProgressVida.setToolTipText("");
        ProgressVida.setValue(100);
        ProgressVida.setStringPainted(true);
        getContentPane().add(ProgressVida);
        ProgressVida.setBounds(530, 50, 140, 20);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        VidaBossFinal.setBackground(new java.awt.Color(0, 0, 0));
        VidaBossFinal.setForeground(new java.awt.Color(51, 204, 0));
        VidaBossFinal.setMaximum(1100);
        VidaBossFinal.setValue(1100);
        VidaBossFinal.setName(""); // NOI18N
        VidaBossFinal.setStringPainted(true);
        jPanel1.add(VidaBossFinal);
        VidaBossFinal.setBounds(490, 210, 200, 30);
        VidaBossFinal.getAccessibleContext().setAccessibleParent(this);

        ZombieBoss.setBackground(new java.awt.Color(204, 255, 0));
        ZombieBoss.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        ZombieBoss.setForeground(new java.awt.Color(0, 204, 153));
        ZombieBoss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ZombieBoss.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\BossFinal.png")); // NOI18N
        jPanel1.add(ZombieBoss);
        ZombieBoss.setBounds(450, -20, 250, 290);

        ARMA.setBackground(new java.awt.Color(204, 255, 0));
        ARMA.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        ARMA.setForeground(new java.awt.Color(0, 204, 153));
        ARMA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ARMA.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\arma1.png")); // NOI18N
        jPanel1.add(ARMA);
        ARMA.setBounds(0, 302, 60, 60);

        Zombie2.setBackground(new java.awt.Color(204, 255, 0));
        Zombie2.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Zombie2.setForeground(new java.awt.Color(0, 204, 153));
        Zombie2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Zombie2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\ZombieFace.png")); // NOI18N
        jPanel1.add(Zombie2);
        Zombie2.setBounds(700, 11, 60, 60);

        Player.setBackground(new java.awt.Color(255, 0, 51));
        Player.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Player.setForeground(new java.awt.Color(0, 204, 153));
        Player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\Personaje.png")); // NOI18N
        Player.setName(""); // NOI18N
        jPanel1.add(Player);
        Player.setBounds(0, 0, 60, 60);

        Zombie1.setBackground(new java.awt.Color(204, 255, 0));
        Zombie1.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Zombie1.setForeground(new java.awt.Color(0, 204, 153));
        Zombie1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Zombie1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\ZombieFace.png")); // NOI18N
        jPanel1.add(Zombie1);
        Zombie1.setBounds(694, 236, 60, 60);

        Zombie3.setBackground(new java.awt.Color(204, 255, 0));
        Zombie3.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Zombie3.setForeground(new java.awt.Color(0, 204, 153));
        Zombie3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Zombie3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\ZombieFace.png")); // NOI18N
        jPanel1.add(Zombie3);
        Zombie3.setBounds(694, 368, 60, 60);

        fuego.setBackground(new java.awt.Color(204, 255, 0));
        fuego.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        fuego.setForeground(new java.awt.Color(0, 204, 153));
        fuego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fuego.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\fuego.png")); // NOI18N
        jPanel1.add(fuego);
        fuego.setBounds(694, 236, 60, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 210, 760, 270);

        Banner.setFont(new java.awt.Font("Monsters Attack!", 1, 24)); // NOI18N
        Banner.setForeground(new java.awt.Color(255, 51, 51));
        Banner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Banner.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\Banner.png")); // NOI18N
        getContentPane().add(Banner);
        Banner.setBounds(0, 0, 700, 500);

        Escenario.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\Escenario2.png")); // NOI18N
        getContentPane().add(Escenario);
        Escenario.setBounds(0, 0, 700, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyChar() == 's'){
            if(y == 290){
                y= 0;
            }else{
                y= y+10;
            }
            Player.setLocation(x, y); 
        }else if(evt.getKeyChar() == 'd'){
            if(x == 600){
                x=0;
            }else{
                x= x+10; 
            }
            Player.setLocation(x, y); 
        }else if(evt.getKeyChar() == 'w'){
            if(y != 0){
                y= y-10;
                Player.setLocation(x, y); 
            } 
        }else if(evt.getKeyChar() == 'a'){
            if(x != 0){
                x= x-10;
                Player.setLocation(x, y); 
            }
        }else if(evt.getKeyChar() == 'k'){
            if(contAtacks > 0){
                if(atack[contAtacks-1].getEje() == false){
                    atack();
                    contAtacks++; 
                }
            }else{
                atack();
                contAtacks++;
            }
        }else if(evt.getKeyCode() == evt.VK_ENTER && cont==0){
            Banner.setVisible(false);
            initZombies();
            songPrincipal(true);
            cont++;
        }
        
    }//GEN-LAST:event_formKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nivel2_BossFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nivel2_BossFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nivel2_BossFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nivel2_BossFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nivel2_BossFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ARMA;
    private javax.swing.JLabel Banner;
    private javax.swing.JLabel Escenario;
    private javax.swing.JLabel LabelLevel;
    private javax.swing.JLabel LabelScore;
    private javax.swing.JLabel LabelVida;
    private javax.swing.JLabel Level;
    private javax.swing.JLabel Player;
    private javax.swing.JProgressBar ProgressVida;
    private javax.swing.JLabel Score;
    private javax.swing.JProgressBar VidaBossFinal;
    private javax.swing.JLabel Zombie1;
    private javax.swing.JLabel Zombie2;
    private javax.swing.JLabel Zombie3;
    private javax.swing.JLabel ZombieBoss;
    private javax.swing.JLabel fuego;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    void song_bola_fuego(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
