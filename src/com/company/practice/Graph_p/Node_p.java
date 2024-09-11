package com.company.practice.Graph_p;

import java.util.ArrayList;

public class Node_p {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node_p> nexts;
    public ArrayList<Edge_p> edges;


    public Node_p(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
