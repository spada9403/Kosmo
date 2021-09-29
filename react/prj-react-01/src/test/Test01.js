import React, { Component } from "react";

class Test01 extends Component {
  state = {
    number: 0,
  };
  add = () => {
    this.setState({ number: this.state.number + 1 });
  };

  render() {
    const number = this.state.number;

    return (
      <>
        <center>
          <div>{number}</div>
          <button onClick={this.add}>+1</button>
        </center>
      </>
    );
  }
}
export default Test01;
