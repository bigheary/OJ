package com.xxd.leetcode;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        int start;
        int end;
        while(row < n && col >= 0){
            // 列二分
            start = 0;
            int midCol;
            while(start < col){
                midCol = (start + col) >> 1;
                int midVal = matrix[row][midCol];
                if(midVal == target){
                    return true;
                }else if(midVal > target){
                    col = midCol - 1;
                }else{
                    start = midCol;
                }
            }
            if (matrix[row][start] == target){
                return true;
            }

            //行二分
            end = n - 1;
            int midRow;
            while(row < end){
                midRow = (row + end) >> 1;
                int midVal = matrix[midRow][col];
                if (midVal == target){
                    return true;
                }else if(midVal < target){
                    row = midRow + 1;
                }else{
                    end = midRow;
                }
            }
            if (matrix[row][col] == target){
                return true;
            }
        }
        return false;
    }
}
