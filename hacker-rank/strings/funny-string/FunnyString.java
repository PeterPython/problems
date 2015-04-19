// https://www.hackerrank.com/challenges/funny-string

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {
    public static void isFunny(String str) {
        char a[] = str.toCharArray();
        for(int i=0; i<a.length-1; i++) {
            int x = Math.abs(a[i] - a[i+1]);
            int y = Math.abs(a[a.length-i-1] - a[a.length-i-2]);
            if(x != y) {
                System.out.println("Not Funny");
                return;
            }
        }
        System.out.println("Funny");
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i=0; i<n; i++) {
            String str = in.nextLine();
            isFunny(str);
        }
    }
}