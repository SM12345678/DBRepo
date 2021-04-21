use library;

CREATE TABLE sm_authors (
    author_id   INT NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT 'This is author unique id.',
    first_name  VARCHAR(30) NOT NULL COMMENT 'First name of the author',
    last_name   VARCHAR(30) NOT NULL COMMENT 'Last name of the author',
    st_address  VARCHAR(50) NOT NULL COMMENT 'This is author street component of address.',
    city        VARCHAR(30) NOT NULL COMMENT 'This is author city component of address.',
    state       VARCHAR(2) NOT NULL COMMENT 'This is author state component of address.',
    zipcode     VARCHAR(5) NOT NULL COMMENT 'This is author zipcode component of address.',
    email       VARCHAR(100) NOT NULL COMMENT 'This is author email address.'
);



CREATE TABLE sm_book (
    topic_id   TINYINT NOT NULL COMMENT 'This is topic id for the given book.',
    book_id    INT NOT NULL  PRIMARY KEY AUTO_INCREMENT COMMENT 'This is unique book id for the given book.',
    book_name  VARCHAR(50) NOT NULL COMMENT 'This is book name for the given book.'
);



CREATE TABLE sm_book_author (
    book_id    INT NOT NULL COMMENT 'This is book id for given author id.',
    author_id  INT NOT NULL
);



CREATE TABLE sm_book_copy (
    copy_id  INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is unique copy id for the given book.',
    book_id  INT NOT NULL
);



CREATE TABLE sm_customers (
    cus_id         BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is customer id',
    id_type        VARCHAR(30) NOT NULL COMMENT 'This is customer id type',
    id_number      VARCHAR(30) NOT NULL COMMENT 'Identification number of a given ID type',
    full_name      VARCHAR(30) NOT NULL COMMENT 'This customer full name.',
    phone_number   BIGINT NOT NULL COMMENT 'This is customer phone number.',
    email_address  VARCHAR(100) NOT NULL COMMENT 'This is customer email address.'
);



CREATE TABLE sm_events (
    event_id              INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is event unique id.',
    event_name            VARCHAR(50) NOT NULL COMMENT 'This is event name.',
    event_start_datetime  DATETIME NOT NULL COMMENT 'This is event start date with time.',
    event_stop_datetime   DATETIME NOT NULL COMMENT 'This is event stop date with time.',
    sm_topics_topic_id    TINYINT NOT NULL COMMENT 'This is unique topic id.',
    event_type            CHAR(1) NOT NULL COMMENT 'This is event type.'
);
ALTER TABLE sm_events
    ADD CONSTRAINT ch_inh_sm_events CHECK ( event_type IN ( 'E', 'S' ) );



CREATE TABLE sm_exhibition (
    event_id  INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is event unique id.',
    expenses  DECIMAL(7, 2) NOT NULL COMMENT 'This is exhibition expenses.'
);



CREATE TABLE sm_individual (
    sponsor_id  INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
    first_name  VARCHAR(30) NOT NULL,
    last_name   VARCHAR(30) NOT NULL
);



/* updated datatype*/ 
CREATE TABLE sm_invitation (
    invitation_id  INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is seminar invitation id.',
    event_id       INT NOT NULL,
    author_id      INT NOT NULL
);



CREATE TABLE sm_invoice (
    invoice_id      INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is invoice id for the given book rental by a customer.',
    invoice_date    DATETIME NOT NULL COMMENT 'This is invoice generation date for the given book rental by a customer.',
    invoice_amount  DECIMAL(7, 2) NOT NULL COMMENT 'This is invoice  amount for the given book rental by a customer.',
    rental_id       INT NOT NULL
);



CREATE UNIQUE INDEX sm_invoice__idx ON
    sm_invoice (
        rental_id
    ASC );



CREATE TABLE sm_organization (
    sponsor_id  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    org_name    VARCHAR(40) NOT NULL
);



