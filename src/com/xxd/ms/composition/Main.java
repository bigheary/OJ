package com.xxd.ms.composition;

/**
 * Created by Administrator on 2016/10/10 0010.
 */

import java.util.Scanner;

public class Main{
public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        char[] chars = scanner.next().toCharArray();
        char[] charss = new char[chars.length+1];
        charss[0]=' ';
        for(int i = 0; i < chars.length; i++){
            charss[i+1] = chars[i];
        }
        scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();
        boolean[][] cp = new boolean[26][26];
        for(int i = 0; i < n; i++){
            char[] chars1 = scanner.nextLine().toCharArray();
            cp[chars1[0] - 'a'][chars1[1] - 'a'] = true;
            cp[chars1[1] - 'a'][chars1[0] - 'a'] = true;
        }

        int[][] dp = new int[m+1][27];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= 26; j++){
                dp[i][j] = m;
            }
        }

        dp[0][26] = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= 26; j++){
                dp[i][j] = dp[i-1][j] + 1;
            }
            dp[i][charss[i]-'a'] = dp[i-1][26];
            for(int j = 0; j < 26; j++){
                if(!cp[j][charss[i]-'a']){
                    dp[i][charss[i]-'a'] = Math.min(dp[i][charss[i]-'a'], dp[i-1][j]);
                }
            }
        }
        int res = m;
        for(int i = 0; i <= 26; i++){
            res = Math.min(res, dp[m][i]);
        }
        System.out.println(res);
        }
}
