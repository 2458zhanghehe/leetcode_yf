package com.company.Graph;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;    //入度 有多少点指向
    public int out;   //出度 指向多少点
    public ArrayList<Node> nexts;  //当前点的直接邻居
    public ArrayList<Edge> edges;  //当前点指出的边数

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
