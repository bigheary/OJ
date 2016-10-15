package com.xxd.sord.serialization;

import com.xxd.leetcode.common.ListNode;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class ArrayToLinked {
    public static ListNode toLinked(int[] array){
        if(array == null || array.length <= 0){
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for(int i = 1; i < array.length; i++){
            ListNode node = new ListNode(array[i]);
            p.next = node;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3, 4};
        ListNode head = toLinked(array);
        while(head!= null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
