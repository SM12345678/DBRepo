-- SM_Customers entity
INSERT INTO SM_Customers(cus_id, id_type, id_number, full_name, phone_number, email_address)
VALUES(1, 'SSN', 'S123451', 'David Ross', 7897894156, 'david@gmail.com');
INSERT INTO SM_Customers(cus_id, id_type, id_number, full_name, phone_number, email_address)
VALUES(2, 'SSN', 'S123443', 'Moira Ross', 7897894155, 'moira@gmail.com');
INSERT INTO SM_Customers(cus_id, id_type, id_number, full_name, phone_number, email_address)
VALUES(3, 'Passport', 'K12378632', 'Alexis Ross', 7897894120, 'alexis@gmail.com');
INSERT INTO SM_Customers(cus_id, id_type, id_number, full_name, phone_number, email_address)
VALUES(4, 'Driver License', 'DL454522', 'Johnny Ross', 7897895155, 'johnny@gmail.com');
INSERT INTO SM_Customers(cus_id, id_type, id_number, full_name, phone_number, email_address)
VALUES(5, 'Driver License', 'DL123522', 'Jim Halpert', 9127894155, 'jim@gmail.com');
INSERT INTO SM_Customers(cus_id, id_type, id_number, full_name, phone_number, email_address)
VALUES(6, 'Driver License', 'DL123111', 'Pam Bisley', 9126794155, 'pam@gmail.com');
SELECT * FROM SM_Customers;

-- ------------------------------------------------------------------------------------------
-- SM_Study_Room entity
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (10, 2);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (11, 2);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (12, 2);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (13, 2);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (14, 2);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (20, 5);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (25, 5);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (30, 8);
INSERT INTO SM_Study_Room(room_id, room_capacity) VALUES (31, 8);
SELECT * FROM SM_Study_Room;

-- ------------------------------------------------------------------------------------------
-- SM_Topics entity
INSERT INTO SM_Topics(topic_id, topic_name) VALUES (01, 'History');
INSERT INTO SM_Topics(topic_id, topic_name) VALUES (02, 'Children');
INSERT INTO SM_Topics(topic_id, topic_name) VALUES (03, 'Science');
INSERT INTO SM_Topics(topic_id, topic_name) VALUES (04, 'Arts');
INSERT INTO SM_Topics(topic_id, topic_name) VALUES (05, 'Travel');
SELECT * FROM SM_Topics;

-- ------------------------------------------------------------------------------------------
-- SM_Authors entity
INSERT INTO SM_Authors(author_id, First_Name, Last_Name, st_address, city, state, zipcode, email) 
VALUES (1001, 'William', 'Shakespeare', '566 st', 'London', 'UK', 56898, 'ws@gmail.com');
INSERT INTO SM_Authors(author_id, First_Name, Last_Name, st_address, city, state, zipcode, email) 
VALUES (1002, 'Rowling', 'J K', '566 st', '4 Privet Drive', 'UK', 56800, 'jkr@gmail.com');
INSERT INTO SM_Authors(author_id, First_Name, Last_Name, st_address, city, state, zipcode, email) 
VALUES (1003, 'Roy', 'Arundathi', '#456, G street', 'Delhi', 'DL', 54621, 'ar@gmail.com');
INSERT INTO SM_Authors(author_id, First_Name, Last_Name, st_address, city, state, zipcode, email) 
VALUES (1004, 'Henry', 'James', '2853 JFK', 'Jersey City', 'NJ', 08556, 'jh@gmail.com');
INSERT INTO SM_Authors(author_id, First_Name, Last_Name, st_address, city, state, zipcode, email) 
VALUES (1005, 'Stephen', 'Hawking', '22nd st', 'London', 'UK', 56008, 'sk@gmail.com');
SELECT * FROM SM_Authors;

