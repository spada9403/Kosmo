import React, { useState } from "react";

function Ceckchic() {
  const [mailChick, setMailChick] = useState(0);
  const [femailChick, setFemailChick] = useState(0);
  const [totCount, setTotCount] = useState(0);

  const femailChickAdd = () => {
    setFemailChick(femailChick + 1);
    setTotCount(totCount + 1);
  };
  const femailChickMinus = () => {
    setFemailChick(femailChick - 1);
    setTotCount(totCount - 1);
  };
  const mailChickAdd = () => {
    setMailChick(mailChick + 1);
    setTotCount(totCount + 1);
  };
  const mailChickMinus = () => {
    setMailChick(mailChick - 1);
    setTotCount(totCount - 1);
  };
  return (
    <>
      <center>
        <div
          style={{
            margin: "20px 0px",
          }}
        >
          <span>총개수 : {totCount}</span>
        </div>
        <div>
          <button onClick={femailChickAdd}>+1</button>
          <button onClick={femailChickMinus} style={{ marginRight: "30px" }}>
            -1
          </button>
          <button onClick={mailChickAdd}>+1</button>
          <button onClick={mailChickMinus}>-1</button>
        </div>
        <div>
          <span style={{ marginRight: "15px" }}>암병아리</span>
          <span>숫병아리</span>
        </div>
        <div>
          <span style={{ marginRight: "80px" }}>{femailChick}</span>
          <span>{mailChick}</span>
        </div>
      </center>
    </>
  );
}

export default Ceckchic;
