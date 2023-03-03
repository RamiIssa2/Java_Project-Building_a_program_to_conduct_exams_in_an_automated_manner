/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public abstract class Question {
        
    String QName;
    String QDifficulty;
    int QMark;
    String QText;
    ArrayList<String> OptionList;
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.QName);
        hash = 37 * hash + Objects.hashCode(this.QDifficulty);
        hash = 37 * hash + this.QMark;
        hash = 37 * hash + Objects.hashCode(this.QText);
        hash = 37 * hash + Objects.hashCode(this.OptionList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.QMark != other.QMark) {
            return false;
        }
        if (!Objects.equals(this.QName, other.QName)) {
            return false;
        }
        if (!Objects.equals(this.QDifficulty, other.QDifficulty)) {
            return false;
        }
        if (!Objects.equals(this.QText, other.QText)) {
            return false;
        }
        if (!Objects.equals(this.OptionList, other.OptionList)) {
            return false;
        }
        return true;
    }

    public String getQName() {
        return QName;
    }

    public String getQDifficulty() {
        return QDifficulty;
    }

    public int getQMark() {
        return QMark;
    }

    public String getQText() {
        return QText;
    }

    public ArrayList<String> getOptionList() {
        return OptionList;
    }
    
    
    public abstract JPanel render();
    public abstract int validate(ArrayList<String> SO);
}
