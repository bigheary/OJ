package com.xxd.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class UniqueWord {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == ' ' || chars[i] == ',' || chars[i] =='.'){
                sb.append(" ");
            }else{
                sb.append(chars[i]);
            }
        }
        String tmp = sb.toString();
        tmp = tmp.trim();
        String[] words = tmp.split("\\s+");

        StringBuffer out = new StringBuffer();
        Set<String> wordSet = new HashSet();
        for (int i = 0; i < words.length; i++){
            if (wordSet.add(words[i])){
                out.append(words[i]);
                out.append(" ");
            }
        }
        String outStr = out.toString();
        outStr = outStr.trim();
        System.out.println(outStr);
    }
}
