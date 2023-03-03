/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.QuestionBank.QListContains;
import static Classes.QuestionBank.QuestionList;
import Frames.AddQuestionFrame;
import Frames.TeacherFrame;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuestionBankHandler {
    
    private File QBank;
    private int QuestionNumber = 0;
    
    public QuestionBankHandler(File QBank){
        this.QBank = QBank;
    }
    
    public void write(Question Q){
        BufferedWriter bw = null;
        String QType;
        if (Q.getClass() == SingleQuestion.class){
            QType = "Single Answer";
        }else{
            QType = "Multiple Answer";
        }
        ArrayList<String> optionList = Q.getOptionList();
        try {
            if (!QBank.exists()){
                QBank.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(QBank, true));
            bw.write("QName: " + Q.getQName() + "\n");
            bw.write("QDifficulty: " + Q.getQDifficulty() + "\n");
            bw.write("QType: " + QType + "\n");
            bw.write("QMark: " + Q.getQMark() + "\n");
            bw.write("QText: " + Q.getQText() + "\n");
            for (String t : optionList){
                bw.write("QOption: " + t + "\n");
            }
            bw.write("%%\n");
            bw.close();
        } catch (IOException ex) {
                Logger.getLogger(AddQuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean CheckQuestion(ArrayList<String> Question){
        
        if ((Question.size() > 10) || (Question.size() < 7)){
            return false;
        }else if (!Question.get(0).startsWith("QName: ")){
            return false;
        }else if (!Question.get(1).startsWith("QDifficulty: ")){
            return false;
        }else if (!Question.get(2).startsWith("QType: ")){
            return false;
        }else if (!Question.get(3).startsWith("QMark: ")){
            return false;
        }else if (!Question.get(4).startsWith("QText: ")){
            return false;
        }else if (!Question.get(5).startsWith("QOption: ")){
            return false;
        }else if (!Question.get(6).startsWith("QOption: ")){
            return false;
        }else if (Question.size() > 7) {
            if (!Question.get(7).startsWith("QOption: ")){
                return false;
            }else if (Question.size() > 8){
                if (!Question.get(8).startsWith("QOption: ")){
                    return false;
                }else if (Question.size() > 9){
                    if (!Question.get(9).startsWith("QOption: ")){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
        }
        return true;
    }
    
    private void trimQuestion(ArrayList<String> Question){
        Question.set(0, Question.get(0).substring(7));
        Question.set(1, Question.get(1).substring(13));
        Question.set(2, Question.get(2).substring(7));
        Question.set(3, Question.get(3).substring(7));
        Question.set(4, Question.get(4).substring(7));
        Question.set(5, Question.get(5).substring(9));
        Question.set(6, Question.get(6).substring(9));
        if (Question.size() > 7) {
            Question.set(7, Question.get(7).substring(9));
            if (Question.size() > 8){
                Question.set(8, Question.get(8).substring(9));
                if (Question.size() > 9){
                    Question.set(9, Question.get(9).substring(9));
                }
            }
        }     
    }
    
    private boolean CheckDuplicatedOptions(Question Q){
        ArrayList<String> OL = Q.getOptionList();
        for (int i=0 ; i<OL.size() ; i++){
            for (int j=i+1 ; j<OL.size() ; j++){
                if (OL.get(i).equals(OL.get(j))){
                    return true;
                }
            }
        }
        return false;
    }
    
    private void addQuestion(ArrayList<String> Question) throws InvalidFormatException{
        if (CheckQuestion(Question)){
            Question Q;
            trimQuestion(Question);
            if (Question.get(2).equals("Single Answer")){
                Q = new SingleQuestion(Question);
            }else{
                Q = new MultipleQuestion(Question);
            }
            if (CheckDuplicatedOptions(Q)){
                throw new InvalidFormatException(QuestionNumber, 0);
            }else if (QListContains(Q)){
                throw new InvalidFormatException(QuestionNumber, 1);
            }else{
                QuestionList.add(Q);
            }
        }else{
            throw new InvalidFormatException(QuestionNumber, 2);
        }
    }
    
    public void read(){
        ArrayList<String> Question = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(QBank));
            String Line = br.readLine();
            while (Line != null){
                if (Line.equals("%%")){
                    QuestionNumber++;
                    try{
                        addQuestion(Question);
                    } catch (InvalidFormatException ex) {
                        File Logs = new File("Files\\Logs.txt");
                        Classes.Logger logger = new Classes.Logger(Logs);
                        ILogger.LogLevel level = ILogger.LogLevel.ERROR;
                        String msg = "";
                        switch(ex.getErrorType()){
                            case 0:
                                msg = "Question number " + ex.getQNumber() + " has Duplicated Options";
                                break;
                            case 1:
                                msg = "Question number " + ex.getQNumber() + " is a Duplicated Question ";
                                break;
                            case 2:
                                msg = "Question number " + ex.getQNumber() + " has an Invalid Question Format";
                                break;
                        }
                        logger.log(level, msg);
                    }
                    Question.clear();
                }else{
                    Question.add(Line);
                }
                Line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
