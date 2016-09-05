package com.xxd.leetcode;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class SearchMatrixII1 {
//    //没有使用行列二分，从右上角，或者左下角进行的
//    public boolean searchMatrix(int[][] matrix, int target){
//        if(matrix == null || matrix.length == 0){
//            return false;
//        }
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int row = n - 1;
//        int col = 0;
//        while(row > 0 && col< m - 1){
//            int value = matrix[row][col];
//            if (value == target){
//                return true;
//            }
//            if (value < target){
//                col++;
//                continue;
//            }else{
//                row--;
//            }
//        }
//        if (row == 0 && col == m-1){
//            if (matrix[row][col] != target){
//                return false;
//            }
//        }
//        if (row == 0){
//            for (int i = col; i < m; i++){
//                if (matrix[0][i] == target){
//                    return true;
//                }
//            }
//            return false;
//        }else{
//            for (int i = 0; i < row; i++){
//                if (matrix[i][m-1] == target){
//                    return true;
//                }
//            }
//            return false;
//        }
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
