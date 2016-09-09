package com.xxd.huawei;

import java.util.*;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class RotationDelete {
    public int delete(int n){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            queue.offer(i);
        }

        while (queue.size() > 1){
            int p = queue.poll();
            queue.offer(p);
            p = queue.poll();
            queue.offer(p);
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args){
        RotationDelete rd = new RotationDelete();
        //int res = rd.delete(8);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int res = rd.delete(n);
            System.out.println(res);
        }
    }
}
