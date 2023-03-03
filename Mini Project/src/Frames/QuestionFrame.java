/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.event.*;
import javax.swing.*;
import Classes.*;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Asus
 */
public class QuestionFrame extends javax.swing.JFrame {

    private JButton Submit_BT;
    private JLabel SelectedOptions_Label;
    private JLabel QText_Label;
    private JCheckBox Option1_CheckBox;
    private JCheckBox Option2_CheckBox;
    private JCheckBox Option3_CheckBox;
    private JCheckBox Option4_CheckBox;
    private JCheckBox Option5_CheckBox;
    private ButtonGroup Options_buttonGroup;
    private JRadioButton Option1_RadioButton;
    private JRadioButton Option2_RadioButton;
    private JRadioButton Option3_RadioButton;
    private JRadioButton Option4_RadioButton;
    private JRadioButton Option5_RadioButton;
    
    private ArrayList<String> SelectedOptions = new ArrayList<>();
    private SingleQuestion SQ;
    private MultipleQuestion MQ;
    
    public QuestionFrame() {
        initComponents();
    }

    private void setSingleAnswerQuestionPanel(JPanel Question_Panel){
        QText_Label = new JLabel();
        Options_buttonGroup = new ButtonGroup();
        Option1_RadioButton = new JRadioButton();
        Option2_RadioButton = new JRadioButton();
        Option3_RadioButton = new JRadioButton();
        Option4_RadioButton = new JRadioButton();
        Option5_RadioButton = new JRadioButton();
        Submit_BT = new JButton();
        SelectedOptions_Label = new JLabel();
        SingleAnswerQuestionPanel QP = (SingleAnswerQuestionPanel) Question_Panel;
        this.SQ = QP.SQ;
        
        this.setTitle(SQ.getQName());
        QText_Label.setText(QP.getQText_Label().getText());
        
        Options_buttonGroup.add(Option1_RadioButton);
        Options_buttonGroup.add(Option2_RadioButton);
        Options_buttonGroup.add(Option3_RadioButton);
        Options_buttonGroup.add(Option4_RadioButton);
        Options_buttonGroup.add(Option5_RadioButton);
        Option1_RadioButton.setText(QP.getOption1_RadioButton().getText());
        Option1_RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option1_RadioButtonActionPerformed(evt);
            }
        });

        Option2_RadioButton.setText(QP.getOption2_RadioButton().getText());
        Option2_RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option2_RadioButtonActionPerformed(evt);
            }
        });

        Option3_RadioButton.setText(QP.getOption3_RadioButton().getText());
        Option3_RadioButton.setVisible(QP.getOption3_RadioButton().isVisible());
        Option3_RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option3_RadioButtonActionPerformed(evt);
            }
        });

        Option4_RadioButton.setText(QP.getOption4_RadioButton().getText());
        Option4_RadioButton.setVisible(QP.getOption4_RadioButton().isVisible());
        Option4_RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option4_RadioButtonActionPerformed(evt);
            }
        });

        Option5_RadioButton.setText(QP.getOption5_RadioButton().getText());
        Option5_RadioButton.setVisible(QP.getOption5_RadioButton().isVisible());
        Option5_RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option5_RadioButtonActionPerformed(evt);
            }
        });

        Submit_BT.setText(QP.getSubmit_BT().getText());
        Submit_BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                SingleSubmit_BTActionPerformed(evt);
            }
        });

        SelectedOptions_Label.setText("No option is selected");

        GroupLayout layout = new GroupLayout(this.Question_Panel);
        this.Question_Panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Submit_BT, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectedOptions_Label, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                    .addComponent(QText_Label, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Option2_RadioButton)
                    .addComponent(Option1_RadioButton)
                    .addComponent(Option3_RadioButton)
                    .addComponent(Option4_RadioButton)
                    .addComponent(Option5_RadioButton))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(QText_Label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option1_RadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option2_RadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option3_RadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option4_RadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option5_RadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit_BT, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedOptions_Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }
    
    private void setMultipleAnswerQuestionPanel (JPanel Question_Panel){
        Submit_BT = new JButton();
        SelectedOptions_Label = new JLabel();
        QText_Label = new JLabel();
        Option1_CheckBox = new JCheckBox();
        Option2_CheckBox = new JCheckBox();
        Option3_CheckBox = new JCheckBox();
        Option4_CheckBox = new JCheckBox();
        Option5_CheckBox = new JCheckBox();
        MultipleAnswerQuestionPanel QP = (MultipleAnswerQuestionPanel) Question_Panel;
        this.MQ = QP.MQ;
        
        this.setTitle(MQ.getQName());

        Submit_BT.setText(QP.getSubmit_BT().getText());
        Submit_BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MultipleSubmit_BTActionPerformed(evt);
            }
        });

        SelectedOptions_Label.setText("No option is selected");

        QText_Label.setText(QP.getQText_Label().getText());

        Option1_CheckBox.setText(QP.getOption1_CheckBox().getText());
        Option1_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option1_CheckBoxActionPerformed(evt);
            }
        });

        Option2_CheckBox.setText(QP.getOption2_CheckBox().getText());
        Option2_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option2_CheckBoxActionPerformed(evt);
            }
        });

        Option3_CheckBox.setText(QP.getOption3_CheckBox().getText());
        Option3_CheckBox.setVisible(QP.getOption3_CheckBox().isVisible());
        Option3_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option3_CheckBoxActionPerformed(evt);
            }
        });

        Option4_CheckBox.setText(QP.getOption4_CheckBox().getText());
        Option4_CheckBox.setVisible(QP.getOption4_CheckBox().isVisible());
        Option4_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option4_CheckBoxActionPerformed(evt);
            }
        });

        Option5_CheckBox.setText(QP.getOption5_CheckBox().getText());
        Option5_CheckBox.setVisible(QP.getOption5_CheckBox().isVisible());
        Option5_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Option5_CheckBoxActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this.Question_Panel);
        this.Question_Panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(Option5_CheckBox)
                    .addComponent(Option4_CheckBox)
                    .addComponent(Option3_CheckBox)
                    .addComponent(Option2_CheckBox)
                    .addComponent(Option1_CheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Submit_BT, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectedOptions_Label, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                    .addComponent(QText_Label, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(QText_Label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option1_CheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option2_CheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option3_CheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option4_CheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option5_CheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit_BT, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedOptions_Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }
    
    public void setQuestion_Panel(JPanel Question_Panel) {
        
        if (Question_Panel.getClass() == SingleAnswerQuestionPanel.class){
            setSingleAnswerQuestionPanel(Question_Panel);
        }else{
            setMultipleAnswerQuestionPanel(Question_Panel);
        }
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private void ShowSelectedOptions(){
        Collections.sort(SelectedOptions);
        if (SelectedOptions.isEmpty()){
            SelectedOptions_Label.setText("No option is selected");
        }
        else if (SelectedOptions.size() == 1){
            SelectedOptions_Label.setText("Option " + SelectedOptions.get(0) + " is selected");
        }
        else if (SelectedOptions.size() == MQ.getOptionList().size()){
            SelectedOptions_Label.setText("All options are selected");
        }
        else{
            String temp = "Options ";
            int i = 0;
            for (String t : SelectedOptions){
                temp = temp + t;
                i++;
                if (i != SelectedOptions.size()){
                    temp = temp + " and ";
                }
            }
            temp = temp + " are selected";
            SelectedOptions_Label.setText(temp);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Question_Panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout Question_PanelLayout = new javax.swing.GroupLayout(Question_Panel);
        Question_Panel.setLayout(Question_PanelLayout);
        Question_PanelLayout.setHorizontalGroup(
            Question_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        Question_PanelLayout.setVerticalGroup(
            Question_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Question_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Question_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MultipleSubmit_BTActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ResultFrame result = new ResultFrame();
        String resultText = "Your result is: ";
        int TotalMark = MQ.validate(SelectedOptions);
        resultText = resultText + TotalMark + "/" + MQ.getQMark();
        result.setResult_Label(resultText);
        result.setLastFrame(this);
        result.setVisible(true);
    }
    
    private void Option1_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (Option1_CheckBox.isSelected()){
            SelectedOptions.add("1");
        }
        else{
            SelectedOptions.remove("1");
        }
        ShowSelectedOptions();
    }                                                

    private void Option2_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (Option2_CheckBox.isSelected()){
            SelectedOptions.add("2");
        }
        else{
            SelectedOptions.remove("2");
        }
        ShowSelectedOptions();
    }                                                

    private void Option3_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (Option3_CheckBox.isSelected()){
            SelectedOptions.add("3");
        }
        else{
            SelectedOptions.remove("3");
        }
        ShowSelectedOptions();
    }                                                

    private void Option4_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (Option4_CheckBox.isSelected()){
            SelectedOptions.add("4");
        }
        else{
            SelectedOptions.remove("4");
        }
        ShowSelectedOptions();
    }                                                

    private void Option5_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (Option5_CheckBox.isSelected()){
            SelectedOptions.add("5");
        }
        else{
            SelectedOptions.remove("5");
        }
        ShowSelectedOptions();
    }
    
    private void Option1_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        SelectedOptions_Label.setText("Option 1 is selected");
        SelectedOptions.clear();
        SelectedOptions.add("1");
    }
    
    private void Option2_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        SelectedOptions_Label.setText("Option 2 is selected");
        SelectedOptions.clear();
        SelectedOptions.add("2");
    }
    
    private void Option3_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        SelectedOptions_Label.setText("Option 3 is selected");
        SelectedOptions.clear();
        SelectedOptions.add("3");
    }
    
    private void Option4_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        SelectedOptions_Label.setText("Option 4 is selected");
        SelectedOptions.clear();
        SelectedOptions.add("4");
    }
    
    private void Option5_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        SelectedOptions_Label.setText("Option 5 is selected");
        SelectedOptions.clear();
        SelectedOptions.add("5");
    }
    
    private void SingleSubmit_BTActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ResultFrame result = new ResultFrame();
        String resultText = "Your result is: ";
        int TotalMark = SQ.validate(SelectedOptions);
        resultText = resultText + TotalMark + "/" + SQ.getQMark();
        result.setResult_Label(resultText);
        result.setLastFrame(this);
        result.setVisible(true);
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Question_Panel;
    // End of variables declaration//GEN-END:variables
}
