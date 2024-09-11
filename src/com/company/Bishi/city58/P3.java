package com.company.Bishi.city58;

public class P3 {
    public static String decompress (String compress) {
        int i = 0;
        int m = 0;
        while(compress.charAt(i) >= '0' && compress.charAt(i) <= '9'){
            m = m * 10 + compress.charAt(i++) - '0';
        }
        if(i == 0){
            m = 1;
        }else if(i > 0 && compress.charAt(i) == '!'){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(i < compress.length()){

            if(compress.charAt(i) == '#'){
                i++;
                int bulkLen = 0;
                String bulk = "";
                while(compress.charAt(i) >= '0' && compress.charAt(i) <= '9'){
                    bulkLen = bulkLen * 10 + compress.charAt(i++) - '0';
                }
                bulk = compress.substring(i + 1, i + 1 + bulkLen);
                i += bulkLen + 2;
                sb.append(bulk);
            }
            if(compress.charAt(i) == '%'){
                i++;
                int num = 0;
                while(compress.charAt(i) >= '0' && compress.charAt(i) <= '9'){
                    num = num * 10 + compress.charAt(i++) - '0';
                }
                sb.append(num);
                i++;
            }
            String ans = sb.toString();
            sb.setLength(0);
            for (int j = 0; j < m; j++) {
                sb.append(ans);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "2!#1!a!%0!";
        System.out.println(decompress(str));
    }
}
