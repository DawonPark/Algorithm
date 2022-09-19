package javaalgo.swea.d1d2;


import java.util.Scanner;

class Solution_1288 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int n=1;
			int temp=0;
			boolean result =false;
			int num = sc.nextInt();
			int[] arr = new int[10];
			temp=num;
			while (true) {
				while (num >=10) {
					arr[num % 10]++;
					num /= 10;
				}
				arr[num]++;
				int cnt=0;
				for(int k=0; k<arr.length; k++) {
					if(arr[k]>0) {
						cnt++;
					}
					if(cnt ==10)
						result=true;
				}
				if(result == true)
					break;
				else {
				n++;
				num=n*temp;
				}
			}
			System.out.println("#"+ (i+1)+ " "+ n*temp);
	
		}
		sc.close();
	}
}
