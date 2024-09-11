package com.company.practice.Graph_p;

public class Edge_p {
    public int weight;
    public Node_p from;
    public Node_p to;

    public Edge_p(int weight, Node_p from, Node_p to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
