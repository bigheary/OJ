package com.xxd.huawei;

/**
 * Created by Administrator on 2016/9/3 0003.
 */
public enum PokerEnum {
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
