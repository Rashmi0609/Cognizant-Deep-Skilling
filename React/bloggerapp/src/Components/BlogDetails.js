import React from "react";

function BlogDetails() {
  const blogs = [
    { id: 1, title: "React Basics", author: "Rashmi" },
    { id: 2, title: "ES6 Features", author: "Admin" }
  ];

  return (
    <div>
      <h2>Blog Details</h2>
      <ul>
        {blogs.map((blog) => (
          <li key={blog.id}>
            <b>{blog.title}</b> - {blog.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails; 