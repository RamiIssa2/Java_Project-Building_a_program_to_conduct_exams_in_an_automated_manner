/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.*;
import Classes.ILogger.LogLevel;
import static Classes.QuestionBank.QListContains;
import static Classes.QuestionBank.QuestionList;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class AddQuestionFrame extends javax.swing.JFrame {

   
    private boolean Closing_BTClicked = false;
    private int OptionsUnchecked = 5;
    private Question Q;
    
    public AddQuestionFrame() {
        initComponents();
        CheckEnablingBT();
        Warning_Panel.setVisible(false);
    }
    
    private void initQ(){
        ArrayList<String> PossibleQ = new ArrayList<>();
        PossibleQ.add(QName_TextField.getText());
        PossibleQ.add((String) QDifficulty_ComboBox.getSelectedItem());
        PossibleQ.add((String) QType_ComboBox.getSelectedItem());
        PossibleQ.add(QMark_TextField.getText());
        PossibleQ.add(QText_TextField.getText());
        String temp = Option1_TextField.getText();
        if (Option1_CheckBox.isSelected()){
            temp = temp + " (T)";
        }
        PossibleQ.add(temp);
        temp = Option2_TextField.getText();
        if (Option2_CheckBox.isSelected()){
            temp = temp + " (T)";
        }
        PossibleQ.add(temp);
        if (Option3_CheckBox.isVisible()){
            temp = Option3_TextField.getText();
            if (Option3_CheckBox.isSelected()){
                temp = temp + " (T)";
            }
            PossibleQ.add(temp);
            if (Option4_CheckBox.isVisible()){
                temp = Option4_TextField.getText();
                if (Option4_CheckBox.isSelected()){
                    temp = temp + " (T)";
                }
                PossibleQ.add(temp);
                if (Option5_CheckBox.isVisible()){
                    temp = Option5_TextField.getText();
                    if (Option5_CheckBox.isSelected()){
                        temp = temp + " (T)";
                    }
                    PossibleQ.add(temp);
                }
            }
        }
        if (PossibleQ.get(2).equals("Single Answer")){
            Q = new SingleQuestion(PossibleQ);
        }else{
            Q = new MultipleQuestion(PossibleQ);
        }
    }
    
    private boolean checkQ(){
        if (QListContains(Q)){
            WarningFrame WR = new WarningFrame();
            WR.setWarning_Label("Warning:The Question already exists");
            WR.setVisible(true);
            return false;
        }else{
            return true;
        }
    }
    
    private void CountUncheckedOptions(){
        OptionsUnchecked = 5;
        if (Option1_CheckBox.isSelected()){
            OptionsUnchecked--;
        }
        if (Option2_CheckBox.isSelected()){
            OptionsUnchecked--;
        }
        if (Option3_CheckBox.isSelected()){
            OptionsUnchecked--;
        }
        if (Option4_CheckBox.isSelected()){
            OptionsUnchecked--;
        }
        if (Option5_CheckBox.isSelected()){
            OptionsUnchecked--;
        }
    }
    
    private void CheckEnablingBT(){
        Warning_Panel.setVisible(false);
        boolean QTextFields = true;
        boolean OTextFields = true;
        if (QName_TextField.getText().equals("")){
            QName_TextField.setBackground(Color.PINK);
            QTextFields &= false;
        }else{
            QName_TextField.setBackground(Color.WHITE);
            QTextFields &= true;
        }
        if (QMark_TextField.getText().equals("")){
            QMark_TextField.setBackground(Color.PINK);
            QTextFields &= false;
        }else{
            QMark_TextField.setBackground(Color.WHITE);
            QTextFields &= true;
        }
        if (QText_TextField.getText().equals("")){
            QText_TextField.setBackground(Color.PINK);
            QTextFields &= false;
        }else{
            QText_TextField.setBackground(Color.WHITE);
            QTextFields &= true;
        }
        if (Option1_TextField.getText().equals("")){
            Option1_TextField.setBackground(Color.PINK);
            OTextFields &= false;
        }else{
            Option1_TextField.setBackground(Color.WHITE);
            OTextFields &= true;
        }
        if (Option2_TextField.getText().equals("")){
            Option2_TextField.setBackground(Color.PINK);
            OTextFields &= false;
        }else{
            Option2_TextField.setBackground(Color.WHITE);
            OTextFields &= true;
        }
        if (Option3_TextField.isVisible()){
            if (Option3_TextField.getText().equals("")){
                Option3_TextField.setBackground(Color.PINK);
                OTextFields &= false;
            }else{
                Option3_TextField.setBackground(Color.WHITE);
                OTextFields &= true;
            }
            if (Option4_TextField.isVisible()){
                if (Option4_TextField.getText().equals("")){
                    Option4_TextField.setBackground(Color.PINK);
                    OTextFields &= false;
                }else{
                    Option4_TextField.setBackground(Color.WHITE);
                    OTextFields &= true;
                }
                if (Option5_TextField.isVisible()){
                    if (Option5_TextField.getText().equals("")){
                        Option5_TextField.setBackground(Color.PINK);
                        OTextFields &= false;
                    }else{
                        Option5_TextField.setBackground(Color.WHITE);
                        OTextFields &= true;
                    }
                }
            }
        }
        if (OTextFields && QTextFields && (OptionsUnchecked < 5)){
            AddQ_BT.setEnabled(true);
        }else{
            AddQ_BT.setEnabled(false);
        }
    }
    
    private boolean checkOptions(){
        int FO = 0;
        int SO = 0;
        boolean r;
        if (Option1_TextField.getText().equals(Option2_TextField.getText())){
            FO = 1;
            SO = 2;
            r = false;
        }else if ((Option1_TextField.getText().equals(Option3_TextField.getText())) && Option3_TextField.isVisible()){
            FO = 1;
            SO = 3;
            r = false;
        }else if ((Option1_TextField.getText().equals(Option4_TextField.getText())) && Option4_TextField.isVisible()){
            FO = 1;
            SO = 4;
            r = false;
        }else if ((Option1_TextField.getText().equals(Option5_TextField.getText())) && Option5_TextField.isVisible()){
            FO = 1;
            SO = 5;
            r = false;
        }else if ((Option2_TextField.getText().equals(Option3_TextField.getText())) && Option3_TextField.isVisible()){
            FO = 2;
            SO = 3;
            r = false;
        }else if ((Option2_TextField.getText().equals(Option4_TextField.getText())) && Option4_TextField.isVisible()){
            FO = 2;
            SO = 4;
            r = false;
        }else if ((Option2_TextField.getText().equals(Option5_TextField.getText())) && Option5_TextField.isVisible()){
            FO = 2;
            SO = 5;
            r = false;
        }else if ((Option3_TextField.getText().equals(Option4_TextField.getText())) && Option4_TextField.isVisible()){
            FO = 3;
            SO = 4;
            r = false;
        }else if ((Option3_TextField.getText().equals(Option5_TextField.getText())) && Option5_TextField.isVisible()){
            FO = 3;
            SO = 5;
            r = false;
        }else if ((Option4_TextField.getText().equals(Option5_TextField.getText())) && Option5_TextField.isVisible()){
            FO = 4;
            SO = 5;
            r = false;
        }else{
            r = true;
        }
        if (!r){
            WarningFrame WR = new WarningFrame();
            WR.setWarning_Label("Warning: Option " + FO + " is the same as Option " + SO);
            WR.setVisible(true);
        }
        return r;
    }
    
    private void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Options_buttonGroup = new javax.swing.ButtonGroup();
        QName_Label = new javax.swing.JLabel();
        QName_TextField = new javax.swing.JTextField();
        QDifficulty_Label = new javax.swing.JLabel();
        QDifficulty_ComboBox = new javax.swing.JComboBox<>();
        QType_Label = new javax.swing.JLabel();
        QType_ComboBox = new javax.swing.JComboBox<>();
        QMark_Label = new javax.swing.JLabel();
        QMark_TextField = new javax.swing.JTextField();
        QText_Label = new javax.swing.JLabel();
        QText_TextField = new javax.swing.JTextField();
        OptionNumber_Label = new javax.swing.JLabel();
        OptionsNumber_ComboBox = new javax.swing.JComboBox<>();
        Options_Label = new javax.swing.JLabel();
        Option1_TextField = new javax.swing.JTextField();
        Option2_TextField = new javax.swing.JTextField();
        Option3_TextField = new javax.swing.JTextField();
        Option4_TextField = new javax.swing.JTextField();
        Option5_TextField = new javax.swing.JTextField();
        Option1_CheckBox = new javax.swing.JCheckBox();
        Option2_CheckBox = new javax.swing.JCheckBox();
        Option3_CheckBox = new javax.swing.JCheckBox();
        Option4_CheckBox = new javax.swing.JCheckBox();
        Option5_CheckBox = new javax.swing.JCheckBox();
        AddQ_BT = new javax.swing.JButton();
        Warning_Panel = new javax.swing.JPanel();
        Warning_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Question");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        QName_Label.setText("Enter the question name:");

        QName_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QName_TextFieldKeyReleased(evt);
            }
        });

        QDifficulty_Label.setText("Select the question difficulty:");

        QDifficulty_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EASY", "MEDIUM", "HARD" }));
        QDifficulty_ComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QDifficulty_ComboBoxMouseClicked(evt);
            }
        });

        QType_Label.setText("Select the question type:");

        QType_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Answer", "Multiple Answer" }));
        QType_ComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QType_ComboBoxMouseClicked(evt);
            }
        });
        QType_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QType_ComboBoxActionPerformed(evt);
            }
        });

        QMark_Label.setText("Enter the question mark:");

        QMark_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        QMark_TextField.setToolTipText("");
        QMark_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QMark_TextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QMark_TextFieldKeyTyped(evt);
            }
        });

        QText_Label.setText("Enter the question text:");

        QText_TextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        QText_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QText_TextFieldKeyReleased(evt);
            }
        });

        OptionNumber_Label.setText("Select how many options does the question have:");

        OptionsNumber_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5" }));
        OptionsNumber_ComboBox.setSelectedIndex(3);
        OptionsNumber_ComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptionsNumber_ComboBoxMouseClicked(evt);
            }
        });
        OptionsNumber_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsNumber_ComboBoxActionPerformed(evt);
            }
        });

        Options_Label.setText("Enter the question's options and check the correct option:");

        Option1_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Option_TextFieldKeyReleased(evt);
            }
        });

        Option2_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Option_TextFieldKeyReleased(evt);
            }
        });

        Option3_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Option_TextFieldKeyReleased(evt);
            }
        });

        Option4_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Option_TextFieldKeyReleased(evt);
            }
        });

        Option5_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Option_TextFieldKeyReleased(evt);
            }
        });

        Option1_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option1_CheckBoxActionPerformed(evt);
            }
        });

        Option2_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option2_CheckBoxActionPerformed(evt);
            }
        });

        Option3_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option3_CheckBoxActionPerformed(evt);
            }
        });

        Option4_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option4_CheckBoxActionPerformed(evt);
            }
        });

        Option5_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option5_CheckBoxActionPerformed(evt);
            }
        });

        AddQ_BT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddQ_BT.setText("Add Question");
        AddQ_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddQ_BTActionPerformed(evt);
            }
        });

        Warning_Panel.setBackground(new java.awt.Color(255, 255, 204));
        Warning_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Warning_Label.setBackground(new java.awt.Color(255, 51, 51));
        Warning_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Warning_Label.setText("You can only enter positive numbers");
        Warning_Label.setMaximumSize(new java.awt.Dimension(210, 16));
        Warning_Label.setMinimumSize(new java.awt.Dimension(210, 16));
        Warning_Label.setPreferredSize(new java.awt.Dimension(210, 16));

        javax.swing.GroupLayout Warning_PanelLayout = new javax.swing.GroupLayout(Warning_Panel);
        Warning_Panel.setLayout(Warning_PanelLayout);
        Warning_PanelLayout.setHorizontalGroup(
            Warning_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Warning_PanelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(Warning_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        Warning_PanelLayout.setVerticalGroup(
            Warning_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Warning_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QText_TextField)
                    .addComponent(QName_TextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Option1_CheckBox)
                                .addComponent(Option3_CheckBox))
                            .addComponent(Option4_CheckBox, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option2_CheckBox, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option5_CheckBox, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Option5_TextField)
                            .addComponent(Option4_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option3_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option2_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option1_TextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AddQ_BT))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QDifficulty_Label)
                            .addComponent(QName_Label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(QMark_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Warning_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(QText_Label)
                            .addComponent(OptionNumber_Label)
                            .addComponent(OptionsNumber_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Options_Label)
                            .addComponent(QType_Label)
                            .addComponent(QType_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QMark_Label)
                            .addComponent(QDifficulty_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(QName_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QDifficulty_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QDifficulty_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QType_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QType_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QMark_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(QMark_TextField)
                    .addComponent(Warning_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QText_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QText_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionNumber_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionsNumber_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Options_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Option1_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Option1_CheckBox)
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Option2_CheckBox)
                    .addComponent(Option2_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Option3_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Option3_CheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Option4_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Option4_CheckBox))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Option5_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Option5_CheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(AddQ_BT)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OptionsNumber_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsNumber_ComboBoxActionPerformed
        String OptionsNumber = (String) OptionsNumber_ComboBox.getSelectedItem();
        switch(OptionsNumber){
            case "2":
                Option5_TextField.setVisible(false);
                Option5_CheckBox.setVisible(false);
                Option4_TextField.setVisible(false);
                Option4_CheckBox.setVisible(false);
                Option3_TextField.setVisible(false);
                Option3_CheckBox.setVisible(false);
                
                Option1_CheckBox.setSelected(false);
                Option2_CheckBox.setSelected(false);
                Option3_CheckBox.setSelected(false);
                Option4_CheckBox.setSelected(false);
                Option5_CheckBox.setSelected(false);
                break;
            case "3":
                Option5_TextField.setVisible(false);
                Option5_CheckBox.setVisible(false);
                Option4_TextField.setVisible(false);
                Option4_CheckBox.setVisible(false);
                Option3_TextField.setVisible(true);
                Option3_CheckBox.setVisible(true);
                
                Option1_CheckBox.setSelected(false);
                Option2_CheckBox.setSelected(false);
                Option3_CheckBox.setSelected(false);
                Option4_CheckBox.setSelected(false);
                Option5_CheckBox.setSelected(false);
                break;
            case "4":
                Option5_TextField.setVisible(false);
                Option5_CheckBox.setVisible(false);
                Option4_TextField.setVisible(true);
                Option4_CheckBox.setVisible(true);
                Option3_TextField.setVisible(true);
                Option3_CheckBox.setVisible(true);
                
                Option1_CheckBox.setSelected(false);
                Option2_CheckBox.setSelected(false);
                Option3_CheckBox.setSelected(false);
                Option4_CheckBox.setSelected(false);
                Option5_CheckBox.setSelected(false);
                break;
            case "5":
                Option5_TextField.setVisible(true);
                Option5_CheckBox.setVisible(true);
                Option4_TextField.setVisible(true);
                Option4_CheckBox.setVisible(true);
                Option3_TextField.setVisible(true);
                Option3_CheckBox.setVisible(true);
                
                Option1_CheckBox.setSelected(false);
                Option2_CheckBox.setSelected(false);
                Option3_CheckBox.setSelected(false);
                Option4_CheckBox.setSelected(false);
                Option5_CheckBox.setSelected(false);
                break;
        }
        OptionsUnchecked = 5;
        CheckEnablingBT();
    }//GEN-LAST:event_OptionsNumber_ComboBoxActionPerformed

    private void Option1_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option1_CheckBoxActionPerformed
        if (QType_ComboBox.getSelectedIndex() == 0) {
            Option2_CheckBox.setSelected(false);
            Option3_CheckBox.setSelected(false);
            Option4_CheckBox.setSelected(false);
            Option5_CheckBox.setSelected(false);
        }
        CountUncheckedOptions();
        CheckEnablingBT();
    }//GEN-LAST:event_Option1_CheckBoxActionPerformed

    private void Option2_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option2_CheckBoxActionPerformed
        if (QType_ComboBox.getSelectedIndex() == 0) {
            Option1_CheckBox.setSelected(false);
            Option3_CheckBox.setSelected(false);
            Option4_CheckBox.setSelected(false);
            Option5_CheckBox.setSelected(false);
        }
        CountUncheckedOptions();
        CheckEnablingBT();
    }//GEN-LAST:event_Option2_CheckBoxActionPerformed

    private void Option3_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option3_CheckBoxActionPerformed
        if (QType_ComboBox.getSelectedIndex() == 0) {
            Option1_CheckBox.setSelected(false);
            Option2_CheckBox.setSelected(false);
            Option4_CheckBox.setSelected(false);
            Option5_CheckBox.setSelected(false);
        }
        CountUncheckedOptions();
        CheckEnablingBT();
    }//GEN-LAST:event_Option3_CheckBoxActionPerformed

    private void Option4_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option4_CheckBoxActionPerformed
        if (QType_ComboBox.getSelectedIndex() == 0) {
            Option1_CheckBox.setSelected(false);
            Option2_CheckBox.setSelected(false);
            Option3_CheckBox.setSelected(false);
            Option5_CheckBox.setSelected(false);
        }
        CountUncheckedOptions();
        CheckEnablingBT();
    }//GEN-LAST:event_Option4_CheckBoxActionPerformed

    private void Option5_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option5_CheckBoxActionPerformed
        if (QType_ComboBox.getSelectedIndex() == 0) {
            Option1_CheckBox.setSelected(false);
            Option2_CheckBox.setSelected(false);
            Option3_CheckBox.setSelected(false);
            Option4_CheckBox.setSelected(false);
        }
        CountUncheckedOptions();
        CheckEnablingBT();
    }//GEN-LAST:event_Option5_CheckBoxActionPerformed

    private void QType_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QType_ComboBoxActionPerformed
        int QType = QType_ComboBox.getSelectedIndex();
        switch(QType){
            case 0:
                Options_Label.setText("Enter the question's options and check the correct option:");
                break;
            case 1:
                Options_Label.setText("Enter the question's options and check the correct options:");
                break;
        }
        Option1_CheckBox.setSelected(false);
        Option2_CheckBox.setSelected(false);
        Option3_CheckBox.setSelected(false);
        Option4_CheckBox.setSelected(false);
        Option5_CheckBox.setSelected(false);
        OptionsUnchecked = 5;
        CheckEnablingBT();
    }//GEN-LAST:event_QType_ComboBoxActionPerformed

    private void AddQ_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddQ_BTActionPerformed
        if (checkOptions()){
            initQ();
            if (checkQ()){
                Closing_BTClicked = true;
                QuestionList.add(Q);
                File QBank = new File("Files\\Question Bank.txt");
                QuestionBankHandler QBH = new QuestionBankHandler(QBank);
                QBH.write(Q);
                File Logs = new File("Files\\Logs.txt");
                Logger logger = new Logger(Logs);
                LogLevel level = LogLevel.INFO;
                logger.log(level, "A Question named: (" + Q.getQName() + ") has been added successfully");
                close();
                TeacherFrame teacher = new TeacherFrame();
                teacher.setVisible(true);
            }
        }
    }//GEN-LAST:event_AddQ_BTActionPerformed

    private void QDifficulty_ComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QDifficulty_ComboBoxMouseClicked
        CheckEnablingBT();
    }//GEN-LAST:event_QDifficulty_ComboBoxMouseClicked

    private void QType_ComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QType_ComboBoxMouseClicked
        CheckEnablingBT();
    }//GEN-LAST:event_QType_ComboBoxMouseClicked

    private void OptionsNumber_ComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptionsNumber_ComboBoxMouseClicked
        CheckEnablingBT();
    }//GEN-LAST:event_OptionsNumber_ComboBoxMouseClicked

    private void QMark_TextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QMark_TextFieldKeyTyped
        char c = evt.getKeyChar();
        QMark_TextField.setEditable(true);
        if (!Character.isDigit(c)){
            evt.consume();
            Warning_Panel.setVisible(true);
        }else{
            Warning_Panel.setVisible(false);
        }
    }//GEN-LAST:event_QMark_TextFieldKeyTyped

    private void QName_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QName_TextFieldKeyReleased
        CheckEnablingBT();
    }//GEN-LAST:event_QName_TextFieldKeyReleased

    private void QText_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QText_TextFieldKeyReleased
        CheckEnablingBT();
    }//GEN-LAST:event_QText_TextFieldKeyReleased

    private void Option_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Option_TextFieldKeyReleased
        CheckEnablingBT();
    }//GEN-LAST:event_Option_TextFieldKeyReleased

    private void QMark_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QMark_TextFieldKeyReleased
        CheckEnablingBT();
        char c = evt.getKeyChar();
        QMark_TextField.setEditable(true);
        if (!Character.isDigit(c)){
            evt.consume();
            Warning_Panel.setVisible(true);
        }else{
            Warning_Panel.setVisible(false);
        }
    }//GEN-LAST:event_QMark_TextFieldKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!Closing_BTClicked){
            TeacherFrame teacher = new TeacherFrame();
            teacher.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    
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
            java.util.logging.Logger.getLogger(AddQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuestionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddQ_BT;
    private javax.swing.JCheckBox Option1_CheckBox;
    private javax.swing.JTextField Option1_TextField;
    private javax.swing.JCheckBox Option2_CheckBox;
    private javax.swing.JTextField Option2_TextField;
    private javax.swing.JCheckBox Option3_CheckBox;
    private javax.swing.JTextField Option3_TextField;
    private javax.swing.JCheckBox Option4_CheckBox;
    private javax.swing.JTextField Option4_TextField;
    private javax.swing.JCheckBox Option5_CheckBox;
    private javax.swing.JTextField Option5_TextField;
    private javax.swing.JLabel OptionNumber_Label;
    private javax.swing.JComboBox<String> OptionsNumber_ComboBox;
    private javax.swing.JLabel Options_Label;
    private javax.swing.ButtonGroup Options_buttonGroup;
    private javax.swing.JComboBox<String> QDifficulty_ComboBox;
    private javax.swing.JLabel QDifficulty_Label;
    private javax.swing.JLabel QMark_Label;
    private javax.swing.JTextField QMark_TextField;
    private javax.swing.JLabel QName_Label;
    private javax.swing.JTextField QName_TextField;
    private javax.swing.JLabel QText_Label;
    private javax.swing.JTextField QText_TextField;
    private javax.swing.JComboBox<String> QType_ComboBox;
    private javax.swing.JLabel QType_Label;
    private javax.swing.JLabel Warning_Label;
    private javax.swing.JPanel Warning_Panel;
    // End of variables declaration//GEN-END:variables
}
