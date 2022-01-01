package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 01/01/22
public class SubArrayProductLessK {
    public int countSubArrayProductLessThanK(long a[], long n, long k) {
        int length = (int) n;
        long[] product = new long[length];
        int[] last = new int[length];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(a[i]>=k) continue;
            int start = i>0 ? Math.max(i, last[i-1]+1) : i;
            product[i] = 1;
            if(start>i){
                product[i] = product[i-1]/a[i-1];
            }
            last[i] = start-1;
            for (int j = start; j < n; j++) {
                if(product[i]*a[j]>=k)
                    break;
                product[i] *= a[j];
                last[i] = j;
            }
            int c = Math.max(last[i]-i+1, 0);
            count += c;
        }
        return count;
    }
}