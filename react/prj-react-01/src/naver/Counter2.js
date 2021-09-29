// 프로젝트명/node_modules/react 안에 default 가 붙어 수출하는 놈을 수입해서
//   현재 파일 안에서 React 란 이름으로 사용함
// 프로젝트명/node_modules/react 안에 default 가 '안' 붙어 수출하는 놈 useState 수입해서
//   현재 파일 안에서 useState 란 이름으로 사용함
// <참고> 아래 수입 코드는 함수 컴포넌트가 선언되는 js 파일안에서는 필수로 수입되는 놈들이다.
import React, { useState } from "react";

function Counter2() {
  const default_number = 1;

  // 지역변수 number, setNumber 선언.
  // 리액트가 제공하는 내장 함수 useState(default_number) 를 호출하여
  // 지역변수 number 에 default_number 변수안의 데이터를 저장하고
  // 지역변수 setNumber 에 number 을 수정하는 익명함수 저장하기.
  // 단 useState(~) 함수가 호출되는 코딩 줄은 제외된다
  // 이제부터 setNumber 변수 안의 익명함수를 호출하여
  // number 변수 안의 데이터가 갱신 되면 Counter2 함수가 재호출된다.
  // setNumber 변수안의 익명함수를 호출하는 방법은 setNumber(number 변수안에 저장될 데이터 )이다
  const [number, setNumber] = useState(default_number);

  const add = () => {
    // 지역변수 number 안의 데이터를 1 업데이트 하기.
    // 이때 setNumber(~) 호출로 업데이트를 한다.
    // setNumber(~) 호출이 실행되면 함수 컴포넌트는 재호출된다.
    setNumber(number + 1);
  };
  const minus = () => {
    setNumber(number - 1);
  };
  const init = () => {
    setNumber(default_number);
  };
  return (
    <center>
      <span>시작값 : {default_number}</span>
      <span>현재값 : {number}</span>
      <button onClick={add}>+</button>
      <button onClick={minus}>-</button>
      <button onClick={init}>초기화</button>
    </center>
  );
}

export default Counter2;
