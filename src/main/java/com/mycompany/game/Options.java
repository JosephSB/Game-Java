package com.mycompany.game;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Options extends javax.swing.JFrame {
    private settings config;
    private Clip sonido;
    private Init mainInicio;
    
    public Options(settings config, Clip song,Init in) {
        initComponents();
        this.mainInicio = in;
        this.config = config;
        this.sonido = song;
        System.out.println("ejecutando");
    }   
    //public int volume = config.getVol();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        accept = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Options");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Monsters Attack!", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OPTIONS");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 30, 240, 70);

        jSlider1.setBackground(new java.awt.Color(0, 0, 0));
        jSlider1.setMaximum(6);
        jSlider1.setMinimum(-50);
        getContentPane().add(jSlider1);
        jSlider1.setBounds(260, 130, 200, 23);

        jLabel3.setFont(new java.awt.Font("Videopac", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LANGUAGE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 180, 130, 20);

        jLabel4.setFont(new java.awt.Font("Videopac", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Volume");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 130, 90, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingles", "Español" }));
        jComboBox1.setToolTipText("");
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(280, 180, 160, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\cancel.png")); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(300, 280, 90, 80);

        accept.setBackground(new java.awt.Color(255, 255, 255));
        accept.setForeground(new java.awt.Color(255, 255, 255));
        accept.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\check.png")); // NOI18N
        accept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptMouseClicked(evt);
            }
        });
        getContentPane().add(accept);
        accept.setBounds(210, 280, 90, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Josehp\\Documents\\NetBeansProjects\\Game\\src\\main\\java\\img\\fondo2.png")); // NOI18N
        jLabel1.setAutoscrolls(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptMouseClicked
    
        config.setVol(jSlider1.getValue());
        FloatControl gainControl = (FloatControl) sonido.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(config.getVol());
        
        sonido.start();
        
        if(jComboBox1.getSelectedItem() == "Ingles")config.setLenguage(false);
        else config.setLenguage(true);
        
        mainInicio.verificarIdioma(config.getLenguage());
        
        this.setVisible(false);
    }//GEN-LAST:event_acceptMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setVisible(false);
        sonido.start();
    }//GEN-LAST:event_jLabel6MouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                //new Options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accept;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
