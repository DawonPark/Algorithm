function solution(genres, plays) {
    let answer = [];
    let map = new Map();
    genres.forEach((item, index) =>{
        if(map.get(item)){
            map.set(item, map.get(item) + plays[index]); 
        }else{
            map.set(item, plays[index]);
        }
    })
    let size = map.size;
    for(let i = 0; i < size; i++){
        let max = 0;
        let genre = "";
        for(let [key, value] of map){
            if(value > max){
                max = value;
                genre = key;
            }
        }
        map.delete(genre);
        let arr = [];
        for(let i =0; i< genres.length; i++){
            if(genres[i] === genre){
                arr.push([i,plays[i]]);
            }
        }
        arr.sort((a,b)=> {
            if(b[1] === a[1]){
                return a[0] - b[0];
            }else{
                return b[1] - a[1];
            }
        })
        for(let i =0; i < arr.length; i++){
            if(i >= 2) break;
            answer.push(arr[i][0]);
        }
    }

    return answer;
}