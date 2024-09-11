package com.company.BNtree;

public class PaperFolding {
    public static void Paperf(int N) {
        process(1, N, true);
    }

    public static void process(int ilevel, int N, boolean ao) {
        if (ilevel > N) {
            return;
        }
        process(ilevel + 1, N, true);
        System.out.println(ao ? "凹" : "凸");
        process(ilevel + 1, N, false);
    }

    public static void main(String[] args) {
        Paperf(3);
    }
}
