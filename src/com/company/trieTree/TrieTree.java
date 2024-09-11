package com.company.trieTree;

/*注意：前缀树的形式多种多样，在本class中，因为默认字符串只有26字母小写，所以nexts直接写成大小为26的数组。
可以根据题目写多种情况，比如
public class TrieTree {
    public static class TrieNode {
        public String luName;  //需要使用到路的名称，直接放进节点方便查找
        public HashMap<String,TrieNode> nexts;

        public TrieNode(String name) {
            luName = name;
            nexts = new HashMap<>();
        }
    }
* */
public class TrieTree {
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
            // next[0]=null 表示没有走向a的路
            // next[1]=null 表示没有走向b的路
            //注意，引用数组这样写没有新建实例对象，只指出对象数量。
            //如果next仅仅为一个对象，这样写会报错，因为死循环
        }
    }

//    public static class TrieNode1{
//        public int pass;
//        public int end;
//        public TrieNode1 next;
//        public TrieNode1(){
//            pass = 0;
//            end = 0;
//            //next = new TrieNode1();
//        }
//    }

    public static class Trie {
        private TrieNode root;

        public Trie() {   //构造函数
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            TrieNode cur = root;
            cur.pass++;
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new TrieNode();
                }
                cur.nexts[index].pass++;
                cur = cur.nexts[index];
            }
            cur.end++;
        }

        public void delete(String word) {
            if (search(word) == 0) {
                return;
            }
            int index = 0;
            TrieNode cur = root;
            cur.pass--;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (--cur.nexts[index].pass == 0) {
                    cur.nexts[index] = null;
                    return;
                }
                cur = cur.nexts[index];
            }
            cur.end--;
        }

        //word这个单词加过几次
        public int search(String word) {
            TrieNode cur = root;
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (cur.nexts[index] == null) {
                    return 0;
                }
                cur = cur.nexts[index];
            }
            return cur.end;
        }

        //所有加入的字符串中。有多少是以pre这个字符为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            TrieNode cur = root;
            int index = 0;
            for (int i = 0; i < pre.length(); i++) {
                index = pre.charAt(i) - 'a';
                if (cur.nexts[index] == null) {
                    return 0;
                }
                cur = cur.nexts[index];
            }
            return cur.pass;
        }

    }

    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }


    public static void main(String[] args) {
//        TrieNode root = new TrieNode();
//        for(int i=0;i<26;i++){
//            if(root.nexts[i] != null){
//                System.out.println("error");
//            }
//        }
////        TrieNode1 root1 = new TrieNode1();
////        if(root1.next != null){
////            System.out.println("not null");
////        }

        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            Trie trie = new Trie();
            for (int j = 0; j < arr.length; j++) {
                trie.insert(arr[j]);
                trie.delete(arr[0]);
            }
        }
    }
}
