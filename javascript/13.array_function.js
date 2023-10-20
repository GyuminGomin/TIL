// 13.array_function.js

// alert('js 파일 html 문서에 적용!');

/*
    점수를 등록할 배열, 입력받을 점수 갯수, 교과목 이름
    3개의 매개변수를 전달 받아 입력받을 점수 갯수 만큼 배열에 사용자로부터 점수를 입력받아 등록하고 점수가 등록된 배열을 반환
*/
function inputScores(arrays, size, subject) {
    for(let i = 0; i < size; i++) {
        let score = prompt(subject+"과목에 점수를 입력하세요.");
        score = parseInt(score);
        arrays.push(score);
    }
    // 점수가 등록된 배열 반환
    return arrays;
}

/*
    점수가 저장된 배열을 매개변수로 전달 받아 최대값을 검색하여 반환
*/
function maxScore(arrays) {
    let result = 0;
    for (let i of arrays) {
        if (i >= result) result = i;
    }
    return result;
}

/*
    점수가 저장된 배열을 매개변수로 전달 받아 최소값을 검색하여 반환
*/
function minScore(arrays) {
    let result = 100;
    for (let i of arrays) {
        if (i <= result) result = i;
    }
    return result;
}

/*
    점수가 저장된 배열을 매개변수로 전달 받아 전체 합계를 반환
*/
function totalScore(arrays) {
    let result = 0;
    for (let i of arrays) {
        result += i;
    }
    return result;
}

/*
    점수가 저장된 배열을 매개변수로 전달 받아 전체 평균을 반환
*/
function average(arrays) {
    let total = totalScore(arrays);
    let result = total/arrays.length;
    return result;
}