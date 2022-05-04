package com.self.pramp;
import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Map.Entry;

class WordCount2 {

    static String[][] wordCountEngine(String document) {
        // your code goes here
        Map<String, Integer> map = new LinkedHashMap<>();
        String newDoc = removeSpecial(document);
        String[] arr = newDoc.split(" ");
        for(String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // you can also write a comparator class and use
        // map

    /*
    sorted = budget .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))   .collect( toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

Read more: https://javarevisited.blogspot.com/2017/09/java-8-sorting-hashmap-by-values-in.html#ixzz6KejyUFRT



    map.entrySet().stream()
    .sorted(Map.Entry.comparingByValue())
    .forEach(entry -> ... );
    */
    /*
    Collections.sort(map, (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)->{
      return (int)e2.getValue()-(int)e1.getValue();
    });
    */


        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        String[][] rst = new String[map.size()][2];
        int i = 0;
        for(String key : sortedMap.keySet()){ // chnage map.keySet()
            rst[i][0] = key;
            rst[i++][1] = String.valueOf(sortedMap.get(key)); // convert to String String.valueOf();
        }
        return rst;
    }

    public static void main(String[] args) {
        String[][] rst = wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice makes");
        print(rst);


    }

    private static String removeSpecial(String s){
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toLowerCase().toCharArray();
        for(char c : arr){
            if((c<='z'&&c>='a') || c==' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static void print(String[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
