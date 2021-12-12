import React, { useState } from "react";
import axios from "axios";

function LoginForm(props) {
  const [id_pwd, setId_pwd] = useState({ login_id: "", pwd: "" });

  const change = (e) => {
    setId_pwd({
      ...id_pwd,
      [e.target.name]: e.target.value,
    });
  };

  const login = () => {
    axios
      .post("http://localhost:8081/naver/loginProc.do", id_pwd)
      .then((response) => {
        console.log(response);
        if (response.data === 1) {
          alert("로그인 성공!!");
          props.history.push("/board/boardList");
        } else {
          alert("아이디 또는 암호가 틀립니다.");
          setId_pwd({ ...id_pwd, ...{ login_id: "", pwd: "" } });
        }
      })
      .catch((error) => {
        alert(error.message);
      });
  };
  return (
    <>
      <center>
        <table border="0" cellPadding="7" cellSpacing="0" bgcolor="lightgray">
          <caption>[로그인]</caption>
          <tbody>
            <tr>
              <td align="right">[아이디]</td>
              <td>
                <input type="text" name="login_id" onChange={change} value={id_pwd.login_id} />
              </td>
            </tr>
            <tr>
              <td align="right">[암 호]</td>
              <td>
                <input type="text" name="pwd" onChange={change} value={id_pwd.pwd} />
              </td>
            </tr>
          </tbody>
        </table>
        <br />
        <button onClick={login}>로그인</button>
      </center>
    </>
  );
}

export default LoginForm;
