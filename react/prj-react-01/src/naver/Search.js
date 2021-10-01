import React, { useState, useRef } from "react";
import styled from "styled-components";
const Tr = styled.tr`
  background-color: ${(props) => (props.className === "odd" ? "lightcoral" : "lightpink")};
`;

function Search() {
  //DB 연동으로 가지고온 데이터
  const allDev = [
    { dev_no: 1, dev_name: "사오정", addr: "서울시", phone: "010-1111-2222" },
    { dev_no: 2, dev_name: "사오정2", addr: "서울시", phone: "010-3333-4444" },
    { dev_no: 3, dev_name: "사오정3", addr: "서울시", phone: "010-5555-6666" },
    { dev_no: 4, dev_name: "사오정4", addr: "서울시", phone: "010-7777-8888" },
    { dev_no: 5, dev_name: "사오정5", addr: "서울시", phone: "010-9999-1212" },
    { dev_no: 6, dev_name: "사오정6", addr: "서울시", phone: "010-5555-3333" },
    { dev_no: 7, dev_name: "사오정7", addr: "서울시", phone: "010-4444-1111" },
  ];
  const nameRef = useRef(null);
  const [developers, setDevelopers] = useState(allDev);
  const [inputText, setInputText] = useState("");

  const changeText = (e) => {
    setInputText(e.target.value);
  };
  const search = () => {
    const val = inputText.trim();
    if (val === "" || val === undefined || val === null) {
      alert("검색할 키워드가 없습니다!");
      nameRef.current.focus();
      return;
    }
    const array = allDev.filter((item) => item.dev_name.indexOf(val) >= 0 || item.phone.indexOf(val) >= 0 || item.addr.indexOf(val) >= 0);
    setDevelopers(array);
    setInputText("");
    nameRef.current.focus();
  };
  const allSearch = () => {
    setDevelopers(allDev);
    setInputText("");
    nameRef.current.focus();
  };

  const devList = developers.map((dev, index) => {
    let even_or_odd = "odd";
    if (index % 2 === 0) {
      even_or_odd = "even";
    }
    return (
      <Tr className={even_or_odd}>
        <td>{dev.dev_no}</td>
        <td>{dev.dev_name}</td>
        <td>{dev.addr}</td>
        <td>{dev.phone}</td>
      </Tr>
    );
  });
  return (
    <>
      <center>
        <br />
        <br />
        <span>
          키워드: <input type="text" onChange={changeText} ref={nameRef} value={inputText} />
        </span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button onClick={search} className="searchBtn">
          검색
        </button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button onClick={allSearch} className="searchBtn">
          모두 검색
        </button>
        <br />
        <br />
        <span>총 {developers.length}명</span>
        <br />
        <br />
        <table border="1" cellPadding="5" style={{ borderCollapse: "collapse" }}>
          <tr style={{ backgroundColor: "gray" }}>
            <th>번호</th>
            <th>직원명</th>
            <th>거주지</th>
            <th>전화</th>
          </tr>
          {devList}
        </table>
      </center>
    </>
  );
}

export default Search;
