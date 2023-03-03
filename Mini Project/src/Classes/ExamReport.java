/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Asus
 */
public class ExamReport {
    
    private String StudentName;
    private String EDifficulty;
    private int QNumber;
    private String EGenerator;
    private int EScore;

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getEDifficulty() {
        return EDifficulty;
    }

    public void setEDifficulty(String EDifficulty) {
        this.EDifficulty = EDifficulty;
    }

    public int getQNumber() {
        return QNumber;
    }

    public void setQNumber(int QNumber) {
        this.QNumber = QNumber;
    }

    public String getEGenerator() {
        return EGenerator;
    }

    public void setEGenerator(String EGenerator) {
        this.EGenerator = EGenerator;
    }

    public int getEScore() {
        return EScore;
    }

    public void setEScore(int EScore) {
        this.EScore = EScore;
    }
    
    
}
