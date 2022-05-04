package misc;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RestClient {

    public static void main(String[] args) {
        //      URL twitter = new URL("http://twitter.com/statuses/public_timeline.xml");
        try {
            URL url = new URL("http://twitter.com/statuses/public_timeline.xml");

            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = null;
            while((line = reader.readLine()) != null){
                print(line);
            }
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        print("code from link");

        try {
            URL twitter = new URL("https://simpledebit.gocardless.io/health_check");
            URLConnection tc = twitter.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(tc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void print(String line) {
        System.out.println(line);
    }
}
