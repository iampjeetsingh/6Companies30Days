package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 03/01/22
public class TotalDecodingMessages {
    long mod = 1_000_000_007;
    int[] dp;
    private int count(String str, int i){
        if(i==str.length())
            return 1;
        if(dp[i]!=-1) return dp[i];
        char c = str.charAt(i);
        char d = i<str.length()-1 ? str.charAt(i+1) : '#';
        if(c=='0')
            return 0;
        long ans = 0;
        if(c=='1') {
            ans += count(str, i+1);
            ans %= mod;
            if(d!='#'){
                ans += count(str, i+2);
                ans %= mod;
            }
        }else if(c=='2'){
            ans += count(str, i+1);
            ans %= mod;
            if('0'<=d && d<='6'){
                ans += count(str, i+2);
                ans %= mod;
            }
        }else {
            ans += count(str, i+1);
            ans %= mod;
        }
        return dp[i]=(int) ans;
    }
    public int CountWays(String str) {
        dp = new int[str.length()];
        Arrays.fill(dp, -1);
        return count(str, 0);
    }
}