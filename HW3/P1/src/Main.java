//문제 1)
//형수는 스택과 큐를 이용해서 숫자들을 정렬하는 것을 만들어보려고 합니다.
//다음과 같은 알고리즘으로 숫자들 정렬하는 것을 수행합니다.
//
//a) 큐와 스택을 생성합니다.
//
//b) 숫자 n을 입력받습니다.
//
//c) 큐에 n개의 랜덤한 숫자들을 넣습니다.  랜덤한 숫자는 0~10000 범위로 합니다.
//
//d) 큐에서 숫자 하나를 꺼냅니다.
//
//e) 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 작은 경우, 스택에서 숫자를 꺼내 큐에 넣습니다.
//
//f) 스택이 비어있거나 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 클때까지 e)를 반복합니다.
//
//g) 스택에 큐에서 꺼낸 숫자를 넣습니다.
//
//h) 큐가 비어있지 않다면 d)로 가서 수행을 계속합니다.
//
//i) 스택에 있는데이터를 하나씩 꺼내면서 데이터를 출력합니다.

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int size = 1024; //배열의 크기(정렬할 숫자의 개수)
		
		// 숫자 n 입력
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

		//큐에 n개의 랜덤한 숫자 넣기 
		for (int i=0; i<n; i++) {
			queue[tail] = rand.nextInt(10000);
			tail = (tail+1)%(size);
		}
		
// 입력배열 출력		
		System.out.print("original queue: ");
		for (int i=head; i<tail; i++) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
		
		//큐가 빌때까지 작없 수행
		while (head != tail) {
			//queue의 제일 앞의 값이 stack의 제일 위의 값보다 작거나 스택이 비어있으면 
			//queue의 head값을 꺼내서 스택에 넣는다 
			
			if (top == -1) {
				stack[++top] = queue[head]; //push stack 
				head = (head+1)%size; //remove queue
			}
			
			else if (queue[head]<stack[top]) {
				stack[++top] = queue[head]; //push stack 
				head = (head+1)%size; //remove queue
			}
			
			//queue의 제일 앞의 값이 stack의 제일 위의 값보다 크다면
			//stack에서 값을 꺼내서 큐의 제일 뒤에 넣고 그 후에 stack에 queue[head]를 넣는다.
			else {
				while (top != -1 && stack[top] < queue[head]) {
					queue[tail] = stack[top]; //stack의 값을 꺼내서 queue의 제일 뒤에 넣음
					tail = (tail+1)%size;
					top--; //remove stack[top]
				}
				stack[++top] = queue[head];
				head = (head+1)%size;
			}
		}
		
		//정렬된 stack을 출력한다.
		System.out.print("sorted stack: ");
		for (int i=0; i<=top; i++) {
			System.out.print(stack[i]+" ");
		}
	}
}
