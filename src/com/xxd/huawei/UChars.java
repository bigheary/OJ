package com.xxd.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class UChars {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        ArrayList<CharDist> list = new ArrayList(chars.length);
        for (char c : chars){
            list.add(new CharDist(c));
        }
        Comparator<CharDist> cmp = new Comparator<CharDist>() {
            @Override
            public int compare(CharDist o1, CharDist o2) {
                return o1.dist - o2.dist;
            }
        };
        Collections.sort(list, cmp);
        for (CharDist cc : list){
            System.out.print(cc.c);
        }
    }

    static class CharDist{
        char c;
        int dist;
        CharDist(char c){
            this.c = c;
            dist = c - 'U' > 0 ? c - 'U' : 'U' - c;
        }
    }
}