CREATE TABLE sm_payment (
    payment_id        INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is the invoice payment id for the given book rental by a customer.',
    invoice_id        INT NOT NULL COMMENT 'This is the invoice id for the given book rental by a customer.',
    payment_date      DATETIME NOT NULL COMMENT 'This is the invoice payment date for the given book rental by a customer.',
    card_holder_name  VARCHAR(16) NOT NULL COMMENT 'This is the invoice payment''s cardholder name for the given book rental by a customer.',
    payment_amount    DECIMAL(7, 2) NOT NULL COMMENT 'This is the invoice payment amount for the given book rental by a customer.',
    payment_method    VARCHAR(50) NOT NULL COMMENT 'This is the invoice payment method for the given book rental by a customer.'
);



CREATE TABLE sm_registration (
    registration_id  INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is exhibition registration id.',
    cus_id           BIGINT NOT NULL COMMENT 'This is event customer id.',
    event_id         INT NOT NULL COMMENT 'This is exhibition event id.'
);



CREATE TABLE sm_rental (
    rental_id             INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary key of SM_Rental entity',
    borrow_date           DATETIME NOT NULL COMMENT 'This is borrow date for the given book rental by a customer.',
    expected_return_date  DATETIME NOT NULL COMMENT 'This is expected return date for the given book rental by a customer.',
    actual_return_date    DATETIME NOT NULL COMMENT 'This is actual return date for the given book rental by a customer.',
    cus_id                BIGINT NOT NULL COMMENT 'This is customer id for the given book rental by a customer.',
    copy_id               INT NOT NULL
);



CREATE TABLE sm_reservations (
    reservation_id    INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is study room reservation id',
    cus_id            BIGINT NOT NULL,
    room_id           SMALLINT NOT NULL,
    reservation_date  DATETIME NOT NULL COMMENT 'This is study room reservation date',
    time_from         DATETIME NOT NULL COMMENT 'This is study room reservation time from.',
    time_to           DATETIME NOT NULL COMMENT 'This is study room reservation time to.'
);



CREATE TABLE sm_seminar (
    event_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is event unique id.'
);



CREATE TABLE sm_seminar_sponsor (
    sponsor_id  INT NOT NULL,
    event_id    INT NOT NULL,
    amount      BIGINT NOT NULL
);

CREATE TABLE sm_sponsors (
    sponsor_id    INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
    sponsor_type  CHAR(1) NOT NULL
);
ALTER TABLE sm_sponsors
    ADD CONSTRAINT ch_inh_sm_sponsors CHECK ( sponsor_type IN ( 'I', 'O' ) );



CREATE TABLE sm_study_room (
    room_id        SMALLINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is study room id.',
    room_capacity  SMALLINT NOT NULL COMMENT 'This is study room capacity.'
);



CREATE TABLE sm_topics (
    topic_id    TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is topic unique id.',
    topic_name  VARCHAR(30) NOT NULL COMMENT 'This is topic name.'
);



ALTER TABLE sm_book_author
    ADD CONSTRAINT sm_book_author_sm_authors_fk FOREIGN KEY ( author_id )
        REFERENCES sm_authors ( author_id );

ALTER TABLE sm_book_author
    ADD CONSTRAINT sm_book_author_sm_book_fk FOREIGN KEY ( book_id )
        REFERENCES sm_book ( book_id );

ALTER TABLE sm_book_copy
    ADD CONSTRAINT sm_book_copy_sm_book_fk FOREIGN KEY ( book_id )
        REFERENCES sm_book ( book_id );

ALTER TABLE sm_book
    ADD CONSTRAINT sm_book_sm_topics_fk FOREIGN KEY ( topic_id )
        REFERENCES sm_topics ( topic_id );
        
        

ALTER TABLE sm_events
    ADD CONSTRAINT sm_events_sm_topics_fk FOREIGN KEY ( sm_topics_topic_id )
        REFERENCES sm_topics ( topic_id );

ALTER TABLE sm_exhibition
    ADD CONSTRAINT sm_exhibition_sm_events_fk FOREIGN KEY ( event_id )
        REFERENCES sm_events ( event_id );

ALTER TABLE sm_individual
    ADD CONSTRAINT sm_individual_sm_sponsors_fk FOREIGN KEY ( sponsor_id )
        REFERENCES sm_sponsors ( sponsor_id );

ALTER TABLE sm_invitation
    ADD CONSTRAINT sm_invitation_sm_authors_fk FOREIGN KEY ( author_id )
        REFERENCES sm_authors ( author_id );

