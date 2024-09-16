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
