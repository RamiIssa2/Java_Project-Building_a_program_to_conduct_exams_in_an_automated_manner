/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface IExamGenerator {
    public void generate(int QNumber, String Difficulty, ArrayList<Question> Exam);
}
