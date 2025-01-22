import java.util.List;
import java.time.LocalDate;

public class externUser extends User{
    private final String name;
    public int paymentMethod;

    public externUser(int password, String emailAddress, List<BasicBook> borrowedBooks, String name, int paymentMethod) {
        super(password, emailAddress, borrowedBooks);
        this.name = name;
        this.paymentMethod = paymentMethod;

    }

    public Boolean Payment (int paymentMethod) {
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        return (currentDay == 28);
    }


}
