package com.company.Bishi.dewu;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == '('){
                count++;
            }else {
                count--;
            }

            if(count == 0){
                ans = i + 1;
            }else if(count < 0){
                break;
            }
        }
        System.out.println(ans);
    }
}
