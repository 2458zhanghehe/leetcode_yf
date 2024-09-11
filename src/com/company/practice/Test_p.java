package com.company.practice;

public class Test_p {

    public static class Node{
        public Node left;
        public Node right;
        public int val;
        public Node(int v){
            val = v;
        }
    }


    public static int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public static int rand10() {
        int tmp;
        do {

            tmp = (randP01() << 3) + (randP01() << 2) + (randP01() << 1) + randP01();
        } while (tmp > 9);
        return tmp + 1;
    }

    public static int randP01() {
        int tmp;
        do {
            tmp = rand7();
        } while (tmp == 4);
        return (tmp < 4) ? 0 : 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(rand10());
        }
    }
}
