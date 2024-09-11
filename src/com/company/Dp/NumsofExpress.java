package com.company.Dp;

/*
*给定一个只由0（假）、1（真）、&、|、^五种字符组成的字符串express，再给定一个布尔值desired。
* 返回不改变顺序，express能有多少种组合的方式，可以达到desired的结果
* eg：express = "1^0|0|1", desired = false
* 只有 1^((0|0)|1) 和 1^(0|(0|1))的组合可以得到false，返回2
* */
public class NumsofExpress {
    public int ways(String str, boolean desired){
        boolean valid = isValid(str);
        if(!valid){
            return 0;
        }

        int ans = process(str,0,str.length() - 1, desired);
        return ans;
    }

    private int process(String str, int L, int R, boolean desired) {
        if(L == R){
            if(desired){
                return str.charAt(L)=='1' ? 1 : 0;
            }else {
                return str.charAt(L)=='1' ? 0 : 1;
            }
        }

        int res = 0;
        for(int i = L + 1; i < R; i += 2){
            if(desired){
                switch (str.charAt(i)){
                    case '&':
                        res += process(str, L,i - 1,true) * process(str,i + 1, R,true);
                        break;
                    case '|':
                        res += process(str, L,i - 1,true) * process(str,i + 1, R,false);
                        res += process(str, L,i - 1,false) * process(str,i + 1, R,true);
                        res += process(str, L,i - 1,true) * process(str,i + 1, R,true);
                        break;
                    case '^':
                        res += process(str, L,i - 1,true) * process(str,i + 1, R,false);
                        res += process(str, L,i - 1,false) * process(str,i + 1, R,true);
                        break;
                }
            }else {
                switch (str.charAt(i)){
                    case '&':
                        res += process(str, L,i - 1,false) * process(str,i + 1, R,true);
                        res += process(str, L,i - 1,true) * process(str,i + 1, R,false);
                        res += process(str, L,i - 1,false) * process(str,i + 1, R,false);
                        break;
                    case '|':
                        res += process(str, L,i - 1,false) * process(str,i + 1, R,false);
                        break;
                    case '^':
                        res += process(str, L,i - 1,true) * process(str,i + 1, R,true);
                        res += process(str, L,i - 1,false) * process(str,i + 1, R,false);
                        break;
                }
            }
        }
        return res;
    }


    public int ways1(String str, boolean desired){
        boolean valid = isValid(str);
        if(!valid){
            return 0;
        }
        int N = str.length();
        int ans = 0;
        int[][] dp_true = new int[N][N];
        int[][] dp_false = new int[N][N];

        for(int i = 0; i < N; i += 2){
            if(str.charAt(i) == '1'){
                dp_true[i][i] = 1;
            }else {
                dp_false[i][i] = 1;
            }
        }

        for(int row = N - 3; row >= 0; row -= 2){
            for(int col = row + 2; col < N; col += 2){
                for(int i = row + 1; i < col; i+= 2){
                    switch (str.charAt(i)){
                        case '&':
                            dp_true[row][col] += dp_true[row][i - 1] * dp_true[i + 1][col];
                            break;
                        case '|':
                            dp_true[row][col] += dp_true[row][i - 1] * dp_false[i + 1][col];
                            dp_true[row][col] += dp_false[row][i - 1] * dp_true[i + 1][col];
                            dp_true[row][col] += dp_true[row][i - 1] * dp_true[i + 1][col];
                            break;
                        case '^':
                            dp_true[row][col] += dp_true[row][i - 1] * dp_false[i + 1][col];
                            dp_true[row][col] += dp_false[row][i - 1] * dp_true[i + 1][col];
                            break;
                    }
                    switch (str.charAt(i)){
                        case '&':
                            dp_true[row][col] += dp_false[row][i - 1] * dp_true[i + 1][col];
                            dp_true[row][col] += dp_true[row][i - 1] * dp_false[i + 1][col];
                            dp_true[row][col] += dp_false[row][i - 1] * dp_false[i + 1][col];
                            break;
                        case '|':
                            dp_true[row][col] += dp_false[row][i - 1] * dp_false[i + 1][col];
                            break;
                        case '^':
                            dp_true[row][col] += dp_true[row][i - 1] * dp_true[i + 1][col];
                            dp_true[row][col] += dp_false[row][i - 1] * dp_false[i + 1][col];
                            break;
                    }
                }
            }
        }
        return desired ? dp_true[0][N - 1] : dp_false[0][N - 1];
    }

    private boolean isValid(String str) {
        if(str.length() % 2 == 0){
            return false;
        }
        for(int i = 0; i < str.length(); i+=2){
            if(str.charAt(i) != '1' && str.charAt(i) != '0'){
                return false;
            }
        }
        for(int i = 1; i < str.length(); i+=2){
            if(str.charAt(i) != '^' && str.charAt(i) != '&' && str.charAt(i) != '|'){
                return false;
            }
        }
        return true;
    }
}
