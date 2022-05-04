package misc;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamArrayMerge {
    // function to merge two arrays
    public static <T> Object[] mergeArray(T[] arr1, T[] arr2) {
        return Stream.of(arr1, arr2).flatMap(Stream::of).toArray();
    }

    public static void main(String[] args) {
//        Integer[] firstArray = new Integer[]{13, 12, 11, 6, 9, 3}; //source array
//        Integer[] secondArray = new Integer[]{78, 34, 56, 67, 2, 11, 7}; //destination array
//        Integer[] mergedArray = (Integer[]) mergeArray(firstArray, secondArray); //merged array
//        System.out.println("Merged array: " + Arrays.toString(mergedArray));
//
//        Map PstnPool = new HashMap<String, String>();
//        PstnPool.put("tests", "sfgs");
//        String pstns[] =(String[]) PstnPool.keySet().toArray(new String [PstnPool.size()]);
//        System.out.println(" array: " + Arrays.toString(pstns));


        String s = "00110011";
        int count = 0;
        List<String> list = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(i==0)
            {
                sb.append(c);
            }
            else
            {
                if(sb.toString().endsWith(c+"")) {
                    sb.append(c);
                }
                else {
                    list.add(sb.toString());

                    sb = new StringBuilder("");
                    sb.append(c);
                }
            }
        }

        int[] arr = new int[5];

        System.out.println(list.toString());




    }

}
