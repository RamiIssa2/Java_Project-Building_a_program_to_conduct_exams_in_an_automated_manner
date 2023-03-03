/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.*;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class ExamReportFrame extends javax.swing.JFrame {

    JFrame LastFrame = null;
    private boolean Closing_BTClicked = false;
    
    public ExamReportFrame() {
        initComponents();
    }
    
    public void setLastFrame(JFrame LastFrame) {
        this.LastFrame = LastFrame;
    }

    public void setExamReport_Label(ExamReport ER) {
        ExamReport_Label.setText("<html>Student Name: " + ER.getStudentName()
                                + "<br>Exam Difficulty: " + ER.getEDifficulty()
                                + "<br>Number of Questions: " + Integer.toString(ER.getQNumber())
                                + "<br>Exam Genertor: " + ER.getEGenerator()
                                + "<br>Exam Score: " + Integer.toString(ER.getEScore()) + "/100</html>");
    }

    private void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExamReport_Label = new javax.swing.JLabel();
        OK_BT = new javax.swing.JButton();
        ShowQAnswers_BT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exam Report");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        ExamReport_Label.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        OK_BT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OK_BT.setText("OK");
        OK_BT.setPreferredSize(new java.awt.Dimension(60, 31));
        OK_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_BTActionPerformed(evt);
            }
        });

        ShowQAnswers_BT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ShowQAnswers_BT.setText("Show Questions' Answers");
        ShowQAnswers_BT.setPreferredSize(new java.awt.Dimension(270, 31));
        ShowQAnswers_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowQAnswers_BTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ExamReport_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addComponent(ShowQAnswers_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(OK_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExamReport_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OK_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowQAnswers_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OK_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_BTActionPerformed
        close();
    }//GEN-LAST:event_OK_BTActionPerformed

    private void ShowQAnswers_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowQAnswers_BTActionPerformed
        Closing_BTClicked = true;
        close();
        ((ExamFrame) LastFrame).setShowAnswers(true);
    }//GEN-LAST:event_ShowQAnswers_BTActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!Closing_BTClicked){
            ((ExamFrame) LastFrame).close();
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ExamReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamReportFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ExamReport_Label;
    private javax.swing.JButton OK_BT;
    private javax.swing.JButton ShowQAnswers_BT;
    // End of variables declaration//GEN-END:variables
}
