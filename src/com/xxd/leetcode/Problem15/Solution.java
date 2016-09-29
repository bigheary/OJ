package com.xxd.leetcode.Problem15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (nums[i] != nums[i-1])){
                int left = i+1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[left] + nums[right] == -nums[i]){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }else if (nums[left] + nums[right] < -nums[i]){
                        while(left < right && nums[left] == nums[left+1]) left++;
                        left++;
                    }else{
                        while(left < right && (nums[right] == nums[right-1]))  right--;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
