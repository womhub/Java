CREATE TABLE publishers(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL
);

CREATE TABLE books (
	id INT PRIMARY KEY AUTO_INCREMENT,
	book_title VARCHAR(255) NOT NULL,
	author VARCHAR(255) NOT NULL,
	publisher_id INT,
	FOREIGN KEY (publisher_id) REFERENCES publishers(id)
);


CREATE TABLE reviews(
	id INT PRIMARY KEY AUTO_INCREMENT,
	book_id INT NOT NULL,
	review_text TEXT,
	FOREIGN KEY (book_id) REFERENCES books(id)
);
