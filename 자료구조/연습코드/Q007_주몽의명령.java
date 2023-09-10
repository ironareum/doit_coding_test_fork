package 연습코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q007_주몽의명령 {
	public static void main(String[] args) throws IOException {
		/*(문제) : 고유번호 2가지 수의 합이 M (1<= M <= 10,000,000)이 되는 갯수를 구하라 
		 * 첫번째줄 : N 재료의 개수 (1<= N <= 15,000)
		 * 두번째줄 : M 구할수의 합
		 * 세번째중 : 재료들 (숫자사이 공백 있음)  
		 * 
		 * -------------------------------------------------------------
		 * 시간복잡도란, 입력된 N의 크기에 따라 실행되는 조작의 수. 
		 * -------------------------------------------------------------
		 * (시간복잡도) : 두 재료의 합, 즉 크기를 비교하므로 계산에 앞서 우선 값을 정렬필요.
		 *             최대수가 15,000 이므로 O(nlogn) 사용해도 무방함 
		 *             ==> 일반적인 정렬알고리즘의 시간복잡도는 O(nlogn) 임!! 
		 *             
		 * (풀이방법)
		 * 1. 입력받은 N개의 재료를 배열에 넣어 오름차순 정렬한다
		 * 2. 투포인터 사용 (i,j를 양끝에 셋팅) 
		 * 
		 * 
		 * (투포인터 이동원칙)
		 * A[i] + A[j] >  M : j--;
		 * A[i] + A[j] == M : i++; J--; count++;
		 * A[i] + A[j] <  M : i++;
		 * */
		
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int[] A = new int[N];
//		
//		//배열 값 저장
//		for(int i=0; i<N; i++) {
//			A[i] = sc.nextInt();
//		}
		
		/*------------------------------------*/
		//InputStream & StringTokenizer 사용 (s)
		/*------------------------------------*/
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		//배열 값 저장
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		/*------------------------------------*/
		//InputStream & StringTokenizer 사용 (e)
		/*------------------------------------*/
		
		//투포인터 인덱스
		int i = 0;
		int j = N-1;
		int cnt = 0;
		
		//배열 정렬
		Arrays.sort(A); //오름차순		
		
		/* e.g) M= 9, N = 6
		 * 
		 * i :               i
		 * j :            j 
		 *       1  2  3  4  5  7
		 * sum : 8  9  8  9
		 *  
		 */
	
		//재료의합 구하기
		while(i<j) {
			if(A[i]+A[j] > M) {
				j--;
			}
			else if(A[i]+A[j] == M) {
				i++;
				j--;
				cnt ++;
			}
			else if(A[i]+A[j] < M) {
				i++;				
			}		
		}
		
		System.out.println("RS : "+ cnt);
		bf.close();
	}
}
