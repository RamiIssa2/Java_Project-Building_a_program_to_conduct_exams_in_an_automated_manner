/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.QuestionBank.QuestionList;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class RandomExamGenerator implements IExamGenerator {

    @Override
    public void generate(int QNumber, String Difficulty, ArrayList<Question> Exam) {
        BasicExamGenerator BEG = new BasicExamGenerator();
        ArrayList<Question> BExam = new ArrayList<>();
        BEG.generate(QuestionList.size(), Difficulty,BExam);
        Exam.clear();
        Random rand = new Random();
        int BSize = BExam.size();
        for (int i=0 ; (i<BSize && i<QNumber) ; i++){
            int j = rand.nextInt(BExam.size());
            Exam.add(BExam.get(j));
            BExam.remove(j);
        }
    }
    
}
