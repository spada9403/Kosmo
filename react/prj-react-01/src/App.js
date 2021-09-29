import React from "react";
import { Route } from "react-router-dom";

import Counter from "./naver/Counter";
import Counter2 from "./naver/Counter2";
import Test2 from "./test/Test02";
import Test01 from "./test/Test01";
import Checkchic from "./naver/Checkchic";
import Checkchic2 from "./naver/Checkchic2";

function App() {
  return (
    <div>
      {/* URL 주소가 ~:3000/naver/counter 일 경우 Counter 컴포넌트 호출해라.*/}
      <Route path="/naver/counter" component={Counter}></Route>
      <Route path="/naver/counter2" component={Counter2}></Route>
      <Route path="/test/test01" component={Test01}></Route>
      <Route path="/test/test02" component={Test2}></Route>
      <Route path="/naver/Checkchic" component={Checkchic}></Route>
      <Route path="/naver/Checkchic2" component={Checkchic2}></Route>
    </div>
  );
}

export default App;
