package com.xxd.sougou;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12 0012.
 */
public class ShuiXian {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            StringBuffer sb = new StringBuffer();
            int cnt = 0;
            for(int k = m; k <= n; k++){
                int tmp = k;
                int a = tmp % 10;
                tmp /= 10;
                int b = tmp % 10;
                tmp /= 10;
                int c = tmp;
                if(k == a*a*a + b*b*b + c*c*c){
                    cnt++;
                    sb.append(k+" ");
                }
            }
            if(cnt == 0){
                System.out.println("no");
            }else{
                String out = sb.toString();
                out = out.trim();
                System.out.println(out);
            }
        }
    }
}
