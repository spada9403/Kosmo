import React, { Component } from "react";

class Checkchic2 extends Component {
  state = {
    mChickNo: 0,
    wChickNo: 0,
  };

  updateChickCnt = (sex, number) => {
    if (sex === "mail") {
      const nowMailChickNo = this.state.mChickNo;
      if (nowMailChickNo + number < 0) {
        alert("숫병아리의 숫자는 마이너스가 될 수 없습니다.");
        return;
      }
      this.setState({ mChickNo: nowMailChickNo + number });
    }
    if (sex === "femail") {
      const nowFemailChickNo = this.state.wChickNo;
      if (nowFemailChickNo + number < 0) {
        alert("암병아리의 숫자는 마이너스가 될 수 없습니다.");
        return;
      }
      this.setState({ wChickNo: nowFemailChickNo + number });
    }
  };
  render() {
    const { mChickNo, wChickNo } = this.state;
    return (
      <>
        <center>
          <div
            style={{
              margin: "20px 0px",
            }}
          >
            <span>총개수 : {mChickNo + wChickNo}</span>
          </div>
          <div>
            <button
              onClick={() => {
                this.updateChickCnt("femail", +1);
              }}
            >
              +1
            </button>
            <button
              onClick={() => {
                this.updateChickCnt("femail", -1);
              }}
              style={{ marginRight: "30px" }}
            >
              -1
            </button>
            <button
              onClick={() => {
                this.updateChickCnt("mail", +1);
              }}
            >
              +1
            </button>
            <button
              onClick={() => {
                this.updateChickCnt("mail", -1);
              }}
            >
              -1
            </button>
          </div>
          <div>
            <span style={{ marginRight: "15px" }}>암병아리</span>
            <span>숫병아리</span>
          </div>
          <div>
            <span style={{ marginRight: "80px" }}>{wChickNo}</span>
            <span>{mChickNo}</span>
          </div>
        </center>
      </>
    );
  }
}

export default Checkchic2;