-- ------------------------------------------------------------------------------------------
-- SM_Sponsors entity
INSERT INTO SM_Sponsors(sponsor_id, sponsor_type) VALUES (1, 'I');
INSERT INTO SM_Sponsors(sponsor_id, sponsor_type) VALUES (2, 'O');
INSERT INTO SM_Sponsors(sponsor_id, sponsor_type) VALUES (3, 'I');
INSERT INTO SM_Sponsors(sponsor_id, sponsor_type) VALUES (4, 'O');
INSERT INTO SM_Sponsors(sponsor_id, sponsor_type) VALUES (5, 'I');
INSERT INTO SM_Sponsors(sponsor_id, sponsor_type) VALUES (6, 'O');
SELECT * FROM SM_Sponsors;

-- --------------------------------------------------------------------------------------------
-- SM_Reservations entity
INSERT INTO SM_Reservations(reservation_id, cus_id, room_id, reservation_date, time_from, time_to) 
VALUES (1, 5, 11, Date'2021-04-06', STR_TO_DATE('2021-04-06 8:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 10:00:00', '%Y-%m-%d %H:%i:%s'));
INSERT INTO SM_Reservations(reservation_id, cus_id, room_id, reservation_date, time_from, time_to) 
VALUES (2, 1, 31, Date'2021-04-06', STR_TO_DATE('2021-04-06 11:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 13:00:00', '%Y-%m-%d %H:%i:%s'));
INSERT INTO SM_Reservations(reservation_id, cus_id, room_id, reservation_date, time_from, time_to) 
VALUES (3, 2, 25, Date'2021-04-06', STR_TO_DATE('2021-04-06 13:00:00',  '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 15:00:00', '%Y-%m-%d %H:%i:%s'));
INSERT INTO SM_Reservations(reservation_id, cus_id, room_id, reservation_date, time_from, time_to) 
VALUES (4, 3, 11, Date'2021-04-06', STR_TO_DATE('2021-04-06 16:00:00',  '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 18:00:00',  '%Y-%m-%d %H:%i:%s'));
INSERT INTO SM_Reservations(reservation_id, cus_id, room_id, reservation_date, time_from, time_to) 
VALUES (5, 5, 11, Date'2021-04-06', STR_TO_DATE('2021-04-06 11:00:00',  '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 13:00:00',  '%Y-%m-%d %H:%i:%s'));
-- ALTER SESSION SET nls_date_format = 'DD/MON/YYYY hh24:mi:ss';
SELECT * FROM SM_Reservations;

-- --------------------------------------------------------------------------------------------
-- SM_Book
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (1, 1, 'Mughal Dynasty');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (2, 2, 'The Cat in the Hat');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (3, 2, 'The Hobbit');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (4, 3, 'Sapience');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (5, 4, 'Art and Fear');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (6, 5, 'Into the wild');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (7, 3, 'The elegant Universe');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (8, 5, 'The alchemist');
INSERT INTO SM_Book(book_id, topic_id, book_name) 
VALUES (9, 5, 'The travel book');
SELECT * FROM SM_Book;

-- --------------------------------------------------------------------------------------------
-- SM_Book_Copy entity
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (1, 1);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (2, 1);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (3, 1);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (4, 2);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (5, 3);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (6, 3);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (7, 4);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (8, 4);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (9, 4);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (10, 4);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (11, 5);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (12, 6);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (13, 7);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (14, 8);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (15, 9);
INSERT INTO SM_Book_Copy(copy_id, book_id) VALUES (16, 9);
SELECT * FROM SM_Book_Copy;

-- ---------------------------------------------------------------------------------------------
-- SM_Rental entity
ALTER TABLE SM_Rental modify actual_return_date datetime ;
INSERT INTO SM_Rental(rental_id, borrow_date, expected_return_date, cus_id, copy_id) 
VALUES (1, Date'2021-03-01', Date'2021-03-08', 2, 1);
INSERT INTO SM_Rental(rental_id, borrow_date, expected_return_date, cus_id, copy_id) 
VALUES (2, Date'2021-03-01', Date'2021-03-08', 1, 2);
INSERT INTO SM_Rental(rental_id, borrow_date, expected_return_date, cus_id, copy_id) 
VALUES (3, Date'2021-03-02', Date'2021-03-09', 3, 9);
INSERT INTO SM_Rental(rental_id, borrow_date, expected_return_date, cus_id, copy_id) 
VALUES (4, Date'2021-03-03', Date'2021-03-10', 4, 3);
INSERT INTO SM_Rental(rental_id, borrow_date, expected_return_date, cus_id, copy_id) 
VALUES (5, Date'2021-03-11', Date'2021-03-18', 5, 4);
INSERT INTO SM_Rental(rental_id, borrow_date, expected_return_date, cus_id, copy_id) 
VALUES (6, Date'2021-03-09', Date'2021-03-16', 2, 7);
SELECT * FROM SM_Rental;

