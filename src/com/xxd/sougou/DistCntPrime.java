package com.xxd.sougou;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12 0012.
 */
public class DistCntPrime {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = scanner.nextInt();
        }

        //计算从 到num[n-1]为止的所有质数
        int[] prime = new int[num[n-1]];
        int cnt=1;
        prime[0] = 2;
        for(int i = 3; i < num[n-1]; i++){
            int j = 0;
            for(j = 0; j < cnt; j++){
                if(i % prime[j] == 0){
                    break;
                }
            }
            if(j == cnt){
                prime[cnt++] = i;
            }
        }

        //计算距离， 求和
        int sum = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = i+1; j < n; j++){
//                sum += getDist(prime, cnt, num[i], num[j]);
//            }
//        }
        sum = getDist(prime, cnt, num[0], num[n-1]);
        for(int i = 1; i < n-1; i++){

        }
        System.out.println(sum);

    }

    public static int getDist(int[] prime, int cnt, int num1, int num2){
        int i = 0;
        int startIdx = 0;
        for(i = 0; i < cnt; i++){
            if(prime[i] > num1){
                startIdx = i;
                break;
            }
        }

        int endIdx = 0;
        for( ; i < cnt; i++){
            if(prime[i] > num2){
                endIdx = i - 1;
                break;
            }
        }
        if(i == cnt){
            endIdx = i-1;
        }
        return (endIdx - startIdx + 1);
    }
}
