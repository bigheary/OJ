package com.xxd.sord.replaceSpace;

/**
 * Created by Administrator on 2016/10/7 0007.
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int cnt=0;
        int origLen = str.length();
        for(int i = 0; i < origLen; i++){
            if (str.charAt(i) == ' '){
                cnt++;
            }
        }
        for(int i = 0; i < cnt; i++){
            str = str.append(' ').append(' ');
        }
        int i = origLen-1;
        int j = str.length() - 1;
        if(i == j){
            return str.toString();
        }
        for(; i >= 0; i--){
            if(str.charAt(i) == ' '){
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            }else{
                str.setCharAt(j--, str.charAt(i));
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        StringBuffer sb = new StringBuffer("hello world");
        String res = solution.replaceSpace(sb);
    }
}
