package com.xxd.sord.reconstructTree;

/**
 * Created by Administrator on 2016/10/7 0007.
 */
public class Solution {

    public class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //return helper(pre, 0, pre.length-1, in, 0, in.length-1);
        return helper(pre, 0, in, 0, pre.length);
    }

    public TreeNode helper(int[] pre, int pstart, int[] in, int istart, int len){
        TreeNode node = new TreeNode(pre[pstart]);
        node.left = null;
        node.right = null;
        int leftLen = 0;
        for(int i = 0; i < len; i++){
            if(in[istart + i] == pre[pstart]){
                leftLen = i;
                break;
            }
        }
        int rightLen = len-1-leftLen;
        if (leftLen > 0){
            node.left = helper(pre, pstart+1, in, istart, leftLen);
        }
        if(rightLen > 0){
            node.right = helper(pre, pstart+1+leftLen, in, istart+1+leftLen, rightLen);
        }
        return node;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode res = solution.reConstructBinaryTree(pre, in);
    }
}
