package com.company.practice.Graph_p;

//一个例子，基于Graphy的算法代码写好，以后给任何的图结构都转为Graphy然后直接用原来代码
public class GraphGenerator_p {

    public static Graph_p createGraphFromMatrix(Integer[][] matrix){
        Graph_p graphP = new Graph_p();
        for(int i = 0; i < matrix.length; i++){
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if(!graphP.nodes.containsKey(from)){
                graphP.nodes.put(from,new Node_p(from));
            }
            if(!graphP.nodes.containsKey(to)){
                graphP.nodes.put(to,new Node_p(to));
            }

            Node_p fromNode = graphP.nodes.get(from);
            Node_p toNode = graphP.nodes.get(to);
            Edge_p edge = new Edge_p(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graphP.edges.add(edge);

        }

        return graphP;
    }

}
