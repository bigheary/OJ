package com.xxd.leetcode.Problem16;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)
            throw new IllegalArgumentException("No three numbers");
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int lo=i+1,hi=len-1;
                while(lo<hi){
                    if(nums[i]+nums[lo]+nums[hi]==target){
                        return target;
                    }
                    if(Math.abs(nums[i]+nums[lo]+nums[hi]-target)<Math.abs(closest-target)){
                        closest = nums[i]+nums[lo]+nums[hi];
                    }
                    if(nums[lo]+nums[hi]<target-nums[i]){
                        while(lo<hi&&nums[lo]==nums[lo+1]) lo++;
                        lo++;
                    }
                    else{
                        while(lo<hi&&nums[hi]==nums[hi-1]) hi--;
                        hi--;
                    }
                }
            }
        }

        return closest;
    }
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int res = solution1.threeSumClosest(new int[]{-1, 0, 1, 1, 55},3 );
    }
}
