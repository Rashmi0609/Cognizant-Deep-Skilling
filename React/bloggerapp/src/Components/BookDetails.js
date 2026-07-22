import React from "react";

function BookDetails() {
  const books = [
    { id: 1, name: "React Guide", author: "Jordan Walke" },
    { id: 2, name: "Java Programming", author: "James Gosling" }
  ];

  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            <b>{book.name}</b> - {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;