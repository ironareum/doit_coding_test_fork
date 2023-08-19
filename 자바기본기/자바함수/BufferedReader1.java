package 자바함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BufferedReader1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String s = br.readLine();
		int i = Integer.parseInt(br.readLine());
		
		System.out.println("readLine (String): "+ s);
		System.out.println("readLine (int): "+ i);
		
		// StringTokenizer 
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		System.out.println("StringTokenizer : "+ st.nextToken()); //nextToken 공백단위로 자르기 
		
		String S = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println("StringTokenizer : "+ S); 
		System.out.println("StringTokenizer : "+ N); 
		System.out.println("StringTokenizer : "+ M); 

		// String.split() 함수
		String arr[] = s.split(" ");
		System.out.println("StringTokenizer arr: "+ arr.toString());
		
	}

}
