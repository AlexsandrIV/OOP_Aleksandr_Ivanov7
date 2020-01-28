import java.io.IOException;
import java.util.Scanner;

/**
 * @author Aleksandr_Ivanov7
 */
public class MainQuote {
    /**
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberQuote;
        System.out.println("Enter the number of the quote you want to see. Enter any text to exit.");
        do {
            numberQuote = scanner.nextInt();
            StringBuilder pageQuote = new GetData().getData(numberQuote);
            ParseQuote pq = new ParseQuote(pageQuote.toString());
            if(pq.checkExistPage(numberQuote)) {
                System.out.println(pq.parsePage(pageQuote.toString()).trim());
            }else{
                System.out.println("Quote isn't exist ");
            }
        } while (scanner.hasNextInt());
        scanner.close();
    }
}
