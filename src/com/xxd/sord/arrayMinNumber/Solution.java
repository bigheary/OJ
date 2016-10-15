package com.xxd.sord.arrayMinNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        if(numbers.length == 1){
            return numbers[0]+"";
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2) {
                String str1 = n1+""+n2;
                String str2 = n2+""+n1;
                return str1.compareTo(str2);
            }
        });
        String res = "";
        for(int i : list){
            res += i;
        }
        return res;
    }

    public static void main(String[] args){
        int[] data = new int[]{3, 32, 321};
        String res = new Solution().PrintMinNumber(data);
    }
}
