package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 05/01/22
public class ArrayPairSumDivisibility {
    public boolean canPair(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int ai = num % k;
            map.put(ai, 1 + map.getOrDefault(ai, 0));
        }
        if(nums.length%2!=0)
            return false;
        for(int e : map.keySet()){
            if(e==0) continue;
            if(!map.containsKey(k-e))
                return false;
            if(2*e==k && map.get(e)%2!=0)
                return false;
            if(!Objects.equals(map.get(e), map.get(k - e)))
                return false;
        }
        return true;
    }
}