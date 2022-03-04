package com.company;

import java.util.*;

public class Main {
    int id=0;

    public static TreeNode<BoardState> gerarFilhos(Tree<BoardState> arvore, TreeNode<BoardState> parent, int line, int column) {
//        System.out.println("entrou no gerar");
        BoardState newState = new BoardState();
//        System.out.println("2");
        for(Square queen : parent.data.getFilledSquares()){
            newState.putQueen(queen.line, queen.column);
//            System.out.println("for");
        }
//        System.out.println("saiu do for");

        newState.putQueen(line,column);
//        System.out.println("enfiou a rainha");
        TreeNode n = arvore.addChild(parent, newState);
//        System.out.println(n);
//        if(n==null){
//            System.out.println("pai\n"+oldState);
//            System.out.println("linha  "+line+"coluna  "+column);
//            System.out.println("deu null");
//        }
        return n;
    }

    public static List<TreeNode<BoardState>> expandir(Tree<BoardState> arvore, TreeNode<BoardState> node){
        System.out.println("entrou no expandir");
        List<TreeNode<BoardState>> novosNos = new LinkedList<>();

        for(int i=0; i<node.data.freeBoard.size(); i++){
            novosNos.add(gerarFilhos(arvore,node,node.data.getEmptySquares().get(i).line, node.data.getEmptySquares().get(i).column));
        }
        System.out.println("saiu do expandir com "+novosNos.size()+" novos filhos");
        return novosNos;
    }

    public static BoardState profundidadeLimitada(Tree<BoardState> arvore, int limite){
        Stack<TreeNode<BoardState>> borda = new Stack<>();
        borda.push(arvore.root);

        while(!borda.isEmpty()){
//            System.out.println("entrou no while");
            TreeNode<BoardState> node = borda.pop();
            System.out.println("deu pop");
            if(node.data.isSolution()){
                System.out.println("entrou no primeiro if - "+node.data.isSolution());
                return node.data;
            }
            if(arvore.getNodeHeight(node.data)<limite){
                System.out.println("entrou no segundo if - chamou expandir");
                for(TreeNode<BoardState> a : expandir(arvore, node)){
                    borda.push(a);
                }
//                System.out.println("terminou o for");
            }

        }
//        System.out.println("pulou fora do while");

        return null;
    }

    public static void main(String[] args) {

        BoardState inicio = new BoardState();
        Tree<BoardState> arvore = new Tree<>(inicio);
        BoardState solution = profundidadeLimitada(arvore, 8);
        System.out.println(solution);
//        System.out.println(solution);
//        System.out.println(inicio);
//        gerarFilhos(arvore,arvore.getRoot(),3,1);
//        gerarFilhos(arvore,arvore.getRoot(),3,3);
//        inicio.putQueen(3,3);
//        inicio.putQueen(3,1);
//        gerarFilhos(arvore,inicio,7,0);
//        System.out.println(arvore);
//        System.out.println(arvore.getNodeHeight(arvore.root.children.get(0).data));




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
