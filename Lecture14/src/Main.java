// Lecture14 (Lab 10)
// 분할정복을 이용해 히스토그램에서 가장 큰 넓이의 직사각형 구하기
// 입력
// 처음에 히스토그램의 샘플 갯수 N이 입력됩니다.
// 다음에 각 샘플들의 도수들이 N개 입력됩니다.
// 예를 들어서 {3, 2, 6, 7}의 도수를 가지는 4개의 샘플이 있는 히스토그램은
// 4 3 2 6 7 로 입력이 주어집니다.
// 이에 대한 답변을 직사각형의 넓이를 출력하면 됩니다. result = 12
// ex) n = 8, v[n] = {3 2 3 4 2 3 4 1}, -> 입력: 3 2 3 4 2 3 4 1, result = 14

import java.util.Scanner;
public class Main {

	//분할정복을 위한 함수
	// 배열 v에서 범위 (a, b)구간에서 최대 크기의 직사각형 넓이 반환
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
	
	// 히스토그램에서 최대의 직사각형 넓이를 계산해서 출력하는 함수
	// v: 히스토그램의 샘플들의 도수들의 배열 (0 이상의 자연수)
	// n: 샘플의 갯수
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.print("샘플의 갯수 입력: ");
		int n = sc.nextInt();
		
		//System.out.print("도수들의 배열 입력: ");
		int[] v = new int[n];
		for (int i=0; i<n; i++) v[i] = sc.nextInt();
		
		int r = histo(v, n);
		System.out.println(r);
	}
}
