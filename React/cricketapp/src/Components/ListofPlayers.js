import React from "react";

function ListofPlayers() {

  const players = [
    { name: "Virat Kohli", score: 95 },
    { name: "Rohit Sharma", score: 85 },
    { name: "MS Dhoni", score: 65 },
    { name: "Sachin Tendulkar", score: 98 },
    { name: "Yuvraj Singh", score: 55 },
    { name: "Hardik Pandya", score: 75 },
    { name: "Ravindra Jadeja", score: 60 },
    { name: "KL Rahul", score: 80 },
    { name: "Shubman Gill", score: 72 },
    { name: "Rishabh Pant", score: 68 },
    { name: "Bumrah", score: 90 }
  ];


  return (
  <div>
    <h2>List of Players</h2>

    <ul>
      {
        players.map((player) => (
          <li key={player.name}>
            {player.name} : {player.score}
          </li>
        ))
      }
    </ul>


    <h2>Players with score below 70</h2>

    <ul>
      {
        players
        .filter(player => player.score < 70)
        .map(player => (
          <li key={player.name}>
            {player.name} : {player.score}
          </li>
        ))
      }
    </ul>

  </div>
);
}

export default ListofPlayers;