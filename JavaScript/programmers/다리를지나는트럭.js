function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    const queue = [];
    let sum = truck_weights[0];
    let cnt = 1;
    queue.push(truck_weights[0]);
    while(queue.length){
        if(cnt >= truck_weights.length) break;
        if(queue.length === bridge_length){
            sum -= queue.shift();
        }
        if(cnt < truck_weights.length && weight >= sum+ truck_weights[cnt]){
            sum += truck_weights[cnt];
            queue.push(truck_weights[cnt]);
            cnt++;
        }else{
            queue.push(0);
        }
        answer++;
    }
    answer += bridge_length + 1;
    return answer;
}