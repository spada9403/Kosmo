//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
// 프로젝트명/node_modules/react 안에서 default 가 붙어 수출하는 놈을 수입해서 현재 파일에서 변수 React 에 저장하기
// 프로젝트명/node_modules/react 안안에서에 default 가 안붙어 수출하는 useState 함수를 수입해서 현재 파일에서 변수 useState 에 저장하기
// <참고>함수 컴포넌트를 선언할 할 경우 대부분 useState 함수를 사용한다.
//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
import React, { useState, useRef, useEffect } from "react";

const developerList = [
  { dev_no: 1, dev_name: "사오정", addr: "서울", phone: "010-1111-2222" },
  { dev_no: 2, dev_name: "사오정2", addr: "서울", phone: "010-3333-4444" },
  { dev_no: 3, dev_name: "사오정3", addr: "서울", phone: "010-5555-6666" },
  { dev_no: 4, dev_name: "사오정4", addr: "경기", phone: "010-7777-8888" },
  { dev_no: 5, dev_name: "사오정5", addr: "경기", phone: "010-9999-1212" },
  { dev_no: 6, dev_name: "사오정6", addr: "인천", phone: "010-5555-3333" },
  { dev_no: 7, dev_name: "사오정7", addr: "인천", phone: "010-4444-1111" },
  { dev_no: 8, dev_name: "사오정8", addr: "대구", phone: "010-4444-1111" },
];

const Search3 = () => {
  const keywordRef = useRef(null);
  // 재 마운트 되게 하는 지역변수들을 선언하기.
  // 검색 결과물 저장 변수 developers 선언
  // 키워드 저장 변수 keyword 선언
  // 체크된 주소 저장 변수 addrs 선언
  const [developers, setDevelopers] = useState(developerList);
  const [keyword, setKeyword] = useState("");
  const [addrs, setAddrs] = useState([]);

  // addrs 변수 안의 데이터 변경 시 일어나는 마운트(=함수안의 모든 코딩이 실행된 이후) 후에만
  // search(); 구문 실행하도록 설정하기
  /*
  useEffect 형싱은 아래와 같다.
  //////////////////////////
  useEffect(콜백함수,[useState로 선언한 변수명])
  //////////////////////////
  useEffect(()=>{
    마운트 후에 실행할 코딩.
  }, [useState 함수호출로 저장한 변수명])
  */
  useEffect(() => {
    // if (!addrs.length > 0) {
    //   setDevelopers(developerList);
    // }
    search();
  }, [addrs]);
  // 2번쨰 인수 useState 함수호출로 저장한 변수명이 없으면,
  // 마운드 될때마다 실행된다.
  useEffect(() => {
    keywordRef.current.focus();
  });

  const checkList = document.getElementsByName("addr");
  let checkListValue = [];
  checkList.forEach((item) => {
    checkListValue.push(item.value);
  });
  const keywordChange = (e) => {
    setKeyword(e.target.value); // 이벤트가 발생한 입력양식의 value
  };
  const addrChecked = (e) => {
    // 체크의 넣기/빼기 이벤트가 발생한 입력 양식의 value값 얻기
    const value = e.target.value;
    // 체크의 넣기/빼기 정보 얻어오기.
    const checked = e.target.checked;
    // 만약에 체크가 됬으면 addrs 변수안의 Array 객체에 value 변수의 값을 누적 저장.

    if (checked) {
      setAddrs(addrs.concat(value));
      // 만약에 체크가 되어 있지 않으면 addrs 변수안의 Array 객체에
      // 배열안에서 체크 풀린놈의 value 값을 없애기.
    } else {
      setAddrs(addrs.filter((addr) => addr !== value));
    }
  };
  const search = () => {
    const flag1 = keyword != null && keyword.split(" ").join("") !== "";
    const flag2 = addrs != null && addrs.length > 0;
    let tmp_keyword = "";
    if (flag1) {
      tmp_keyword = keyword.trim();
    }
    if (flag1 === false && flag2 === false) {
      setDevelopers(developerList);
      return;
    }
    const newDeveloperList = developerList.filter((dev) => {
      let result = false;

      if (flag1) {
        result = dev.dev_name.includes(tmp_keyword) || dev.addr.includes(tmp_keyword) || dev.phone.includes(tmp_keyword);
      }
      if (flag2) {
        let checkBoxString = addrs.includes(dev.addr);
        if (addrs.includes("기타")) {
          checkBoxString = checkBoxString || !checkListValue.includes(dev.addr);
        }
        if (flag1) {
          result = result && checkBoxString;
        } else {
          result = checkBoxString;
        }
      }
      return result;
    });
    setDevelopers(newDeveloperList);
  };
  const searchAll = () => {
    setKeyword("");
    setAddrs([]);
    const checkbox = document.getElementsByName("addr");
    checkbox.forEach((item) => {
      if (item.checked) {
        item.checked = false;
      }
    });
    setDevelopers(developerList);
  };
  // 지역변수 searchResultTag 선언.
  // 검색 결과물이 저장된 developers 안의 저장된 사용정 객체들 안의 데이터를 html 태그 형태로 누적시키기.
  const searchResultTag = developers.map((developer, index) => {
    let css = {
      backgroundColor: "lightpink",
    };
    if (index % 2 === 0) {
      css = {
        backgroundColor: "lightcoral",
      };
    }
    return (
      <tr key={developer.dev_no} style={css}>
        <td>{developer.dev_no}</td>
        <td>{developer.dev_name}</td>
        <td>{developer.addr}</td>
        <td>{developer.phone}</td>
      </tr>
    );
  });
  return (
    <>
      <center>
        <table cellPadding="5" bordercolor="lightgray">
          <caption>[검색 조건]</caption>
          <tbody>
            <tr>
              <td alight="right">키워드</td>
              <td>
                <input type="text" value={keyword} onChange={keywordChange} ref={keywordRef} />
              </td>
            </tr>
            <tr>
              <td align="right">주소</td>
              <td>
                <input type="checkbox" name="addr" value="서울" onChange={addrChecked} />
                서울
                <input type="checkbox" name="addr" value="경기" onChange={addrChecked} />
                경기
                <input type="checkbox" name="addr" value="인천" onChange={addrChecked} />
                인천
                <input type="checkbox" name="addr" value="기타" onChange={addrChecked} />
                기타
              </td>
            </tr>
          </tbody>
        </table>
        <br />
        <button onClick={search} style={{ marginRight: "20px" }}>
          검색
        </button>
        <button onClick={searchAll}>모두검색</button>
        <br />
        <br />
        검색 개수 : {developers.length}
        <table border="1" cellPadding="2" bordercolor="lightgray" className="ListTable">
          <thead>
            <tr bgcolor="lightgray">
              <th>번호</th>
              <th>직원명</th>
              <th>주소</th>
              <th>전화</th>
            </tr>
          </thead>
          <tbody>{searchResultTag}</tbody>
        </table>
      </center>
    </>
  );
};
export default Search3;
