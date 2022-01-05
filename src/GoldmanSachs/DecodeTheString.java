package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 05/01/22
public class DecodeTheString {
    static boolean digit(char c){
        return '0'<=c && c<='9';
    }
    static boolean symbol(char c){
        return c=='[' || c==']';
    }
    static String decodedString(String s){
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(digit(c)){
                int end = i;
                StringBuilder builder = new StringBuilder();
                builder.append(c);
                while (end+1<s.length() && digit(s.charAt(end+1))){
                    end++;
                    builder.append(s.charAt(end));
                }
                int num = Integer.parseInt(builder.toString());
                numStack.push(num);
                i = end;
            }else if(symbol(c)){
                if(c=='['){
                    strStack.push(null);
                }else {
                    Stack<String> revStack = new Stack<>();
                    while (!strStack.isEmpty() && strStack.peek()!=null){
                        revStack.push(strStack.pop());
                    }
                    StringBuilder builder = new StringBuilder();
                    while (!revStack.isEmpty()){
                        builder.append(revStack.pop());
                    }
                    String str =  builder.toString().repeat(numStack.pop());
                    strStack.pop();
                    strStack.push(str);
                }
            }else {
                int end = i;
                StringBuilder builder = new StringBuilder();
                builder.append(c);
                while (end+1<s.length() && !symbol(s.charAt(end+1)) && !digit(s.charAt(end+1))){
                    end++;
                    builder.append(s.charAt(end));
                }
                strStack.push(builder.toString());
                i = end;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!strStack.isEmpty())
            builder.append(strStack.pop());
        return builder.toString();
    }
}