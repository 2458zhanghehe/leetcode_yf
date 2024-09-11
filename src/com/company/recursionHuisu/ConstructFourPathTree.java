package com.company.recursionHuisu;

//leetcode 427 建立四叉树
public class ConstructFourPathTree {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return process(grid, n, 0 ,0);
    }

    private Node process(int[][] grid, int size, int x, int y) {
        if(size == 1){
            return new Node(grid[x][y] == 1, true);
        }

        boolean allSame = true;
        int preVal = grid[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(grid[i][j] != preVal){
                    allSame = false;
                    i = grid.length;
                    break;
                }
            }
        }

        if(!allSame){
            int halfSize = size / 2;
            Node topLeft = process(grid, halfSize, x, y);
            Node bottomLeft = process(grid, halfSize, x + halfSize, y);
            Node topRight = process(grid, halfSize, x, y + halfSize);
            Node bottomRight = process(grid, halfSize, x + halfSize, y + halfSize);
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }else {
            return new Node(grid[x][y] == 1, true);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}};
        ConstructFourPathTree constructFourPathTree = new ConstructFourPathTree();
        Node root = constructFourPathTree.construct(grid);
        System.out.println(root);
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
