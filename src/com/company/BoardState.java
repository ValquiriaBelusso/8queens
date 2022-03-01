package com.company;

import java.util.*;

public class BoardState {

    List<Square> board;

    public BoardState()  {
        this.board = new LinkedList<Square>();
    }

    public List<Square> getEmptySquares(){
        List<Square> emptySquares = new LinkedList<Square>();
        for (Square square : board) {
            if(!square.isQueen){
                emptySquares.add(square);
            }
        }
        return emptySquares;
    }

    public List<Square> getFilledSquares(){
        List<Square> filledSquares = new LinkedList<Square>();
        for (Square square : board) {
            if(square.isQueen){
                filledSquares.add(square);
            }
        }
        return filledSquares;
    }

    public void putQueen(int line, int column){
        for(Square square : board){
            if((square.line==line)&&(square.column==column)){
                square.isQueen=true;
            }
        }
    }

    public int conflicts(){
        int conflicts=0;

        return conflicts;
    }

    public Dictionary<Square, Integer> getConflictsList(){
        Dictionary<Square, Integer> conflicts = new Hashtable<Square, Integer>();

        for(Square square : this.getFilledSquares()){
            int m,n;
            m = square.line;
            n = square.column;

            //linha
            for(int i=0; i<8; i++){
                if(i!=n){
//                    System.out.println("{"+m+","+i+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==m)&&(square1.column==i)){
                            if(conflicts.get(square)==null){
                                conflicts.put(square,1);
                            }else{
                                int aux=conflicts.get(square);
                                aux++;
                                conflicts.put(square,aux);
                            }
                        }
                    }
                }
            }
            //System.out.println("----------");
            //coluna
            for(int i=0; i<8; i++){
                if(i!=m){
                    //System.out.println("{"+i+","+n+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==n)){
                            if(conflicts.get(square)==null){
                                conflicts.put(square,1);
                            }else{
                                int aux=conflicts.get(square);
                                aux++;
                                conflicts.put(square,aux);
                            }
                        }
                    }
                }
            }
            //System.out.println("----------");
            //diagonais
            int j=n;
            int k=n;
            for(int i=m-1; i>=0; i--){
                j--;
                k++;
                if(j>=0){
                    //System.out.println("{"+i+","+j+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==j)){
                            if(conflicts.get(square)==null){
                                conflicts.put(square,1);
                            }else{
                                int aux=conflicts.get(square);
                                aux++;
                                conflicts.put(square,aux);
                            }
                        }
                    }
                }
                if(k<8){
                    //System.out.println("{"+i+","+k+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==k)){
                            if(conflicts.get(square)==null){
                                conflicts.put(square,1);
                            }else{
                                int aux=conflicts.get(square);
                                aux++;
                                conflicts.put(square,aux);
                            }
                        }
                    }
                }
            }
            j=n;
            k=n;
            for(int i=m+1; i<8; i++){
                j--;
                k++;
                if(j>=0){
                    //System.out.println("{"+i+","+j+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==j)){
                            if(conflicts.get(square)==null){
                                conflicts.put(square,1);
                            }else{
                                int aux=conflicts.get(square);
                                aux++;
                                conflicts.put(square,aux);
                            }
                        }
                    }
                }
                if(k<8){
                    //System.out.println("{"+i+","+k+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==k)){
                            if(conflicts.get(square)==null){
                                conflicts.put(square,1);
                            }else{
                                int aux=conflicts.get(square);
                                aux++;
                                conflicts.put(square,aux);
                            }
                        }
                    }
                }
            }
        }

        return conflicts;
    }

    public void printBoard(){
        List<Square> filledSquares = new LinkedList<Square>();
        filledSquares=this.getFilledSquares();
        System.out.println(filledSquares);

        for(int i=0; i<8; i++){
            String linha="", letra="";
            for(int j=0; j<8; j++){
                for(Square square : filledSquares){
                    if((square.line==i)&&(square.column==j)){
                        letra="Q";
                        break;
                    }else{
                        letra="X";
                    }
                }
                linha=linha+letra+" ";
            }
            System.out.println(linha);
        }
    }

}
