import React from "react";
import officeImage from "./office.png";

function App() {

  const offices = [
    {
      id: 1,
      name: "DBS",
      rent: 50000,
      address: "Chennai"
    },
    {
      id: 2,
      name: "Regus",
      rent: 75000,
      address: "Bangalore"
    },
    {
      id: 3,
      name: "WeWork",
      rent: 90000,
      address: "Hyderabad"
    }
  ];

  return (
    <div style={{ margin: "20px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office"
        width="500"
        height="300"
      />

      <h2>Office Details</h2>

      {
        offices.map((office) => (
          <div key={office.id} style={{ marginBottom: "20px" }}>

            <h3>{office.name}</h3>

            <p>
              <strong>Rent:</strong>

              <span
                style={{
                  color: office.rent < 60000 ? "red" : "green"
                }}
              >
                {" "}₹{office.rent}
              </span>

            </p>

            <p>
              <strong>Address:</strong> {office.address}
            </p>

            <hr />

          </div>
        ))
      }

    </div>
  );
}

export default App; 