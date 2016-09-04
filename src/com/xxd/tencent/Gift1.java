package com.xxd.tencent;

/**
 * Created by Administrator on 2016/9/4 0004.
 */
public class Gift1 {
    public int getValue(int[] gifts, int n) {
        // write code here
        int cnt = 1;
        int res = gifts[0];
        if (1 == n)
            return res;
        //一遍扫描
        for (int i = 1; i < n; i++){
            if (cnt == 0){
                res = gifts[i];
                cnt = 1;
            }else{
                if (res == gifts[i]){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        //
        cnt = 0;
        for (int i = 0; i < n; i++){
            if (gifts[i] == res){
                cnt++;
            }
        }
        if (cnt > n/2){
            return res;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        Gift gift = new Gift();
        int[] gifts = new  int[]{1, 2, 3, 2, 2};
        int res = gift.getValue(gifts, 5);
        System.out.println(res);
    }

}
