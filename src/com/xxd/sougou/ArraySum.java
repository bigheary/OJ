package com.xxd.sougou;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Created by Administrator on 2016/9/12 0012.
 */
public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            double res = 0;
            double next = (double) n;
            for (int i = 0; i < m; i++) {
                res += next;
                next = Math.sqrt(next);
            }
            System.out.println(df.format(res));

        }
    }
}
