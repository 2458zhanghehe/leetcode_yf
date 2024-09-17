package com.company.Bishi.tuhu;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        ArrayList<Node> list = new ArrayList<>();
        Node node = new Node(3);
        list.add(node);
        list.add(node);
        System.out.println(list);

    }

    static class Node {
        public int val;
        public int in;
        public List<Node> nexts;

        public Node(int val) {
            this.val = val;
            in = 0;
            nexts = new ArrayList<>();
        }
    }
}
