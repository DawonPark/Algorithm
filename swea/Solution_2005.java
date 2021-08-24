package swea;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc= sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int num = sc.nextInt();
            int[] arr=new int[num];
            int index=1;
            arr[0]=1;
            System.out.println("#"+t);
            for(int i=0; i<num; i++) {
                arr[i]=1;
                for(int k : arr) {
                    if(k!=0) {
                        System.out.printf(k+" ");
                    }
                }
                int[] temp=Arrays.copyOf(arr, arr.length);
                if(i>0) { for(int j=1; j<=index; j++) {
                    arr[j]=temp[j]+temp[j-1];                   
                }
                index++;
                }
                System.out.println();
             
            }
        }
    }
}