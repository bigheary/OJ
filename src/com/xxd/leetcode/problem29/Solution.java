package com.xxd.leetcode.problem29;

import com.xxd.didi.Main;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
public class Solution {
    public int divide(int dividend, int divisor){
        int digits = 0;
        int res=0;
        boolean isNeg = (dividend ^ divisor) >>> 31 == 1;
        if (divisor == 0){
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE){
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
            if(divisor == 1){
                return Integer.MIN_VALUE;
            }
            else{
                dividend += Math.abs(divisor);
                res = 1;
            }
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(divisor <= (dividend>>1)){
            digits++;
            divisor = divisor << 1;
        }
        if(divisor == dividend){
            res = 1 << digits;
            return isNeg ? -res:res;
        }
        while(digits >= 0){
            while(dividend >= divisor){
                res += 1<<digits;
                dividend -= divisor;
            }
            digits--;
            divisor = divisor >> 1;
        }
        return isNeg ? -res:res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int dividend = -1010369383;
        int divisor = Integer.MIN_VALUE;
        //int res1 = Math.abs(divisor);
        int res = solution.divide(dividend, divisor);
    }
}
