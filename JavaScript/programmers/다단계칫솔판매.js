function solution(enroll, referral, seller, amount) {
  var answer = Array(enroll.length).fill(0);
  let map = new Map();
  for (let i = 0; i < enroll.length; i++) {
    map.set(enroll[i], referral[i]);
  }
  let tempProfit = {};
  for (let i = 0; i < seller.length; i++) {
    let parrent = map.get(seller[i]);
    let profit = Math.floor(amount[i] * 100 * 0.9);
    let tempAmount = amount[i] * 100 * 0.1;
    if (!tempProfit[seller[i]]) {
      tempProfit[seller[i]] = profit;
    } else {
      tempProfit[seller[i]] += profit;
    }

    while (parrent !== "-") {
      let parrentProfit = tempAmount - Math.floor(tempAmount * 0.1);
      if (i === 0) console.log(parrentProfit);
      if (!tempProfit[parrent]) {
        tempProfit[parrent] = parrentProfit;
      } else tempProfit[parrent] += parrentProfit;
      parrent = map.get(parrent);
      tempAmount = Math.floor(tempAmount * 0.1);
      if (tempAmount <= 0) break;
    }
  }

  for (let i = 0; i < enroll.length; i++) {
    if (tempProfit[enroll[i]]) answer[i] = tempProfit[enroll[i]];
  }

  return answer;
}
