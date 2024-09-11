package com.company.Tanxin;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// leetcode 08.06
public class Hanoi {
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        // process(i,form,to,other)
        process(A.size(), A, C, B);
    }

    public static void process(int i, List<Integer> from, List<Integer> to, List<Integer> other) {
        if (i == 1) {
            to.add(from.remove(from.size() - 1));
            return;
        }
        process(i - 1, from, other, to);
        to.add(from.remove(from.size() - 1));
        process(i - 1, other, to, from);
    }

    public static void main(String[] args) {
        List<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        List<Integer> listb = new LinkedList<>();
        List<Integer> listc = new LinkedList<>();
        hanota(lista, listb, listc);
    }
}
