package com.xxd.netease;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class CntStr{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        count(0, n, "", res);
        System.out.println(res.get(0));
    }

    public static void count(int pos, int len, String str, ArrayList<Integer> res){
        if(pos == len){
            res.set(0, res.get(0)+1);
            return ;
        }

        for(int i = 0; i < 3; i++){
            if(pos-1 >=0){
                if(pos-2 >= 0){
                    Set<Character> set = new HashSet<Character>();
                    set.add(str.charAt(pos-1));
                    set.add(str.charAt(pos-2));
                    set.add((char)('A'+i));
                    if(set.size() == 3){
                        continue;
                    }else{
                        count(pos+1, len, str+(char)('A'+i), res);
                    }
                }else{
                    count(pos+1, len, str+(char)('A'+i), res);
                }
            }else{
                count(pos+1, len, str+(char)('A'+i), res);
            }
        }
    }
}
