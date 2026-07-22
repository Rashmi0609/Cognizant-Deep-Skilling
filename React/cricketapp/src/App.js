import React from "react";
import ListofPlayers from "./Components/ListofPlayers";
import IndianPlayers from "./Components/IndianPlayers";

function App() {

  let flag = true;

  return (
    <div style={{ textAlign: "left", margin: "20px" }}>
      {
        flag ? 
        <ListofPlayers /> 
        :
        <IndianPlayers />
      }
    </div>
  );
}

export default App; 