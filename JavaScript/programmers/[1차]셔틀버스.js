function solution(n, t, m, timetable) {
    // n 회 t 분 간격 , 최대 m 명의 승객
    timetable.sort((a, b) => {
        if(Number(a.substring(0,2)) === Number(b.substring(0,2))){
            return Number(a.substring(3,5)) - Number(b.substring(3,5))
        }else{
            return Number(a.substring(0,2)) - Number(b.substring(0,2))
        }
    })
    console.log(timetable);
    let queue = [];
    const answer = [];
    let cnt = 0;
    let startTime =  "09:00"
    for(let i =0; i<n; i++){
        let [hour, min] = [Number(startTime.substring(0,2)), Number(startTime.substring(3,5))];
        for(; cnt<timetable.length; cnt++){
            if(Number(timetable[cnt].substring(0,2) < hour)) queue.push(timetable[cnt]);
            else if(Number(timetable[cnt].substring(0,2)) ===hour && 
                    Number(timetable[cnt].substring(3,5)) <=min) queue.push(timetable[cnt])
            else {
                break;
            }
        }        
        if(queue.length < m){
            answer.push(startTime);
            queue = [];
        }else{
            let [hour, min] = [Number(queue[m-1].substring(0,2)) , Number(queue[m-1].substring(3,5))];
            console.log(queue);
            if(min - 1 < 0){
                if(hour -1 >=10)    answer.push("" + (hour-1) + ":59");
                else    answer.push("0" + (hour-1) + ":59");
             
            }else {
                if(min - 1 < 10){
                    if(hour >= 10) answer.push("" + hour + ":0" + (min-1));
                    else answer.push("0"+hour+":0" + (min -1));
                }else{
                    if(hour >= 10) answer.push("" + hour + ":" + (min -1));
                    else answer.push("0"+hour+":0" + (min -1));
                }
                queue.splice(m,queue.length);
            }
        }
        if(min + t >= 60){
            let convert = min + t - 60;
            if(convert < 10){
                convert = "0"+convert;
            }else convert = ""+convert;
            if(hour+1 >=10) startTime = "" + (hour+1) + ":" + convert;
            else startTime = "0" + (hour+1) + ":" + convert;
        }else{
            let convert = min + t;
            if(convert < 10){
                convert = "0"+convert;
            }else convert = ""+convert;
            if(hour >=10) startTime = "" + (hour) + ":" + convert;
            else startTime = "0" + (hour) + ":" + convert;
        }
    }
    console.log(answer);
    
    return answer.pop();
}