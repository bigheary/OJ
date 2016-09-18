package com.xxd.tencent;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class ThrowEggs {

    private static int fun(int layer){
        if(layer <= 0){
            return 0;
        }
        if(layer == 1){
            return 1;
        }
        int min = layer;
        int tmp;
        for(int i = 1; i < layer; i++){
            tmp = 1 + Math.max(i-1, fun(layer - i));
            if(min > tmp){
                min = tmp;
            }
        }
        return min;
    }

    private static int fun1(int layer){
        if(layer <= 0){
            return 0;
        }
        if(layer == 1){
            return 1;
        }
        return 1;
    }

    public static void main(String[] args){
        int layer = 19;
        int res = fun(layer);
        System.out.println(res);
    }
}
