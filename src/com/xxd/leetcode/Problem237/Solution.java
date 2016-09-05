package com.xxd.leetcode.Problem237;

import com.xxd.leetcode.common.ListNode;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class Solution {
    public void deleteNode(ListNode node){
        //O(1) delete a node
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return ;
    }
}
