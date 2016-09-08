package com.xxd.leetcode.Problem131;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> item = new ArrayList<>();
        boolean[][] palin = getPalin(s);
        helper(s, palin, 0, item, res);
        return res;
    }

    public void helper(String str, boolean[][] palin, int start, ArrayList<String> item, List<List<String>> res){
        if (start == str.length()){
            res.add( new ArrayList<>(item));
            return;
        }

        for(int i = start; i < str.length(); i++){
            if (palin[start][i]){
                item.add(str.substring(start, i+1));
                helper(str, palin, i+1, item, res);
                item.remove(item.size() - 1);
            }
        }
        return;
    }

    public boolean[][] getPalin(String str){
        boolean[][] res = new boolean[str.length()][str.length()];
        for (int i = str.length() - 1; i >= 0; i--){
            for (int j = i; j < str.length(); j++){
                if (str.charAt(j) == str.charAt(i) && (j-i <= 2 || res[i+1][j-1])){
                    res[i][j] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String str = "aab";
        List<List<String>> arrayLists = solution.partition(str);
    }

}
