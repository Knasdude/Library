import java.io.*;
import java.util.*;

public class Library {

    public String availableBooks () {
        StringBuilder books = new StringBuilder();
        File file = new File("C:\\Users\\06rohshe\\IdeaProjects\\Library\\src\\Books.txt");
        try {
            Scanner booksFileReader = new Scanner(file);
            while (booksFileReader.hasNextLine()) {
                books.append(booksFileReader.nextLine()).append("\n");
            }
            return "tillgängliga böcker" + books.toString().trim();
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
    }
    public String borrowBook (User user, String keyword) {
        try {
            FileWriter borrowsWriter = new FileWriter("C:\\Users\\06rohshe\\IdeaProjects\\Library\\src\\borrows.txt");
            //user.borrowedBooks.add(keyword);
            borrowsWriter.write(user.getEmailAddress() + " lånar: " + user.getBorrowedBooks());
            return "Boken är lånad";
        }
        catch (IOException e) {
            return e.getMessage();
        }
    }

    public String returnBook (User user, String title, String author) {
        List<BasicBook> borrowedBooks = user.getBorrowedBooks();
        for (BasicBook book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                borrowedBooks.remove(book);
                book.setCopies(1);
                //lägg till i available books
                return book.getTitle() + " är återlämnad";
            }
            else {
                return "boken hittades inte";
            }
        }
        return "Boken hittades inte";
    }

    public String addBook (BasicBook book) {
        File file = new File("C:\\Users\\06rohshe\\IdeaProjects\\Library\\src\\Books.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                if (reader.nextLine().split(" ")[2].equals(book.getISBN())) {
                    book.setCopies(1);
                    reader.close();
                    return "Kopia tillagd";
                }
            }

            FileWriter BookInfo = new FileWriter("C:\\Users\\06rohshe\\IdeaProjects\\Library\\src\\Books.txt", true);
            BookInfo.write(book.getTitle() + ", " + book.getAuthor() + ", " + book.getISBN() + "\n");
            BookInfo.close();
            return "Bok tillagd";
        }
        catch (IOException e) {
            return e.getMessage();
        }
    }

    public String removeBook(User user, String ISBN) {
        if (user instanceof AdminUser) {
            try {
                List<String> filteredBooks = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader("Books.txt"));
                String currentline;
                while ((currentline = reader.readLine()) != null) {
                    if (!currentline.equalsIgnoreCase(ISBN)) {
                        filteredBooks.add(currentline);
                    }
                }
                reader.close();

                if (filteredBooks.size() == 0) {
                    return "ISBN numret hittades inte";
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter("Books.txt"));

                for (String book: filteredBooks) {
                    writer.write(book);
                    writer.newLine();
                }
                writer.close();
                return "Boken har tagits bort";

            } catch (IOException e) {
                return e.getMessage();
            }
        }
        else {
            return "Gick inte";
        }

    }

}
