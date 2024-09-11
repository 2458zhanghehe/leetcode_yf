package com.company.matrix;

import java.util.LinkedList;
import java.util.Stack;

// lc 85 最大矩形
public class MaximalRectangle {
    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] right1 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1'){
                    right1[i][j] = j + 1 < n ? (1 + right1[i][j + 1]) : 1;
                }else {
                    right1[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int row1 = 0; row1 < m; row1++) {
            for (int row2 = row1; row2 < m; row2++) {
                for (int j = 0; j < n; j++) {
                    if(right1[row1][j] == 0){
                        continue;
                    }
                    int curLen = right1[row1][j];
                    for (int k = row1 + 1; k <= row2; k++) {
                        curLen = Math.min(right1[k][j], curLen);
                    }
                    ans = Math.max(curLen * (row2 - row1 + 1), ans);
                }
            }
        }
        return ans;
    }

    //方法二，同样先统计累计连续1，然后当成一维高度使用单调栈处理，也就是largestRectangleArea lc 84
    //注意，为了方便传递，这里改为下面的累计1
    public int maximalRectangle2(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] down = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if(matrix[i][j] == '1'){
                    down[i][j] = i + 1 < m ? (1 + down[i + 1][j]) : 1;
                }else {
                    down[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            int curAns = largestRectangleArea(down[i]);
            ans = Math.max(ans, curAns);
        }
        return ans;
    }


    private int largestRectangleArea(int[] heights) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
                continue;
            }

            int peekValue =heights[stack.peek().getLast()];
            while(!stack.isEmpty() && heights[i] < peekValue){
                LinkedList<Integer> curList = stack.pop();
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek().getLast();
                for(int index : curList){
                    //以heights[i]为高度能构成的矩形的宽就是right - left - 1
                    ans = Math.max(ans, (right - left - 1) * heights[index]);
                }
                peekValue = stack.isEmpty() ? Integer.MIN_VALUE : heights[stack.peek().getLast()];
            }

            if(heights[i] > peekValue){
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }else{
                stack.peek().addLast(i);
            }
        }

        while (!stack.isEmpty()){
            LinkedList<Integer> curList = stack.pop();
            int right = heights.length;
            int left = stack.isEmpty() ? -1 : stack.peek().getLast();
            for(int index : curList){
                //以heights[i]为高度能构成的矩形的宽就是right - left - 1
                ans = Math.max(ans, (right - left - 1) * heights[index]);
            }
        }
        return ans;
    }
}
