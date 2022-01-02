package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 02/01/22
public class GCDofStrings {
    private TreeSet<Integer> factors(int n){
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 1; i*i <= n; i++) {
            if(n%i!=0)
                continue;
            set.add(n/i);
            set.add(i);
        }
        return set;
    }
    private boolean divides(String s, String t){
        String res = t.repeat(s.length()/t.length());
        return s.equals(res);
    }
    public String gcdOfStrings(String str1, String str2) {
        TreeSet<Integer> factors = factors(Math.min(str1.length(), str2.length()));
        String small, large;
        if(str1.length()<str2.length()){
            small = str1;
            large = str2;
        }else {
            small = str2;
            large = str1;
        }
        for(int d : factors){
            String repeater = str1.substring(0, d);
            if(divides(small, repeater) && divides(large, repeater)){
                return repeater;
            }
        }
        return "";
    }
}