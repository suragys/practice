package misc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class dbregLogParsing {
    public String[] reorderLogFiles(String[] logs) {
        List<Log> letterLogs = new ArrayList<>();
        for (String l : logs) {
            Log log = new Log(l);
                letterLogs.add(log);
        }
        Comparator<Log> compareByLogData = new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return o1.identifier.compareTo(o2.identifier);
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

        String[] result = new String[letterLogs.size()];
        int i = 0;
        for (Log l : letterLogs) {
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

            this.identifier = log.substring(log.indexOf("[") + 1, log.indexOf("]"));
            this.logData = log.substring(log.indexOf("]") + 1);
            System.out.println(logData);
            this.isLetterLog = Character.isAlphabetic(logData.charAt(0));
        }

        @Override
        public String toString() {
            return identifier + " " + logData;
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        Constraints:

            0 <= logs.length <= 100
            3 <= logs[i].length <= 100
            logs[i] is guaranteed to have an identifier, and a word after the identifier.
         */

        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"}; // Input:
        String[] expected = {"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"}; // Output:
        String log = "dbregsrv.log.10:[2022-04-26 20:03:19,847] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.10:[2022-04-26 20:04:31,374] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 119 milliseconds\n" +
                "dbregsrv.log.13:[2022-04-26 17:06:18,341] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.13:[2022-04-26 17:07:45,936] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 133 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:08:49,927] [JobWorker-9] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:12:48,167] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 119 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:22:25,523] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 133 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:27:35,232] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:30:58,709] [JobWorker-1] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:34:24,199] [JobWorker-7] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 116 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:36:53,780] [JobWorker-0] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.14:[2022-04-26 16:51:08,916] [JobWorker-1] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.15:[2022-04-26 15:19:09,059] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 204 milliseconds\n" +
                "dbregsrv.log.15:[2022-04-26 15:27:15,856] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.15:[2022-04-26 15:43:11,579] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.15:[2022-04-26 15:45:02,483] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.15:[2022-04-26 15:55:34,807] [JobWorker-7] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 133 milliseconds\n" +
                "dbregsrv.log.15:[2022-04-26 15:55:35,773] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 122 milliseconds\n" +
                "dbregsrv.log.16:[2022-04-26 14:39:34,326] [JobWorker-0] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 132 milliseconds\n" +
                "dbregsrv.log.16:[2022-04-26 14:41:21,979] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 132 milliseconds\n" +
                "dbregsrv.log.16:[2022-04-26 14:52:42,091] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 116 milliseconds\n" +
                "dbregsrv.log.16:[2022-04-26 15:06:40,107] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.16:[2022-04-26 15:08:45,540] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.16:[2022-04-26 15:17:20,831] [JobWorker-0] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 133 milliseconds\n" +
                "dbregsrv.log.17:[2022-04-26 13:44:47,112] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.17:[2022-04-26 13:46:17,715] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 137 milliseconds\n" +
                "dbregsrv.log.17:[2022-04-26 13:46:19,673] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.17:[2022-04-26 13:51:12,483] [JobWorker-7] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 119 milliseconds\n" +
                "dbregsrv.log.17:[2022-04-26 14:03:50,298] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.17:[2022-04-26 14:11:36,178] [JobWorker-1] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.18:[2022-04-26 13:03:52,579] [JobWorker-1] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 132 milliseconds\n" +
                "dbregsrv.log.18:[2022-04-26 13:07:14,042] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 116 milliseconds\n" +
                "dbregsrv.log.18:[2022-04-26 13:17:34,380] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.18:[2022-04-26 13:17:35,361] [JobWorker-2] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.18:[2022-04-26 13:25:51,123] [JobWorker-7] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 132 milliseconds\n" +
                "dbregsrv.log.18:[2022-04-26 13:41:17,586] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.19:[2022-04-26 12:17:14,263] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.19:[2022-04-26 12:26:49,616] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.19:[2022-04-26 12:28:19,442] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.19:[2022-04-26 12:52:11,573] [JobWorker-0] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.19:[2022-04-26 12:52:15,219] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.19:[2022-04-26 12:57:05,243] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.19:[2022-04-26 12:57:05,299] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.2:[2022-04-27 14:20:35,962] [JobWorker-9] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 150 milliseconds\n" +
                "dbregsrv.log.2:[2022-04-27 14:20:36,966] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 149 milliseconds\n" +
                "dbregsrv.log.20:[2022-04-26 11:07:56,324] [JobWorker-1] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 117 milliseconds\n" +
                "dbregsrv.log.20:[2022-04-26 11:14:18,531] [JobWorker-2] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 116 milliseconds\n" +
                "dbregsrv.log.20:[2022-04-26 11:32:25,110] [JobWorker-9] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.20:[2022-04-26 11:35:12,018] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 118 milliseconds\n" +
                "dbregsrv.log.20:[2022-04-26 11:37:13,919] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 11:05:59,350] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 11:13:26,662] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 125 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 11:20:01,490] [JobWorker-1] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 201 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 11:23:04,884] [JobWorker-7] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 125 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 11:24:52,708] [JobWorker-2] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 11:45:21,272] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 150 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 11:48:34,999] [JobWorker-0] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 151 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 12:12:03,655] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 224 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 12:15:05,556] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 148 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 12:37:25,412] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.3:[2022-04-27 12:50:56,155] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 150 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 07:21:13,636] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 125 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 07:26:15,164] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 07:31:12,459] [JobWorker-9] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 150 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 07:32:55,501] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 07:58:29,859] [JobWorker-5] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 08:25:59,492] [JobWorker-2] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 08:33:34,826] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 08:36:16,903] [JobWorker-7] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 150 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 08:46:31,677] [JobWorker-7] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 149 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 10:56:13,139] [JobWorker-6] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 150 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 10:59:03,913] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 125 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 11:02:35,189] [JobWorker-0] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 150 milliseconds\n" +
                "dbregsrv.log.4:[2022-04-27 11:04:00,161] [JobWorker-2] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 125 milliseconds\n" +
                "dbregsrv.log.5:[2022-04-27 06:57:25,796] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 125 milliseconds\n" +
                "dbregsrv.log.5:[2022-04-27 06:58:44,913] [JobWorker-3] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 126 milliseconds\n" +
                "dbregsrv.log.5:[2022-04-27 07:00:05,551] [JobWorker-1] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 149 milliseconds\n" +
                "dbregsrv.log.5:[2022-04-27 07:02:00,175] [JobWorker-2] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 125 milliseconds\n" +
                "dbregsrv.log.5:[2022-04-27 07:12:04,654] [JobWorker-4] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 149 milliseconds\n" +
                "dbregsrv.log.9:[2022-04-26 20:21:13,677] [JobWorker-8] INFO  c._.d.handler.NotifyRequestHandler - The CTI publish call event for vos in 134 milliseconds";
//        logs = log.split("\n");
//        System.out.println(Arrays.toString(logs));
        dbregLogParsing instance = new dbregLogParsing();


        String path = "/Users/syalaburgi/Documents/dbreg-effort";
        List<String> l = Files.readAllLines(Paths.get(path+"/latency-3.log"));
        System.out.println(l);
        String[] result = instance.reorderLogFiles(l.toArray(new String[l.size()]));
        System.out.println("result is");
        Arrays.stream(result).forEach(System.out::println);
//        System.out.println(Arrays.toString(result));

        Files.write(Paths.get(path + "/latency-sorted-time.log"),new ArrayList<>(Arrays.asList(result)), Charset.defaultCharset());

        //
    }
}
