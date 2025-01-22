import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    public int password;
    public String emailAddress;
    public List<BasicBook> borrowedBooks;

    public User (int password, String emailAddress, List<BasicBook> borrowedBooks){
        this.password = password;
        this.emailAddress = emailAddress;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean login (String testEmailAddress, int testPassword) {
        if (testPassword == password && testEmailAddress == emailAddress){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean borrowBook (BasicBook book) {
        LocalDate borrowDate = LocalDate.now();
        LocalDate returnDate = borrowDate.plusDays(28);
        if (borrowedBooks.size() < 5 && returnDate.isAfter(borrowDate)) {
            borrowedBooks.add(book);
            return true;
        }
        else {
            return false;
        }
    }

    public String returnBook (BasicBook book) {
        if (!borrowedBooks.isEmpty()) {
            borrowedBooks.remove(book);
            return "Boken är återlämnad";
        }
        else {
            return "Gick inte att återlämna";
        }
    }

    public String getName (String emailAddress) {
        return emailAddress;
    }
}