-- ---------------------------------------------------------------------------------------------
-- SM_Events entity
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (1, 'Climate Change', STR_TO_DATE('2021-04-08 11:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-08 14:00:00', '%Y-%m-%d %H:%i:%s'), 3, 'S');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (2, 'Childhood Obesity', STR_TO_DATE('2021-04-08 15:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-08 18:00:00', '%Y-%m-%d %H:%i:%s'), 2, 'S');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (3, 'Black History Month', STR_TO_DATE('2021-03-12 11:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-03-12 14:00:00', '%Y-%m-%d %H:%i:%s'), 1, 'S');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (4, 'Travel and Living', STR_TO_DATE('2021-04-07 11:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-07 14:00:00', '%Y-%m-%d %H:%i:%s'), 5, 'S');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (5, 'Art & Design', STR_TO_DATE('2021-04-06 10:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 12:00:00', '%Y-%m-%d %H:%i:%s'), 4, 'E');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (6, 'Art & Design-I', STR_TO_DATE('2021-04-06 10:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 12:00:00', '%Y-%m-%d %H:%i:%s'), 4, 'E');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (7, 'Art & Design-II', STR_TO_DATE('2021-04-06 10:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 12:00:00', '%Y-%m-%d %H:%i:%s'), 4, 'E');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (8, 'Art & Design-III', STR_TO_DATE('2021-04-06 10:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 12:00:00', '%Y-%m-%d %H:%i:%s'), 4, 'E');
INSERT INTO SM_Events(event_id, event_Name, event_start_datetime, event_stop_datetime, SM_Topics_topic_id, event_type ) 
VALUES (9, 'Art & Design-IV', STR_TO_DATE('2021-04-06 10:00:00', '%Y-%m-%d %H:%i:%s'), STR_TO_DATE('2021-04-06 12:00:00', '%Y-%m-%d %H:%i:%s'), 4, 'E');

SELECT * FROM SM_Events;

-- ---------------------------------------------------------------------------------------------
-- SM_Seminar entity
INSERT INTO SM_Seminar(event_id) VALUES (1); 
INSERT INTO SM_Seminar(event_id) VALUES (2); 
INSERT INTO SM_Seminar(event_id) VALUES (3); 
INSERT INTO SM_Seminar(event_id) VALUES (4); 
SELECT * FROM SM_Seminar;


-- ---------------------------------------------------------------------------------------------
-- SM_Exhibition entity
INSERT INTO SM_Exhibition(event_id, expenses) VALUES (5, 555); 
INSERT INTO SM_Exhibition(event_id, expenses) VALUES (6, 435); 
INSERT INTO SM_Exhibition(event_id, expenses) VALUES (7, 1000); 
INSERT INTO SM_Exhibition(event_id, expenses) VALUES (8, 1200); 
INSERT INTO SM_Exhibition(event_id, expenses) VALUES (9, 2000); 
SELECT * FROM SM_Exhibition;

-- ---------------------------------------------------------------------------------------------
-- SM_Seminar_Sponsor entity
ALTER TABLE SM_Seminar_Sponsor
ADD CONSTRAINT Seminar_sponsor_id_pk PRIMARY KEY (sponsor_id, event_id);
INSERT INTO SM_Seminar_Sponsor(sponsor_id, event_id, amount) 
VALUES( 1, 1, 5000);
INSERT INTO SM_Seminar_Sponsor(sponsor_id, event_id, amount) 
VALUES( 2, 2, 200);
INSERT INTO SM_Seminar_Sponsor(sponsor_id, event_id, amount) 
VALUES( 3, 3, 4725);
INSERT INTO SM_Seminar_Sponsor(sponsor_id, event_id, amount) 
VALUES( 4, 4, 485);
SELECT * FROM SM_Seminar_Sponsor;

