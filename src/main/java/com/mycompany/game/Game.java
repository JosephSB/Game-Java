package com.mycompany.game;
import java.io.File;
import static java.lang.Thread.sleep;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Game extends javax.swing.JFrame{
    public int puntajeMax = 1000;
    public int score = 0; 
    public int Nivel = 1; 
    public int vida = 100;
    Atack[] atack = new Atack[100];
    //POSICION DEL PLAYER
    private int x=0, y=0, cont=0,contAtacks=0;
    
    //song --> controla sonidos de win o fail
    Clip song;
    
    Clip song2; //song2 --> controla sonido de fondo del juego 
    public void songWIN(boolean op){
        try{
            if(op == true){
                song = AudioSystem.getClip();
                song.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/songWin.wav")));
                FloatControl gainControl = (FloatControl) song.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-2.0f);
                song.start();
            }else{
                song = AudioSystem.getClip();
                song.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/songFail.wav")));
                FloatControl gainControl = (FloatControl) song.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-2.0f);
                song.start();
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            System.out.println (new File (".").getAbsolutePath ());
        }
    }
    public void songPrincipal(boolean op){
        try{
            if(op == true){
                song2 = AudioSystem.getClip();
                song2.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/musicaFondo.wav")));
                FloatControl gainControl = (FloatControl) song2.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-2.0f);
                song2.start();
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            System.out.println (new File (".").getAbsolutePath ());
        }
    }
   
    
    
    public void animateWin(){
        IMG_BANNERINFO.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\WinIMG.png"));
        ScoreBanner.setText(Integer.toString(score));
        BannerInfo.setVisible(true);
        try{
           sleep((int)(4000)); 
           song2.close();
           this.setVisible(false);
           Nivel2_BossFinal main = new Nivel2_BossFinal();
           main.setVisible(true);
        }catch(InterruptedException e){
            System.out.println("ERROR: "+e);
        }
        
    }
    public void animateFail(){
        IMG_BANNERINFO.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\FailIMG.png"));
        ScoreBanner.setText(Integer.toString(score));
        BannerInfo.setVisible(true);
        try{
           sleep((int)(4000)); 
           BannerInfo.setVisible(false);
           song2.close();
           this.setVisible(false);
           Init vprincipal = new Init();
           vprincipal.setVisible(true);
           vprincipal.pantallacreditos();
        }catch(InterruptedException e){
            System.out.println("ERROR: "+e);
        }
        
    }
    
    public void setVida(int vida){
        this.vida = vida;
        jProgressBar1.setValue(vida);
    }
    
    public void setScore(int score) {
        this.score = score;
        Score.setText(Integer.toString(score));
    }
    
    public int getVida(){
        return this.vida;
    }
    
    
    public Game() {
        initComponents(); 
        System.out.println("ejecutando init");
        BannerInfo.setVisible(false);
        Zombie1.setVisible(false);
        Zombie2.setVisible(false);
        Zombie3.setVisible(false);
        ARMA.setVisible(false);
    }
    
    public void initZombies(){
        Zombies z1 = new Zombies();
        z1.setParams(this,Zombie1,Zombie2,Zombie3,ARMA, puntajeMax);
        z1.start();
    }
    public void atack(){
        atack[contAtacks] = new Atack();
        atack[contAtacks].setParams(ARMA, Player);
        atack[contAtacks].start();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BannerInfo = new javax.swing.JPanel();
        ScoreBanner = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        IMG_BANNERINFO = new javax.swing.JLabel();
        Banner = new javax.swing.JLabel();
        labeLevel = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ARMA = new javax.swing.JLabel();
        Player = new javax.swing.JLabel();
        Zombie2 = new javax.swing.JLabel();
        Zombie1 = new javax.swing.JLabel();
        Zombie3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        BannerInfo.setBackground(new java.awt.Color(255, 255, 255));
        BannerInfo.setOpaque(false);

        ScoreBanner.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ScoreBanner.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SCORE: ");

        IMG_BANNERINFO.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        IMG_BANNERINFO.setForeground(new java.awt.Color(255, 255, 255));
        IMG_BANNERINFO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IMG_BANNERINFO.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\WinIMG.png")); // NOI18N

        javax.swing.GroupLayout BannerInfoLayout = new javax.swing.GroupLayout(BannerInfo);
        BannerInfo.setLayout(BannerInfoLayout);
        BannerInfoLayout.setHorizontalGroup(
            BannerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerInfoLayout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addComponent(ScoreBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addComponent(IMG_BANNERINFO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BannerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BannerInfoLayout.createSequentialGroup()
                    .addGap(179, 179, 179)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(416, Short.MAX_VALUE)))
        );
        BannerInfoLayout.setVerticalGroup(
            BannerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BannerInfoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(IMG_BANNERINFO, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScoreBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(BannerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BannerInfoLayout.createSequentialGroup()
                    .addContainerGap(201, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(179, 179, 179)))
        );

        getContentPane().add(BannerInfo);
        BannerInfo.setBounds(0, 0, 700, 500);

        Banner.setFont(new java.awt.Font("Monsters Attack!", 1, 24)); // NOI18N
        Banner.setForeground(new java.awt.Color(255, 51, 51));
        Banner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Banner.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\Banner.png")); // NOI18N
        getContentPane().add(Banner);
        Banner.setBounds(0, 0, 700, 500);

        labeLevel.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        labeLevel.setForeground(new java.awt.Color(255, 255, 255));
        labeLevel.setText("1");
        getContentPane().add(labeLevel);
        labeLevel.setBounds(640, 10, 90, 40);

        Score.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        Score.setForeground(new java.awt.Color(255, 255, 255));
        Score.setText("0");
        getContentPane().add(Score);
        Score.setBounds(540, 10, 90, 40);

        jLabel4.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VIDA: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 40, 90, 40);

        jLabel3.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SCORE: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(480, 10, 90, 40);

        jLabel5.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LEVEL: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(590, 10, 90, 40);

        jProgressBar1.setBackground(new java.awt.Color(255, 0, 102));
        jProgressBar1.setToolTipText("");
        jProgressBar1.setValue(100);
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(530, 50, 140, 20);

        jLabel6.setFont(new java.awt.Font("Bebas", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LEVEL: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(590, 10, 90, 40);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        ARMA.setBackground(new java.awt.Color(204, 255, 0));
        ARMA.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        ARMA.setForeground(new java.awt.Color(0, 204, 153));
        ARMA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ARMA.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\arma1.png")); // NOI18N
        jPanel1.add(ARMA);
        ARMA.setBounds(610, 309, 60, 60);

        Player.setBackground(new java.awt.Color(204, 255, 0));
        Player.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Player.setForeground(new java.awt.Color(0, 204, 153));
        Player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\Personaje.png")); // NOI18N
        Player.setName(""); // NOI18N
        jPanel1.add(Player);
        Player.setBounds(0, 0, 60, 60);

        Zombie2.setBackground(new java.awt.Color(204, 255, 0));
        Zombie2.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Zombie2.setForeground(new java.awt.Color(0, 204, 153));
        Zombie2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Zombie2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\ZombieFace.png")); // NOI18N
        jPanel1.add(Zombie2);
        Zombie2.setBounds(610, 66, 60, 60);

        Zombie1.setBackground(new java.awt.Color(204, 255, 0));
        Zombie1.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Zombie1.setForeground(new java.awt.Color(0, 204, 153));
        Zombie1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Zombie1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\ZombieFace.png")); // NOI18N
        jPanel1.add(Zombie1);
        Zombie1.setBounds(610, 132, 60, 60);

        Zombie3.setBackground(new java.awt.Color(204, 255, 0));
        Zombie3.setFont(new java.awt.Font("Tech Headlines", 0, 8)); // NOI18N
        Zombie3.setForeground(new java.awt.Color(0, 204, 153));
        Zombie3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Zombie3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\ZombieFace.png")); // NOI18N
        jPanel1.add(Zombie3);
        Zombie3.setBounds(613, 309, 60, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(100, 210, 680, 380);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\Escenario.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if(evt.getKeyChar() == 's'){
            if(y == 290){
                y= 0;
            }else{
                y= y+10;
            }
        }else if(evt.getKeyChar() == 'd'){
            if(x == 600){
                x=0;
            }else{
                x= x+10; 
            }
        }else if(evt.getKeyChar() == 'w'){
            if(y != 0){
                y= y-10;
            } 
        }else if(evt.getKeyChar() == 'a'){
            if(x != 0){
                x= x-10;
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
        Player.setLocation(x, y); 
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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ARMA;
    private javax.swing.JLabel Banner;
    private javax.swing.JPanel BannerInfo;
    private javax.swing.JLabel IMG_BANNERINFO;
    private javax.swing.JLabel Player;
    private javax.swing.JLabel Score;
    private javax.swing.JLabel ScoreBanner;
    private javax.swing.JLabel Zombie1;
    private javax.swing.JLabel Zombie2;
    private javax.swing.JLabel Zombie3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labeLevel;
    // End of variables declaration//GEN-END:variables




}
