package com.xxd.leetcode.Problem134;

/**
 * Created by Administrator on 2016/9/7 0007.
 */

public class Solution {
    //gas station
    public int canCompletecircuit(int[] gas, int[] cost){
        int sum = 0, total = 0, diff;
        int point = -1;
        for(int i = 0; i < gas.length; i++){
            diff = gas[i] - cost[i];
            sum += diff;
            total += diff;
            if (sum < 0){
                sum = 0;
                point = i;
            }
        }
        if (total >= 0){
            return point + 1;
        }else{
            return -1;
        }
    }
}
