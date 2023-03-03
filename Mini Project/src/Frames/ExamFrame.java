/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frames;

import Classes.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ExamFrame extends javax.swing.JFrame {

    private JButton Validate_BT;
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
    private ArrayList<boolean[]> QSelectedOptions = new ArrayList<>();
    private Question CurrentQ;
    
    private ArrayList<Question> ExamQuestions = new ArrayList<>();
    private ArrayList<Integer> QuestionMarks;
    private int Page = 1;
    private int QN = 0;
    private ExamReport ER;
    private boolean ShowAnswers = false;

    public ExamFrame() {
        initComponents();
    }

    public void setShowAnswers(boolean ShowAnswers) {
        this.ShowAnswers = ShowAnswers;
        Question_Panel.removeAll();
        Question_Panel.revalidate();
        Question_Panel.repaint();
        Submit_BT.setText("Exit");
        resetButtons();
    }
    
    public void setER(ExamReport ER) {
        this.ER = ER;
    }
    
    public void setExamQuestions(ArrayList<Question> ExamQuestions) {
        this.ExamQuestions = ExamQuestions;
        boolean[] tmp = new boolean[5];
        for (int i=0 ; i<5 ; i++){
            tmp[i] = false;
        }
        QuestionMarks = new ArrayList<>(ExamQuestions.size());
        for (int i = 0; i < ExamQuestions.size(); i++) {
            QuestionMarks.add(0);
            QSelectedOptions.add(tmp);
        }
        initQPages();
    }
    
    private void initQPages(){
        if (Page == 1){
            PreviousQPage_BT.setVisible(false);
        }else{
            PreviousQPage_BT.setVisible(true);
        }
        if (ExamQuestions.size() - (7 * Page) < 0){
            NextQPage_BT.setVisible(false);
        }else{
            NextQPage_BT.setVisible(true);
        }
        int PageOffset = 7 * (Page - 1);
        int CQ = ExamQuestions.size() - PageOffset;
        if (CQ < 7){
            switch (CQ){
                case 1:
                    Question_BT1.setVisible(true);
                    Question_BT1.setText("Question " + (1 + PageOffset));
                    Question_BT2.setVisible(false);
                    Question_BT3.setVisible(false);
                    Question_BT4.setVisible(false);
                    Question_BT5.setVisible(false);
                    Question_BT6.setVisible(false);
                    Question_BT7.setVisible(false);
                    break;
                case 2:
                    Question_BT1.setVisible(true);
                    Question_BT1.setText("Question " + (1 + PageOffset));
                    Question_BT2.setVisible(true);
                    Question_BT2.setText("Question " + (2 + PageOffset));
                    Question_BT3.setVisible(false);
                    Question_BT4.setVisible(false);
                    Question_BT5.setVisible(false);
                    Question_BT6.setVisible(false);
                    Question_BT7.setVisible(false);
                    break;
                case 3:
                    Question_BT1.setVisible(true);
                    Question_BT1.setText("Question " + (1 + PageOffset));
                    Question_BT2.setVisible(true);
                    Question_BT2.setText("Question " + (2 + PageOffset));
                    Question_BT3.setVisible(true);
                    Question_BT3.setText("Question " + (3 + PageOffset));
                    Question_BT4.setVisible(false);
                    Question_BT5.setVisible(false);
                    Question_BT6.setVisible(false);
                    Question_BT7.setVisible(false);
                    break;
                case 4:
                    Question_BT1.setVisible(true);
                    Question_BT1.setText("Question " + (1 + PageOffset));
                    Question_BT2.setVisible(true);
                    Question_BT2.setText("Question " + (2 + PageOffset));
                    Question_BT3.setVisible(true);
                    Question_BT3.setText("Question " + (3 + PageOffset));
                    Question_BT4.setVisible(true);
                    Question_BT4.setText("Question " + (4 + PageOffset));
                    Question_BT5.setVisible(false);
                    Question_BT6.setVisible(false);
                    Question_BT7.setVisible(false);
                    break;
                case 5:
                    Question_BT1.setVisible(true);
                    Question_BT1.setText("Question " + (1 + PageOffset));
                    Question_BT2.setVisible(true);
                    Question_BT2.setText("Question " + (2 + PageOffset));
                    Question_BT3.setVisible(true);
                    Question_BT3.setText("Question " + (3 + PageOffset));
                    Question_BT4.setVisible(true);
                    Question_BT4.setText("Question " + (4 + PageOffset));
                    Question_BT5.setVisible(true);
                    Question_BT5.setText("Question " + (5 + PageOffset));
                    Question_BT6.setVisible(false);
                    Question_BT7.setVisible(false);
                    break;
                case 6:
                    Question_BT1.setVisible(true);
                    Question_BT1.setText("Question " + (1 + PageOffset));
                    Question_BT2.setVisible(true);
                    Question_BT2.setText("Question " + (2 + PageOffset));
                    Question_BT3.setVisible(true);
                    Question_BT3.setText("Question " + (3 + PageOffset));
                    Question_BT4.setVisible(true);
                    Question_BT4.setText("Question " + (4 + PageOffset));
                    Question_BT5.setVisible(true);
                    Question_BT5.setText("Question " + (5 + PageOffset));
                    Question_BT6.setVisible(true);
                    Question_BT6.setText("Question " + (6 + PageOffset));
                    Question_BT7.setVisible(false);
                    break;
            }
        }else{
            Question_BT1.setVisible(true);
            Question_BT1.setText("Question " + (1 + PageOffset));
            Question_BT2.setVisible(true);
            Question_BT2.setText("Question " + (2 + PageOffset));
            Question_BT3.setVisible(true);
            Question_BT3.setText("Question " + (3 + PageOffset));
            Question_BT4.setVisible(true);
            Question_BT4.setText("Question " + (4 + PageOffset));
            Question_BT5.setVisible(true);
            Question_BT5.setText("Question " + (5 + PageOffset));
            Question_BT6.setVisible(true);
            Question_BT6.setText("Question " + (6 + PageOffset));
            Question_BT7.setVisible(true);
            Question_BT7.setText("Question " + (7 + PageOffset));
        }
        Pages_Label.setText("Page " + Page + "/" + (ExamQuestions.size()/7 + 1));
    }
    
    private void setSingleAnswerQuestionPanel(JPanel Question_Panel){
        QText_Label = new JLabel();
        Options_buttonGroup = new ButtonGroup();
        Option1_RadioButton = new JRadioButton();
        Option2_RadioButton = new JRadioButton();
        Option3_RadioButton = new JRadioButton();
        Option4_RadioButton = new JRadioButton();
        Option5_RadioButton = new JRadioButton();
        Validate_BT = new JButton();
        SelectedOptions_Label = new JLabel();
        SingleAnswerQuestionPanel QP = (SingleAnswerQuestionPanel) Question_Panel;
        this.CurrentQ = QP.SQ;
        
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

        Validate_BT.setText("Validate");
        Validate_BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Validate_BT_BTActionPerformed(evt);
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
                        .addComponent(Validate_BT, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(Validate_BT, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedOptions_Label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }
    
    private void setMultipleAnswerQuestionPanel (JPanel Question_Panel){
        Validate_BT = new JButton();
        SelectedOptions_Label = new JLabel();
        QText_Label = new JLabel();
        Option1_CheckBox = new JCheckBox();
        Option2_CheckBox = new JCheckBox();
        Option3_CheckBox = new JCheckBox();
        Option4_CheckBox = new JCheckBox();
        Option5_CheckBox = new JCheckBox();
        MultipleAnswerQuestionPanel QP = (MultipleAnswerQuestionPanel) Question_Panel;
        this.CurrentQ = QP.MQ;
        
        Validate_BT.setText("Validate");
        Validate_BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Validate_BT_BTActionPerformed(evt);
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
                        .addComponent(Validate_BT, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(Validate_BT, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
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
        ShowLastSelectedOptions();
    }
    
    private void ShowSelectedOptions(){
        Collections.sort(SelectedOptions);
        if (SelectedOptions.isEmpty()){
            SelectedOptions_Label.setText("No option is selected");
        }
        else if (SelectedOptions.size() == 1){
            SelectedOptions_Label.setText("Option " + SelectedOptions.get(0) + " is selected");
        }
        else if (SelectedOptions.size() == CurrentQ.getOptionList().size()){
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
    
    private void resetButtons(){
        Question_BT1.setForeground(Color.black);
        Question_BT2.setForeground(Color.black);
        Question_BT3.setForeground(Color.black);
        Question_BT4.setForeground(Color.black);
        Question_BT5.setForeground(Color.black);
        Question_BT6.setForeground(Color.black);
        Question_BT7.setForeground(Color.black);
    }
    
    private void showCurrectAnswers(){
        ArrayList<String> COP = CurrentQ.getOptionList();
        int i = 1;
        for (String t : COP){
            if(t.endsWith(" (T)")){
                if (CurrentQ.getClass() == SingleQuestion.class){
                    switch(i){
                        case 1:
                            Option1_RadioButton.setSelected(true);
                            Option1_RadioButton.setForeground(Color.green);
                            break;
                        case 2:
                            Option2_RadioButton.setSelected(true);
                            Option2_RadioButton.setForeground(Color.green);
                            break;
                        case 3:
                            Option3_RadioButton.setSelected(true);
                            Option3_RadioButton.setForeground(Color.green);
                            break;
                        case 4:
                            Option4_RadioButton.setSelected(true);
                            Option4_RadioButton.setForeground(Color.green);
                            break;
                        case 5:
                            Option5_RadioButton.setSelected(true);
                            Option5_RadioButton.setForeground(Color.green);
                            break;
                    }
                }else{
                    switch(i){
                        case 1:
                            Option1_CheckBox.setSelected(true);
                            Option1_CheckBox.setForeground(Color.green);
                            break;
                        case 2:
                            Option2_CheckBox.setSelected(true);
                            Option2_CheckBox.setForeground(Color.green);
                            break;
                        case 3:
                            Option3_CheckBox.setSelected(true);
                            Option3_CheckBox.setForeground(Color.green);
                            break;
                        case 4:
                            Option4_CheckBox.setSelected(true);
                            Option4_CheckBox.setForeground(Color.green);
                            break;
                        case 5:
                            Option5_CheckBox.setSelected(true);
                            Option5_CheckBox.setForeground(Color.green);
                            break;
                    }
                }
            }else{
                if (CurrentQ.getClass() == SingleQuestion.class){
                    switch(i){
                        case 1:
                            Option1_RadioButton.setSelected(false);
                            Option1_RadioButton.setForeground(Color.black);
                            break;
                        case 2:
                            Option2_RadioButton.setSelected(false);
                            Option2_RadioButton.setForeground(Color.black);
                            break;
                        case 3:
                            Option3_RadioButton.setSelected(false);
                            Option3_RadioButton.setForeground(Color.black);
                            break;
                        case 4:
                            Option4_RadioButton.setSelected(false);
                            Option4_RadioButton.setForeground(Color.black);
                            break;
                        case 5:
                            Option5_RadioButton.setSelected(false);
                            Option5_RadioButton.setForeground(Color.black);
                            break;
                    }
                }else{
                    switch(i){
                        case 1:
                            Option1_CheckBox.setSelected(false);
                            Option1_CheckBox.setForeground(Color.black);
                            break;
                        case 2:
                            Option2_CheckBox.setSelected(false);
                            Option2_CheckBox.setForeground(Color.black);
                            break;
                        case 3:
                            Option3_CheckBox.setSelected(false);
                            Option3_CheckBox.setForeground(Color.black);
                            break;
                        case 4:
                            Option4_CheckBox.setSelected(false);
                            Option4_CheckBox.setForeground(Color.black);
                            break;
                        case 5:
                            Option5_CheckBox.setSelected(false);
                            Option5_CheckBox.setForeground(Color.black);
                            break;
                    }
                }
            }
            i++;
        }
    }
    
    private void ShowLastSelectedOptions(){
        if (CurrentQ.getClass() == SingleQuestion.class){
            Option1_RadioButton.setSelected(QSelectedOptions.get(QN)[0]);
            Option2_RadioButton.setSelected(QSelectedOptions.get(QN)[1]);
            Option3_RadioButton.setSelected(QSelectedOptions.get(QN)[2]);
            Option4_RadioButton.setSelected(QSelectedOptions.get(QN)[3]);
            Option5_RadioButton.setSelected(QSelectedOptions.get(QN)[4]);
        }else{
            Option1_CheckBox.setSelected(QSelectedOptions.get(QN)[0]);
            Option2_CheckBox.setSelected(QSelectedOptions.get(QN)[1]);
            Option3_CheckBox.setSelected(QSelectedOptions.get(QN)[2]);
            Option4_CheckBox.setSelected(QSelectedOptions.get(QN)[3]);
            Option5_CheckBox.setSelected(QSelectedOptions.get(QN)[4]);
        }
    }
    
    private void UpdateQSelectedOptions(){
        if (CurrentQ.getClass() == SingleQuestion.class){
            boolean[] tmp = new boolean[5];
            tmp[0] = Option1_RadioButton.isSelected();
            tmp[1] = Option2_RadioButton.isSelected();
            tmp[2] = Option3_RadioButton.isSelected();
            tmp[3] = Option4_RadioButton.isSelected();
            tmp[4] = Option5_RadioButton.isSelected();
            QSelectedOptions.set(QN, tmp);
        }else{
            boolean[] tmp = new boolean[5];
            tmp[0] = Option1_CheckBox.isSelected();
            tmp[1] = Option2_CheckBox.isSelected();
            tmp[2] = Option3_CheckBox.isSelected();
            tmp[3] = Option4_CheckBox.isSelected();
            tmp[4] = Option5_CheckBox.isSelected();
            QSelectedOptions.set(QN, tmp);
        }
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Question_Panel = new javax.swing.JPanel();
        QuestionList_Panel = new javax.swing.JPanel();
        Question_BT1 = new javax.swing.JButton();
        Question_BT2 = new javax.swing.JButton();
        Question_BT3 = new javax.swing.JButton();
        Question_BT4 = new javax.swing.JButton();
        Question_BT5 = new javax.swing.JButton();
        Question_BT6 = new javax.swing.JButton();
        Question_BT7 = new javax.swing.JButton();
        NextQPage_BT = new javax.swing.JButton();
        PreviousQPage_BT = new javax.swing.JButton();
        Pages_Label = new javax.swing.JLabel();
        Submit_BT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exam");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Question_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Question_Panel.setPreferredSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout Question_PanelLayout = new javax.swing.GroupLayout(Question_Panel);
        Question_Panel.setLayout(Question_PanelLayout);
        Question_PanelLayout.setHorizontalGroup(
            Question_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        Question_PanelLayout.setVerticalGroup(
            Question_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        QuestionList_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        QuestionList_Panel.setMinimumSize(new java.awt.Dimension(200, 400));

        Question_BT1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Question_BT1.setText("Question 1");
        Question_BT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Question_BTActionPerformed(evt);
            }
        });

        Question_BT2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Question_BT2.setText("Question 2");
        Question_BT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Question_BTActionPerformed(evt);
            }
        });

        Question_BT3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Question_BT3.setText("Question 3");
        Question_BT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Question_BTActionPerformed(evt);
            }
        });

        Question_BT4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Question_BT4.setText("Question 4");
        Question_BT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Question_BTActionPerformed(evt);
            }
        });

        Question_BT5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Question_BT5.setText("Question 5");
        Question_BT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Question_BTActionPerformed(evt);
            }
        });

        Question_BT6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Question_BT6.setText("Question 6");
        Question_BT6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Question_BTActionPerformed(evt);
            }
        });

        Question_BT7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Question_BT7.setText("Question 7");
        Question_BT7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Question_BTActionPerformed(evt);
            }
        });

        NextQPage_BT.setText(">");
        NextQPage_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextQPage_BTActionPerformed(evt);
            }
        });

        PreviousQPage_BT.setText("<");
        PreviousQPage_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousQPage_BTActionPerformed(evt);
            }
        });

        Pages_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pages_Label.setText("Page 1/1");

        javax.swing.GroupLayout QuestionList_PanelLayout = new javax.swing.GroupLayout(QuestionList_Panel);
        QuestionList_Panel.setLayout(QuestionList_PanelLayout);
        QuestionList_PanelLayout.setHorizontalGroup(
            QuestionList_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuestionList_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QuestionList_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Question_BT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Question_BT2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(Question_BT3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(Question_BT4, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(Question_BT5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(Question_BT6, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(Question_BT7, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuestionList_PanelLayout.createSequentialGroup()
                .addComponent(PreviousQPage_BT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pages_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NextQPage_BT))
        );
        QuestionList_PanelLayout.setVerticalGroup(
            QuestionList_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuestionList_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Question_BT1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Question_BT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Question_BT3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Question_BT4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Question_BT5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Question_BT6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Question_BT7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(QuestionList_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NextQPage_BT)
                    .addComponent(PreviousQPage_BT)
                    .addComponent(Pages_Label)))
        );

        Submit_BT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Submit_BT.setText("Submit");
        Submit_BT.setPreferredSize(new java.awt.Dimension(100, 31));
        Submit_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_BTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(QuestionList_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Question_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(Submit_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Question_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Submit_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(QuestionList_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NextQPage_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextQPage_BTActionPerformed
        Page++;
        initQPages();
        resetButtons();
    }//GEN-LAST:event_NextQPage_BTActionPerformed

    private void PreviousQPage_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousQPage_BTActionPerformed
        Page--;
        initQPages();
        resetButtons();
    }//GEN-LAST:event_PreviousQPage_BTActionPerformed

    private void Question_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Question_BTActionPerformed
        Question_Panel.removeAll();
        SelectedOptions.clear();
        resetButtons();
        Object source = evt.getSource();
        ((JButton) source).setForeground(Color.red);
        QN = Integer.parseInt(((JButton) source).getText().substring(9)) - 1;
        JPanel Q_panel = ExamQuestions.get(QN).render();
        this.setQuestion_Panel(Q_panel);
        if (ShowAnswers){
            Validate_BT.setVisible(false);
            SelectedOptions_Label.setVisible(false);
            showCurrectAnswers();
        }
    }//GEN-LAST:event_Question_BTActionPerformed

    private void Submit_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_BTActionPerformed
        if (ShowAnswers){
            close();
        }else{
            int fullMark = 0;
            int totalMark = 0;
            for (Question Q : ExamQuestions){
                fullMark += Q.getQMark();
            }
            for (int M : QuestionMarks){
                totalMark += M;
            }
            ER.setEScore((100*totalMark)/fullMark);
            File ExamReports = new File("Files\\Exam Reports.txt");
            BufferedWriter bw = null;
            try {
                if (!ExamReports.exists()){
                    ExamReports.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(ExamReports, true));
                bw.write("Student Name: " + ER.getStudentName() + "\n");
                bw.write("Exam Difficulty: " + ER.getEDifficulty() + "\n");
                bw.write("Number of Questions: " + ER.getQNumber() + "\n");
                bw.write("Exam Genertor: " + ER.getEGenerator() + "\n");
                bw.write("Exam Score: " + ER.getEScore() + "/100\n");
                bw.write("%%\n");
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(AddQuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            File Logs = new File("Files\\Logs.txt");
            Classes.Logger logger = new Classes.Logger(Logs);
            ILogger.LogLevel level = ILogger.LogLevel.INFO;
            logger.log(level, "An Exam has been taken by student named: (" + ER.getStudentName() + ") with a score: (" + ER.getEScore() + "/100)");
            ExamReportFrame ERF = new ExamReportFrame();
            ERF.setExamReport_Label(ER);
            ERF.setLastFrame(this);
            ERF.setVisible(true);
        }
        
    }//GEN-LAST:event_Submit_BTActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        close();
        MainFrame MF = new MainFrame();
        MF.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    
    private void Option1_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            if (Option1_CheckBox.isSelected()){
                SelectedOptions.add("1");
            }
            else{
                SelectedOptions.remove("1");
            }
            ShowSelectedOptions();
        }
    }                                                

    private void Option2_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            if (Option2_CheckBox.isSelected()){
                SelectedOptions.add("2");
            }
            else{
                SelectedOptions.remove("2");
            }
            ShowSelectedOptions();
        }
    }                                                

    private void Option3_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            if (Option3_CheckBox.isSelected()){
                SelectedOptions.add("3");
            }
            else{
                SelectedOptions.remove("3");
            }
            ShowSelectedOptions();
        }
    }                                                

    private void Option4_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            if (Option4_CheckBox.isSelected()){
                SelectedOptions.add("4");
            }
            else{
                SelectedOptions.remove("4");
            }
            ShowSelectedOptions();
        }
    }                                                

    private void Option5_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            if (Option5_CheckBox.isSelected()){
                SelectedOptions.add("5");
            }
            else{
                SelectedOptions.remove("5");
            }
            ShowSelectedOptions();
        }
    }
    
    private void Option1_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            SelectedOptions_Label.setText("Option 1 is selected");
            SelectedOptions.clear();
            SelectedOptions.add("1");
        }
    }
    
    private void Option2_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            SelectedOptions_Label.setText("Option 2 is selected");
            SelectedOptions.clear();
            SelectedOptions.add("2");
        }
    }
    
    private void Option3_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            SelectedOptions_Label.setText("Option 3 is selected");
            SelectedOptions.clear();
            SelectedOptions.add("3");
        }
    }
    
    private void Option4_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            SelectedOptions_Label.setText("Option 4 is selected");
            SelectedOptions.clear();
            SelectedOptions.add("4");
        }
    }
    
    private void Option5_RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        if (ShowAnswers){
            showCurrectAnswers();
        }else{
            SelectedOptions_Label.setText("Option 5 is selected");
            SelectedOptions.clear();
            SelectedOptions.add("5");
        }
    }
    
    private void Validate_BT_BTActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int QTotalMark = CurrentQ.validate(SelectedOptions);
        QuestionMarks.set(QN, QTotalMark);
        UpdateQSelectedOptions();
    }
    
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
            java.util.logging.Logger.getLogger(ExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NextQPage_BT;
    private javax.swing.JLabel Pages_Label;
    private javax.swing.JButton PreviousQPage_BT;
    private javax.swing.JPanel QuestionList_Panel;
    private javax.swing.JButton Question_BT1;
    private javax.swing.JButton Question_BT2;
    private javax.swing.JButton Question_BT3;
    private javax.swing.JButton Question_BT4;
    private javax.swing.JButton Question_BT5;
    private javax.swing.JButton Question_BT6;
    private javax.swing.JButton Question_BT7;
    private javax.swing.JPanel Question_Panel;
    private javax.swing.JButton Submit_BT;
    // End of variables declaration//GEN-END:variables

}
