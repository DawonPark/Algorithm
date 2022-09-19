package javaalgo.programmers.해시;

import java.util.*;
import java.util.Map.Entry;

class Song {
    String genre;
    int plays;
    int idx;
    Song(String genre,int plays, int idx){
        this.genre = genre;
        this.plays = plays;
        this.idx = idx;
    }
}
public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            if(hm.get(genres[i])!=null) hm.put(genres[i], hm.get(genres[i]) + plays[i]);
            else hm.put(genres[i], plays[i]);
        }
        
        List<Entry<String,Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list,(o1,o2) -> o2.getValue()-o1.getValue());
        
        Song[] songs = new Song[genres.length];
        
        for(int i=0; i<genres.length; i++){
            songs[i] = new Song(genres[i], plays[i] , i);
        }
        
        Arrays.sort(songs, (o1,o2) ->{
            if(o1.genre.equals(o2.genre)){
                return o2.plays - o1.plays;
            }else return o1.genre.compareTo(o2.genre);
        });
        
        List<Integer> result = new ArrayList<>();
     
        for(int i=0; i<list.size(); i++){
            String genre = list.get(i).getKey();
            int cnt =0;
            for(int j = 0; j<songs.length; j++){
                if(genre.equals(songs[j].genre)){
                    result.add(songs[j].idx);
                    cnt++;
                }
                if(cnt == 2) {
                    break;
                }
            }
        }

        
        int[] answer = new int[result.size()];
        for(int i =0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}