package p01_200803;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("D:/git/codmon-dev/01_algorithm/src/sample_input.txt"));

		int a = 0;
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			a++;
			if (a == 1) continue;
			System.out.println("Case #"+(a-1));
			/*
				"=" 으로 split
				    var1 = (=)[1]; 
				"x" 으로 split
				    var2 = (x)[1];
				(var1 + var2) / (x)[0]
			 */
			String[] strArr = str.split("=");	// [ax - b][y]
			String[] lStrArr = strArr[0].split("x");	// [a][-b]
			
			String rStr = strArr[1].trim();	// 우변 값
			String lVar = lStrArr[1].replace(" ", "");
			String nx =  lStrArr[0].trim();
			
			int rInt = Integer.parseInt(rStr);
			int lInt = Integer.parseInt(lVar);
			int nInt = Integer.parseInt(nx);
			
			printFraction(reduceFraction((rInt - lInt), nInt));
		}
	}
	
	// 분수 출력 함수
	// (분자 분모가 든 배열을 입력받아 출력)
	public static void printFraction(int[] bunsu) {
	  System.out.format("%d / %d%n", bunsu[0], bunsu[1]);
	}
	
	// 분수 약분 함수 (Reduce a Fraction)
	// 분자 분모를 입력받아, 약분 후, 분자 분모가 든 배열을 반환
	public static int[] reduceFraction(int bunja, int bunmo) {
	  int[] frac = new int[2];
	  frac[0] = bunja;
	  frac[1] = bunmo;
	
	  if (frac[1] == 0) { // 분모가 0일 경우에 에러 반환
	    frac[0] = 0;
	    frac[1] = 0;
	    return frac;
	  }
	
	  int gcd_result = gcd(frac[0], frac[1]);
	
	  frac[0] = frac[0] / gcd_result;
	  frac[1] = frac[1] / gcd_result;
	
	  return frac;
	}
	
	// 최대 공약수 계산 메서드
	// (Euclidean Algorithm; Euclid's Algorithm)
	public static int gcd(int a, int b) {
	
	  while (b != 0) {
	    int temp = a % b;
	    a = b;
	    b = temp;
	  }
	
	  return Math.abs(a);
	}
}
