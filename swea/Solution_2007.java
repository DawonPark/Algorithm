package swea;

import java.util.Scanner;

public class Solution_2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc= Integer.parseInt(sc.nextLine());
        for(int t=1; t<=tc; t++) {
            String msg=sc.nextLine();
            for(int i=1; i<msg.length(); i++) {
                String start= msg.substring(0,i);
                String end=msg.substring(i,i+i);
                if(start.equals(end)) {
                    System.out.println("#"+t + " " + i);
                    break;
                }
            }
        }
        sc.close();
    }
}
