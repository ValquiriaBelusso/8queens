package com.company;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Main {
    int id=0;

    public static void gerarFilhos(Tree<BoardState> arvore, BoardState oldState, int line, int column) {
        BoardState newState = new BoardState();

        for(Square queen : oldState.getFilledSquares()){
            newState.putQueen(queen.line, queen.column);
        }

        newState.putQueen(line,column);
//        System.out.println(newState.getFilledSquares().size());
//        System.out.println(oldState);
        System.out.println(newState);
//        System.out.println(arvore.find(oldState).getData());


        arvore.addChild(arvore.find(oldState), newState);

    }

    public static void main(String[] args) {

        BoardState inicio = new BoardState();
        Tree<BoardState> arvore = new Tree<>(inicio);
//        System.out.println(inicio);
        gerarFilhos(arvore,inicio,3,3);
//        gerarFilhos(arvore,inicio,3,1);
//        gerarFilhos(arvore,inicio,7,0);
//        System.out.println(arvore);




//        Tree<String> tree = new Tree<String>("a");


//        tree.addChild(tree.getRoot(), "b");
//        tree.addChild(tree.getRoot(), "c");
//        tree.addChild(tree.find("b"), "d");
//        tree.addChild(tree.find("b"), "e");
//        tree.addChild(tree.find("c"), "f");
//        tree.addChild(tree.find("c"), "g");
//        System.out.println(tree);
//
//        BoardState state = new BoardState();
//

//
//        state.putQueen(3,3);
//        state.putQueen(3,1);
//        state.putQueen(1,3);
//        state.putQueen(7,0);
//
//
//        Dictionary<Square, Integer> teste = new Hashtable<>();
//        teste=state.getConflictsList();
//        System.out.println(state.totalConflicts());



    }

}
