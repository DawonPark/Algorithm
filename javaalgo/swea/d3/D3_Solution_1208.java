package javaalgo.swea.d3;


import java.util.Scanner;


public class D3_Solution_1208 {
	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
         
	        for(int t =1; t<=10; t++) {
	            int[] height = new int[100];
	            int dump = sc.nextInt();
	            int result=0;
	            int minIndex = 0, maxIndex = 0;
	            int max = Integer.MIN_VALUE;
	            int min = Integer.MAX_VALUE;
	            for(int i=0; i<100; i++) {
	                height[i] = sc.nextInt();
	            }
	            for(int i=0; i<=dump; i++) {
	                for(int j=0; j<100; j++) {
	                    if(height[j]<=min) {
	                        min= height[j];
	                        minIndex= j;
	                    }
	                    else if(height[j]>=max) {
	                        max= height[j];
	                        maxIndex=j;
	                    }
	                }
	                max =height[maxIndex]--;
	                min =height[minIndex]++;
	                result =max -min;
	                if(result==0||result==1)
	                    break;
	            }
	             
	            System.out.println("#"+t + " " + result);
	             
	        }
	        sc.close();
	    }
	}

