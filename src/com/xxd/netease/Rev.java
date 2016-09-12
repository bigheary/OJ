package com.xxd.netease;

import java.util.Scanner;
public class Rev{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int res = rev(rev(x)+rev(y));
        System.out.println(res);
    }
    private static int rev(int n){
        int res = 0;
        while(n != 0){
            int tmp = n % 10;
            res = 10*res + tmp;
            n /= 10;
        }
        return res;
    }
}