function solution(user_id, banned_id) {
    let answer = 0;
    let visited=[];
    let set=new Set();
    
    const check=(i,j)=>{
        for(let idx=0;idx<i.length;idx++){
            if(i[idx]!=='*' && i[idx]!==j[idx]) return false;
        }
        return true;
    }
   
    const combination=(start,count,str)=>{
        if(count===banned_id.length){
            let arr=str.split(" ");
            arr.shift();
            arr.sort();
            let newstr=arr.join("");
            set.add(newstr);
        } 
        
        for(let i=start;i<banned_id.length;i++){
            for(let j=0;j<user_id.length;j++){
                if(visited[j]) continue;
                if(banned_id[i].length!==user_id[j].length) continue;
                if(!check(banned_id[i],user_id[j])) continue;
          
                visited[j]=1;
                combination(i+1,count+1,str+" "+user_id[j]);
                visited[j]=0;
            }
        }
    }
    
    combination(0,0,"");
    return set.size;
}