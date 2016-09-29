package com.xxd.leetcode.Problem16;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class Solution {
    public int treeSumClosest(int[] nums, int target) {
            int tmpSum = 0;
            int diff = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length - 1; i++){
                int twoSum = target - nums[i];
                int left = i+1;
                int right = nums.length - 1;
                if (i > 0 && nums[i-1] == nums[i]) continue;
                while(left < right){
                    if(nums[left] + nums[right] == twoSum){
                        tmpSum = 0;
                        return tmpSum;
                    }else if(nums[left] + nums[right] < twoSum){
                        int diffTmp = twoSum - nums[left] - nums[right];
                        if(diffTmp < diff){
                            tmpSum = target - diffTmp;
                            diff = diffTmp;
                        }
                        while (left < right && nums[left] == nums[left+1]) left++;
                        left++;
                    }else if(nums[left] + nums[right] > twoSum){
                        int diffTmp = nums[left] + nums[right] - twoSum;
                        if (diffTmp < diff){
                            tmpSum = target + diffTmp;
                            diff = diffTmp;
                        }
                        while(left < right && nums[right - 1] == nums[right]) right--;
                        right--;
                    }
                }
            }
        return tmpSum;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-1,0,1,1,55};
        Solution solution = new Solution();
        int res = solution.treeSumClosest(nums, 3);
    }
}
