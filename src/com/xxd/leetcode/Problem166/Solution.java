package com.xxd.leetcode.Problem166;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/6 0006.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Long> map = new LinkedHashMap<Long, Long>();
        boolean isNeg = ((numerator ^ denominator)>>>31 == 1);
        long numerator1 = numerator;
        long denominator1 = denominator;
        numerator1 = Math.abs(numerator1);
        denominator1 = Math.abs(denominator1);
        long intPart = numerator1 / denominator1;
        long n = numerator1 % denominator1;
        long tmp;
        if (n == 0){
            if (isNeg){
                return "-"+intPart;
            }
            return ""+intPart;
        }
        while(n != 0){
            n = 10*n;
            if(map.containsKey(n)){
                break;
            }
            tmp = n / denominator1;
            map.put(n, tmp);
            n = n % denominator1;
        }

        StringBuilder sb = new StringBuilder();
        if(isNeg){
            sb.append("-");
        }
        sb.append(""+intPart).append(".");
        boolean flag = false;
        Iterator<Long> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Long t = iterator.next();
            if(t == n){
                flag = true;
                sb.append("(");
            }
            sb.append(map.get(t));
        }
        if(flag){
            sb.append(")");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        String res = solution.fractionToDecimal(Integer.MIN_VALUE, 1);
    }

}
