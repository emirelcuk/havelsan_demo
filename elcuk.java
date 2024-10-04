import java.util.ArrayList;
import java.util.List;

public class BuggyJavaApp {

    public static void main(String[] args) {
        // Declaring a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1); // Adding an integer
        numbers.add("two"); // ERROR: Adding a string to an integer list

        // Trying to print the list - syntax error
        System.out.println("Numbers in the list are " numbers); // Missing + operator

        // Declaring an array with incorrect size
        int[] array = new int[-5]; // ERROR: Negative array size

        // Loop through the array (incorrect condition, infinite loop)
        for (int i = 0; i <= array.length; i--) {  // ERROR: Wrong loop condition
            System.out.println("Array element at index " + i + " is " + array[i]); // ArrayIndexOutOfBoundsException
        }

        // Declaring an uninitialized variable
        String text;
        System.out.println(text); // ERROR: Variable 'text' might not have been initialized

        // Invalid arithmetic operation
        int result = 10 / 0; // ERROR: Division by zero

        // Trying to parse a string into an integer
        String numStr = "abc";
        int number = Integer.parseInt(numStr); // ERROR: NumberFormatException

        // Null pointer exception scenario
        String name = null;
        if (name.equals("John")) {  // ERROR: NullPointerException when calling equals on null
            System.out.println("Name is John");
        }

        // Invalid method declaration inside a method
        public void invalidMethod() {  // ERROR: Methods cannot be declared inside other methods
            System.out.println("This is invalid!");
        }

        // Recursive method call without termination
        recursiveMethod();  // ERROR: StackOverflowError due to infinite recursion

        // Invalid casting between unrelated types
        Object obj = new Integer(10);
        String str = (String) obj;  // ERROR: ClassCastException

        // Incorrect file operations (file not found)
        File file = new File("nonexistent.txt");  // ERROR: FileNotFoundException
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

        // Accessing static method using an instance (not the class)
        BuggyJavaApp buggyApp = new BuggyJavaApp();
        buggyApp.staticMethod(); // ERROR: Static method should be called on the class, not instance

        // Missing return statement in a method that should return a value
        public int addition(int a, int b) {  // ERROR: Missing return statement
            a + b; // Missing return
        }

        // Using an undeclared variable
        System.out.println(undeclaredVariable);  // ERROR: Variable 'undeclaredVariable' has not been declared

        // Trying to access a method that doesn't exist
        buggyApp.nonExistentMethod();  // ERROR: Method does not exist
    }

    // Recursive method without base case
    public static void recursiveMethod() {
        recursiveMethod();  // Infinite recursion
    }

    // Static method example (should not be called via instance)
    public static void staticMethod() {
        System.out.println("Static method called.");
    }
}
