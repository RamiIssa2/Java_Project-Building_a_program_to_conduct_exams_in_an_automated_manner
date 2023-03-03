/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.QuestionBank.QuestionList;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class BasicExamGenerator implements IExamGenerator {

    @Override
    public void generate(int QNumber, String Difficulty, ArrayList<Question> Exam) {
        Exam.clear();
        int i = 0;
        for (Question Q : QuestionList){
            if(i == QNumber){
                break;
            }else if (Q.QDifficulty.equals(Difficulty)){
                Exam.add(Q);
                i++;
            }
        }
    }
    
}
