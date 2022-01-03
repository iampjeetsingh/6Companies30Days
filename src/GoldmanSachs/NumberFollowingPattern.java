package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 03/01/22
public class NumberFollowingPattern {
    private static int getMin(String s, boolean[] used, int i, String t, int last){
        if(i==s.length())
            return Integer.parseInt(t);
        int min = Integer.MAX_VALUE;
        if(s.charAt(i)=='D'){
            for (int j = 1; j < last; j++) {
                if(used[j]) continue;
                used[j] = true;
                int m = getMin(s, used, i+1, t+""+j, j);
                min = Math.min(m, min);
                used[j] = false;
            }
        }else {
            for (int j = last+1; j < 10; j++) {
                if(used[j]) continue;
                used[j] = true;
                int m = getMin(s, used, i+1, t+""+j, j);
                min = Math.min(m, min);
                used[j] = false;
            }
        }
        return min;
    }
    static String printMinNumberForPattern(String S){
        boolean[] used = new boolean[10];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 10; i++) {
            used[i] = true;
            min = Math.min(min, getMin(S, used,0, ""+i, i));
            used[i] = false;
        }
        return ""+min;
    }
}