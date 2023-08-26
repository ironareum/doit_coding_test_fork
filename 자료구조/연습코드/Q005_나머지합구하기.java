package 연습코드;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q005_나머지합구하기 {

	public static void main(String[] args) throws IOException {
		/* 문제 : N개의수 A₁,A₂...Aｎ이 주어졌을때 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수 구하기 
		 *      즉, Aｉ+..+Aｊ(i<=j)의 합이 M으로 나누어떨어지는 (i,j)쌍의 개수를 구하기
		 * 1번째줄 : N, 나눌수 M (1<=N<= 10^6, 2<=M<=10^3)
		 * 2번째줄 : N개의 수 A₁,A₂...Aｎ이 주어짐(0<=Aｉ<=10^9)
		 * */
		
//		int N ; //N개의 수
//		int M ; //나눌수
//		long[] S ; //구간합배열
//		long[] C ; //나머지값 배열
//		int reminder = 0; //나머지값 
//		
//		int rs = 0; //구간개수 
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
//		
//		//초기화
//		N = Integer.valueOf(st.nextToken()); 
//		M = Integer.valueOf(st.nextToken());
//		S = new long[(N+1)]; //구간합배열 초기화 
//		C = new long[(N+1)]; //나머지배열 초기화
//		
//		//구간합 구하기 
//		st = new StringTokenizer(bf.readLine());
//		
//		for (int i = 1; i <= N; i++) {
//			S[i] = S[i-1] + Integer.valueOf(st.nextToken());
//			
//		}
//		
//		//합배열을 M으로 나눈 나머지값
//		for (int i = 1; i < S.length; i++) {
//			reminder = (int) (S[i] % M);
//			
//			//구간합이 0으로 나누어떨어질때(=원본배열 0부터 i까지의 구간합이 이미 M으로 나누어떨어진 상태)
//			if(reminder == 0) {
//				rs++; //정답 1증가
//			}				
//			
//			//나머지값이 같은 원소의 값이 같은 2개의 원소를 뽑는 경우의수 
//			C[reminder] = C[reminder]+1;
//
//		}
//		
//		//구간개수 구하기 (= 나머지인 인덱스 개수에서 2가지를 뽑는 경우의 수  
//		for (int i = 0; i < C.length; i++) {
//			rs += C[i]*(C[i]-1)/2;
//		}
//		
//		System.out.println("정답 : " + rs );
		
		
		//Scanner version ======================
		int N ; //N개의 수
		int M ; //나눌수
		long[] S ; //구간합배열
		long[] C ; //나머지값 배열

		int rs = 0; //구간개수
		
		Scanner sc = new Scanner(System.in);
		
		//초기화
		N = sc.nextInt();
		M = sc.nextInt();
		S = new long[(N)]; //구간합배열 초기화 
		C = new long[(M)]; //나머지배열 초기화
		
		//구간합 구하기 
		S[0] = sc.nextInt();		
		for (int i = 1; i <N; i++) {
			S[i] = S[i-1] + sc.nextInt();;	
		}
		
		//합배열을 M으로 나눈 나머지값
		for (int i = 0; i < S.length; i++) {
			int reminder = (int) (S[i] % M); //나머지값 
			 
			//구간합이 0으로 나누어떨어질때(=원본배열 0부터 i까지의 구간합이 이미 M으로 나누어떨어진 상태)
			if(reminder == 0) {
				rs++; //정답 1증가
			}				
			
			//나머지값이 같은 원소의 값이 같은 2개의 원소를 뽑는 경우의수 
			C[reminder]++;
		}
		
		//구간개수 구하기   
		for (int i = 0; i < M; i++) {
			//나머지인 인덱스 개수에서 2가지를 뽑는 경우의 수
			if(C[i] > 1) {
				rs += C[i]*(C[i]-1)/2;				
			}
		}
		
		System.out.println("정답 : " + rs );
		
	}

}
