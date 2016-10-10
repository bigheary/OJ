package com.xxd.sord.printNum;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class Solution {
    public void printOneToMaxOfNDigits(int n){
        if(n < 0){
            return ;
        }
        char[] number = new char[n+1];
        for (int i = 0; i < number.length; i++){
            number[i] = '0';
        }
        while (increment(number)){
            printNum(number);
        }
    }

    public void printNum(char[] number){

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

}
