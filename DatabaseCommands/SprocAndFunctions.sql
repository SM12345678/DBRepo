DELIMITER $$ CREATE PROCEDURE `sproc_rentalListForCustomer`(in custIdparam INT) BEGIN -- Q1 Table joins with at least 3 tables in join: 
select r.rental_id as 'rid',
    u.cus_id as 'cusid',
    b.book_id as 'bookid',
    c.copy_id as 'bokcopyid',
    CASE
        WHEN r.actual_return_date is not null THEN '0'
        WHEN NOW() > r.expected_return_date THEN '1'
        WHEN NOW() <= r.expected_return_date THEN '2'
    END AS 'Status'
from sm_rental r
    inner join sm_book_copy c on r.copy_id = c.copy_id
    inner join sm_book b on c.book_id = b.book_id
    inner join sm_customers u on r.cus_id = u.cus_id
where r.cus_id = custIdparam
order by r.borrow_date desc;
END $$ DELIMITER;
DELIMITER $$ CREATE PROCEDURE `sproc_rentalListForLibrarian`() BEGIN -- Q1 Table joins with at least 3 tables in join: 
select r.rental_id as 'RId',
    u.cus_id as 'cusIid',
    b.book_id as 'bookid',
    c.copy_id as 'BookCopyId',
    CASE
        WHEN r.actual_return_date is not null THEN '0'
        WHEN NOW() > r.expected_return_date THEN '1'
        WHEN NOW() <= r.expected_return_date THEN '2'
    END AS 'Status'
from sm_rental r
    inner join sm_book_copy c on r.copy_id = c.copy_id
    inner join sm_book b on c.book_id = b.book_id
    inner join sm_customers u on r.cus_id = u.cus_id
order by r.borrow_date desc;
END $$ DELIMITER;
-- function to check checkBookAvailabiltyStatus
DELIMITER $$ CREATE DEFINER = `root` @`localhost` FUNCTION `checkBookAvailabiltyStatus`(book_id INT) RETURNS int DETERMINISTIC BEGIN
DECLARE copyid INT;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET copyid = 0;
set copyid = (
        select min(c.copy_id)
        from sm_book b
            join SM_Book_Copy c on b.book_id = c.book_id
        where c.copy_id not in (
                select distinct copy_id
                from sm_rental
                where actual_return_date is null
            )
            and b.book_id = book_id
    );
RETURN copyid;
END $$ DELIMITER;


DELIMITER $$
CREATE PROCEDURE `SM_PROC_BookName_CHANGE`(IN bookidparam int, IN newnameparam varchar(50))
BEGIN
DECLARE  oldnameparam  varchar(50);
select book_name into oldnameparam from sm_book where book_id=bookidparam;
INSERT INTO sm_book_name_hist (book_id,oldname,newname) VALUES(bookidparam,oldnameparam,newnameparam);
END$$
DELIMITER ;