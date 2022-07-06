function solution(relation) {
    let idxArr = Array.from(Array(relation[0].length), (v, i) => i);
    let combinations = [];
    for(let i = 0 ; i < idxArr.length ; i++){
        combinations.push(...getCombination(idxArr, i + 1));
    }
    console.log(combinations);
    combinations = checkUniqueness(relation, combinations);
    console.log(combinations);
    combinations = checkMinimality(combinations);

    return combinations.length;
}

const checkUniqueness = (arr, comb) => {
    const results = [];
    comb.forEach((v1, i1) => {
        let set = new Set();
        arr.forEach((v2, i2) => {
            set.add(v1.map(e => v2[e]).join(','));
        });

        if(set.size == arr.length) results.push(v1);
    });

    return results;
}

const checkMinimality = (comb) => {
    const results = [];

    while(comb.length){
        results.push(comb[0]);
        comb = comb.reduce((a, c) => {
            let check = comb[0].every(e => c.includes(e));
            if(!check) a.push(c);
            return a;
        },[]);

    }

    return results;
}

const getCombination = (arr, num) => {
    const results = [];
    if(num === 1) return arr.map(v => [v]);

    arr.forEach((fixed, index, origin) => {
        const rest = origin.slice(index + 1);
        const combinations = getCombination(rest, num - 1);
        const attached = combinations.map(v => [fixed, ...v]);
        results.push(...attached);
    });

    return results;
}
