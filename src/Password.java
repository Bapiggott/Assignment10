import java.util.ArrayList;
import java.util.List;

public class Password {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Provide a password as a command line argument.");
            return;
        }
        
        String password = args[0];
        if (password.length() < 8 || password.length() > 16) {
            System.out.println("Password's length must be between 8 and 16.");
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
        
        int fourCategories = 0;
        if (!lowercase.isEmpty()) {
            fourCategories++;
        }
        if (!uppercase.isEmpty()) {
            fourCategories++;
        }
        if (!numbers.isEmpty()) {
            fourCategories++;
        }
        if (!symbols.isEmpty()) {
            fourCategories++;
        }
        
        if (fourCategories < 3) {
            System.out.println("Password must have 3 of the following categories: lowercase letters, uppercase letters, numbers, special symbols.");
            return;
        }
        
        System.out.println("Password is valid.");
    }
}