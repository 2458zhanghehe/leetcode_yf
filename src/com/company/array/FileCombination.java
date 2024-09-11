package com.company.array;

import java.util.ArrayList;
import java.util.List;

// LCR 180 文件组合
public class FileCombination {

    //方法一 纯数学计算
    public int[][] fileCombination1(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if (i < j && j == (int) j) {  // k是整数,eg:5.0，且ans中至少会含有两个数
                int[] ans = new int[(int) j - i + 1];
                for (int k = i; k <= (int) j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }

    //方法二 滑动窗口
    public int[][] fileCombination2(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int l = 1, r = 2, sum = 3; r <= target / 2 + 1; ) {
            if(sum > target){
                sum -= l;
                l++;
            }else if(sum == target){
                int[] nums = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    nums[i - l] = i;
                }
                list.add(nums);
                sum -= l;
                l++;
            }else {
                r++;
                sum += r;
            }
        }
        return list.toArray(new int[0][]);
    }
}
