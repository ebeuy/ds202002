import java.util.Scanner;

public class Main {
	
	public static boolean isValid(String st) {
		char[] stack = new char[50];
		int top = -1;

		for (int i=0; i<st.length(); i++) {
			char ch = st.charAt(i);
			if (ch == '(') stack[++top] = ch; 
			
			else if (ch == ')') {
				if (top == -1 || stack[top] != '(') return false;
				top--;
			}
		}
		return top == -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		for (int i= 0; i < n; i++) {
			String st = sc.next();
			if (isValid(st)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

