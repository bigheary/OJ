package com.xxd.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class UniqueCharacter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            StringBuffer sb = new StringBuffer();
            Set<Character> set = new HashSet<>();
            String str = scanner.next();
            char[] characters = str.toCharArray();
            for (char character : characters){
                if (set.add(character)){
                    sb.append(character);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
