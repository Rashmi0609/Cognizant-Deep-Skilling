import React from "react";
import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {
  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h1>Blogger App</h1>

      <div
        style={{
          display: "flex",
          justifyContent: "space-around",
          alignItems: "flex-start",
          marginTop: "30px",
        }}
      >
        {/* Book Details */}
        <div style={{ flex: 1 }}>
          {showBooks ? <BookDetails /> : <h3>No Book Details</h3>}
        </div>

        {/* Green Vertical Line */}
        <div
          style={{
            width: "3px",
            backgroundColor: "green",
            height: "300px",
          }}
        ></div>

        {/* Blog Details */}
        <div style={{ flex: 1 }}>
          {showBlogs && <BlogDetails />}
        </div>

        {/* Green Vertical Line */}
        <div
          style={{
            width: "3px",
            backgroundColor: "green",
            height: "300px",
          }}
        ></div>

        {/* Course Details */}
        <div style={{ flex: 1 }}>
          {showCourses ? <CourseDetails /> : null}
        </div>
      </div>
    </div>
  );
}

export default App; 