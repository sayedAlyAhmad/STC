 
import java.util.Stack;

public class StringProblem {

 
	public static void main(String[] args) {
		
		System.out.println(reverseString("dd(df)a(ghhh)"));
	}

	   public static String reverseString(String s) {
	        Stack<StringBuilder> stack = new Stack<>();
	        stack.push(new StringBuilder());

	        for (char c : s.toCharArray()) {
	            if (c == '(') {
	                stack.push(new StringBuilder());
	            } else if (c == ')') {
	                StringBuilder sb = stack.pop();
	                stack.peek().append('(').append(sb.reverse()).append(')');
	            } else {
	                stack.peek().append(c);
	            }
	        }

	        return stack.pop().toString();
	    }
}
