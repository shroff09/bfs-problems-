import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
 
public class Main {
 
	public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        
		checkPalindromeUsingStack(s);
	}
 
	public static void checkPalindromeUsingStack(String string) {
		String palindromeString = "";
		// initialize a stack
                Stack<Character> stack = new Stack<Character>();
                // iterate over the string
		for (int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			stack.push(character);
		}
                // iterate over the stack till it is empty
		while (!stack.isEmpty()) {
                        // add the character at the top to a string   
			palindromeString = palindromeString + stack.pop();
		}
                // compare original and reversed strings  
		if (string.equals(palindromeString)) {
			System.out.print("String is palindrome");
		} else {
			System.out.print("String is not palindrome");
		}
	}
}
