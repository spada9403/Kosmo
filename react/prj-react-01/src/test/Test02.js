import React, { useState } from "react";

function Test2() {
  const [number, setNumber] = useState(0);

  const add = () => {
    setNumber(number + 1);
  };

  return (
    <>
      <center>
        <div>{number}</div>
        <button onClick={add}>+1</button>
      </center>
    </>
  );
}

export default Test2;
