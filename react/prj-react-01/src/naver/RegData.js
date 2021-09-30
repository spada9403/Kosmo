import React, { useState, useRef } from "react";

const RegData = () => {
  const nameRef = useRef(null);
  const [names, setNames] = useState([
    { id: 1, text: "사오정" },
    { id: 2, text: "저팔계" },
    { id: 3, text: "손오공" },
    { id: 4, text: "삼장법사" },
  ]);
  const [inputText, setInputText] = useState("");
  const [nextId, setNextId] = useState(names.length + 1);
  const textChange = (e) => {
    let val = e.target.value;
    val = val.trim();
    /*
    // 앞뒤 공백 제거 로직    <- 무한 츠쿠요미 당함...
    while (val.indexOf(" ") === 0) {
      val = val.substring(1);
    }
    while (val.lastIndexOf(" ") === val.length - 1) {
      val = val.substring(0, val.length - 1);
    }
    */
    setInputText(val);
  };
  const addBtn = () => {
    if (inputText.split(" ").join("") === "" || inputText === null || inputText === undefined) {
      alert("이름을 입력해 주세요");
      setInputText("");
      nameRef.current.focus();
      return;
    }
    if (names !== null || names !== undefined) {
      if (names.filter((name) => name.text === inputText).length > 0) {
        alert("중복된 데이터 입니다!");
        setInputText("");
        nameRef.current.focus();
        return;
      }
    }
    const newNames = names.concat({
      id: nextId,
      text: inputText,
    });
    setNames(newNames);
    setNextId(nextId + 1);
    // setNames([
    //   ...names,
    //   {
    //     id: nextId,
    //     text: inputText,
    //   },
    // ]);
    setInputText("");
    // 포커스 들여 놓기.
    nameRef.current.focus();
  };
  const remove = (id) => {
    const newNames = names.filter((item) => item.id !== id);
    setNames(newNames);
  };
  const namesTag = names.map((name) => (
    <li
      style={{
        cursor: "pointer",
      }}
      key={name.id}
      onDoubleClick={() => remove(name.id)}
    >
      {name.text}
    </li>
  ));
  return (
    <>
      <center>
        <table>
          <tr>
            <td>
              <input type="text" ref={nameRef} value={inputText} onChange={textChange} />
              <button onClick={addBtn}>추가</button>
              &nbsp;
              <ul>{namesTag}</ul>
            </td>
          </tr>
        </table>
      </center>
    </>
  );
};

export default RegData;
