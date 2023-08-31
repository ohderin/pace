import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private long isbn;
    private boolean isAvailable;

    public Book(String title, String author, long isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public void checkIn() {
        isAvailable = true;
    }
}

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Book> books = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            long isbn = scanner.nextLong();
            books.add(new Book(title, author, isbn));
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            long isbn = scanner.nextLong();
            String action = scanner.next();
            for (Book book : books) {
                if (book.getIsbn() == isbn) {
                    if (action.equals("out")) {
                        book.checkOut();
                    } else if (action.equals("in")) {
                        book.checkIn();
                    }
                }
            }
        }

        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + ", " + book.getAuthor() + ", " + book.getIsbn());
            }
        }
    }
}
