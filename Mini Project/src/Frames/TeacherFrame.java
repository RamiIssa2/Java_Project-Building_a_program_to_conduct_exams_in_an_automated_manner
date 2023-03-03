/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.*;
import static Classes.QuestionBank.QuestionList;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class TeacherFrame extends javax.swing.JFrame {

    private boolean Closing_BTClicked = false;
            
    public TeacherFrame() {
        initComponents();
    }

    private void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Choosing_Label = new javax.swing.JLabel();
        TryLastQ_BT = new javax.swing.JButton();
        AddQ_BT = new javax.swing.JButton();
        GoBack_BT = new javax.swing.JButton();
        LogViewer_BT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teacher");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Choosing_Label.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        Choosing_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Choosing_Label.setText("<html><center>Please choose one of the events</html>");

        TryLastQ_BT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TryLastQ_BT.setText("Try Last Question");
        TryLastQ_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TryLastQ_BTActionPerformed(evt);
            }
        });

        AddQ_BT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        AddQ_BT.setText("Add Question");
        AddQ_BT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddQ_BTMouseClicked(evt);
            }
        });

        GoBack_BT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GoBack_BT.setText("Go Back");
        GoBack_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBack_BTActionPerformed(evt);
            }
        });

        LogViewer_BT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LogViewer_BT.setText("Log Viewer");
        LogViewer_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogViewer_BTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Choosing_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GoBack_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddQ_BT, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(TryLastQ_BT, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(LogViewer_BT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(Choosing_Label)
                .addGap(37, 37, 37)
                .addComponent(AddQ_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(GoBack_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TryLastQ_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LogViewer_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddQ_BTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddQ_BTMouseClicked
        Closing_BTClicked = true;
        close();
        AddQuestionFrame addQuestion = new AddQuestionFrame();
        addQuestion.setVisible(true);
    }//GEN-LAST:event_AddQ_BTMouseClicked

    private void TryLastQ_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TryLastQ_BTActionPerformed
        if (QuestionList.isEmpty()){
            WarningFrame WR = new WarningFrame();
            WR.setWarning_Label("<html><center>Sorry,<br>your question bank is empty right now</html>");
            WR.setVisible(true);
        }else{
            JPanel Q_panel = QuestionList.get(QuestionList.size()-1).render();
            QuestionFrame Q_Frame = new QuestionFrame();
            Q_Frame.setQuestion_Panel(Q_panel);
            Q_Frame.setVisible(true);
        }
    }//GEN-LAST:event_TryLastQ_BTActionPerformed

    private void GoBack_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBack_BTActionPerformed
        Closing_BTClicked = true;
        close();
        MainFrame MF = new MainFrame();
        MF.setVisible(true);
    }//GEN-LAST:event_GoBack_BTActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!Closing_BTClicked){
            MainFrame MF = new MainFrame();
            MF.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void LogViewer_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogViewer_BTActionPerformed
        File logsFile = new File("Files\\Logs.txt");
        if (logsFile.exists()){
            Closing_BTClicked = true;
            close();
            LogViewerFrame logViewer = new LogViewerFrame();
            logViewer.setVisible(true);
        }else{
            WarningFrame WR = new WarningFrame();
            WR.setWarning_Label("<html><center>Sorry,<br>your Logs File is empty right now</html>");
            WR.setVisible(true);
        }
    }//GEN-LAST:event_LogViewer_BTActionPerformed

    
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
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddQ_BT;
    private javax.swing.JLabel Choosing_Label;
    private javax.swing.JButton GoBack_BT;
    private javax.swing.JButton LogViewer_BT;
    private javax.swing.JButton TryLastQ_BT;
    // End of variables declaration//GEN-END:variables
}
