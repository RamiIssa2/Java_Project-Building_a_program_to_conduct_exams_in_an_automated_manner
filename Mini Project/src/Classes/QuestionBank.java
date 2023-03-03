/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;


public class QuestionBank {
    
    public static ArrayList<Question> QuestionList = new ArrayList<>();
    public static boolean InvalidQBank = false;
    
    public static boolean QListContains(Question Q){
        boolean r = false;
        for (Question q : QuestionList){
            if (q.equals(Q)){
                r = true;
                break;
            }
        }
        return r;
    }
}
