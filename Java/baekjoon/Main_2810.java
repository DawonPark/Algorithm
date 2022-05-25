package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 2810 - 컵홀더
 * 
 * 처음에는 무조건 컵을 놓을 수 있음  S가 들어오면 앞쪽에도 놓을 수 있음. L이 들어온다면 LL이 와야 놓을 수 있음
 * -> 처음에 놓으면 뒤에 놓는것만 생각하면 됨.
 */
public class Main_2810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		int count = 1;
		int check = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'S') {
				count++;
			} else if (s.charAt(i) == 'L') {
				check++;
				if (check == 2) {
					count++;
					check = 0;
				}

			}
		}
		if (count > N)
			System.out.println(N);
		else
			System.out.println(count);
		sc.close();
	}
}
