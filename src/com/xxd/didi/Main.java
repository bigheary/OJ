package com.xxd.didi;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
import java.util.ListIterator;
import java.util.Scanner;
import java.util.LinkedList;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int P = scanner.nextInt();
        int[][] data = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                data[i][j] = scanner.nextInt();
            }
        }
        LinkedList<Pos> stack = new LinkedList<Pos>();
        visited[0][0] = true;
        stack.push(new Pos(0, 0));
        boolean res = dfs(data, visited, 0, 0, stack, P);
        while(stack.size() > 1){
            System.out.print(stack.pollLast()+",");
        }
        System.out.println(stack.pollLast());
    }

    private static boolean dfs(int[][] data, boolean[][] visited, int x, int y, LinkedList<Pos> stack, int P){
        int n = data.length;
        int m = data[0].length;
        if (x == 0 && y == m-1){
            if (P >= 0){
                return true;
            }
        }
        if(P <= 0){
            return false;
        }
        if(y+1 < m && data[x][y+1]==1 && !visited[x][y+1]){//right
            visited[x][y+1] = true;
            stack.push(new Pos(x, y+1));
            if(dfs(data, visited, x, y+1, stack, P-1)){
                return true;
            }else{
                stack.pop();
                visited[x][y+1] = false;
            }
        }

        if(x-1 >= 0 && data[x-1][y]==1 && !visited[x-1][y]){//up
            visited[x-1][y] = true;
            stack.push(new Pos(x-1, y));
            if(dfs(data, visited, x-1, y, stack, P-3)){
                return true;
            }else{
                stack.pop();
                visited[x-1][y] = false;
            }
        }

        if(x+1 < n && data[x+1][y]==1 && !visited[x+1][y]){//down
            visited[x+1][y] = true;
            stack.push(new Pos(x+1, y));
            if(dfs(data, visited, x+1, y, stack, P)){
                return true;
            }else{
                stack.pop();
                visited[x+1][y] = false;
            }
        }
        if(y-1 >= 0 && data[x][y-1]==1 && !visited[x][y-1]){//left
            visited[x][y-1] = true;
            stack.push(new Pos(x, y-1));
            if(dfs(data, visited, x, y-1, stack, P-1)){
                return true;
            }else{
                stack.pop();
                visited[x][y-1] = false;
            }
        }
        return false;
    }

    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "["+this.x+","+this.y+"]";
        }
    }
}