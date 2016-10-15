package com.xxd.sord.serialization;

import com.xxd.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class LinkedToArray {
    public static int[] toArray(ListNode head){
        if (head == null){
            return null;
        }
        ListNode p = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(p != null){
            list.add(p.val);
            p = p.next;
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        int[] res = toArray(root);
        for(int i : res){
            System.out.println(i);
        }

    }
}
