import React, { useState } from "react";

function Test03() {
  const [names, setNames] = useState([
    { id: 1, text: "사오정" },
    { id: 2, text: "저팔계" },
    { id: 3, text: "손오공" },
    { id: 4, text: "삼장법사" },
  ]);
  const xxx = names.map((name) => (
    <tr key={name.id}>
      <td>{name.id}</td>
      <td>{name.text}</td>
    </tr>
  ));
  return (
    <>
      <center>
        <table
          border="1"
          cellpadding="2"
          style={{
            borderCollapse: "collapse",
          }}
        >
          <caption>{names.length}명</caption>
          <tr>
            <th>학생번호</th>
            <th>학생명</th>
          </tr>
          {xxx}
        </table>
      </center>
    </>
  );
}

export default Test03;
