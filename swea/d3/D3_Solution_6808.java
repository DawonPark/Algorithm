package swea.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 *  1~18까지의 카드가 있고 게임을 하는데 중복된 카드 없이 나누고 높은 카드를 낸 사람이  두 사람의 낸 카드의 합만큼 총점을 얻는다.
 *  
 *  -> 반으로 나눌 때 한 쪽의 입력은 배열로 받고 한 쪽은 어떻게 줘야할지 생각하다 list를 사용해서 나온 숫자를 제거해주기로 했음
 *    list.remove(Object O) 를 사용해서 제거를 해주고 모든 경우를 생각함 -> 순열
 *    -> 순열에서 result배열에 뽑은 숫자들을 넣어주고 순열이 만들어졌을 때 총점을 계산하는 방식으로 문제를 품.
 *  
 *  순열에서 flag 비트 마스킹으로 하는 방법과  isSelected 배열을 활용하는 방법 두가지 사용해봄
 */
public class D3_Solution_6808 {
	static int firstCard[];
	static int secondCard[];
	static List<Integer> list;
	static int N = 9;
	static int win, lose;
//	static boolean[] isSelected;
	static void permutation(int cnt , int flag) {
		if (cnt==N) {
			int firstScore=0;  // 첫번째 사람 총점
			int secondScore =0; // 두번째 사람 총점
			for(int i=0; i<N; i++) {
				if(firstCard[i]>secondCard[i]) {
					firstScore+=firstCard[i] +secondCard[i];
				}else {
					secondScore+=secondCard[i] + firstCard[i];
				}
			}
			if(firstScore>secondScore) {
				win++;
			}
			if(firstScore<secondScore) {
				lose++;
			}
			
		}
		for(int i=0; i<N; i++) {
			if((flag&1<<i)!=0) continue;
			secondCard[cnt] = list.get(i);
			permutation(cnt+1,flag | 1<<i);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			list = new ArrayList<Integer>();
			for(int i=1; i<=18; i++) {
				list.add(i);
			}
			firstCard = new int[N];
			secondCard = new int[N];
//			isSelected= new boolean[N];
			win =0; 
			lose =0;
			for(int i=0; i<N; i++) {
				int temp = sc.nextInt();
				firstCard[i] = temp; 
				list.remove(Integer.valueOf(temp));
			}	
			permutation(0,0);
			System.out.println("#" + t +" "+ win+" "+lose);
		
		}
		
		
		sc.close();
		
		
	}
}
