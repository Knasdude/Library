import java.util.List;

public class StudentUser extends User {
    private final String name;

    public StudentUser (int password, String emailAddress, List<BasicBook> borrowedBooks, String name){
        super(password, emailAddress, borrowedBooks);
        this.name = name;
    }

}
