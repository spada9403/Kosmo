import React, { Component } from "react";
import "./validation.css";

class CheckLogin extends Component {
  /*
    리액트가 지원하는 속성변수 state 선언하고 사용자 정의 객체({~}) 저장.
    속성변수 state 의 데이터 갱신은 setState(~) 라는 메소드 호출로 갱신된다.
    setState(~) 메소드가 호출되어 state 변수 안의 데이터가 생신되면 render 메소드가 재호출되고 리턴되는
    JSX 의 실행결과가 웹브라우저로 출력된다
    */
  state = {
    pwd: "",
    id: "",
    cliked: false,
    validated: false,
  };
  handleChange = (e) => {
    // if (e.target.name === "pwd") {
    //   this.setState({
    //     pwd: e.target.value,
    //   });
    // }
    // if (e.target.name === "pwd") {
    //   this.setState({
    //     pwd: e.target.value,
    //   });
    // }
    // state 속성변수 안의 사용정 객체에서
    // 이벤트가 발생한 입력양식의
    // name값을 속성변수명으로 사용하는 놈에게
    // 이벤트가 발생한 입력양식의 value 값을 저장하기
    // <주의> 이벤트가 발생한 입력양식의 name 값을 속성변수명을 취급할 때
    //         꼭 [] 로 감싼다.
    this.setState({
      [e.target.name]: e.target.value,
    });
  };
  handleButtonClick = () => {
    this.setState({
      clicked: true,
      validated: this.state.pwd === "0000" && this.state.id === "abc",
    });
  };
  render() {
    const validate = this.state.validated;
    const clicked = this.state.clicked;
    if (clicked && validate === false) {
      setTimeout(() => {
        this.setState({
          id: "",
          pwd: "",
          clicked: false,
        });
      }, 3000);
    }
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
              <input type="text" value={this.state.id} onChange={this.handleChange} name="id" />
            </td>
          </tr>
          <tr>
            <th>암 호 : </th>
            <td>
              <input type="password" value={this.state.pwd} onChange={this.handleChange} name="pwd" />
            </td>
          </tr>
        </table>
        <button style={{ marginLeft: "20px" }} onClick={this.handleButtonClick} className={this.state.clicked ? (this.state.validated ? "success" : "failure") : ""}>
          검증하기
        </button>
      </center>
    );
  }
}
export default CheckLogin;
