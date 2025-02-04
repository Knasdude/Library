import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Skanner läser input från user

        //Sökväg till dataset med
        String filename = "C:\\Users\\06joesta\\IdeaProjects\\Bibliotek\\src\\Prog2 Dataset - books.csv.csv";

        // Hämta det du ska söka på
        //String filename = getFilePath(scanner);

        String keyword = StrategySearch.getSearchKeyword(scanner);

        // Utför sök
        StrategySearch.performSearch(filename, keyword, scanner);
    }
}
