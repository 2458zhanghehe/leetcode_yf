package com.company.Bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class P1_2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = reader.readLine();
//        while(line != null){
//            System.out.println(line);
//            line = reader.readLine();
//        }
//        reader.close();


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String[]> splits = new ArrayList<>();
        int sum = 0;
        int lineCount = 0;
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.trim().isEmpty()){
                break;
            }
            String[] split = str.split(",");
            splits.add(split);
            sum += split.length;
            lineCount++;
        }


        int[] point = new int[lineCount];
        int index = 0;
        while(index < sum){
            for (int i = 0; i < lineCount; i++) {
                String[] cur = splits.get(i);
                for (int j = point[i]; j < point[i] + n && j < cur.length; j++) {
                    if(index < sum - 1){
                        System.out.print(cur[j] + ",");
                    }else {
                        System.out.print(cur[j]);
                    }
                    index++;
                }
                point[i] += n;
            }
        }
    }
}