-- ---------------------------------------------------------------------------------------------
-- SM_Individual entity
INSERT INTO SM_Individual(sponsor_id, first_name, last_name) 
VALUES( 3, 'Smith', 'Gallega');
INSERT INTO SM_Individual(sponsor_id, first_name, last_name) 
VALUES( 5, 'Donald', 'Trump');
INSERT INTO SM_Individual(sponsor_id, first_name, last_name) 
VALUES( 1, 'Kamala', 'Harris');
SELECT * FROM SM_Individual;

-- ---------------------------------------------------------------------------------------------
-- SM_Organization entity
INSERT INTO SM_Organization(sponsor_id, org_name) 
VALUES( 2, 'IBM');
INSERT INTO SM_Organization(sponsor_id, org_name) 
VALUES( 4, 'Amazon');
INSERT INTO SM_Organization(sponsor_id, org_name) 
VALUES( 6, 'eBay');
SELECT * FROM SM_Organization;

-- ---------------------------------------------------------------------------------------------
-- SM_Book_Author entity
ALTER TABLE SM_Book_Author
ADD CONSTRAINT Book_Author_id_pk PRIMARY KEY (book_id, author_id);
INSERT INTO SM_Book_Author(book_id, author_id) VALUES (1, 1002);
INSERT INTO SM_Book_Author(book_id, author_id) VALUES (4, 1005);
INSERT INTO SM_Book_Author(book_id, author_id) VALUES (2, 1003);
INSERT INTO SM_Book_Author(book_id, author_id) VALUES (4, 1004);
INSERT INTO SM_Book_Author(book_id, author_id) VALUES (3, 1001);
SELECT * FROM SM_Book_Author;
-----------------------------------------------------------------------------------------------
-- SM_Invitation
INSERT INTO SM_Invitation(Invitation_Id, event_Id, author_Id) VALUES (1, 1, 1003);
INSERT INTO SM_Invitation(Invitation_Id, event_Id, author_Id) VALUES (2, 1, 1001);
INSERT INTO SM_Invitation(Invitation_Id, event_Id, author_Id) VALUES (3, 1, 1002);
INSERT INTO SM_Invitation(Invitation_Id, event_Id, author_Id) VALUES (4, 1, 1004);
INSERT INTO SM_Invitation(Invitation_Id, event_Id, author_Id) VALUES (5, 2, 1003);
INSERT INTO SM_Invitation(Invitation_Id, event_Id, author_Id) VALUES (6, 3, 1005);
INSERT INTO SM_Invitation(Invitation_Id, event_Id, author_Id) VALUES (7, 4, 1003);
SELECT * FROM SM_Invitation;
-- ---------------------------------------------------------------------------------------------

-- SM_Registration entity
INSERT INTO SM_Registration(registration_Id, cus_id, event_id) VALUES (1, 1, 5);
INSERT INTO SM_Registration(registration_Id, cus_id, event_id) VALUES (2, 2, 5);
INSERT INTO SM_Registration(registration_Id, cus_id, event_id) VALUES (3, 3, 5);
INSERT INTO SM_Registration(registration_Id, cus_id, event_id) VALUES (4, 4, 5);
INSERT INTO SM_Registration(registration_Id, cus_id, event_id) VALUES (5, 5, 9);
INSERT INTO SM_Registration(registration_Id, cus_id, event_id) VALUES (6, 6, 9);


UPDATE `library`.`SM_Rental` SET `actual_return_date`='2021-03-07 00:00:00' WHERE `rental_id`='1';
UPDATE `library`.`SM_Rental` SET `actual_return_date`='2021-03-10 00:00:00' WHERE `rental_id`='2';
UPDATE `library`.`SM_Rental` SET `actual_return_date`='2021-03-05 00:00:00' WHERE `rental_id`='3';
select * from SM_Rental;
select * from sm_invoice;


