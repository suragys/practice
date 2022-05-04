package leet;

import com.self.pramp.WordCount;

import java.util.*;

public class _1268SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        /*
            sort the products lex
            Map<String, treeNode>
            m =
            first letter entered

        */

        /*
            sort the products lex
            Map<String, treeNode>
            m =
            first letter entered

        */

        List<String> sortedProducts = Arrays.asList(products);

        Collections.sort(sortedProducts);

        System.out.println(sortedProducts);

        List<List<String>> res = new ArrayList<>();
        int i = 1;
        int cap = 3;
        String typed = searchWord.substring(0,i);
        System.out.println(typed);
        while(i < searchWord.length()){
            int results = 0;
            LinkedList<String> searchResult = new LinkedList();
            for(String w: sortedProducts) {
                if(w.startsWith(typed)){
                    searchResult.addLast(w);
                }
                if(searchResult.size() == cap) break;
            }
            res.add(searchResult);
            i++;
            typed = searchWord.substring(0,i);
        }
        return res;
    }



}
