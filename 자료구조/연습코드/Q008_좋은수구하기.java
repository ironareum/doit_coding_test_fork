package 연습코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q008_좋은수구하기 {
	public static void main(String[] args) throws IOException {
		/* (문제)주어진 N개의 수에서 다른 두수의 합으로 표현되는 "좋은수(=K)" 찾기. 단, 자기자신을 "좋은수(=K)" 만들기에 포함시키면 안됨
		 * 첫번째 줄 : 수의 개수 N (1<= N <= 2,000)
		 * 두번째 줄 : N개의 수의 값 Aｉ (|Aｉ| <= 1,000,000,000, Aｉ는 정수)
		 * 
		 * (시간복잡도) 최소 O(nlogn)이여야 함. ===> 정렬, 투포인터 알고리즘 사용! 
		 * 
		 * (풀이방식)
		 * 1. N개의 수 배열에 저장
		 * 2. 배열 오름차순 정렬
		 * 3. 투포인터 셋팅 (양끝)
		 * 4. 투포인터 두수의 합이 배열 인덱스 순차적으로 하나씩 증가시킨 값 "좋은수(=K)"가 되는지 확인  
		 * */
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N   = Integer.parseInt(bf.readLine());
		int[] A = new int[N];		
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		//배열 값 저장
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//배열 정렬
		Arrays.sort(A); //오름차순

		/*---------------------------------------------------------------*/
		//FYI) 내림차순시 int 배열을 Integer로 변경 후 정렬해주어야 함
		/*---------------------------------------------------------------*/
//		Integer[] IA = Arrays.stream(A).boxed().toArray(Integer[]::new);
//		Arrays.sort(IA, Collections.reverseOrder());
		
		//K를 0부터 N까지 반복 
		for(int k=0; k<N; k++) {
			
			int i = 0;
			int j = N-1; 
			
			while(i < j) {
				if(A[i]+A[j]== A[k]) {
					if((i!=k) && j!=k) {
						cnt++;
						break;
					} else if(i == k) {
						i++;
					} else if(j == k) {
						j--;
					}
				} else if(A[i]+A[j] > A[k]) {
					j--;
				} else {
					i++;
				}
			} //end while
		}//end for
		
		System.out.println("RS : "+ cnt );
		bf.close();
	}
}
