package javaalgo.swea.d3;

import java.util.Scanner;

/*
 * N-queen
 * 
 * -> 유명한 문제, 한 번 풀어봤던 것 같은데 다시 보니까 어렵고 새로웠다.
 * 	  이차원 배열을 생각하면 복잡할 것 같아서 간단하게 보기 위해 가로를 기준으로 보면 가로에는 다른 것이 없어야한다.
 * -> 한쪽처리는 자연스럽게 배열의 index가 넘어가면서 처리를 해서 체크를 안해도 되고 다른 한쪽은 배열안에 저장을해서
 *    같으면 false 처리 , 틀리면 대각선 체크로 넘어감. -> 대각선 규칙을 찾다보니 (행-행) == (열-열) 같으면 대각선에 있어야한다
 *    -> 코드는 board[i] = x 에서 i는 열로 받고 x는 행으로 받아서 행만 체크할 수 있도록 함.
 */
public class D3_Solution_2806 {
	static int N;
	static int result;
	static int board[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		for(int t =1; t<=tc; t++) {
			 N= sc.nextInt();
			 board = new int[N];
			result =0;
			set(0);
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}

	static void set(int y) {
		if(y == N) {
			result++;
			return;
		}
		for(int x=0; x<N; x++) { 
			board[y] = x;  //y 열 x는 행
			if(go(y)) {
				set(y+1);
			}
		}
	}
	
	static boolean go(int y) {
		for(int i=0; i<y; i++ ) {
			if(board[y]==board[i]) {
				return false; // 가로체크
			}
			if(Math.abs(y-i) == Math.abs(board[y]-board[i])) { // 대각선 체크
				return false;
			}
		}
		return true;
	}
}
