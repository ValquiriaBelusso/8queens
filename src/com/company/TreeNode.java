package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TreeNode<T> implements Iterable<TreeNode<T>> {

    T data;
    int id;
    TreeNode<T> parent;
    List<TreeNode<T>> children;

    public TreeNode(T data, int _id) {
        this.data = data;
        this.id = _id;
        this.children = new LinkedList<TreeNode<T>>();
    }



    public TreeNode<T> addChild(T child, int id) {
        TreeNode<T> childNode = new TreeNode<T>(child, id);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super TreeNode<T>> consumer) {
        Iterable.super.forEach(consumer);
    }

    @Override
    public Spliterator<TreeNode<T>> spliterator() {
        return Iterable.super.spliterator();
    }

    // other features ...

}
