// https://www.hackerrank.com/contests/epiccode/challenges/perfect-hiring/submissions/code/3333079

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a[] = in.nextLine().split(" ");
        
        int n = Integer.parseInt(a[0]);
        int p = Integer.parseInt(a[1]);
        int x = Integer.parseInt(a[2]);
        
        String l[] = in.nextLine().split(" ");
        double max = Double.MIN_VALUE;
        int maxID = 0;
        for(int i=0; i<n; i++) {
            double point = Double.parseDouble(l[i]);
            double total = point*p;
            
            if(total > max) {
                max = total;
                maxID = i;
            }
            p -= x;
        }
        
        System.out.println(maxID + 1);
    }
}