package 연습코드;

import java.util.Iterator;
import java.util.Scanner;

public class Q001_숫자의합구하기 {

	/*문제:N개의숫자가공백없이써있다.이숫자를모두합해출력하라.
	 * 1번째줄에숫자의개수(1<=N<=100)
	 * 2번째줄에숫자N개가공백없이있음
	 * 
	 * */
	public static void main(String[] args) {
		
//----------------------------------------------------------		
//		내코드 
//----------------------------------------------------------		
//		System.out.println("입력값 : " +args);
//		int rowNum   = Integer.parseInt(args[0]);
//		String sNum[] = args[1].split("") ;
//		int sum = 0;
//		
//		for (int i = 0; i < rowNum; i++) {
//			sum += Integer.parseInt(sNum[i]) ;
//		}
//		
//		System.out.println("정답 : " + sum);
//----------------------------------------------------------		
		
		/* *************************
		 * 두잇 가이드
		 * -------------------------
		 * char 문자열로 변환하는 방법.
		 * e.g) char[5] ===> 문자'5'는 아스키코드 53. 숫자와 아스키코드문자의 차이는 48. 
		 *************************** */
		Scanner sc = new Scanner(System.in);
		System.out.println("inData : " + sc);
		
		int N    = sc.nextInt();
		
		//입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기 
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += cNum[i]-'0'; //cNum을 정수형으로 변환하면서 sum에 누적하기 
		}
		System.out.println("정답 : "+sum);

		
		/* *****************
		 * 형변환 함수 사용하기 
		 ***************** */
		//String -> 숫자형 (int, double, float, long, short)
		String num = "1234"; //String형 변수
		
		int    i1 = Integer.parseInt(num);
		int    i2 = Integer.valueOf(num);
		
		double d1 = Double.parseDouble(num);
		double d2 = Double.valueOf(num);
		
		float  f1 = Float.parseFloat(num);
		float  f2 = Float.valueOf(num);
		
		long   l1 = Long.parseLong(num);
		long   l2 = Long.valueOf(num);
		
		short  s1 = Short.parseShort(num);
		short  s2 = Short.valueOf(num);
		
		//숫자형 (int, double, float, long, short) -> String
		
		int i = 1234;
		String si1 = String.valueOf(i);
		String si2 = Integer.toString(i);
		
		
		
		
		
	}

}
