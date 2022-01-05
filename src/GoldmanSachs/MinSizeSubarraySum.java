package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 05/01/22
public class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = nums[0];

        int minLength = 0;
        while (end+1<nums.length && sum<target){
            end++;
            sum += nums[end];
        }
        int length = end-start+1;
        if(sum>=target){
            minLength = length;
        }
        while (end<nums.length){
            // increment start if possible
            while (start<nums.length && sum-nums[start]>=target){
                sum -= nums[start];
                start++;
                length--;
            }
            minLength = Math.min(length, minLength);
            length++;
            end++;
            if(end<nums.length) sum += nums[end];
        }
        return minLength;
    }
}