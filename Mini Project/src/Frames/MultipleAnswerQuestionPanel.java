/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.MultipleQuestion;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class MultipleAnswerQuestionPanel extends javax.swing.JPanel {

    private ArrayList<Integer> SelectedOptions = new ArrayList<>();
    MultipleQuestion MQ;
    JFrame Current_Frame;
    
    public MultipleAnswerQuestionPanel() {
        initComponents();
    }

    public JCheckBox getOption1_CheckBox() {
        return Option1_CheckBox;
    }

    public JCheckBox getOption2_CheckBox() {
        return Option2_CheckBox;
    }

    public JCheckBox getOption3_CheckBox() {
        return Option3_CheckBox;
    }

    public JCheckBox getOption4_CheckBox() {
        return Option4_CheckBox;
    }

    public JCheckBox getOption5_CheckBox() {
        return Option5_CheckBox;
    }

    public JLabel getQText_Label() {
        return QText_Label;
    }

    public JLabel getSelectedOptions_Label() {
        return SelectedOptions_Label;
    }

    public JButton getSubmit_BT() {
        return Submit_BT;
    }
    
    public void setMQ(MultipleQuestion MQ) {
        this.MQ = MQ;
    }
    
    public void setCurrent_Frame(JFrame Current_Frame) {
        this.Current_Frame = Current_Frame;
    }
    
    private void ShowSelectedOptions(){
        Collections.sort(SelectedOptions);
        if (SelectedOptions.isEmpty()){
            SelectedOptions_Label.setText("No option is selected");
        }
        else if (SelectedOptions.size() == 1){
            SelectedOptions_Label.setText("Option " + SelectedOptions.get(0) + " is selected");
        }
        else{
            String temp = "Options ";
            int i = 0;
            for (int t : SelectedOptions){
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
    
    private void setOption(String temp, int n){
        switch(n){
            case 1:
                if(temp.endsWith(" (T)")){
                    Option1_CheckBox.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option1_CheckBox.setText(temp);
                }
                break;
            case 2:
                if(temp.endsWith(" (T)")){
                    Option2_CheckBox.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option2_CheckBox.setText(temp);
                }
                break;
            case 3:
                if(temp.endsWith(" (T)")){
                    Option3_CheckBox.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option3_CheckBox.setText(temp);
                }
                break;
            case 4:
                if(temp.endsWith(" (T)")){
                    Option4_CheckBox.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option4_CheckBox.setText(temp);
                }
                break;
            case 5:
                if(temp.endsWith(" (T)")){
                    Option5_CheckBox.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option5_CheckBox.setText(temp);
                }
                break;
            default:
                break;
        }
    }
    
    public void render(){
        QText_Label.setText(MQ.getQText());
        String temp = MQ.getOptionList().get(0);
        setOption(temp, 1);
        temp = MQ.getOptionList().get(1);
        setOption(temp, 2);
        int tempSize = MQ.getOptionList().size();
        switch(tempSize){
            case 2:
                Option5_CheckBox.setVisible(false);
                Option4_CheckBox.setVisible(false);
                Option3_CheckBox.setVisible(false);
                break;
            case 3:
                Option5_CheckBox.setVisible(false);
                Option4_CheckBox.setVisible(false);
                temp = MQ.getOptionList().get(2);
                setOption(temp, 3);
                break;
            case 4:
                Option5_CheckBox.setVisible(false);
                temp = MQ.getOptionList().get(2);
                setOption(temp, 3);
                temp = MQ.getOptionList().get(3);
                setOption(temp, 4);
                break;
            case 5:
                temp = MQ.getOptionList().get(2);
                setOption(temp, 3);
                temp = MQ.getOptionList().get(3);
                setOption(temp, 4);
                temp = MQ.getOptionList().get(4);
                setOption(temp, 5);
                break;
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Submit_BT = new javax.swing.JButton();
        SelectedOptions_Label = new javax.swing.JLabel();
        QText_Label = new javax.swing.JLabel();
        Option1_CheckBox = new javax.swing.JCheckBox();
        Option2_CheckBox = new javax.swing.JCheckBox();
        Option3_CheckBox = new javax.swing.JCheckBox();
        Option4_CheckBox = new javax.swing.JCheckBox();
        Option5_CheckBox = new javax.swing.JCheckBox();

        Submit_BT.setText("Submit");

        SelectedOptions_Label.setText("No option is selected");

        QText_Label.setText("Question text");

        Option1_CheckBox.setText("Option 1");

        Option2_CheckBox.setText("Option 2");

        Option3_CheckBox.setText("Option 3");

        Option4_CheckBox.setText("Option 4");

        Option5_CheckBox.setText("Option 5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Option5_CheckBox)
                    .addComponent(Option4_CheckBox)
                    .addComponent(Option3_CheckBox)
                    .addComponent(Option2_CheckBox)
                    .addComponent(Option1_CheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Submit_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectedOptions_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                    .addComponent(QText_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(QText_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option1_CheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option2_CheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option3_CheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option4_CheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option5_CheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedOptions_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Option1_CheckBox;
    private javax.swing.JCheckBox Option2_CheckBox;
    private javax.swing.JCheckBox Option3_CheckBox;
    private javax.swing.JCheckBox Option4_CheckBox;
    private javax.swing.JCheckBox Option5_CheckBox;
    private javax.swing.JLabel QText_Label;
    private javax.swing.JLabel SelectedOptions_Label;
    private javax.swing.JButton Submit_BT;
    // End of variables declaration//GEN-END:variables
}
