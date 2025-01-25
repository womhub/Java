-- publishers
INSERT INTO publishers (name) VALUES ('おさるの出版社');
INSERT INTO publishers (name) VALUES ('あひる出版');

-- books
INSERT INTO books (book_title, author, publisher_id) VALUES ('吾輩は猫です', '夏目漱石', 1);
INSERT INTO books (book_title, author, publisher_id) VALUES ('おさるのジョージ', 'レイ夫妻', 1);
INSERT INTO books (book_title, author, publisher_id) VALUES ('向日葵の向かない夏', '道尾秀介', 2);

--reviews
INSERT INTO reviews (book_id, review_text) VALUES (2, 'サルキチがかわいい');
INSERT INTO reviews (book_id, review_text) VALUES (3, 'ふふふ');


