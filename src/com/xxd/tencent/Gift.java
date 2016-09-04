package com.xxd.tencent;

/**
 * Created by Administrator on 2016/9/4 0004.
 */
import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        int targetPos = n >> 1;
        int start = 0;
        int end = n - 1;
        int middle = partition(gifts, start, end);
        while(middle != targetPos){
            if(middle < targetPos){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
            middle = partition(gifts, start, end);
        }
        int res = countNumber(gifts, gifts[targetPos]);
        if(res > (n >> 1)){
            return gifts[targetPos];
        }else{
            return 0;
        }
    }

    public int countNumber(int[] gifts, int number){
        int count = 0;
        for(int i = 0; i < gifts.length; i++){
            if(gifts[i] == number){
                count++;
            }
        }
        return count;
    }

    public int partition(int[] gifts, int start, int end){
        if(end == start)
            return start;
        int pivotPos = start;
        int i = start+1;
        int j = end;
        while(i < j){
            while(i < j && gifts[j] >= gifts[pivotPos]) j--;
            while(i < j && gifts[i] < gifts[pivotPos]) i++;
            if(i < j){
                int temp = gifts[i];
                gifts[i] = gifts[j];
                gifts[j] = temp;
            }
        }
        int temp = gifts[pivotPos];
        gifts[pivotPos] = gifts[i];
        gifts[i] = temp;
        return i;
    }

    public static void main(String[] args){
        Gift gift = new Gift();
        int[] gifts = new  int[]{1, 2, 3, 2, 2};
        int res = gift.getValue(gifts, 5);
        System.out.println(res);
    }

}