package com.xxd.sord.printNum;


/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class Solution {
    public void printOneToMaxOfNDigits(int n){
        if(n < 0){
            return ;
        }
        Math.abs(-1);
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++){
            number[i] = '0';
        }
        while (increment(number)){
            printNum(number);
        }
    }

    public void printNum(char[] number){
        int i = 0;
        for (i = 0; i < number.length; i++){
            if (number[i] != '0'){
                break;
            }
        }
        if (i == number.length){
            System.out.println('0');
        }else{
            for(; i < number.length; i++){
                System.out.print(number[i]);
            }
            System.out.println();
        }
    }

    public boolean increment(char[] number){
        int i = number.length-1;
        number[i] = (char)(number[i] + 1);
        if (number[i] > '9'){
            boolean flag = true;
            number[i] = '0';
            i--;
            while(flag){
                if (i == -1){
                    return false;//溢出了
                }
                number[i] = (char)(number[i] + 1);
                if (number[i] > '9'){
                    flag = true;
                    number[i] = '0';
                }else{
                    flag = false;
                }
                i--;
            }
        }
        return true;//正常退出
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.printOneToMaxOfNDigits(3);
    }
}
