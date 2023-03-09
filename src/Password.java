import java.util.ArrayList;
import java.util.List;

public class Password {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a password as a command line argument.");
            return;
        }
        
        String password = args[0];
        if (password.length() < 8 || password.length() > 16) {
            System.out.println("Password must be between 8 and 16 characters long.");
            return;
        }
        
        List<Character> lowercase = new ArrayList<>();
        List<Character> uppercase = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercase.add(c);
            } else if (Character.isUpperCase(c)) {
                uppercase.add(c);
            } else if (Character.isDigit(c)) {
                numbers.add(c);
            } else {
                symbols.add(c);
            }
        }
        
        int numCategories = 0;
        if (!lowercase.isEmpty()) {
            numCategories++;
        }
        if (!uppercase.isEmpty()) {
            numCategories++;
        }
        if (!numbers.isEmpty()) {
            numCategories++;
        }
        if (!symbols.isEmpty()) {
            numCategories++;
        }
        
        if (numCategories < 3) {
            System.out.println("Password must contain characters from at least three of the following categories: lowercase letters, uppercase letters, numbers, special symbols.");
            return;
        }
        
        System.out.println("Password is valid.");
    }
}