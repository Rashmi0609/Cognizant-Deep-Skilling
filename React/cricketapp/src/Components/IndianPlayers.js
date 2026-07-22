import React from "react";

function IndianPlayers() {

  const IndianTeam = [
    "Rohit",
    "Virat",
    "Dhoni",
    "Rahul",
    "Jadeja",
    "Bumrah"
  ];


  const [oddPlayers, evenPlayers] = [
    IndianTeam.filter((player,index)=> index % 2 === 0),
    IndianTeam.filter((player,index)=> index % 2 !== 0)
  ];


  const T20players = [
    "Rohit",
    "Virat",
    "Hardik"
  ];


  const RanjiTrophyPlayers = [
    "Rahul",
    "Jadeja",
    "Bumrah"
  ];


  const mergedPlayers = [
    ...T20players,
    ...RanjiTrophyPlayers
  ];


  return (
    <div>

      <h2>Odd Team Players</h2>

      {
        oddPlayers.map(player =>
          <p key={player}>{player}</p>
        )
      }


      <h2>Even Team Players</h2>

      {
        evenPlayers.map(player =>
          <p key={player}>{player}</p>
        )
      }


      <h2>Merged T20 and Ranji Players</h2>

      {
        mergedPlayers.map(player =>
          <p key={player}>{player}</p>
        )
      }


    </div>
  );
}

export default IndianPlayers; 