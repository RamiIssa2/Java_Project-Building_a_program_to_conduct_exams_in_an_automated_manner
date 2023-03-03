/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.*;
import static Classes.QuestionBank.InvalidQBank;
import static Classes.QuestionBank.QuestionList;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.JFrame;


public class MainFrame extends javax.swing.JFrame {

    private boolean Closing_BTClicked = false;
    
    public MainFrame() {
        initComponents();
        initQList();
    }
    
    private void initQList(){
        if (QuestionList.isEmpty()){
            File QBank = new File("Files\\Question Bank.txt");
            QuestionBankHandler QBH = new QuestionBankHandler(QBank);
            QBH.read();
        }
    }

    public void close(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Welcoming_Label = new javax.swing.JLabel();
        Teacher_BT = new javax.swing.JButton();
        Student_BT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Main Frame");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Welcoming_Label.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Welcoming_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Welcoming_Label.setText("<html><center>Welcome<P><font size=12>Please choose one of the following</html>");

        Teacher_BT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Teacher_BT.setText("Teacher");
        Teacher_BT.setVerifyInputWhenFocusTarget(false);
        Teacher_BT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Teacher_BTMouseClicked(evt);
            }
        });

        Student_BT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Student_BT.setText("Student");
        Student_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student_BTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Welcoming_Label)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Student_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Teacher_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(Welcoming_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(Teacher_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Student_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Student_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Student_BTActionPerformed
        if (QuestionList.isEmpty()){
            WarningFrame WR = new WarningFrame();
            WR.setWarning_Label("<html><center>Sorry,<br>your question bank is empty right now</html>");
            WR.setVisible(true);
        }else{
            Closing_BTClicked = true;
            close();
            StudentFrame student = new StudentFrame();
            student.setVisible(true);
        }
    }//GEN-LAST:event_Student_BTActionPerformed

    private void Teacher_BTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Teacher_BTMouseClicked
        Closing_BTClicked = true;
        close();
        TeacherFrame teacher = new TeacherFrame();
        teacher.setVisible(true);
    }//GEN-LAST:event_Teacher_BTMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (InvalidQBank && !Closing_BTClicked){
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            FixQuestionBankFrame FQBF = new FixQuestionBankFrame();
            FQBF.setLastFrame(this);
            FQBF.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Student_BT;
    private javax.swing.JButton Teacher_BT;
    private javax.swing.JLabel Welcoming_Label;
    // End of variables declaration//GEN-END:variables

    private void formWindowClosing(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
