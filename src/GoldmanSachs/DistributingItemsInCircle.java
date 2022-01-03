package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 03/01/22
public class DistributingItemsInCircle {
    static int findPosition(int N , int M , int K) {
        int ans = (K+M-1)%N;
        if(ans==0) ans = N;
        return ans;
    }
}