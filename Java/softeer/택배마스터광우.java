package softeer;

import java.util.*;
import java.io.*;

public class 택배마스터광우
{
    static boolean[] isVisited;
    static int[] rails, res;
    static int N,M,K;
    static int ans;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        K = Integer.parseInt(data[2]);
        rails = new int[N];
        data= br.readLine().split(" ");
        for(int i=0; i<N; i++){
            rails[i]= Integer.parseInt(data[i]);
        }
        isVisited = new boolean[N];
        res = new int[N];
        ans = Integer.MAX_VALUE;
        go(0);
        System.out.println(ans);
    }
    public static void go(int cnt){
        if(cnt == N){
            int total = 0;
            int idx =0;
            for(int i=0; i<K; i++){
                int sum = 0;
                while(true){
                    sum+=rails[res[idx]];
                    if(sum > M){
                        sum-=rails[res[idx]];
                        break;
                    }else{
                        idx++;
                    }
                    if(idx == N){
                        idx =0;
                    }
                }
                total+=sum;
            }
            // System.out.println(total);
            ans = Math.min(ans,total);
            return;
        }
        for(int i=0; i<N; i++){
            if(isVisited[i]) continue;
            res[cnt] = i;
            isVisited[i]= true;
            go(cnt+1);
            isVisited[i] = false;
        }
    }

}