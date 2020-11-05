import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 키보드 입력
		// N a b
		int N = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();
		
		//배열입력
		int [] arr = new int[1024];
		Random rand = new Random();
		for (int i=0; i<N; i++) {
			arr[i] = rand.nextInt();
		}
		
		//최댓값, 최솟값 구하기
		int max = arr[0]; int min = arr[0];
		for (int i=a-1; i<b; i++) {
			if (max<arr[i]) max = arr[i];
			if (min>arr[i]) min = arr[i];
		}
		
		//최댓값+최솟값 출력
		System.out.println(max+min);
	}
}

