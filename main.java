import java.util.Scanner;

public class SimpleCalculator {

    // Toplama işlemi
    public static double add(double a, double b) {
        return a + b;
    }

    // Çıkarma işlemi
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Çarpma işlemi
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Bölme işlemi
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Bölme işlemi yapılamaz! Bölen sıfır olamaz.");
            return 0;
        }
        return a / b;
    }

    public static void printMenu() {
        System.out.println("Basit Hesap Makinesi");
        System.out.println("1. Toplama");
        System.out.println("2. Çıkarma");
        System.out.println("3. Çarpma");
        System.out.println("4. Bölme");
        System.out.println("5. Çıkış");
        System.out.println("Bir işlem seçiniz: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            
            if (choice == 5) {
                exit = true;
                System.out.println("Program sonlandırılıyor.");
                continue;
            }
            
            System.out.println("Birinci sayıyı girin: ");
            double num1 = scanner.nextDouble();
            System.out.println("İkinci sayıyı girin: ");
            double num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Sonuç: " + add(num1, num2));
                    break;
                case 2:
                    System.out.println("Sonuç: " + subtract(num1, num2));
                    break;
                case 3:
                    System.out.println("Sonuç: " + multiply(num1, num2));
                    break;
                case 4:
                    System.out.println("Sonuç: " + divide(num1, num2));
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
                    break;
            }

            System.out.println();
        }
        
        scanner.close();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kitap sınıfı
class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Başlık: " + title + ", Yazar: " + author + ", ISBN: " + isbn;
    }
}

// Kütüphane sınıfı
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Kütüphanede hiç kitap yok.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// Kütüphane yöneticisi sınıfı
public class LibraryManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\nKütüphane Yönetim Sistemi");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Sil");
            System.out.println("3. Kitap Ara");
            System.out.println("4. Kitapları Listele");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the newline

            switch (choice) {
                case 1:
                    System.out.print("Kitap Başlığı: ");
                    String title = scanner.nextLine();
                    System.out.print("Kitap Yazarı: ");
                    String author = scanner.nextLine();
                    System.out.print("Kitap ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    System.out.println("Kitap eklendi.");
                    break;

                case 2:
                    System.out.print("Silinecek Kitap ISBN'sini girin: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    System.out.println("Kitap silindi.");
                    break;

                case 3:
                    System.out.print("Aranacak Kitap Başlığı: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Kitap Bulundu: " + foundBook);
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 4:
                    System.out.println("Kütüphanedeki Kitaplar:");
                    library.listBooks();
                    break;

                case 5:
                    running = false;
                    System.out.println("Program sonlandırılıyor.");
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
                    break;
            }
        }

        scanner.close();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kitap sınıfı
class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Başlık: " + title + ", Yazar: " + author + ", ISBN: " + isbn;
    }
}

// Kütüphane sınıfı
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Kütüphanede hiç kitap yok.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// Kütüphane yöneticisi sınıfı
public class LibraryManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\nKütüphane Yönetim Sistemi");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Sil");
            System.out.println("3. Kitap Ara");
            System.out.println("4. Kitapları Listele");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the newline

            switch (choice) {
                case 1:
                    System.out.print("Kitap Başlığı: ");
                    String title = scanner.nextLine();
                    System.out.print("Kitap Yazarı: ");
                    String author = scanner.nextLine();
                    System.out.print("Kitap ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    System.out.println("Kitap eklendi.");
                    break;

                case 2:
                    System.out.print("Silinecek Kitap ISBN'sini girin: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    System.out.println("Kitap silindi.");
                    break;

                case 3:
                    System.out.print("Aranacak Kitap Başlığı: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Kitap Bulundu: " + foundBook);
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 4:
                    System.out.println("Kütüphanedeki Kitaplar:");
                    library.listBooks();
                    break;

                case 5:
                    running = false;
                    System.out.println("Program sonlandırılıyor.");
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
                    break;
            }
        }

        scanner.close();
    }
}
