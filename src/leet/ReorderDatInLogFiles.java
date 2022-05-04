package leet;

import com.sun.tools.javac.util.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReorderDatInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<Log> letterLogs = new ArrayList<>();
        List<Log> digitLogs = new LinkedList<>();
        for (String l : logs) {
            Log log = new Log(l);
            if (log.isLetterLog) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }
        Comparator<Log> compareByLogData = new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                int v = o1.logData.compareTo(o2.logData);
                if (v == 0) {
                    return o1.identifier.compareTo(o2.identifier);
                }
                return v;
            }
        };

        /*
        Collections.sort(letterLogs, (Log o1, Log o2) -> {
            int v = o1.logData.compareTo(o2.logData);
            if (v == 0) {
                return o1.identifier.compareTo(o2.identifier);
            }
            return v;
        });

         */

        Collections.sort(letterLogs, compareByLogData);
        String[] result = new String[letterLogs.size() + digitLogs.size()];
        int i = 0;
        for (Log l : letterLogs) {
            result[i++] = l.toString();
        }
        for (Log l : digitLogs) {
            result[i++] = l.toString();
        }
        return result;
    }

    class Log {
        String identifier;
        String logData;
        boolean isLetterLog;

        public Log(String identifier, String logData, boolean isLetterLog) {
            this.identifier = identifier;
            this.logData = logData;
            this.isLetterLog = isLetterLog;
        }

        public Log(String log) {
            int index = log.indexOf(" ");
            this.identifier = log.substring(0, index);
            this.logData = log.substring(index + 1);
            this.isLetterLog = Character.isAlphabetic(logData.charAt(0));
        }

        @Override
        public String toString() {
            return identifier + " " + logData;
        }
    }

    public static void main(String[] args) {
        /*
        Constraints:

            0 <= logs.length <= 100
            3 <= logs[i].length <= 100
            logs[i] is guaranteed to have an identifier, and a word after the identifier.
         */

        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"}; // Input:
        String[] expected = {"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"}; // Output:
        ReorderDatInLogFiles instance = new ReorderDatInLogFiles();
        String[] result = instance.reorderLogFiles(logs);
        System.out.println(Arrays.toString(result));
    }
}
