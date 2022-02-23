package com.company;

public class Tree<T> {
    TreeNode<T> root;
    int size;

    public Tree(T data)  {
        root = new TreeNode<T>(data, 1);
        size = 1;
    }

    @Override
    public String toString() {
        System.out.println(root.data);
        for (TreeNode<T> child : root.children) {
            child.toString();
        }
        return " ";
    }

    public TreeNode<T> find(T data) {
        boolean[] isVisited = new boolean[size];
        return traversePreOrder(root, isVisited, data);
    }

    public TreeNode<T> traversePreOrder(TreeNode<T> node, boolean[] isVisited, T data) {
        if (node != null) {
            isVisited[node.id-1] = true;
            for (TreeNode<T> n: node.children) {
                if (n.data == data) return n;
                else traversePreOrder(n, isVisited, data);
            }
        }
        return null;
    }

    public void dfs(TreeNode<T> start) {
        boolean[] isVisited = new boolean[size];
        dfsRecursive(start, isVisited);
    }

    private void dfsRecursive(TreeNode<T> current, boolean[] isVisited) {
        isVisited[current.id] = true;
        for (TreeNode<T> dest : current.children) {
            if (!isVisited[dest.id])
                dfsRecursive(dest, isVisited);
        }
    }



    public void addChild(TreeNode<T> parent, T data) {
        size++;
        parent.addChild(data, size);
    }
    
    public TreeNode<T> getRoot() {
        return root;
    }
    
    
}
