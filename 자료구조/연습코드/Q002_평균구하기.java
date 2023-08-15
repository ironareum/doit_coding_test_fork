package 연습코드;

import java.util.Scanner;

public class Q002_평균구하기 {

	public static void main(String[] args) {
		
		/*문제 :새로운 평균 구하기 
		 * 첫번째줄에 시험을 본 과목의 개수 N (N <= 1000)
		 * 두번째줄에 세준이의 현재성적 S (0<S<=100)
		 * 
		 * 구하는 식 : 기존점수/기존최대점수*100 의 평균 ===> (기존성적A+기존성적B+기존성적C)/기존최대점수*100/과목수  
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //과목수
		int[] A = new int[N];
		
		//N만큼 입력값 받기
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();     //기존 점수			
		}
		
		//(주의)max와 sum을 int형으로 하면 계산할때 답이 달라질수 있음!!!!! 
		float max = A[0]; //최대값
		float sum = 0;
		float avg = 0; //평균
		
		for (int i = 0; i < A.length; i++) {			
			//최대값 구하기
			if(A[i] > max) {
				max = A[i];
			}
			
			//합계
			sum += A[i];
		}
		
		//새평균 구하기
		avg = (float) (sum*100.0/max/N);
		System.out.println("sum/max         : "+ sum/max         );  //해당계산식 int로 되어있을때 오류답 나옴..! 
		System.out.println("sum/max*100.0   : "+ sum/max*100.0   );
		System.out.println("sum/max*100.0/N : "+ sum/max*100.0/N );
		System.out.println("--------------------------------------" );		
		System.out.println("sum*100.0       : "+ sum*100.0       );
		System.out.println("sum*100.0/max   : "+ sum*100.0/max   );
		System.out.println("sum*100.0/max/N : "+ sum*100.0/max/N );
		System.out.println("정답 : "+ avg);
	}

}
