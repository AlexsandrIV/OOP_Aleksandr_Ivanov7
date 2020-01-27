import java.io.IOException;
import java.util.Scanner;

public class MainQuote {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberQuote;
        System.out.print("Enter number of quote: ");
         do {
            numberQuote = scanner.nextInt();
            StringBuilder pageQuote = new GetData().getData(numberQuote);
            System.out.println(pageQuote);
            ParseQuote pq = new ParseQuote();
            System.out.println(pq.parsePage(pageQuote.toString()).trim());
        } while(scanner.hasNextInt());
        scanner.close();
    }
}
