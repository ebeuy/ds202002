//백준 10845
//정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//명령은 총 여섯 가지이다.
//
//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] queue = new int[n];
		int head = 0, tail = 0;
		
		for (int i=0; i<n; i++) {
			String ch = sc.next();
			if (ch.equals("push")) {
				int x = sc.nextInt();
				queue[tail] = x; 
				tail = (tail+1)%n;
			}
			
			else if (ch.equals("pop")) {
				if (head != tail) {
					System.out.println(queue[head]);
					head = (head+1)%n;
				}
				else
					System.out.println(-1);
			}
			
			else if (ch.equals("size")) {
				System.out.println((tail-head+n)%n);
			}
			
			else if (ch.equals("empty")) {
				if (head == tail)
					System.out.println(1);
				else
					System.out.println(0);
			}
			
			else if (ch.equals("front")) {
				if (head != tail)
					System.out.println(queue[head]);
				else
					System.out.println(-1);
			}
			
			else if (ch.equals("back")) {
				if (head != tail)
					System.out.println(queue[tail-1]);
				else
					System.out.println(-1);
			}
	}
}

}