ALTER TABLE sm_invitation
    ADD CONSTRAINT sm_invitation_sm_seminar_fk FOREIGN KEY ( event_id )
        REFERENCES sm_seminar ( event_id );

ALTER TABLE sm_invoice
    ADD CONSTRAINT sm_invoice_sm_rental_fk FOREIGN KEY ( rental_id )
        REFERENCES sm_rental ( rental_id );

ALTER TABLE sm_organization
    ADD CONSTRAINT sm_organization_sm_sponsors_fk FOREIGN KEY ( sponsor_id )
        REFERENCES sm_sponsors ( sponsor_id );

ALTER TABLE sm_payment
    ADD CONSTRAINT sm_payment_sm_invoice_fk FOREIGN KEY ( invoice_id )
        REFERENCES sm_invoice ( invoice_id );

ALTER TABLE sm_registration
    ADD CONSTRAINT sm_reg_sm_cust_fk FOREIGN KEY ( cus_id )
        REFERENCES sm_customers ( cus_id );

ALTER TABLE sm_registration
    ADD CONSTRAINT sm_reg_sm_exh_fk FOREIGN KEY ( event_id )
        REFERENCES sm_exhibition ( event_id );

ALTER TABLE sm_rental
    ADD CONSTRAINT sm_rental_sm_book_copy_fk FOREIGN KEY ( copy_id )
        REFERENCES sm_book_copy ( copy_id );

ALTER TABLE sm_rental
    ADD CONSTRAINT sm_rental_sm_customers_fk FOREIGN KEY ( cus_id )
        REFERENCES sm_customers ( cus_id );

ALTER TABLE sm_reservations
    ADD CONSTRAINT sm_res_sm_cust_fk FOREIGN KEY ( cus_id )
        REFERENCES sm_customers ( cus_id );

ALTER TABLE sm_reservations
    ADD CONSTRAINT sm_res_sm_stdy_rm_fk FOREIGN KEY ( room_id )
        REFERENCES sm_study_room ( room_id );

ALTER TABLE sm_seminar_sponsor
    ADD CONSTRAINT sm_sem_spons_sm_sem_fk FOREIGN KEY ( event_id )
        REFERENCES sm_seminar ( event_id );

ALTER TABLE sm_seminar_sponsor
    ADD CONSTRAINT sm_sem_spons_sm_spons_fk FOREIGN KEY ( sponsor_id )
        REFERENCES sm_sponsors ( sponsor_id );

ALTER TABLE sm_seminar
    ADD CONSTRAINT sm_seminar_sm_events_fk FOREIGN KEY ( event_id )
        REFERENCES sm_events ( event_id );






DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_18_sm_individual_insert $$

