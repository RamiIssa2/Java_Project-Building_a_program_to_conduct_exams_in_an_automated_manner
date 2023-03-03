/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.QuestionBank.InvalidQBank;

public class InvalidFormatException extends Exception {
    
    private int QNumber;
    private int ErrorType;
    
    public InvalidFormatException(int QNumber, int ErrorType){
        this.QNumber = QNumber;
        this.ErrorType = ErrorType;
        InvalidQBank = true;
    }

    public int getQNumber() {
        return QNumber;
    }

    public int getErrorType() {
        return ErrorType;
    }
    
}
