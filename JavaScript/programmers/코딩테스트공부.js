function solution(alp, cop, problems) {
  let goalAlp = 0;
  let goalCop = 0;
  // 목표 알고력, 코딩력 설정
  problems.forEach(([v1, v2]) => {
    goalAlp = Math.max(goalAlp, v1, alp);
    goalCop = Math.max(goalCop, v2, cop);
  });

  let dp = Array.from(Array(goalAlp + 1), () =>
    Array(goalCop + 1).fill(Infinity)
  );
  dp[alp][cop] = 0;

  for (let i = alp; i <= goalAlp; i++) {
    for (let j = cop; j <= goalCop; j++) {
      if (i !== goalAlp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
      if (j !== goalCop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
      for (let k = 0; k < problems.length; k++) {
        let alp_req = problems[k][0];
        let cop_req = problems[k][1];
        let alp_rwd = problems[k][2];
        let cop_rwd = problems[k][3];
        if (i >= alp_req && j >= cop_req) {
          const selAlp = Math.min(i + alp_rwd, goalAlp);
          const selCop = Math.min(j + cop_rwd, goalCop);
          dp[selAlp][selCop] = Math.min(
            dp[selAlp][selCop],
            dp[i][j] + problems[k][4]
          );
        }
      }
    }
  }
  return dp[goalAlp][goalCop];
}
