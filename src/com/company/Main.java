package com.company;

import java.util.Dictionary;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Tree<String> tree = new Tree<String>("a");


        tree.addChild(tree.getRoot(), "b");
        tree.addChild(tree.getRoot(), "c");
        tree.addChild(tree.find("b"), "d");
        tree.addChild(tree.find("b"), "e");
        tree.addChild(tree.find("c"), "f");
        tree.addChild(tree.find("c"), "g");

        BoardState state = new BoardState();

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Square square = new Square(i,j);
                state.board.add(square);
            }
        }

        state.putQueen(3,3);
        state.putQueen(3,1);
        state.putQueen(1,3);

//        state.printBoard();

        Dictionary<Square, Integer> teste = new Hashtable<>();
        teste=state.getConflictsList();
        System.out.println(teste);


//        tree.show();
    }
}