CREATE TRIGGER arc_fkarc_18_sm_individual_insert
BEFORE  Insert
ON sm_individual FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
     SELECT
        sponsor_type
    INTO d
    FROM
        sm_sponsors 
    WHERE
        sponsor_id = NEW.sponsor_id;
        
        IF ( d IS NULL OR d <> 'I' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Individual_SM_Sponsors_FK in Table SM_Individual violates Arc constraint on Table SM_Sponsors - discriminator column sponsor_type doesn''t have value ''I''';
        end if;
    
    -- statements
END$$


DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_18_sm_individual_update $$

CREATE TRIGGER arc_fkarc_18_sm_individual_update
BEFORE  Update
ON sm_individual FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
     SELECT
        sponsor_type
    INTO d
    FROM
        sm_sponsors 
    WHERE
        sponsor_id = NEW.sponsor_id;
        
        IF ( d IS NULL OR d <> 'I' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Individual_SM_Sponsors_FK in Table SM_Individual violates Arc constraint on Table SM_Sponsors - discriminator column sponsor_type doesn''t have value ''I''';
        end if;
    
    -- statements
END$$

-- ----------------------------------------------------------------------------------------

DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_18_sm_organization_insert $$

CREATE TRIGGER arc_fkarc_18_sm_organization_insert
BEFORE  Insert
ON sm_organization FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
     SELECT
        sponsor_type
    INTO d
    FROM
        sm_sponsors 
    WHERE
        sponsor_id = NEW.sponsor_id;
        
        IF ( d IS NULL OR d <> 'O' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Organization_SM_Sponsors_FK in Table SM_Organization violates Arc constraint on Table SM_Sponsors - discriminator column sponsor_type doesn''t have value ''O''';
        end if;
    
    -- statements
END$$


DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_18_sm_organization_update $$

CREATE TRIGGER arc_fkarc_18_sm_organization_update
BEFORE  Update
ON sm_organization FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
     SELECT
        sponsor_type
    INTO d
    FROM
        sm_sponsors 
    WHERE
        sponsor_id = NEW.sponsor_id;
        
        IF ( d IS NULL OR d <> 'O' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Organization_SM_Sponsors_FK in Table SM_Organization violates Arc constraint on Table SM_Sponsors - discriminator column sponsor_type doesn''t have value ''O''';
        end if;
    
    -- statements
END$$

-- ----------------------------------------------------------------------------------------

DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_17_sm_seminar_insert $$

CREATE TRIGGER arc_fkarc_17_sm_seminar_insert
BEFORE  Insert
ON sm_seminar FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
 SELECT
        event_type
    INTO d
    FROM
        sm_events 
    WHERE
        event_id = new.event_id;
        
        IF ( d IS NULL OR d <> 'S' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Seminar_SM_Events_FK in Table SM_Seminar violates Arc constraint on Table SM_Events - discriminator column event_type doesn''t have value ''S''';
        end if;
    
    -- statements
END$$


DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_17_sm_seminar_update $$

CREATE TRIGGER arc_fkarc_17_sm_seminar_update
BEFORE  Insert
ON sm_seminar FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
 SELECT
        event_type
    INTO d
    FROM
        sm_events 
    WHERE
        event_id = new.event_id;
        
        IF ( d IS NULL OR d <> 'S' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Seminar_SM_Events_FK in Table SM_Seminar violates Arc constraint on Table SM_Events - discriminator column event_type doesn''t have value ''S''';
        end if;
    
    -- statements
END$$

-- ----------------------------------------------------------------------------------------
DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_17_sm_exhibition_insert $$

CREATE TRIGGER arc_fkarc_17_sm_exhibition_insert
BEFORE  Insert
ON sm_exhibition FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
 SELECT
        event_type
    INTO d
    FROM
        sm_events 
    WHERE
        event_id = new.event_id;
        
        IF ( d IS NULL OR d <> 'E' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Exhibition_SM_Events_FK in Table SM_Exhibition violates Arc constraint on Table SM_Events - discriminator column event_type doesn''t have value ''E''';
        end if;
    
    -- statements
END$$


DELIMITER $$
DROP TRIGGER IF EXISTS arc_fkarc_17_sm_exhibition_update $$

CREATE TRIGGER arc_fkarc_17_sm_exhibition_update
BEFORE  Insert
ON sm_exhibition FOR EACH ROW 
BEGIN
	DECLARE d char(1);
    
 SELECT
        event_type
    INTO d
    FROM
        sm_events 
    WHERE
        event_id = new.event_id;
        
        IF ( d IS NULL OR d <> 'E' ) THEN
			signal sqlstate '20223' set message_text =  'FK SM_Exhibition_SM_Events_FK in Table SM_Exhibition violates Arc constraint on Table SM_Events - discriminator column event_type doesn''t have value ''E''';
        end if;
    
    -- statements
END$$

-- ----------------------------------------------------------------------------------------

DELIMITER $$
DROP TRIGGER IF EXISTS tu_SM_invoice $$

CREATE TRIGGER tu_SM_invoice
 before UPDATE 
 ON SM_Rental FOR EACH ROW
BEGIN

DECLARE  invoice_amount float;

if (new.actual_return_date IS NOT NULL 
	AND new.actual_return_date<>old.actual_return_date) then
	 IF (new.actual_return_date<=new.expected_return_date) THEN
		set invoice_amount = ( DATEDIFF(new.actual_return_date,new.BORROW_DATE)*0.2);
	 ELSE
		set invoice_amount= (DATEDIFF(new.expected_return_date,new.BORROW_DATE)*0.2 +
										DATEDIFF(new.actual_return_date,new.expected_return_date)*0.4);
	 END IF;
	 INSERT INTO SM_Invoice(Invoice_amount, rental_id, invoice_date)
	 values (cast(invoice_amount as decimal(7,2)), new.rental_id , now());
end if;
END$$
