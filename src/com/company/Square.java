package com.company;

import java.util.Dictionary;
import java.util.Hashtable;

public class Square {

    int line, column;
    boolean isQueen;

    public Square(int line, int column){
        this.line = line;
        this.column = column;
        this.isQueen = false;
    }

    public String toString(){
        return "Linha "+line+", coluna "+column+", rainha: "+isQueen;
    }


}
