package com.xxd.sord.permutation;

import java.util.*;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() == 0){
            return res;
        }
        Set<String> set = new HashSet<String>();
        helper(str, 0, set);
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            res.add(iterator.next());
        }
        Collections.sort(res);
        //res.sort();
        return res;
    }
    public void helper(String str, int idx, Set<String> set){
        if(idx == str.length()){
            set.add(str);
            return;
        }
        char[] chars = str.toCharArray();
        for(int i = idx; i < str.length(); i++){
            char tmp = chars[idx];
            chars[idx] = chars[i];
            chars[i] = tmp;
            String newStr = new String(chars);
            helper(newStr, idx+1, set);
            tmp = chars[idx];
            chars[idx] = chars[i];
            chars[i] = tmp;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ArrayList<String> list = solution.Permutation("abac");
    }
}
