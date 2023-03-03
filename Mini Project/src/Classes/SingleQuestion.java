/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Frames.SingleAnswerQuestionPanel;
import java.util.ArrayList;
import javax.swing.JPanel;

public class SingleQuestion extends Question {
    
    public SingleQuestion(ArrayList<String> SL){
        OptionList = new ArrayList<>();
        QName = SL.get(0);
        QDifficulty = SL.get(1);
        QMark = Integer.parseInt(SL.get(3));
        QText = SL.get(4);
        for (int i=5 ; i<SL.size() ; i++){
            OptionList.add(SL.get(i));
        }
    }


    @Override
    public JPanel render() {
        SingleAnswerQuestionPanel SAQ = new SingleAnswerQuestionPanel();
        SAQ.setSQ(this);
        SAQ.render();
        return SAQ;
    }

    @Override
    public int validate(ArrayList<String> SO) {
        int TotalMark = 0;
        for (String t : SO){
            int i = Integer.parseInt(SO.get(0));
            if (OptionList.get(i-1).endsWith(" (T)")){
                TotalMark = QMark;
            }
        }
        return TotalMark;
    }
    
}
