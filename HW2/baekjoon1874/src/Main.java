import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] stack = new int[n]; int top = -1;
		int seq [] = new int[n]; int idx = 0; 
		String ch = "";
		
		for (int i=0; i<n; i++) {
			seq [i] = sc.nextInt();	
		}
		
		for (int i=1; i<=n; i++) {
			stack[++top] = i;
			ch += '+';
			
			while (top != -1 && stack[top] == seq[idx]) {
				top--; ch += '-'; idx++;
			}
		}
		
		if (top != -1) System.out.println("NO");
		else 
			for (int i=0; i<ch.length(); i++) {
				System.out.println(ch.charAt(i));
			}
	}
}
