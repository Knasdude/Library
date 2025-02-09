import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Library {

    public String borrowBook (String email, String password, StudentUser user, BasicBook book) {
        if (user.login(email, password) && user.gteBorrowedBooks.size() < 5){
            user.borrowedBooks.add(book.getISBN());
            try {
                FileWriter userBorrowsWriter = new FileWriter("C:\\Users\\06rohshe\\IdeaProjects\\Library\\src\\borrows.txt");
                userBorrowsWriter.write(user.getName() + " lånar: " + user.getBorrowedBooks());
            }
            catch (IOException e) {
                return e.getMessage();
            }
            return "Du har lånat" + book.getTitle();
        }
        else {
            return "Gick inte att låna";
        }
    }

    public String returnBook (BasicBook book) {
        return "Boken är återlämnad";
    }

}
