package com.xxd.io;

import java.util.Scanner;
/**
 * Created by Administrator on 2016/9/2 0002.
 */

public class ScannerTest {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        System.out.println("请输入一个整数");
        while(in.hasNextInt()){
            int num = in.nextInt();
            System.out.println("请输入一个字符串");
            String str = in.next();
            System.out.println("num="+num+",str="+str);
            System.out.println("请输入一个整数");
        }
    }
}