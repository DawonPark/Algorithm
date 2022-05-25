package java. java.baekjoon;

import java.util.Scanner;

/*
 * 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 
 * 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
      상근최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 
   5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
      상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
      
	-> 여러 조합들을 생각해보다가 5랑 나눠지면 5kg봉지에만 담아야 최소임 -> 9의 경우 3으로만 나눠야 가능하다 3씩 계속 빼주고 5의 배수가 나오면 5로 나눈 카운트를
	더하는 방식을 사용 -> 그 당시의 최선인 그리디 접근
	-> N이 음수가되면 조합할 수 없는 것이다.
 */
public class Main_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		while (N > 0) {
			if (N % 5 == 0) {
				count += N / 5;
				N = 0;
			} else {
				N -= 3;
				count++;
			}
		}
		if (N == 0)
			System.out.println(count);
		else
			System.out.println(-1);
		sc.close();
	}

}
