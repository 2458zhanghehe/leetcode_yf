package com.company.string;

// lCR 138 有效数字
public class ValidNumber {
    public static boolean validNumber(String s) {
        s = s.trim();
        if(s.isEmpty()){
            return false;
        }
        if(s.length() == 1){
            return s.charAt(0) <= '9' && s.charAt(0) >= '0';
        }
        char[] chars = s.toCharArray();
        boolean alreadyFu = false;
        boolean alreadyPoint = false;
        boolean alreadyE = false;
        int i = 0;
        while(i < chars.length){
            if(chars[i] == '+' || chars[i] == '-'){
                if(alreadyFu){
                    return false;
                }
                alreadyFu = true;
                i++;
                if(i == chars.length){
                    return false;
                }

                if(chars[i] == '.'){
                    alreadyPoint = true;
                    i++;
                    if(i == chars.length){
                        return true;
                    }
                    if(chars[i] < '0' || chars[i] > '9'){
                        return false;
                    }
                }else if(chars[i] < '0' || chars[i] > '9'){
                    return false;
                }else if(i != 1 && !alreadyE){
                    return false;
                }
            }else if(chars[i] == '.'){
                if(alreadyPoint){
                    return false;
                }
                alreadyPoint = true;
                i++;
                if(i == chars.length){
                    return true;
                }
                if(chars[i] < '0' || chars[i] > '9'){
                    return false;
                }
            }else if(chars[i] == 'e' || chars[i] == 'E'){
                if(alreadyE || i == 0 || i == chars.length - 1){
                    return false;
                }
                alreadyE = true;
                i++;
                if(chars[i] == '+' || chars[i] == '-'){
                    i++;
                    if(i == chars.length || chars[i] < '0' || chars[i] > '9'){
                        return false;
                    }
                }else if(chars[i] == '.'){
                    return false;
                }
            }else if(chars[i] >= '0' && chars[i] <= '9'){
                i++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        validNumber("-1e-6");
    }
}
