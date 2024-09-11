package com.company.Bishi.city58;

public class P1 {
    public static int[] paginatePosts (int[] posts, int page, int pageSize) {
        if(posts == null && posts.length == 0){
            return new int[]{};
        }
        int index = (page - 1) * pageSize;
        if(index >= posts.length){
            return new int[]{};
        }

        int[] ans = new int[Math.min(pageSize, posts.length - index)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = posts[i + index];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] posts = {5,7,4,2,3,9,13};
        int[] ans = paginatePosts(posts, 2, 30);
        System.out.println(1);
    }
}
