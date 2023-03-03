/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class StudentFrame extends javax.swing.JFrame {

    ExamReport ER = new ExamReport();
    private boolean Closing_BTClicked = false;
    
    public StudentFrame() {
        initComponents();
        CheckEnablingBT();
        AdvancedOptions_Panel.setVisible(false);
    }
    
    private void CheckEnablingBT(){
        Warning_Panel.setVisible(false);
        boolean QTextFields = true;
        if (SName_TextField.getText().equals("")){
            SName_TextField.setBackground(Color.PINK);
            QTextFields &= false;
        }else{
            SName_TextField.setBackground(Color.WHITE);
            QTextFields &= true;
        }
        if (QNumber_TextField.getText().equals("")){
            QNumber_TextField.setBackground(Color.PINK);
            QTextFields &= false;
        }else{
            QNumber_TextField.setBackground(Color.WHITE);
            QTextFields &= true;
        }
        if (QTextFields){
            GenerateExam_BT.setEnabled(true);
        }else{
            GenerateExam_BT.setEnabled(false);
        }
    }

    private void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private void setExamReport(){
        ER.setStudentName(SName_TextField.getText());
        ER.setEDifficulty((String) ExamDifficulty_ComboBox.getSelectedItem());
        ER.setQNumber(Integer.parseInt(QNumber_TextField.getText()));
        if (BasicExamGenerator_RadioButton.isSelected()){
            ER.setEGenerator("Basic");
        }else{
            ER.setEGenerator("Random");
        }
        ER.setEScore(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GeneratorOptions_buttonGroup = new javax.swing.ButtonGroup();
        SName_Label = new javax.swing.JLabel();
        SName_TextField = new javax.swing.JTextField();
        ExamDifficulty_Label = new javax.swing.JLabel();
        ExamDifficulty_ComboBox = new javax.swing.JComboBox<>();
        QNumber_Label = new javax.swing.JLabel();
        QNumber_TextField = new javax.swing.JTextField();
        AdvancedOptions_CheckBox = new javax.swing.JCheckBox();
        AdvancedOptions_Panel = new javax.swing.JPanel();
        GeneratorOptions_Label = new javax.swing.JLabel();
        BasicExamGenerator_RadioButton = new javax.swing.JRadioButton();
        RandomExamGenerator_RadioButton = new javax.swing.JRadioButton();
        GenerateExam_BT = new javax.swing.JButton();
        Warning_Panel = new javax.swing.JPanel();
        Warning_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        SName_Label.setText("Enter the student name:");

        SName_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SName_TextFieldKeyReleased(evt);
            }
        });

        ExamDifficulty_Label.setText("Select the exam difficulty:");

        ExamDifficulty_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EASY", "MEDIUM", "HARD" }));
        ExamDifficulty_ComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExamDifficulty_ComboBoxMouseClicked(evt);
            }
        });

        QNumber_Label.setText("Enter the number of questions:");

        QNumber_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        QNumber_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QNumber_TextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QNumber_TextFieldKeyTyped(evt);
            }
        });

        AdvancedOptions_CheckBox.setText("Advanced Options");
        AdvancedOptions_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdvancedOptions_CheckBoxActionPerformed(evt);
            }
        });

        GeneratorOptions_Label.setText("Please choose how the exam should be generated:");

        GeneratorOptions_buttonGroup.add(BasicExamGenerator_RadioButton);
        BasicExamGenerator_RadioButton.setSelected(true);
        BasicExamGenerator_RadioButton.setText("Generate Exam Basically");

        GeneratorOptions_buttonGroup.add(RandomExamGenerator_RadioButton);
        RandomExamGenerator_RadioButton.setText("Generate Exam Randomly");

        javax.swing.GroupLayout AdvancedOptions_PanelLayout = new javax.swing.GroupLayout(AdvancedOptions_Panel);
        AdvancedOptions_Panel.setLayout(AdvancedOptions_PanelLayout);
        AdvancedOptions_PanelLayout.setHorizontalGroup(
            AdvancedOptions_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvancedOptions_PanelLayout.createSequentialGroup()
                .addGroup(AdvancedOptions_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GeneratorOptions_Label)
                    .addComponent(BasicExamGenerator_RadioButton)
                    .addComponent(RandomExamGenerator_RadioButton))
                .addGap(0, 87, Short.MAX_VALUE))
        );
        AdvancedOptions_PanelLayout.setVerticalGroup(
            AdvancedOptions_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvancedOptions_PanelLayout.createSequentialGroup()
                .addComponent(GeneratorOptions_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BasicExamGenerator_RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RandomExamGenerator_RadioButton))
        );

        GenerateExam_BT.setText("Generate Exam");
        GenerateExam_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateExam_BTActionPerformed(evt);
            }
        });

        Warning_Panel.setBackground(new java.awt.Color(255, 255, 204));
        Warning_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Warning_Label.setBackground(new java.awt.Color(255, 51, 51));
        Warning_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Warning_Label.setText("You can only enter positive numbers");

        javax.swing.GroupLayout Warning_PanelLayout = new javax.swing.GroupLayout(Warning_Panel);
        Warning_Panel.setLayout(Warning_PanelLayout);
        Warning_PanelLayout.setHorizontalGroup(
            Warning_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Warning_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );
        Warning_PanelLayout.setVerticalGroup(
            Warning_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Warning_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdvancedOptions_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(GenerateExam_BT))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdvancedOptions_CheckBox)
                            .addComponent(SName_Label)
                            .addComponent(SName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExamDifficulty_Label)
                            .addComponent(ExamDifficulty_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QNumber_Label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(QNumber_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Warning_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SName_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExamDifficulty_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExamDifficulty_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(QNumber_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QNumber_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Warning_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AdvancedOptions_CheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AdvancedOptions_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GenerateExam_BT)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AdvancedOptions_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdvancedOptions_CheckBoxActionPerformed
        if (AdvancedOptions_CheckBox.isSelected()) {
            AdvancedOptions_Panel.setVisible(true);
        } else {
            AdvancedOptions_Panel.setVisible(false);
        }
    }//GEN-LAST:event_AdvancedOptions_CheckBoxActionPerformed

    private void ExamDifficulty_ComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamDifficulty_ComboBoxMouseClicked
        CheckEnablingBT();
    }//GEN-LAST:event_ExamDifficulty_ComboBoxMouseClicked

    private void SName_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SName_TextFieldKeyReleased
        CheckEnablingBT();
    }//GEN-LAST:event_SName_TextFieldKeyReleased

    private void QNumber_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QNumber_TextFieldKeyReleased
        CheckEnablingBT();
        char c = evt.getKeyChar();
        QNumber_TextField.setEditable(true);
        if (!Character.isDigit(c)){
            evt.consume();
            Warning_Panel.setVisible(true);
        }else{
            Warning_Panel.setVisible(false);
        }
    }//GEN-LAST:event_QNumber_TextFieldKeyReleased

    private void GenerateExam_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateExam_BTActionPerformed
        ArrayList<Question> Exam = new ArrayList<>();
        int QNumber = Integer.parseInt(QNumber_TextField.getText());
        if (QNumber == 0){
            WarningFrame WR = new WarningFrame();
            WR.setWarning_Label("<html><center>Warning:<br>You can't generate an exam with 0 questions</html>");
            WR.setVisible(true);
        }else{
            if (BasicExamGenerator_RadioButton.isSelected()){
                BasicExamGenerator BEG = new BasicExamGenerator();
                BEG.generate(QNumber, (String) ExamDifficulty_ComboBox.getSelectedItem(),Exam);
            }else{
                RandomExamGenerator REG = new RandomExamGenerator();
                REG.generate(Integer.parseInt(QNumber_TextField.getText()), (String) ExamDifficulty_ComboBox.getSelectedItem(),Exam);
            }
            if (Exam.size() == 0){
                WarningFrame WR = new WarningFrame();
                WR.setWarning_Label("<html><center>Warning: There is no questions from the desired<br>difficulty, we suggest that you choose another difficulty</html>");
                WR.setVisible(true);
            }else if (Exam.size() < QNumber){
                WarningFrame WR = new WarningFrame();
                WR.setWarning_Label("<html><center>Warning: The number of the desired<br>questions can be between 1 and " + Exam.size() + " only</html>");
                WR.setVisible(true);
            }else{
                setExamReport();
                Closing_BTClicked = true;
                close();
                ExamFrame EF = new ExamFrame();
                EF.setExamQuestions(Exam);
                EF.setER(ER);
                EF.setVisible(true);
            }
        }
    }//GEN-LAST:event_GenerateExam_BTActionPerformed

    private void QNumber_TextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QNumber_TextFieldKeyTyped
        char c = evt.getKeyChar();
        QNumber_TextField.setEditable(true);
        if (!Character.isDigit(c)){
            evt.consume();
            Warning_Panel.setVisible(true);
        }else{
            Warning_Panel.setVisible(false);
        }
    }//GEN-LAST:event_QNumber_TextFieldKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!Closing_BTClicked){
            close();
            MainFrame MF = new MainFrame();
            MF.setVisible(true);
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
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AdvancedOptions_CheckBox;
    private javax.swing.JPanel AdvancedOptions_Panel;
    private javax.swing.JRadioButton BasicExamGenerator_RadioButton;
    private javax.swing.JComboBox<String> ExamDifficulty_ComboBox;
    private javax.swing.JLabel ExamDifficulty_Label;
    private javax.swing.JButton GenerateExam_BT;
    private javax.swing.JLabel GeneratorOptions_Label;
    private javax.swing.ButtonGroup GeneratorOptions_buttonGroup;
    private javax.swing.JLabel QNumber_Label;
    private javax.swing.JTextField QNumber_TextField;
    private javax.swing.JRadioButton RandomExamGenerator_RadioButton;
    private javax.swing.JLabel SName_Label;
    private javax.swing.JTextField SName_TextField;
    private javax.swing.JLabel Warning_Label;
    private javax.swing.JPanel Warning_Panel;
    // End of variables declaration//GEN-END:variables
}
