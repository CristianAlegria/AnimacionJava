/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package portada;

import java.awt.Color;
import proyectoAnimacion.*;
public class Menu extends javax.swing.JFrame {
   Principal animacion;
   
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
         this.setResizable(false);
         this.setBackground(Color.black);
        
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabelSalir = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelEmpezar2 = new javax.swing.JLabel();
        jLabelSalir2 = new javax.swing.JLabel();
        jLabelGorila = new javax.swing.JLabel();
        jLabelEmpezar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabelSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPortada/Salir.png"))); // NOI18N
        jLabelSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalirMouseClicked(evt);
            }
        });

        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPortada/Donkey_Kong_Title.png"))); // NOI18N

        jLabelEmpezar2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelEmpezar2.setText("EMPEZAR");

        jLabelSalir2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelSalir2.setText(" SALIR");

        jLabelGorila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPortada/gorilaPortada.png"))); // NOI18N

        jLabelEmpezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPortada/Empezar.png"))); // NOI18N
        jLabelEmpezar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEmpezarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelGorila)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmpezar)
                    .addComponent(jLabelEmpezar2)
                    .addComponent(jLabelSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalir2)))
            .addComponent(jLabelTitulo)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelEmpezar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmpezar2)
                        .addGap(121, 121, 121)
                        .addComponent(jLabelSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSalir2))
                    .addComponent(jLabelGorila)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelEmpezarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEmpezarMouseClicked
       animacion = new Principal();
       animacion.setVisible(true);
    }//GEN-LAST:event_jLabelEmpezarMouseClicked

    private void jLabelSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalirMouseClicked
       animacion.dispose();
       System.exit(0);
    }//GEN-LAST:event_jLabelSalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEmpezar;
    private javax.swing.JLabel jLabelEmpezar2;
    private javax.swing.JLabel jLabelGorila;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelSalir2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
