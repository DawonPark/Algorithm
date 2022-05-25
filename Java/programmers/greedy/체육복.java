package java. java.programmers.greedy;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;
 
        for (int i : lost) 
            people[i-1]--;
        for (int i : reserve) 
            people[i-1]++;
 
        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) { // 바로 왼쪽인지와 체육복 여벌이 있는지 체크
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else answer--;
            }
        }
        return answer;
    }
}