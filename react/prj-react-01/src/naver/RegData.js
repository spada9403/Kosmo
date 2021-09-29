import React, { useState } from "react";

const RegData = () => {
  const [names, setNames] = useState([
    { id: 1, text: "사오정" },
    { id: 2, text: "저팔계" },
    { id: 3, text: "손오공" },
    { id: 4, text: "삼장법사" },
  ]);
  const [inputText, setInputText] = useState("");
  const [nextId, setNextId] = useState(names.length + 1);
  const textChange = (e) => {
    setInputText(e.target.value);
  };
  const addBtn = () => {
    if (inputText.split(" ").join("") === "") {
      alert("이름을 입력해 주세요");
    } else {
      if (names.filter((item) => item.text === inputText).length > 0) {
        alert("중복된 데이터 입니다!");
      } else {
        const newNames = names.concat({
          id: nextId,
          text: inputText,
        });
        setNames(newNames);
        console.log(names);
        setNextId(nextId + 1);
      }
    }
    // setNames([
    //   ...names,
    //   {
    //     id: nextId,
    //     text: inputText,
    //   },
    // ]);
    setInputText("");
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
              <input type="text" value={inputText} onChange={textChange} />
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
