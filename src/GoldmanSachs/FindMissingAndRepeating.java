package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 04/01/22
public class FindMissingAndRepeating {
    int[] findTwoElement(int[] arr, int n) {
        boolean[] visited = new boolean[n+1];
        int a=-1, b=-1;
        for (int e : arr){
            if(visited[e]){
                b = e;
            }
            visited[e] = true;
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                a = i;
                break;
            }
        }
        return new int[]{a, b};
    }
}