package javaalgo.softeer;
import java.util.*;
import java.io.*;


public class _8단변속기
{
    public static void main(String args[])
    {
        String answer = "mixed";
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        if(start != 1 && start != 8) {
            System.out.println(answer);
            return;
        }

        if(start == 1){
            for(int i=1; i<8; i++){
                int n = sc.nextInt();
                if(n-1 !=start) {
                    System.out.println(answer);
                    return;
                }
                start = n;
            }
            System.out.println("ascending");
        }else if(start ==8 ){
                        for(int i=1; i<8; i++){
                int n = sc.nextInt();
                if(n+1 !=start) {
                    System.out.println(answer);
                    return;
                }
                start = n;
            }
            System.out.println("descending");
        }
        
    }
}