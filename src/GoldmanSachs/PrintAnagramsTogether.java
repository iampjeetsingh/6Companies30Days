package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 01/01/22
public class PrintAnagramsTogether {
    public String sorted(String s){
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> order = new ArrayList<>();
        for(String s : string_list){
            String key = sorted(s);
            List<String> list;
            if(map.containsKey(key)){
                list = map.get(key);
            }else {
                list = new ArrayList<>();
                map.put(key, list);
                order.add(key);
            }
            list.add(s);
        }
        for(String key : order){
            result.add(map.get(key));
        }
        return result;
    }
}