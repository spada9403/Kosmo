import React, { Component } from "react";

class RegData2 extends Component {
  nameRef = React.createRef();

  state = {
    names: [],
    inputText: "",
    nextId: 1,
  };
  addBtn = () => {
    const { names, nextId } = this.state;
    let inputText = this.state.inputText;
    inputText = inputText.trim();
    if (inputText.split(" ").join("") === "" || inputText === null || inputText === undefined) {
      alert("이름을 입력해 주세요");
      this.setState({ inputText: "" });
      this.nameRef.current.focus();
      return;
    }
    if (names !== null || names !== undefined) {
      if (names.filter((name) => name.text === inputText).length > 0) {
        alert("중복된 데이터 입니다!");
        this.setState({ inputText: "" });
        this.nameRef.current.focus();
        return;
      }
    }
    const newNames = names.concat({
      id: nextId,
      text: inputText,
    });
    this.setState({ names: newNames, nextId: this.state.nextId + 1, inputText: "" });
    this.nameRef.current.focus();
  };
  textChange = (e) => {
    let val = e.target.value;
    this.setState({ inputText: val });
  };
  remove = (id) => {
    const names = this.state.names;
    if (names.length === 1) {
      alert("최소한 1개는 있어야 합니다.");
      return;
    }
    const newNames = names.filter((item) => item.id !== id);
    this.setState({ names: newNames });
  };
  componentDidMount = () => {
    document.body.addEventListener("keyup", (e) => {
      if (e.keyCode === 13) {
        this.addBtn();
      }
    });
  };

  render() {
    const { inputText, names } = this.state;
    const namesTag = names.map((name) => (
      <li
        style={{
          cursor: "pointer",
        }}
        key={name.id}
        onDoubleClick={() => this.remove(name.id)}
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
                <input type="text" ref={this.nameRef} value={inputText} onChange={this.textChange} />
                <button onClick={this.addBtn}>추가</button>
                &nbsp;
                <ul>{namesTag}</ul>
              </td>
            </tr>
          </table>
        </center>
      </>
    );
  }
}

export default RegData2;
