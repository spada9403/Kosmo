import React, { useEffect, useState } from "react";

function CheckLogin2() {
  const [id, setId] = useState("");
  const [pwd, setPwd] = useState("");
  const [clicked, setClicked] = useState(false);
  const [validate, setValidate] = useState(false);

  useEffect(() => {
    if (clicked && validate === false) {
      setTimeout(() => {
        setId("");
        setPwd("");
        setClicked(false);
      }, 3000);
    }
  }, [clicked]);

  const handleChange = (e) => {
    if (e.target.name === "id") {
      setId(e.target.value);
    }
    if (e.target.name === "pwd") {
      setPwd(e.target.value);
    }
  };
  const handleButtonClick = () => {
    setClicked(true);
    setValidate(id === "abc" && pwd === "0000");
  };
  return (
    <center>
      <table
        style={{
          marginTop: "80px",
        }}
      >
        <tr>
          <th>아이디 : </th>
          <td>
            <input type="text" value={id} onChange={handleChange} name="id" />
          </td>
        </tr>
        <tr>
          <th>암 호 : </th>
          <td>
            <input type="password" value={pwd} onChange={handleChange} name="pwd" />
          </td>
        </tr>
      </table>
      <button style={{ marginLeft: "20px" }} onClick={handleButtonClick} className={clicked ? (validate ? "success" : "failure") : ""}>
        검증하기
      </button>
    </center>
  );
}

export default CheckLogin2;
