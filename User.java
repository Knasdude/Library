import java.util.*;
import java.io.*;

public abstract class User {
    public String password;
    public String emailAddress;
    public List<BasicBook> borrowedBooks = new ArrayList<>();

    public User (String password, String emailAddress){
        this.password = password;
        this.emailAddress = emailAddress;
        saveUser();
    }

    public void saveUser () {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt", true))) {
            writer.write("User: " + emailAddress + " Password: " + password + "\n");
            writer.flush();
        }
        catch (IOException e) {
            System.out.println("Error writing user data: " + e.getMessage());
            }
        }

    public String getPassword () {
        return password;
    }

    public String getEmailAddress () {
        return emailAddress;
    }

    public List<BasicBook> getBorrowedBooks () {
        return borrowedBooks;
    }

}

