package com.xxd.leetcode;

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
        while(row < n-1 && col > 0){
//            if (row == n - 1 && col == 0){
//                if (matrix[row][col] != target){
//                    return false;
//                }
//            }
            // 列二分
            start = 0;
            int midCol;
            while(start < col-1){
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
            //确定col的值
            if(matrix[row][col] > target){
                col = start;
            }
            if (matrix[row][col] == target){
                return true;
            }

            //行二分
            end = n - 1;
            int midRow;
            while(row < end-1){
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
            //确定row的值
            if (matrix[row][col] < target){
                row = end;
            }
            if (matrix[row][col] == target){
                return true;
            }
        }
        //如果到了最后一个
        if (row == n-1 && col == 0){
            if (matrix[row][col] != target){
                    return false;
                }
        }

        //到最后一行
        if (row == n - 1){
            // 列二分
            start = 0;
            int midCol;
            while(start < col-1){
                midCol = (start + col) >> 1;
                int midVal = matrix[row][midCol];
                if(midVal == target){
                    return true;
                }else if(midVal > target){
                    col = midCol - 1;
                }else{
                    start = midCol + 1;
                }
            }
            //确定col的值
            if(matrix[row][start] == target){
                return true;
            }
            if (matrix[row][col] == target){
                return true;
            }
            return false;
        }else{
            //最后一列
            //行二分
            end = n - 1;
            int midRow;
            while(row < end-1){
                midRow = (row + end) >> 1;
                int midVal = matrix[midRow][col];
                if (midVal == target){
                    return true;
                }else if(midVal < target){
                    row = midRow + 1;
                }else{
                    end = midRow - 1;
                }
            }
            //确定row的值
            if (matrix[row][col] == target){
                return true;
            }
            if (matrix[end][col] == target){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1, 1};
        SearchMatrixII searchMatrixII = new SearchMatrixII();
        boolean res = searchMatrixII.searchMatrix(matrix, 2);
    }

}
