package com.company;

public class Main {

    public static void main(String[] args) {

        Tree<String> tree = new Tree<String>("a");


        tree.addChild(tree.getRoot(), "b");
        tree.addChild(tree.getRoot(), "c");
        tree.addChild(tree.find("b"), "d");
        tree.addChild(tree.find("b"), "e");
        tree.addChild(tree.find("c"), "f");
        tree.addChild(tree.find("c"), "g");

        System.out.println(tree.toString());
//        tree.show();
    }
}
