/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Frames.MultipleAnswerQuestionPanel;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class MultipleQuestion extends Question {

    public MultipleQuestion(ArrayList<String> SL){
        OptionList = new ArrayList<>();
        QName = SL.get(0);
        QDifficulty = SL.get(1);
        QMark = Integer.parseInt(SL.get(3));
        QText = SL.get(4);
        for (int i=5 ; i<SL.size() ; i++){
            OptionList.add(SL.get(i));
        }
    }

    public int getNumberOfCorrectAnswers(){
        int i = 0;
        for (String t : OptionList){
            if (t.endsWith(" (T)")){
                i++;
            }
        }
        return i;
    }
    
    
    @Override
    public JPanel render() {
        MultipleAnswerQuestionPanel MAQ = new MultipleAnswerQuestionPanel();
        MAQ.setMQ(this);
        MAQ.render();
        return MAQ;
    }

    @Override
    public int validate(ArrayList<String> SO) {
        int OptionMark = QMark / this.getNumberOfCorrectAnswers();
        int TotalMark = 0;
        int CON = 0;
        int FON = 0;
        for (String t : SO){
            int i = Integer.parseInt(t);
            if (OptionList.get(i-1).endsWith(" (T)")){
                CON++;
                TotalMark += OptionMark;
            }else{
                FON++;
                TotalMark -= OptionMark;
            }
        }
        if ((CON == this.getNumberOfCorrectAnswers()) && (FON == 0)){
            TotalMark = QMark;
        }
        if (TotalMark < 0){
            TotalMark = 0;
        }
        return TotalMark;
    }
    
}
