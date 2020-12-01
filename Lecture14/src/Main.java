// Lecture14 (Lab 10)
// ���������� �̿��� ������׷����� ���� ū ������ ���簢�� ���ϱ�
// �Է�
// ó���� ������׷��� ���� ���� N�� �Էµ˴ϴ�.
// ������ �� ���õ��� �������� N�� �Էµ˴ϴ�.
// ���� �� {3, 2, 6, 7}�� ������ ������ 4���� ������ �ִ� ������׷���
// 4 3 2 6 7 �� �Է��� �־����ϴ�.
// �̿� ���� �亯�� ���簢���� ���̸� ����ϸ� �˴ϴ�. result = 12
// ex) n = 8, v[n] = {3 2 3 4 2 3 4 1}, -> �Է�: 3 2 3 4 2 3 4 1, result = 14

import java.util.Scanner;
public class Main {

	//���������� ���� �Լ�
	// �迭 v���� ���� (a, b)�������� �ִ� ũ���� ���簢�� ���� ��ȯ
	static int histo(int[] v, int a, int b) {
		
		if (a == b) return v[a];
		int c = (a+b)/2, left = histo(v, a, c), right = histo(v, c+1, b), result = Math.max(left, right);
		
		int i = c, j = c+1, height = Math.min(v[i], v[j]);
		result = Math.max(result, height*2);
		
		while (a < i || j <b) {
			if (j < b && ((i == a) || v[i-1] < v[j+1]))	height = Math.min(height, v[++j]);
			else height = Math.min(height, v[--i]);
			result = Math.max(result, height*(j-i+1));
		}
		return result;
	}
	
	// ������׷����� �ִ��� ���簢�� ���̸� ����ؼ� ����ϴ� �Լ�
	// v: ������׷��� ���õ��� �������� �迭 (0 �̻��� �ڿ���)
	// n: ������ ����
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.print("������ ���� �Է�: ");
		int n = sc.nextInt();
		
		//System.out.print("�������� �迭 �Է�: ");
		int[] v = new int[n];
		for (int i=0; i<n; i++) v[i] = sc.nextInt();
		
		int r = histo(v, n);
		System.out.println(r);
	}
}
