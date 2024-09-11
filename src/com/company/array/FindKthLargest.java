package com.company.array;

import java.util.PriorityQueue;

//leetcode 215 数组中的第K个最大元素
public class FindKthLargest {
    //方案1 容量为k的小根堆  注意容量为k
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int cur : nums){
            if(queue.size() < k){
                queue.add(cur);
            }else if(queue.peek() < cur){
                queue.add(cur);
                queue.poll();
            }
        }
        return queue.peek();
    }


    //方案2 快速选择，过程就是partition
    //其实就是快排 + 提前终止
    //选一个数作为中轴，利用partition判断在第k在左还是在右
    public static int findKthLargest2(int[] nums, int k){
        //第k大就是第n-k+1小
        return quick_select(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private static int quick_select(int[] nums, int l, int r, int find) {
        if(l == r){
            return nums[l];
        }

        //l + (r - l) >> 1是错的，一定要加括号
        int mid = l + ((r - l) >> 1);
        int x = nums[mid];
        int i = l - 1;
        int j = r + 1;
        int index = l;

        while(index < j){
            if(nums[index] == x){
                index++;
            }else if(nums[index] < x){
                swap(nums, index++, ++i);
            }else {
                swap(nums,index,--j);
            }
        }

        if(find <= i + 1){
            return quick_select(nums, l, i, find);
        }else if(find > j){
            return quick_select(nums,j,r,find);
        }else {
            return nums[find - 1];
        }
    }

    public static int findKthLargest3(int[] nums, int k){
        //第k大就是第n-k+1小
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSort(int[] nums, int l, int r, int find) {
        if(l == r){
            return nums[l];
        }

        int randomIndex = (int)(Math.random() * (r - l)) + l;
        swap(nums, randomIndex, r);
        int i = l - 1;
        int j = r;
        int index = l;

        while(index < j){
            if(nums[index] == nums[r]){
                index++;
            }else if(nums[index] < nums[r]){
                swap(nums, index++, ++i);
            }else {
                swap(nums,index,--j);
            }
        }
        swap(nums, j++, r);
        if(find <= i){
            return quickSort(nums, l, i, find);
        }else if(find >= j){
            return quickSort(nums,j,r,find);
        }else {
            return nums[find];
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int ans2 = findKthLargest2(nums,4);
        int ans3 = findKthLargest3(nums,4);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
