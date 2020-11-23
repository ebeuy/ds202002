/*term project02
  N과 K를 입력받습니다.
○ N개의 데이터를 랜덤으로 생성합니다.
○ K개의 구간을 랜덤으로 생성합니다.
○ 각 구간별로 최소값, 최대값, 합계를 기존의 방식을 이용해서 구합니다.
● K를 고정하고 N을 변화시키면서그래프를그립니다.
● N을 고정하고 K를 변화시키면서그래프를그립니다.
● 현재 N, K에 대한이 알고리즘의성능을평가합니다.*/

import java.util.Random;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		//키보드 입력
		//N K
		int N = sc.nextInt(); int K = sc.nextInt();
		long t = System.currentTimeMillis();
		
		//N개의 데이터 랜덤 생성
		int [] data = new int[N];
		Random rand = new Random();
		for (int i=0; i<N; i++){
			data[i] = rand.nextInt(); 

//			System.out.print(data[i]+" "); //배열값확인
		}
		
//		System.out.println("\n");
		
		for (int i=0; i<K; i++) {
			int start = 1 + rand.nextInt(N-1); //구간 시작은 1부터 N-1사이의 숫자
			int end = 1 + start + rand.nextInt(N-start); //구간 끝은 시작보다 크고 N보다 작은 숫자

//			System.out.println(start+" "+end); //구간 값 확인
			
			int max = data[start-1]; int min = data[start-1]; //비교값 초기화(구간 시작값의 인덱스값) 
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
