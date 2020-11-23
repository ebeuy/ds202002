/*term project02
  N�� K�� �Է¹޽��ϴ�.
�� N���� �����͸� �������� �����մϴ�.
�� K���� ������ �������� �����մϴ�.
�� �� �������� �ּҰ�, �ִ밪, �հ踦 ������ ����� �̿��ؼ� ���մϴ�.
�� K�� �����ϰ� N�� ��ȭ��Ű�鼭�׷������׸��ϴ�.
�� N�� �����ϰ� K�� ��ȭ��Ű�鼭�׷������׸��ϴ�.
�� ���� N, K�� ������ �˰����Ǽ��������մϴ�.*/

import java.util.Random;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		//Ű���� �Է�
		//N K
		int N = sc.nextInt(); int K = sc.nextInt();
		long t = System.currentTimeMillis();
		
		//N���� ������ ���� ����
		int [] data = new int[N];
		Random rand = new Random();
		for (int i=0; i<N; i++){
			data[i] = rand.nextInt(); 

//			System.out.print(data[i]+" "); //�迭��Ȯ��
		}
		
//		System.out.println("\n");
		
		for (int i=0; i<K; i++) {
			int start = 1 + rand.nextInt(N-1); //���� ������ 1���� N-1������ ����
			int end = 1 + start + rand.nextInt(N-start); //���� ���� ���ۺ��� ũ�� N���� ���� ����

//			System.out.println(start+" "+end); //���� �� Ȯ��
			
			int max = data[start-1]; int min = data[start-1]; //�񱳰� �ʱ�ȭ(���� ���۰��� �ε�����) 
			for (int j = start; j<end; j++) {
				if (max<data[j]) max = data[j];
				if (min>data[j]) min = data[j];
			}
			System.out.println(min+" "+max+" "+(max+min));
		}
		
		long f = System.currentTimeMillis();
		System.out.println("Elapsed time is "+(f-t)+"ms");
	}
}
