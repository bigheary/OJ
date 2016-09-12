package com.xxd.netease;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12 0012.
 */
public class CountTimes{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> numList = new LinkedList<>();
        for(int i = 0; i < n; i++){
            numList.add(scanner.nextInt());
        }
        int res = countTimes(numList);
        System.out.println(res);
    }

    public static int countTimes(LinkedList<Integer> numList){
        if (numList.isEmpty()){
            return 0;
        }
        if (numList.size() == 1){
            return 0;
        }
        if(numList.size() == 2 && numList.getFirst() == numList.getLast()){
            return 0;
        }
        if(numList.size() == 2){
            return 1;
        }

        if (numList.getFirst() == numList.getLast()){
            numList.pollFirst();
            numList.pollLast();
            return countTimes(numList);
        }else if(numList.getFirst() > numList.getLast()){
            int a = numList.pollLast();
            int b = numList.pollLast();
            numList.addLast(a+b);
        }else{
            int a = numList.pollFirst();
            int b = numList.pollFirst();
            numList.addFirst(a+b);
        }
        return countTimes(numList) + 1;
    }
}
