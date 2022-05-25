package java. swea.d4;

import java.util.Scanner;
/*
 * 사칙연산 유효성 검사 이진트리로 입력이 들어와서 이진트리를 만들었음 트리가 두 갈래로 나눠져서  한쪽이 유효하지 못해도
 * 다른 쪽은 유효하게 가서 여러번 프린트문이 찍혀 static으로  check를 선언하게 됨.
 */

public class D4_Solution_1233 {
	static boolean check;
	static class BinaryTree {
		private char[] nodes;
		private final int SIZE;
		private int lastIndex;
		public BinaryTree(int size) {
			this.SIZE= size;
			nodes = new char[size+1];
		}
		public void add(char c) {
			if(lastIndex==SIZE)return;
			
			nodes[++lastIndex] = c;
		}
		
		public void dfs(boolean check) {
			dfs(1);
		}
		public void dfs(int current) {
			if(check==true) {
				return;
			}
			if('0'<=nodes[current] && nodes[current]<='9') {
				if(current*2<=lastIndex) { // 숫자인데 자식이 있을 
					check= true;
					System.out.println("0");
					return;
				}
			}
			if(nodes[current]=='*' || nodes[current] == '-'|| nodes[current] == '+'|| nodes[current] == '/') {
				if(current*2 <=lastIndex) {
					dfs(current*2);
				}
				if(current*2+1 <=lastIndex) {
					dfs(current*2+1);
				}	
			} 
			if(current == lastIndex) {
				System.out.println("1");
				return;
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			BinaryTree bt = new BinaryTree(200);
			int num = Integer.parseInt(sc.nextLine());
			for(int i=0; i <num; i++) {
				String[] s = sc.nextLine().split(" ");
				bt.add(s[1].charAt(0));
			}
			System.out.print("#" + t +" ");
			check=false;
			bt.dfs(check);
		}
		sc.close();
	}
}
