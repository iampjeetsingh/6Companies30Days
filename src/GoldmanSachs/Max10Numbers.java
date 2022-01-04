package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 04/01/22
public class Max10Numbers {
    static class MultiSet<T> extends TreeMap<T, Integer> {
        public void push(T n){
            put(n, 1+getOrDefault(n, 0));
        }
        public void pop(T n){
            int f = getOrDefault(n, 0);
            if(f-1<=0) remove(n);
            else put(n, f-1);
        }
    }
    public static List<Integer> max10(List<Integer> numbers){
        if(numbers.size()<=10) return numbers;
        MultiSet<Integer> set = new MultiSet<>();
        for (int i = 0; i < 10; i++) {
            set.push(numbers.get(i));
        }
        for (int i = 10; i < numbers.size(); i++) {
            int num = numbers.get(i);
            int min = set.firstKey();
            if(num<=min) continue;
            set.push(num);
            set.pop(min);
        }
        return new ArrayList<>(set.keySet());
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10_000_000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        List<Integer> result = max10(list);
        StringBuilder builder = new StringBuilder();
        for (int e : result) {
            builder.append(e).append("\n");
        }
        System.out.println(builder);
    }
}