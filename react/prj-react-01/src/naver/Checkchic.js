import React, { useState } from "react";

function Ceckchic() {
  const [mChickNo, setMailChick] = useState(0);
  const [wChickNo, setFemailChick] = useState(0);

  const updateChickCnt = (sex, number) => {
    if (sex === "mail") {
      const nowMailChickNo = mChickNo;
      if (nowMailChickNo + number < 0) {
        alert("숫병아리의 숫자는 마이너스가 될 수 없습니다.");
        return;
      }
      setMailChick(nowMailChickNo + number);
    }
    if (sex === "femail") {
      const nowFemailChickNo = wChickNo;
      if (nowFemailChickNo + number < 0) {
        alert("암병아리의 숫자는 마이너스가 될 수 없습니다.");
        return;
      }
      setFemailChick(nowFemailChickNo + number);
    }
  };
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
              updateChickCnt("femail", +1);
            }}
          >
            +1
          </button>
          <button
            onClick={() => {
              updateChickCnt("femail", -1);
            }}
            style={{ marginRight: "30px" }}
          >
            -1
          </button>
          <button
            onClick={() => {
              updateChickCnt("mail", +1);
            }}
          >
            +1
          </button>
          <button
            onClick={() => {
              updateChickCnt("mail", -1);
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

export default Ceckchic;
