import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore(props) {
  let average = props.Total / props.goal;

  return (
    <div className="container">
      <h2>Student Score Calculator</h2>

      <p className="name">Name: {props.Name}</p>
      <p className="school">School: {props.School}</p>
      <p className="total">Total Score: {props.Total}</p>
      <p className="average">Average Score: {average}</p>
    </div>
  );
}

export default CalculateScore; 