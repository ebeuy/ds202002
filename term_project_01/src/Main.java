import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Ű���� �Է�
		// N a b
		int N = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();
		
		//�迭�Է�
		int [] arr = new int[1024];
		Random rand = new Random();
		for (int i=0; i<N; i++) {
			arr[i] = rand.nextInt();
		}
		
		//�ִ�, �ּڰ� ���ϱ�
		int max = arr[0]; int min = arr[0];
		for (int i=a-1; i<b; i++) {
			if (max<arr[i]) max = arr[i];
			if (min>arr[i]) min = arr[i];
		}
		
		//�ִ�+�ּڰ� ���
		System.out.println(max+min);
	}
}

