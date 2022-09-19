package javaalgo.swea.d3;

public class D3_Solution_3131 {
	public static void main(String[] args) {
		for(int i = 2; i<=1000000; i++) {
			boolean check = false;
			for(int j = 2; j<=Math.sqrt(i); j++) {
				if(i%j ==0) {
					check=true;
					break;
				}
			}
			if(!check) System.out.print(i+ " ");
		}
	}
}
