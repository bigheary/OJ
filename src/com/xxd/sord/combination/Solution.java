package com.xxd.sord.combination;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class Solution {
    public void combination(int[] num, ArrayList<String> res, String str, int idx, int k){
            if (k == 0) {
                if (res.size() > 0 && res.get(res.size()-1).compareTo(str) == 0) {
                    return;
                }else{
                    res.add(str);
                    return;
                }
            }
        if (idx < num.length) {
            combination(num, res, str + num[idx] + "", idx + 1, k - 1);
            combination(num, res, str, idx + 1, k);
            return;
        }
    }

    public static void main(String[] args){
        int[] num = new int[]{1, 1, 3, 4};
        ArrayList<String> res = new ArrayList<>();
        Arrays.sort(num);
        new Solution().combination(num, res, "", 0, 3);
    }
}
