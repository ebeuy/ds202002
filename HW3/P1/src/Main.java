//���� 1)
//������ ���ð� ť�� �̿��ؼ� ���ڵ��� �����ϴ� ���� �������� �մϴ�.
//������ ���� �˰������� ���ڵ� �����ϴ� ���� �����մϴ�.
//
//a) ť�� ������ �����մϴ�.
//
//b) ���� n�� �Է¹޽��ϴ�.
//
//c) ť�� n���� ������ ���ڵ��� �ֽ��ϴ�.  ������ ���ڴ� 0~10000 ������ �մϴ�.
//
//d) ť���� ���� �ϳ��� �����ϴ�.
//
//e) ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� ���� ���, ���ÿ��� ���ڸ� ���� ť�� �ֽ��ϴ�.
//
//f) ������ ����ְų� ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� Ŭ������ e)�� �ݺ��մϴ�.
//
//g) ���ÿ� ť���� ���� ���ڸ� �ֽ��ϴ�.
//
//h) ť�� ������� �ʴٸ� d)�� ���� ������ ����մϴ�.
//
//i) ���ÿ� �ִµ����͸� �ϳ��� �����鼭 �����͸� ����մϴ�.

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int size = 1024; //�迭�� ũ��(������ ������ ����)
		
		// ���� n �Է�
		System.out.print("input n: ");
		int n = sc.nextInt(); 
		
		//stack
		int [] stack = new int[size];
		int top = -1;
		
		//push(x)
	    //stack[++top] = x
		
		//pop()
		//top--
		
		//empty
		//top == -1
		
		//queue
		int [] queue = new int[size];
		int head = 0, tail = 0;
		
		//add(x)
		//queue[tail] = x; tail = (tail+1)%(size)
		
		//remove()
		//head = (head+1)%(size)
		
		//peek()
		//queue[head]
		
		//empty()
		//head == tail

		//ť�� n���� ������ ���� �ֱ� 
		for (int i=0; i<n; i++) {
			queue[tail] = rand.nextInt(10000);
			tail = (tail+1)%(size);
		}
		
// �Է¹迭 ���		
		System.out.print("original queue: ");
		for (int i=head; i<tail; i++) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
		
		//ť�� �������� �۾� ����
		while (head != tail) {
			//queue�� ���� ���� ���� stack�� ���� ���� ������ �۰ų� ������ ��������� 
			//queue�� head���� ������ ���ÿ� �ִ´� 
			
			if (top == -1) {
				stack[++top] = queue[head]; //push stack 
				head = (head+1)%size; //remove queue
			}
			
			else if (queue[head]<stack[top]) {
				stack[++top] = queue[head]; //push stack 
				head = (head+1)%size; //remove queue
			}
			
			//queue�� ���� ���� ���� stack�� ���� ���� ������ ũ�ٸ�
			//stack���� ���� ������ ť�� ���� �ڿ� �ְ� �� �Ŀ� stack�� queue[head]�� �ִ´�.
			else {
				while (top != -1 && stack[top] < queue[head]) {
					queue[tail] = stack[top]; //stack�� ���� ������ queue�� ���� �ڿ� ����
					tail = (tail+1)%size;
					top--; //remove stack[top]
				}
				stack[++top] = queue[head];
				head = (head+1)%size;
			}
		}
		
		//���ĵ� stack�� ����Ѵ�.
		System.out.print("sorted stack: ");
		for (int i=0; i<=top; i++) {
			System.out.print(stack[i]+" ");
		}
	}
}
