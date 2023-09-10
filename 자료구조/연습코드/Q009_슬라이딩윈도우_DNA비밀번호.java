package 연습코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q009_슬라이딩윈도우_DNA비밀번호 {
	 
	static int [] checkArr = new int[4];   //check배열: {A,C,G,T} 순서
	static int [] myArr    = new int[4];   //현재상태 배열 
	static int checkSecret = 0; 
	
	
	public static void main(String[] args) throws IOException {
		/*슬라이딩 윈도우 알고리즘: 2개의 포인터로 범위를 지정한 다음 범위를 유지한채로 이동하며 문제를 해결. (투포인터 알고리즘과 유사) 
		 * 
		 * (문제) DNA 문자열은 A,C,G,T로만 이루어진 문자열, DNA문자열의 부분문자열을 비밀번호로 사용. 비밀번호 종류의 수 구하기
		 * 
		 * 세부조건 : 
		 * - 임의의 DNA문자열
		 * - 부분 문자열의 길이
		 * - 각 문자별 등장해야하는 횟수
		 * - 단, 부문문자열이 등장하는 위치가 다르면 부분문자열의 내용이 같더라도 다른 문자열로 취급. 
		 * 
		 * 첫번째 줄 : DNA 문자열의 길이 |S|, 비밀번호로 사용할 부분 문자열의 길이 |P|가 주어짐. (1<= |P| <= |S| <= 1,000,000)
		 * 두번째 줄 : DNA 문자열
		 * 세번째 줄 : 부분 문자열에 포함돼야할 A,C,G,T의 최소개수 (문자사이 공백있음)
		 * 각각의 수는 |S|보다 작거나 같은 음이 아닌 정수. 총합은 |S|보다 작거나 같다고 보장.
		 * 
		 * (시간복잡도) O(n) ==> P와 S의 길이가 매우 크므로. 
		 * */
		//result
		int cnt = 0;
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int    S = Integer.parseInt(st.nextToken()); //문자열 길이
		int	   P = Integer.parseInt(st.nextToken()); //부분문자열 길이
		
		//문자배열 셋팅
		char[] A = new char[S] ; //문자배열 
		A = bf.readLine().toCharArray();
		
		//check배열 셋팅
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			
			if(checkArr[i]==0) {
				checkSecret++;
			}
		}
		
		//초기 P부분 문자열 처리 
		for(int i=0; i<P; i++) {
			add(A[i]);
		}
		
		if(checkSecret ==4) {
			cnt++;
		}
		
		//    0  1  2  3  4  5  6  7  8  
		//    C  C  T  G  G  A  T  T  G 
		// i:       i
		// j: j 
		for(int i=P; i<S; i++) {
			int j = i-P; //삭제할 인덱스
			
			add(A[i]);
			remove(A[j]);
			
			if(checkSecret ==4) {
				cnt++;
			}
		}
		
		System.out.println("RS :" + cnt);
		bf.close(); 
	}
	
	//새로 들어온 문자를 처리하는 함수
	private static void add(char c) {
		switch (c) {
		case 'A' :
			myArr[0]++;
			
			if(myArr[0] == checkArr[0]) 
				checkSecret++;
			break;
		case 'C' :
			myArr[1]++;
			
			if(myArr[1] == checkArr[1]) 
				checkSecret++; //같은갯수를 충족할때만 카운팅 
			break;
		case 'G' :
			myArr[2]++;
			
			if(myArr[2] == checkArr[2]) 
				checkSecret++;
			break;
		case 'T' :
			myArr[3]++;
			
			if(myArr[3] == checkArr[3]) 
				checkSecret++;
			break;
		}
	}
	
	//제거되는 문자를 처리하는 함수
	private static void remove(char c) {
		switch (c) {
		case 'A' :
			if(myArr[0] == checkArr[0]) 
				checkSecret--;
			
			myArr[0]--;
			break;
		case 'C' :
			if(myArr[1] == checkArr[1]) 
				checkSecret--;
			
			myArr[1]--;
			break;
		case 'G' :
			if(myArr[2] == checkArr[2]) 
				checkSecret--;
			
			myArr[2]--;
			break;
		case 'T' :
			if(myArr[3] == checkArr[3]) 
				checkSecret--;
			
			myArr[3]--;
			break;
		}
	}
}
