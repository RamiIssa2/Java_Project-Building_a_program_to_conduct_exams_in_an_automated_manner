/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.Question;
import static Classes.QuestionBank.InvalidQBank;
import static Classes.QuestionBank.QuestionList;
import Classes.QuestionBankHandler;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class FixQuestionBankFrame extends javax.swing.JFrame {

    JFrame LastFrame = null;
    
    public FixQuestionBankFrame() {
        initComponents();
    }

    public void setLastFrame(JFrame LastFrame) {
        this.LastFrame = LastFrame;
    }

    private void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Yes_BT = new javax.swing.JButton();
        No_BT = new javax.swing.JButton();
        FixWarning_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fixing Question Bank");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Yes_BT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Yes_BT.setText("Yes");
        Yes_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Yes_BTActionPerformed(evt);
            }
        });

        No_BT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        No_BT.setText("No");
        No_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No_BTActionPerformed(evt);
            }
        });

        FixWarning_Label.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        FixWarning_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FixWarning_Label.setText("<html><center><font size=6>Before you close the program:<br><font size=2><br><P><font size=5>We should inform you that your Question Bank has some invalid questons<br><font size=2><br><font size=5>So by choosing Yes a new Question Bank will be created with only the valid question and the old Question Bank will be marked as Old Question Bank, and by choosing No no action will be preformed</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(Yes_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(No_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FixWarning_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(FixWarning_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Yes_BT, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(No_BT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void No_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No_BTActionPerformed
        close();
    }//GEN-LAST:event_No_BTActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        InvalidQBank = false;
        ((MainFrame) LastFrame).close();
    }//GEN-LAST:event_formWindowClosed

    private void Yes_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Yes_BTActionPerformed
        File NewQBank =new File("Files\\Question Bank.txt");
        File OldQBank =new File("Files\\Old Question Bank.txt");
        if (OldQBank.exists()){
            OldQBank.delete();
        }
        NewQBank.renameTo(OldQBank);
        QuestionBankHandler QBH = new QuestionBankHandler(NewQBank);
        for (Question Q : QuestionList){
            QBH.write(Q);
        }
        close();
    }//GEN-LAST:event_Yes_BTActionPerformed

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
            java.util.logging.Logger.getLogger(FixQuestionBankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FixQuestionBankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FixQuestionBankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FixQuestionBankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FixQuestionBankFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FixWarning_Label;
    private javax.swing.JButton No_BT;
    private javax.swing.JButton Yes_BT;
    // End of variables declaration//GEN-END:variables
}
