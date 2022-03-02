package com.company;

import java.util.*;

public class BoardState {

    List<Square> board;

    public BoardState()  {
        this.board = new LinkedList<Square>();

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Square square = new Square(i,j);
                this.board.add(square);
            }
        }
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

    public List<Square> getConflictsBySquare(Square square){
        List<Square> conflicts = new LinkedList<Square>();

            int m,n;
            m = square.line;
            n = square.column;

            //linha
            for(int i=0; i<8; i++){
                if(i!=n){
//                    System.out.println("{"+m+","+i+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==m)&&(square1.column==i)){
                            conflicts.add(square1);
                        }
                    }
                }
            }
            //coluna
            for(int i=0; i<8; i++){
                if(i!=m){
                    //System.out.println("{"+i+","+n+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==n)){
                            conflicts.add(square1);
                        }
                    }
                }
            }
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
                            conflicts.add(square1);
                        }
                    }
                }
                if(k<8){
                    //System.out.println("{"+i+","+k+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==k)){
                            conflicts.add(square1);
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
                            conflicts.add(square1);
                        }
                    }
                }
                if(k<8){
                    //System.out.println("{"+i+","+k+"}");
                    for(Square square1: this.getFilledSquares()){
                        if((square1.line==i)&&(square1.column==k)){
                            conflicts.add(square1);
                        }
                    }
                }
            }

        return conflicts;
    }

    public int totalConflicts(){
        int total=0;

        Enumeration<Integer> a = this.getConflictsList().elements();
        while(a.hasMoreElements()){
            int g= a.nextElement();
            total = total+g;
        }
        total = total/2;
        return total;
    }

    public Dictionary<Square, Integer> getConflictsList(){
        Dictionary<Square, Integer> conflicts = new Hashtable<Square, Integer>();

//        int aux=conflicts.get(square);
//        aux++;
//        conflicts.put(square,aux);

        for(Square square : this.getFilledSquares()){
            int aux;
            if(conflicts.get(square)==null){
                aux=this.getConflictsBySquare(square).size();
            }else{
                aux=conflicts.get(square)+1;
            }
            conflicts.put(square,aux);
        }

        return conflicts;
    }

//    public String toString(){
//        List<Square> filledSquares = new LinkedList<Square>();
//        filledSquares=this.getFilledSquares();
//        String board="";
//
//        for(int i=0; i<8; i++){
//            String linha="", letra="";
//            for(int j=0; j<8; j++){
//                if(filledSquares==null){
//                    letra=".";
//                }
//                for(Square square : this.board){
//                    for(Square square1 : filledSquares){
//                        if((square.line==square1.line)&&(square.column==square1.column)){
//                            letra="Q";
//                            break;
//                        }else{
//                            letra=".";
//                        }
//                    }
//                }
//                linha=linha+letra+" ";
//            }
////            System.out.println(linha);
//            board=board+linha+"\n";
//        }
//
//        return board;
//    }

}
