package 연습코드;

import java.util.Scanner;

public class Q006_투포인터_연속된자연수의합구하기 {

	public static void main(String[] args) {
		/* (문제)[시간복잡도 최적화문제/투포인터] 
		 * 어떠한 자연수 N은 몇개의 연속된 자연수의 합으로 나타낼수 있다. 
		 * 어떤 자연수 N (1<=N<=10,000,000)을 몇개의 연속된 자연수의 합으로 나타내는 가짓수를 구하라 
		 * 
		 * 
		 *(풀이방식) 
		 * 1) 연속된 자연수의 최대값은 N이다. (1~N까지)  => 카운터 개수 : 1로 초기화 
		 * 2) 시작인덱스, 종료인덱스를 투포인터로 지정한후 문제에 접근
		 * 
		 *(투포인터 이동 원칙)
		 * sum <  N : sum = sum + end_idx; end_idx++;
		 * sum == N : end_idx++; sum = sum + end_idx; count++;
		 * sum >  N : sum = sum - start_idx; start_idx++;    
		 * */
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 1; //N수 일단 카운트함.
		int sum = 1; //시작 자연수(=1)로 셋팅
		
		int stt_idx = 1;
		int end_idx = 1;
		//                        s
		//e.g) 1  2  3  4   5  6  7  8  9  10 11 12 13 14 15
		//                           e 
		//sum :   3  6  10  15 21 22 21
		//        20 18 15        18 13 
		//cnt :1        2
		while(end_idx != N) {
			if(sum == N) {
				cnt ++;
				end_idx++;
				sum += end_idx;
			}
			
			if(sum < N) {
				end_idx++;
				sum+= end_idx;
			}
			
			if(sum > N) {
				sum-= stt_idx;
				stt_idx++;
			}
		}
		
		System.out.println("RS : "+ cnt);
	}

}
