package com.xxd.sord.repeatingNumber;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class RepeatingNumber {
    public static void main(String[] args){
        HashMap<Integer, Boolean> store = new HashMap<>();
        //HashSet<Integer> store = new HashSet<>();
        int[] data = new int[]{1,2,3,4,5, 4};
        for(int i = 0; i < data.length; i++){
            if (store.containsKey(data[i])){
                System.out.println("has repeating number");
                return;
            }else{
                store.put(data[i], true);
            }
        }
        System.out.println("no repeating number");
    }
}
