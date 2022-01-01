package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 01/01/22
public class OverlappingRectangles {
    int X=0, Y=1;
    int[][] corners(int[] L, int[] R){
        int[][] corners = {
                {L[X], L[Y]},
                {L[X], R[Y]},
                {R[X], L[Y]},
                {R[X], R[Y]},
        };
        return corners;
    }

    boolean inside(int[] P, int[] L, int[] R){
        int minX = Math.min(L[X], R[X]);
        int maxX = Math.max(L[X], R[X]);
        int minY = Math.min(L[Y], R[Y]);
        int maxY = Math.max(L[Y], R[Y]);
        return minX<=P[X] && P[X]<=maxX && minY<=P[Y] && P[Y]<=maxY;
    }

    int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
        int[][] corners = corners(L1, R1);
        for(int[] p : corners){
            if(inside(p, L2, R2))
                return 1;
        }
        corners = corners(L2, R2);
        for(int[] p : corners){
            if(inside(p, L1, R1))
                return 1;
        }
        int minX1 = Math.min(L1[X], R1[X]);
        int maxX1 = Math.max(L1[X], R1[X]);
        int minX2 = Math.min(L2[X], R2[X]);
        int maxX2 = Math.max(L2[X], R2[X]);
        int minY1 = Math.min(L1[Y], R1[Y]);
        int maxY1 = Math.max(L1[Y], R1[Y]);
        int minY2 = Math.min(L2[Y], R2[Y]);
        int maxY2 = Math.max(L2[Y], R2[Y]);
        if(minX1<=minX2 && maxX2<=maxX1 && minY2<=minY1 && maxY1<=maxY2)
            return 1;
        if(minX2<=minX1 && maxX1<=maxX2 && minY1<=minY2 && maxY2<=maxY1)
            return 1;
        return 0;
    }
}