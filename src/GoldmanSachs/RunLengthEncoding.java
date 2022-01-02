package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 02/01/22
public class RunLengthEncoding {
    String encode(String str) {
        char last = '#';
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= str.length(); i++) {
            char c = i<str.length() ? str.charAt(i) : '#';
            if(c!=last){
                if(count>0){
                    builder.append(last).append(count);
                }
                count = 1;
            }else {
                count++;
            }
            last = c;
        }
        return builder.toString();
    }
}