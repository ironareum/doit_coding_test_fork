package 연습코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q004_구간합구하기2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/* 문제 : N x N개의 수가 N x N 크기의 표에 채워져있다. 좌표 (x1,y1) 부터 (x2,y2)까지의 합 구하기 
		 * 
		 * 1번째 줄 : 표의 크기 N과 합을 구해야 하는 횟수 M (1<=N<=1024, 1<= M <=100,000)
		 * 2번째 줄 : N개의 줄에 표에 채워져있는 수가 1행부터 차례대로 주어진다. 
		 * 
		 * 2차원 구간합 : D[x][y] = 원본배열 (0,0)부터 (x,y)까지의 사각형 안의 수의 합
		 * 2차원 구간합 배열생성 공식 : D[x][y] = D[x][y-1] + D[x-1][y] + A[x][j] - D[x-1][y-1]
		 * 2차원 구간합 공식 : sum = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
		 * 
		 * */
		int  N ; 
		long M ;
		int[][] D ;
		int rs = 0;
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.valueOf(st.nextToken()); //표 크기초기화
		M = Integer.valueOf(st.nextToken());
		D = new int[N+1][N+1]; //구간합배열 초기화 
		
		//구간합 구하기
		for (int x = 1; x <= N; x++) {
			st = new StringTokenizer(bf.readLine());
			for (int y = 1; y < D.length; y++) {
				//구간합배열 값생성
				//D[x][y] = D[x][y-1] + D[x-1][y] + A[x][j] - D[x-1][y-1]
				D[x][y] = D[x][y-1] + D[x-1][y] - D[x-1][y-1] + Integer.valueOf(st.nextToken());				
			}
			System.out.println("구간합 : "+ Arrays.toString(D[x]));
		}
		
		//답출력
		for (int k = 1; k <= M; k++) {
			st = new StringTokenizer(bf.readLine());

			int x1 = Integer.valueOf(st.nextToken());
			int y1 = Integer.valueOf(st.nextToken());
			int x2 = Integer.valueOf(st.nextToken());
			int y2 = Integer.valueOf(st.nextToken());
			
			//sum = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
			
			System.out.println("정답 : "+ ( D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]));
		}
	}

}
