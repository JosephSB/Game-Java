package com.mycompany.game;
import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Init extends javax.swing.JFrame {
    //funcion que realiza un settimeout
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
    

    settings config = new settings();
    
    public Init() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\ZombieFace.png"));
        songPrincipal(true);
        Btn_Options.setVisible(false);
        Btn_charac.setVisible(false);
        Btn_play.setVisible(false);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\IntroBanner.jpg"));
    }
    Clip song;

    public void songPrincipal(boolean op){
        try{
            if(op == true){
                song = AudioSystem.getClip();
                song.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/Korn-SongInicio.wav")));
                FloatControl gainControl = (FloatControl) song.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-2.0f);
                song.start();
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            System.out.println (new File (".").getAbsolutePath ());
        }
    }
    
    public void sonar(boolean op){
        Clip hover;
        try{
            if(op == true){
                hover = AudioSystem.getClip();
                hover.open(AudioSystem.getAudioInputStream(new File("C:/Users/Josehp/Documents/NetBeansProjects/Game/src/main/java/sounds/hoverSound.wav")));
                hover.start();
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Options = new java.awt.Button();
        Btn_play = new java.awt.Button();
        Btn_charac = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zombie Hunter");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(null);

        Btn_Options.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Btn_Options.setFont(new java.awt.Font("DK Honeyguide Caps", 0, 24)); // NOI18N
        Btn_Options.setLabel("OPTIONS");
        Btn_Options.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_OptionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_OptionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_OptionsMouseExited(evt);
            }
        });
        Btn_Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OptionsActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Options);
        Btn_Options.setBounds(260, 380, 210, 60);

        Btn_play.setBackground(new java.awt.Color(255, 255, 255));
        Btn_play.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Btn_play.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        Btn_play.setLabel("PLAY");
        Btn_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_playMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_playMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_playMouseExited(evt);
            }
        });
        getContentPane().add(Btn_play);
        Btn_play.setBounds(260, 240, 210, 60);

        Btn_charac.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Btn_charac.setFont(new java.awt.Font("DK Honeyguide Caps", 0, 24)); // NOI18N
        Btn_charac.setLabel("CHARACTERS");
        Btn_charac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_characMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_characMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_characMouseExited(evt);
            }
        });
        Btn_charac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_characActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_charac);
        Btn_charac.setBounds(260, 310, 210, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\PROGRAMAS\\NetBeans\\NetbeansProjects\\Game\\src\\main\\java\\img\\fondo.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void verificarIdioma(boolean lengua){
        if(lengua){
            Btn_Options.setLabel("OPCIONES");
            Btn_play.setLabel("JUGAR");
            Btn_charac.setLabel("PERSONAJES");
        }else{
            Btn_Options.setLabel("OPTIONS");
            Btn_play.setLabel("PLAY");
            Btn_charac.setLabel("CHARACTERS");
        }
    }
    private void Btn_OptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_OptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_OptionsActionPerformed

    private void Btn_characActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_characActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_characActionPerformed

    private void Btn_playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_playMouseEntered

        sonar(true);
        Btn_play.setBackground(new java.awt.Color(51, 102, 255));
    }//GEN-LAST:event_Btn_playMouseEntered

    private void Btn_characMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_characMouseEntered

        sonar(true);
        Btn_charac.setBackground(new java.awt.Color(51, 102, 255));
    }//GEN-LAST:event_Btn_characMouseEntered

    private void Btn_OptionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_OptionsMouseEntered
        sonar(true);
        Btn_Options.setBackground(new java.awt.Color(51, 102, 255));
    }//GEN-LAST:event_Btn_OptionsMouseEntered

    private void Btn_playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_playMouseExited
        Btn_play.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_Btn_playMouseExited

    private void Btn_characMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_characMouseExited
        Btn_charac.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_Btn_characMouseExited

    private void Btn_OptionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_OptionsMouseExited
        Btn_Options.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_Btn_OptionsMouseExited

    private void Btn_OptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_OptionsMouseClicked
        Options op = new Options(config, song, this);
        op.setVisible(true);
        //verificarIdioma(config.getLenguage());
        song.stop();    
    }//GEN-LAST:event_Btn_OptionsMouseClicked

    private void Btn_characMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_characMouseClicked
        Characters charac = new Characters();
        charac.setVisible(true);
    }//GEN-LAST:event_Btn_characMouseClicked

    private void Btn_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_playMouseClicked
        Game g = new Game();
        g.setVisible(true);
        this.setVisible(false);
        song.close();
    }//GEN-LAST:event_Btn_playMouseClicked

    public void pantallacreditos(){

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\fondo.png"));
        Btn_Options.setVisible(true);
        Btn_charac.setVisible(true);
        Btn_play.setVisible(true);

    }
    
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Init i = new Init();
                i.setVisible(true);
                setTimeout(() -> i.pantallacreditos(), 4000);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Btn_Options;
    private java.awt.Button Btn_charac;
    private java.awt.Button Btn_play;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
