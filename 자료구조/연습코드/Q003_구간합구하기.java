package 연습코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q003_구간합구하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*문제: 수 N개가 주어졌을때 i번째 수까지의 합을 구하는 프로그램을 작성하시오
		 *1번째 줄에 수의개수 N (1<= N <= 100,000), 합을 구해야하는 횟수 M (1<= N <= 100,000)
		 *2번째 줄에 N개의 수가 주어진다. 각 수는 1000보다 작거나 같은 자연수다.
		 *3번째 줄부터는 M개의 줄에 합을 구해야하는 구간 i와 j가 주어진다. 
		 * 
		 * 
		 ******************************************
		 * e.g) 인덱스(i)|0	|1	|2	|3	|4	|5	
		 * 		--------------------------
		 * 		 배열 A |15	|13	|10	|7	|3	|12
		 *     합 배열 S |15	|28	|38	|45	|48	|60
		 * 
		 * # 합배열 S를 만드는 공식
		 * S[i] = S[i-1] + A[i]
		 * 
		 * # 구간합을 구하는 공식
		 * S[j]- S[i-1] //i~j까지 구간합 
		 * 
		 * */
		
		int N        ;          	//N개의 개수
		int M        ; 			//합을 구해야하는 횟수
		int[] num    ; 	//수의 개수
		long[] numSum ; //구간합배열 초기화

		int rs = 0; //총구간합 
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		//1번째 입력라인 : N,M
		N   = Integer.valueOf(st.nextToken());
		M   = Integer.valueOf(st.nextToken());
		num = new int[N];
		numSum = new long[N+1];
		
		//2번째 입력라인 : 수
		st = new StringTokenizer(bf.readLine());
		//구간합 배열 생성 (구간은 1부터 시작임)
		for (int i = 1; i <= N; i++) {
			numSum[i] = numSum[i-1] + Integer.valueOf(st.nextToken()); //이전구간합S	 + 현재값A
		}
				
		System.out.println("구간합 최종 : " + Arrays.toString(numSum));
		
		//3번째~ 입력라인 : 구간반복 횟수 
		for (int k = 0; k < M; k++) {
			int i, j; // 구간초기화

			st = new StringTokenizer(bf.readLine());
			i = Integer.valueOf(st.nextToken());
			j = Integer.valueOf(st.nextToken());			
						
			//구간합 구하기
			rs += numSum[j] - numSum[i-1];	
			
			System.out.println("정답 :" + (numSum[j] - numSum[i-1]));
		}
		
		System.out.println("정답(총합) :" + rs  );
				
	}

}
