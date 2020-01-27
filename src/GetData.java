import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetData {
    //getdata
    StringBuilder getData(int numberQuote) throws IOException {
        URL site = new URL("https://bash.im/quote/" + numberQuote);
        URLConnection uc = site.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        StringBuilder quote = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            quote.append(inputLine);
        }
        in.close();
        return quote;
    }
}
