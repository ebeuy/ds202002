/* �� ������� : 12�� 14��
�� ��ǥ�ڷ��ۼ�
�� PPT 10������ ����(5�� ��ǥ��)
�� ���� �׽�Ʈ�� ��� ���� 2-3������ ����
�� 11�� 27�� �����Ѿ˰����������Ͽ�����������ǥ
�� ������ �˰����� �ùٸ��� �����ϴ��� ���� �˰��� ����� ��
�� ������ �˰��� ���� �ð� ���
�� �����ڷ�
�� �ҽ�
�� ���̺�(������ �˰��� ����ǥ�� ������ �˰��� ����ǥ ��)
�� �׷���(������ �˰��� �׷����� ���� �˰��� �׷��� ��)*/

import java.util.Random;
import java.util.Scanner;

public class Main {
	static int n; static int k; static int BKsize;
	static int [] data;
	static int [] block; 
	static int [] minBlock;
	static int [] maxBlock;
	
	static void minmaxsum(int[] data, int[] start, int[] end, int rmin[], int rmax[], int[] rsum) {
		for (int k = 0; k < start.length; k++) {
			int sum = 0; int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
			while (start[k] < end[k] && start[k] % BKsize !=0) {
				sum += data[start[k]];
				min = Math.min(min, data[start[k]]);
				max = Math.max(max, data[start[k]]);
				start[k]++;
			}
			while (start[k]+BKsize <= end[k]) {
				sum += block[start[k] / BKsize];
				min = Math.min(min, minBlock[start[k]/BKsize]);
				max = Math.max(max, maxBlock[start[k]/BKsize]);
				start[k] += BKsize;
			}
			while (start[k] <= end[k]) {
				sum += data[start[k]];
				min = Math.min(min, data[start[k]]);
				max = Math.max(max, data[start[k]]);
				start[k]++;
			}		
			rsum[k] = sum;
			rmin[k] = min;
			rmax[k] = max;
		}
	}
	
	static void init(int data[], int n) {
		//BKsize = (int) Math.sqrt(n);
		for (int i=0; i<n; i++) block[i/BKsize] += data[i];
		for (int i=0; i<n; i++) {
			if (i%BKsize == 0) minBlock[i/BKsize] = data[i];
			else minBlock[i/BKsize] = Math.min(minBlock[i/BKsize], data[i]);
		}
		for (int i=0; i<n; i++) {
			if (i%BKsize == 0) maxBlock[i/BKsize] = data[i];
			else maxBlock[i/BKsize] = Math.max(maxBlock[i/BKsize], data[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		n = sc.nextInt(); 
		k = sc.nextInt();
		
		long t = System.currentTimeMillis();
		
		BKsize = (int) Math.sqrt(n);
		data = new int[n]; block = new int[BKsize+2];
		minBlock = new int[BKsize+2]; maxBlock = new int[BKsize+2];
		for (int i=0; i<data.length; i++) data[i] = rand.nextInt();
		
		int[] start = new int[k];
		int[] end = new int[k];
		int[] min = new int[k];
		int[] max = new int[k];
		int[] sum = new int[k];
		
		for (int i=0; i<k; i++) {
			int st = rand.nextInt(n);
			int ed = rand.nextInt(n);
			if (st > ed) {int temp = st; st = ed; ed = temp;}
			start[i] = st; 
			end[i] = ed;
		}
		
		init(data, n);
		minmaxsum(data, start, end, min, max, sum);
		long f = System.currentTimeMillis();

		System.out.println("Elapsed time is "+(f-t)+"ms");
	}
}

