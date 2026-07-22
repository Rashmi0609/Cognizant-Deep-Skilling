import React from "react";
import CohortDetails from "./CohortDetails";

function App() {
  return (
    <div>
      <CohortDetails
        name="React Full Stack Cohort"
        startDate="01-07-2026"
        endDate="31-07-2026"
        status="ongoing"
      />

      <CohortDetails
        name="Java Full Stack Cohort"
        startDate="01-06-2026"
        endDate="30-06-2026"
        status="completed"
      />
    </div>
  );
}

export default App; 