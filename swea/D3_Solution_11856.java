package swea;


import java.util.Scanner;


public class D3_Solution_11856 {
	/*
	 *  길이 4의 알파벳 대문자로 이루어진 문자열 S가 주어졌을 때, S에 정확히 두 개의 서로 다른 문자가 등장하고, 각 문자가 정확히 두 번 등장하는 지 판별하라
	 *  -> set을 사용해도 됐지만 4문자만 들어오기 때문에 반복문으로 해결하기로 함.
	 *
	 */
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int tc= Integer.parseInt(sc.nextLine());
		for(int t=1; t<=tc; t++) {
			int first =1;    
			int second  =1;   // first second는 글자 수 세기용 글자가 들어오면 1이기 때문에 1로 초기화
			char [] arr = new char[4];
			String msg = sc.nextLine();
			for(int i=0; i<4; i++) {
				arr[i] = msg.charAt(i);
			}
			char ch = arr[0]; // 첫글자와 비교
			char ch2 = ' '; // 두번째 글자는 어디서 들어올지 모르기 때문에 들어오지 않을 공백으로 초기화 
			for(int i=1; i<4; i++) {
				if(ch==arr[i] ) {
					first++;
				}if(ch2 == arr[i]) { // 
					second++;
				}if(ch!=arr[i] && ch2== ' ') {  // ch2 세팅은 처음 나올 때만 따지기 떄문에 ch2 ' ' 일 때만 초기화
					ch2 =arr[i];
				}
			}
			if(first==2 && second==2) System.out.println("#" +t +" Yes");
			else System.out.println("#" +t +" No");
			
		}
		sc.close();
	}
}
