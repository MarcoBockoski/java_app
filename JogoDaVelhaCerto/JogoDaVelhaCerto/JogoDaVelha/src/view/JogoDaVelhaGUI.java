/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Code.Jogador;
import Code.JogoDaVelha;


public class JogoDaVelhaGUI extends javax.swing.JFrame {
    JogoDaVelha jv;
    Jogador j1 = new Jogador('X');
    Jogador j2 = new Jogador('O');
    
    
    public JogoDaVelhaGUI() {
        initComponents();
        jv = new JogoDaVelha(j1, j2);
        jv.iniciaJogo(j1);
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jB1 = new javax.swing.JButton();
        jB2 = new javax.swing.JButton();
        jB3 = new javax.swing.JButton();
        jB4 = new javax.swing.JButton();
        jB5 = new javax.swing.JButton();
        jB6 = new javax.swing.JButton();
        jB7 = new javax.swing.JButton();
        jB8 = new javax.swing.JButton();
        jB9 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMJogo = new javax.swing.JMenu();
        jMIIniciarJogo = new javax.swing.JMenuItem();
        JMISair = new javax.swing.JMenuItem();
        jMRanking = new javax.swing.JMenu();
        jMIExibirRanking = new javax.swing.JMenuItem();
        jMIZerarRanking = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setResizable(false);

        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1ActionPerformed(evt);
            }
        });

        jB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2ActionPerformed(evt);
            }
        });

        jB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3ActionPerformed(evt);
            }
        });

        jB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4ActionPerformed(evt);
            }
        });

        jB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB5ActionPerformed(evt);
            }
        });

        jB6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB6ActionPerformed(evt);
            }
        });

        jB7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB7ActionPerformed(evt);
            }
        });

        jB8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB8ActionPerformed(evt);
            }
        });

        jB9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jB7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jB6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB7, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(jB9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMJogo.setText("Jogo");

        jMIIniciarJogo.setText("Iniciar Jogo");
        jMIIniciarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIIniciarJogoActionPerformed(evt);
            }
        });
        jMJogo.add(jMIIniciarJogo);

        JMISair.setText("Sair");
        JMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMISairActionPerformed(evt);
            }
        });
        jMJogo.add(JMISair);

        jMenuBar1.add(jMJogo);

        jMRanking.setText("Pontuação");

        jMIExibirRanking.setText("Exibir Pontuação");
        jMIExibirRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIExibirRankingActionPerformed(evt);
            }
        });
        jMRanking.add(jMIExibirRanking);

        jMIZerarRanking.setText("Zerar Pontuação");
        jMIZerarRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIZerarRankingActionPerformed(evt);
            }
        });
        jMRanking.add(jMIZerarRanking);

        jMenuBar1.add(jMRanking);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMISairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_JMISairActionPerformed

    private void jMIIniciarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIIniciarJogoActionPerformed
      jv.iniciaJogo(j1);
      jB1.setText(null);
      jB2.setText(null);
      jB3.setText(null);
      jB4.setText(null);
      jB5.setText(null);
      jB6.setText(null);
      jB7.setText(null);
      jB8.setText(null);
      jB9.setText(null);
    }//GEN-LAST:event_jMIIniciarJogoActionPerformed

    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1ActionPerformed
        if(jv.ehJogadaValida(0, 0))
        {
            String temp = ""+jv.fazerJogada(0, 0);
            jB1.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB1ActionPerformed

    private void jB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2ActionPerformed
        if(jv.ehJogadaValida(0, 1))
        {
            String temp = ""+jv.fazerJogada(0, 1);
            jB2.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB2ActionPerformed

    private void jB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3ActionPerformed
        if(jv.ehJogadaValida(0, 2))
        {
            String temp = ""+jv.fazerJogada(0, 2);
            jB3.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB3ActionPerformed

    private void jB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4ActionPerformed
        if(jv.ehJogadaValida(1, 0))
        {
            String temp = ""+jv.fazerJogada(1, 0);
            jB4.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB4ActionPerformed

    private void jB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB5ActionPerformed
        if(jv.ehJogadaValida(1, 1))
        {
            String temp = ""+jv.fazerJogada(1, 1);
            jB5.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB5ActionPerformed

    private void jB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6ActionPerformed
        if(jv.ehJogadaValida(1, 2))
        {
            String temp = ""+jv.fazerJogada(1, 2);
            jB6.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB6ActionPerformed

    private void jB7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB7ActionPerformed
        if(jv.ehJogadaValida(2, 0))
        {
            String temp = ""+jv.fazerJogada(2, 0);
            jB7.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB7ActionPerformed

    private void jB8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB8ActionPerformed
        if(jv.ehJogadaValida(2, 1))
        {
            String temp = ""+jv.fazerJogada(2, 1);
            jB8.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB8ActionPerformed

    private void jB9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB9ActionPerformed
        if(jv.ehJogadaValida(2, 2))
        {
            String temp = ""+jv.fazerJogada(2, 2);
            jB9.setText(temp);
            jv.setJogadorDaVez();
        }
        
        if(jv.isFimDoJogo())
        {
            GameOver fim = new GameOver(this, true, jv, j1, j2);
            fim.setVisible(true);
            jv.iniciaJogo(j1);
            jB1.setText(null);
            jB2.setText(null);
            jB3.setText(null);
            jB4.setText(null);
            jB5.setText(null);
            jB6.setText(null);
            jB7.setText(null);
            jB8.setText(null);
            jB9.setText(null);
        }
    }//GEN-LAST:event_jB9ActionPerformed

    private void jMIZerarRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIZerarRankingActionPerformed
        jv.zeraEmpates();
    }//GEN-LAST:event_jMIZerarRankingActionPerformed

    private void jMIExibirRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIExibirRankingActionPerformed
        Placar p = new Placar(this, true, jv, j1, j2);
        p.setVisible(true);
    }//GEN-LAST:event_jMIExibirRankingActionPerformed

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
            java.util.logging.Logger.getLogger(JogoDaVelhaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelhaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelhaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelhaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoDaVelhaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMISair;
    private javax.swing.JButton jB1;
    private javax.swing.JButton jB2;
    private javax.swing.JButton jB3;
    private javax.swing.JButton jB4;
    private javax.swing.JButton jB5;
    private javax.swing.JButton jB6;
    private javax.swing.JButton jB7;
    private javax.swing.JButton jB8;
    private javax.swing.JButton jB9;
    private javax.swing.JMenuItem jMIExibirRanking;
    private javax.swing.JMenuItem jMIIniciarJogo;
    private javax.swing.JMenuItem jMIZerarRanking;
    private javax.swing.JMenu jMJogo;
    private javax.swing.JMenu jMRanking;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
