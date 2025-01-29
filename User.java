import java.util.ArrayList;
import java.util.List;

public abstract class User {
    public String password;
    public String emailAddress;
    public List<String> borrowedBooks = new ArrayList<>();
    public Boolean punishment = false;

    public User (String password, String emailAddress){
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public boolean login (String emailVerification, String passwordVerification) {
        return passwordVerification.equals(password) && emailVerification.equals(emailAddress);
    }


    public String getName () {
        return emailAddress;
    }

    public List<String> getBorrowedBooks () {
        if (borrowedBooks.size() > 5) {//lånetid
            punishment = true;
        }

        return borrowedBooks;
    }


}
