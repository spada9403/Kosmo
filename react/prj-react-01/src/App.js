import React from "react";
import { Route } from "react-router-dom";
import Test from "./naver/Test";

function App() {
  return (
    <div>
      <Route path="/naver/test" component={Test}></Route>
    </div>
  );
}

export default App;
