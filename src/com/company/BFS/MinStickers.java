package com.company.BFS;

import java.util.*;

// 691 贴纸拼词  左程云算法讲解062 第二题
public class MinStickers {
    public static int minStickers(String[] stickers, String target) {
        // index     有哪些字符串是包含字符x的（index即x - 'a'）
        //这里之所以统计，是因为要进行剪枝，先遍历能使target中第一种字符消掉的那些字符串
        //当然也可以不排序，不统计，每一轮全部遍历，不确定会不会超时间复杂度
        HashMap<Integer, List<String>> map = new HashMap<>();
        for(String sticker : stickers){
            sticker = sort(sticker);
            for (int i = 0; i < sticker.length(); i++) {
                if(i == 0 || sticker.charAt(i) != sticker.charAt(i - 1)){  //这里挺不错的
                    int index = sticker.charAt(i) - 'a';
                    List<String> list = map.getOrDefault(index, new ArrayList<>());
                    list.add(sticker);
                    map.put(index, list);
                }
            }
        }
        target = sort(target);
        HashSet<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        int level = 1;
        while(!queue.isEmpty()){
            Queue<String> curQueue = new LinkedList<>(queue);
            queue.clear();
            while(!curQueue.isEmpty()){
                String curTarget = curQueue.poll();
                int index = curTarget.charAt(0) - 'a';
                if(!map.containsKey(index)){
                    return -1;
                }
                List<String> list = map.get(index);
                for(String sticket : list){
                    String nextTarget = next(sticket, curTarget);
                    if(nextTarget.isEmpty()){
                        return level;
                    }
                    if(!visited.contains(nextTarget)){
                        visited.add(nextTarget);
                        queue.add(nextTarget);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private static String next(String str, String target) {
        char[] charsSticker = str.toCharArray();
        char[] charsTarget = target.toCharArray();
        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 < charsSticker.length && p2 < charsTarget.length){
            if(charsSticker[p1] == charsTarget[p2]){
                p1++;
                p2++;
            }else if(charsSticker[p1] < charsTarget[p2]){
                p1++;
            }else {
                sb.append(charsTarget[p2++]);
            }
        }
        while(p2 < charsTarget.length){
            sb.append(charsTarget[p2++]);
        }
        return sb.toString();
    }

    private static String sort(String sticker) {
        char[] chars = sticker.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String[] stickers = {"these", "guess", "about", "garden", "him"};
        String target = "atomher";
        int nums = minStickers(stickers, target);
    }
}
