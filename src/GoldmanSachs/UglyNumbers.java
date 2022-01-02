package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 02/01/22
public class UglyNumbers {
    long getNthUglyNo(int n) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        int two=0, three=0, five=0;
        for (int i = 0; i < n; i++) {
            long twoM = 2*list.get(two);
            long threeM = 3*list.get(three);
            long fiveM = 5*list.get(five);
            long min = Math.min(twoM, Math.min(threeM, fiveM));
            if(twoM==min) two++;
            if(threeM==min) three++;
            if(fiveM==min) five++;
            list.add(min);
        }
        return list.get(n-1);
    }
}