package com.xxd.huawei;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/3 0003.
 */
public class PokerJudge {
    //已由输入保证合法性, 输出牌型枚举
    public static PokerEnum getPokerType(String poker){
        String[] pokers = poker.split(" ");
        if (pokers.length == 1){
            return PokerEnum.SINGLE;
        }else if(pokers.length == 2){
            if (pokers[0].compareToIgnoreCase("joker") == 0){
                return PokerEnum.JOKER;
            }else{
                return PokerEnum.DOUBLE;
            }
        }else if(pokers.length == 3){
            return PokerEnum.THREE;
        }else if(pokers.length == 4){
            return PokerEnum.BOOMB;
        }else if(pokers.length == 5){
            return PokerEnum.SHUNZI;
        }else{
            return PokerEnum.DEFAULT;
        }
    }

    public static int comparePoker(String poker1, String poker2){
        PokerEnum type1 = getPokerType(poker1);
        PokerEnum type2 = getPokerType(poker2);
        if (type1 == PokerEnum.SINGLE){
            if (type2 == PokerEnum.SINGLE){
                return rank(poker1) - rank(poker2);
            }else if(type2 == PokerEnum.BOOMB || type2 == PokerEnum.JOKER){
                return -1;
            }else{
                return 0;
            }
        }else if (type1 == PokerEnum.DOUBLE){
            if (type2 == PokerEnum.DOUBLE){
                return rank(poker1.split(" ")[0]) - rank(poker2.split(" ")[0]);
            }else if (type2 == PokerEnum.BOOMB || type2 == PokerEnum.JOKER){
                return -1;
            }else{
                return 0;
            }
        }else if (type1 == PokerEnum.THREE){
            if (type2 == PokerEnum.THREE){
                return rank(poker1.split(" ")[0]) - rank(poker2.split(" ")[0]);
            }else if(type2 == PokerEnum.BOOMB || type2 == PokerEnum.JOKER){
                return -1;
            }else{
                return 0;
            }
        }else if (type1 == PokerEnum.BOOMB){
            if (type2 == PokerEnum.BOOMB){
                return rank(poker1.split(" ")[0]) - rank(poker2.split(" ")[0]);
            }else if(type2 == PokerEnum.JOKER){
                return -1;
            }else{
                return 1;
            }
        }else if (type1 == PokerEnum.SHUNZI){
            if (type2 == PokerEnum.SHUNZI){
                return rank(poker1.split(" ")[0]) - rank(poker2.split(" ")[0]);
            }else if (type2 == PokerEnum.BOOMB || type2 == PokerEnum.JOKER){
                return -1;
            }else{
                return 0;
            }
        }else if (type1 == PokerEnum.JOKER){
            return 1;
        }else{
            return 0;
        }
    }

    public static int rank(String str){
        return "345678910JQKA2jokerJOKER".indexOf(str);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] pokers = line.split("-");
        int res = comparePoker(pokers[0], pokers[1]);
        if (res < 0){
            System.out.println(pokers[1]);
        }else if(res > 0){
            System.out.println(pokers[0]);
        }else{
            System.out.println("ERROR");
        }
    }

    enum PokerEnum {
        SINGLE(1, "个子"),
        DOUBLE(2, "对子"),
        SHUNZI(3, "顺子"),
        THREE(4, "三个"),
        BOOMB(5, "炸弹"),
        JOKER(6, "王炸"),
        DEFAULT(7, "其它");

        private int id;
        private String desc;

        public int getId(){
            return id;
        }

        public String getDesc(){
            return desc;
        }

        private PokerEnum(int id, String desc){
            this.id = id;
            this.desc = desc;
        }
    }

}
