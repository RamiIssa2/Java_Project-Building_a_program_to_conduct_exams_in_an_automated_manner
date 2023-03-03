/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.SingleQuestion;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Asus
 */
public class SingleAnswerQuestionPanel extends javax.swing.JPanel {

    SingleQuestion SQ;
    JFrame Current_Frame;
    
    public SingleAnswerQuestionPanel() {
        initComponents();
    }

    public JRadioButton getOption1_RadioButton() {
        return Option1_RadioButton;
    }

    public JRadioButton getOption2_RadioButton() {
        return Option2_RadioButton;
    }

    public JRadioButton getOption3_RadioButton() {
        return Option3_RadioButton;
    }

    public JRadioButton getOption4_RadioButton() {
        return Option4_RadioButton;
    }

    public JRadioButton getOption5_RadioButton() {
        return Option5_RadioButton;
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

    
    
    public void setSQ(SingleQuestion SQ) {
        this.SQ = SQ;
    }

    public void setCurrent_Frame(JFrame Current_Frame) {
        this.Current_Frame = Current_Frame;
    }
    
    private void setOption(String temp, int n){
        switch(n){
            case 1:
                if(temp.endsWith(" (T)")){
                    Option1_RadioButton.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option1_RadioButton.setText(temp);
                }
                break;
            case 2:
                if(temp.endsWith(" (T)")){
                    Option2_RadioButton.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option2_RadioButton.setText(temp);
                }
                break;
            case 3:
                if(temp.endsWith(" (T)")){
                    Option3_RadioButton.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option3_RadioButton.setText(temp);
                }
                break;
            case 4:
                if(temp.endsWith(" (T)")){
                    Option4_RadioButton.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option4_RadioButton.setText(temp);
                }
                break;
            case 5:
                if(temp.endsWith(" (T)")){
                    Option5_RadioButton.setText(temp.substring(0, temp.length()-4));
                }else{
                    Option5_RadioButton.setText(temp);
                }
                break;
            default:
                break;
        }
    }
    
    public void render(){
        QText_Label.setText(SQ.getQText());
        String temp = SQ.getOptionList().get(0);
        setOption(temp, 1);
        temp = SQ.getOptionList().get(1);
        setOption(temp, 2);
        int tempSize = SQ.getOptionList().size();
        switch(tempSize){
            case 2:
                Option5_RadioButton.setVisible(false);
                Option4_RadioButton.setVisible(false);
                Option3_RadioButton.setVisible(false);
                break;
            case 3:
                Option5_RadioButton.setVisible(false);
                Option4_RadioButton.setVisible(false);
                temp = SQ.getOptionList().get(2);
                setOption(temp, 3);
                break;
            case 4:
                Option5_RadioButton.setVisible(false);
                temp = SQ.getOptionList().get(2);
                setOption(temp, 3);
                temp = SQ.getOptionList().get(3);
                setOption(temp, 4);
                break;
            case 5:
                temp = SQ.getOptionList().get(2);
                setOption(temp, 3);
                temp = SQ.getOptionList().get(3);
                setOption(temp, 4);
                temp = SQ.getOptionList().get(4);
                setOption(temp, 5);
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QText_Label = new javax.swing.JLabel();
        Option1_RadioButton = new javax.swing.JRadioButton();
        Option2_RadioButton = new javax.swing.JRadioButton();
        Option3_RadioButton = new javax.swing.JRadioButton();
        Option4_RadioButton = new javax.swing.JRadioButton();
        Option5_RadioButton = new javax.swing.JRadioButton();
        Submit_BT = new javax.swing.JButton();
        SelectedOptions_Label = new javax.swing.JLabel();

        QText_Label.setText("Question text");

        Option1_RadioButton.setText("Option 1");

        Option2_RadioButton.setText("Option 2");

        Option3_RadioButton.setText("Option 3");

        Option4_RadioButton.setText("Option 4");

        Option5_RadioButton.setText("Option 5");

        Submit_BT.setText("Submit");

        SelectedOptions_Label.setText("No option is selected");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Submit_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectedOptions_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                    .addComponent(QText_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Option2_RadioButton)
                    .addComponent(Option1_RadioButton)
                    .addComponent(Option3_RadioButton)
                    .addComponent(Option4_RadioButton)
                    .addComponent(Option5_RadioButton))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(QText_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option1_RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option2_RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option3_RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option4_RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Option5_RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedOptions_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Option1_RadioButton;
    private javax.swing.JRadioButton Option2_RadioButton;
    private javax.swing.JRadioButton Option3_RadioButton;
    private javax.swing.JRadioButton Option4_RadioButton;
    private javax.swing.JRadioButton Option5_RadioButton;
    private javax.swing.JLabel QText_Label;
    private javax.swing.JLabel SelectedOptions_Label;
    private javax.swing.JButton Submit_BT;
    // End of variables declaration//GEN-END:variables
}
