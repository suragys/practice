package com.self.pramp;

import java.util.*;
import java.util.stream.Collectors;

public class WordCount {

    static String[][] wordCountEngine(String document) {
        // your code goes here


        Map<String, Integer> wordCount = new HashMap();
        document = document.replaceAll("[^a-zA-Z0-9\\s]+", "");
        String[] words = document.split(" ");
        for (String w : words) {
            w = w.toLowerCase();
            int c = 0;
            if (wordCount.get(w) != null) {
                c = wordCount.get(w);
            }
            wordCount.put(w, ++c);
            wordCount.entrySet();
            Map.Entry<String, String> e ;
        }
        System.out.println(wordCount.toString());
        String[][] r = new String[wordCount.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> e : wordCount.entrySet()) {
            r[i][0] = e.getKey();
            r[i][1] = e.getValue().toString();
            i++;
        }


        return r;
    }

    static String[][] wordCountEngine2(String document) {
        // only consider alphabets
        // case insensitve
        // return in Descending order
        char[] d = document.toCharArray();
        int i = 0;
        Map<String, Integer> m = new HashMap<>();
        int h = Integer.MIN_VALUE;
        while (i < d.length) {
            StringBuffer w = new StringBuffer();
            while (i < d.length && d[i] != ' ') {
                if (d[i] >= 'a' && d[i] <= 'z') {
                    w.append(d[i]);
                } else if (d[i] >= 'A' && d[i] <= 'Z') {
                    w.append(Character.toLowerCase(d[i]));
                }
                i++;
            }
            String wd = w.toString();
            int c = 0;
            if (m.containsKey(wd)) {
                c = m.get(wd);
            }
            c++;
            if (c > h) {
                h = c;
            }
            m.put(wd, c);
            i++;
        }
        List<String>[] l = new List[h];

        int t = 0;
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            List<String> sl = l[e.getValue() - 1];
            if (sl == null) {
                sl = new ArrayList<>();
                l[e.getValue() - 1] = sl;
            }
            sl.add(e.getKey());
            t++;
        }

        String[][] result = new String[t][2];
        int resI = 0;
        for (int j = l.length - 1; j > -1; j--) {
            List<String> sl = l[j];
            for (String s : sl) {
                result[resI][0] = s;
                result[resI][1] = String.valueOf(j + 1);
                resI++;
            }
        }


        return result;
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

    static  String[][] wc(String document) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String newDoc = removeSpecial(document);
        String[] arr = newDoc.split(" ");
        for(String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
//        map.entrySet()
//                .stream()
//                .sorted((Comparator<? super Map.Entry<String, Integer>>) Map.Entry.comparingByValue().reversed())
//                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        String[][] rst = new String[map.size()][2];
        int i = 0;
        for(String key : map.keySet()){
            rst[i][0] = key;
            rst[i++][1] = String.valueOf(map.get(key));
        }
        return rst;
    }

    static String[][] wordCountEngine3(String document) {
        char[] d = document.toCharArray();
        int i = 0;
        Map<String, Word> m = new HashMap<>();
        int h = Integer.MIN_VALUE;
        while (i < d.length) {
            StringBuffer w = new StringBuffer();
            while (i < d.length && d[i] != ' ') {
                if (d[i] >= 'a' && d[i] <= 'z') {
                    w.append(d[i]);
                } else if (d[i] >= 'A' && d[i] <= 'Z') {
                    w.append(Character.toLowerCase(d[i]));
                }
                i++;
            }
            String wd = w.toString();
            int c = 0;
            Word word;
            if (m.containsKey(wd)) {
                c = m.get(wd).c;
                word = m.get(wd);
            } else {
                word = new Word(wd, c, i);
            }
            c++;
            if (c > h) {
                h = c;
            }
            word.c++;
            m.put(wd, word);
            i++;
        }

//        Collections.sort(m.values(), new NameComparator());
        List<Word> list = m.values().stream()
                .map(Word::new)
                .collect(Collectors.toList());
//        List<Word> list = m.values().toArray();
        Collections.sort(list, new NameComparator());
        String[][] res = new String[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j).getS();
        }
        return res;
    }


    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        document = "Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ";
        String[][] r = wordCountEngine3(document);
//        System.out.println(Arrays.toString(wordCountEngine2(document)));
        for (int i = 0; i < r.length; i++) {
            System.out.println(Arrays.toString(r[i]));
        }
    }

    public static class Word {
        int i;
        int c;
        String value;
        String[] s;

        public Word(String wd) {
            value = wd;
        }

        public Word(String wd, int c, int i) {
            value = wd;
            this.c = c;
            this.i = i;
        }

        public Word(Word word) {
            this.i = word.i;
            this.c = word.c;
            this.value = word.value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return value.equals(word.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        String[] getS() {
            s = new String[]{value, String.valueOf(c)};
            return s;
        }
    }

    public static class NameComparator implements Comparator<Word> {
        @Override
        public int compare(Word o1, Word o2) {
            if (o1.c == o2.c) {
                return o1.i < o2.i ? -1 : 1;
            }
            return o1.c > o2.c ? -1 : 1;
        }
    }
}
