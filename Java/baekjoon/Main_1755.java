package java. java.baekjoon;

import java.util.Arrays; // sort를 사용하기 위해서 import
import java.util.Scanner; // 스캐너 import

public class Main_1755 {
	public static void main(String[] args) { // 메인 메서드
		Scanner sc = new Scanner(System.in); // 스캐너 생성
		int M = sc.nextInt();
		int N = sc.nextInt(); // M, N 입력 받음
		Num[] arr = new Num[N - M + 1]; // M이상 N 이하이므로 N-M;
		String[] numE = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" }; // 영어로
																															// 숫자를
																															// 만들기위한
																															// 배열
		int idx = 0; // 배열의 인덱스를 위해 선언
		for (int i = M; i <= N; i++) { // M이상 N이하이므로 M부터 N까지
			String temp = Integer.toString(i); // 편리를 위해 charAt을 쓰기위해 int -> String으로 변환
			String msg = ""; // 넣어둘 메세지를 위한 변수 초기화
			for (int j = 0; j < temp.length(); j++) { // temp의 길이만큼 반복
				msg += numE[temp.charAt(j) - '0'] + " "; // 숫자로 영어를 만듬
			}
			arr[idx++] = new Num(i, msg); // arr배열에 num을 넣어줌
		}
		Arrays.sort(arr, (a, b) -> a.number.compareTo(b.number)); // 오름차순 람다식 sort 메서드 사용
		int cnt = 0; // 10개씩 찍기위해
		for (Num data : arr) {// 출력을 위한 for-each
			System.out.print(data.num + " "); // 출력
			cnt++; // 찍은 수
			if (cnt % 10 == 0)
				System.out.println(); // 10마다 줄넘김
		}
		sc.close(); // 스캐너 close
	}

	static class Num { // 숫자의 영문자를 담기위한 클래스
		int num; // 숫자
		String number; // 영어로 숫자

		public Num(int num, String number) { // 생성자
			this.num = num; // num은 출력을위해서 담아두었음
			this.number = number; // number는 sort를 위해서
		}
	}
}
