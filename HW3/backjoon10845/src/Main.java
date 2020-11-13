//���� 10845
//������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//����� �� ���� �����̴�.
//
//push X: ���� X�� ť�� �ִ� �����̴�.
//pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
//size: ť�� ����ִ� ������ ������ ����Ѵ�.
//empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
//front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
//back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.

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
