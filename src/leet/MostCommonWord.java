package leet;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        for (String w : banned) {
            bannedSet.add(w);
        }
        LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<String, Integer>();

//        String[] words = paragraph.split("");
        String[] words = paragraph.split("[\\s\\?,;.!]");

        int highestValue = Integer.MIN_VALUE;
        String mostCommonWord = "";

        for (String word : words) {
            word = word.toLowerCase();
            char[] letters = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < letters.length; i++) {
                char x = letters[i];
                if ((x >= 'a' && x <= 'z')) {
                    sb.append(x);
                }
            }
            String realWord = sb.toString();
            if (!realWord.isEmpty() && !bannedSet.contains(realWord)) {
                int count = wordMap.getOrDefault(realWord, 0);
                count++;
                wordMap.put(realWord, count);
                if (count > highestValue) {
                    highestValue = count;
                    mostCommonWord = realWord;
                }
            }
        }
        return mostCommonWord;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));

        paragraph = "a, a, a, a, b,b,b,c, c";
        banned = new String[]{"a"};

        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));

    }
}
