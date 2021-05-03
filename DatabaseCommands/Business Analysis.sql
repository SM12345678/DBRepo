-- Q1 Table joins with at least 3 tables in join: 
select u.email_address as 'Customer Email Address',CONCAT(u.f_name,' ',u.l_name) as 'Customer Full Name',
 b.book_name as 'Book Name',c.copy_id as 'Book Copy Id',r.borrow_date as 'Book Borrowed Date',r.expected_return_date as 'Book Expected Returned Date',
 r.actual_return_date as 'Book Actual Return Date',
CASE
    WHEN r.actual_return_date is not null THEN 'Returned'
    WHEN NOW() > r.expected_return_date THEN 'On Rent - Overdue'
    WHEN NOW() <= r.expected_return_date  THEN 'On Rent - Not Overdue'
    END AS 'Rental Status'
from sm_rental r 
inner join sm_book_copy c on r.copy_id=c.copy_id 
inner join sm_book b on c.book_id=b.book_id 
inner join sm_customers u on r.cus_id=u.cus_id order by r.borrow_date desc;



-- Q2)Multi-row subquery:

select e.event_id as 'Event Id',e.event_name as "Event Name",e.event_start_datetime as "Event Start Datetime",
e.event_stop_datetime as "Event Stop Datetime",T.topic_name as "Topic Name" 
from (
select * from sm_events where event_id 
in 
(SELECT e.event_id FROM sm_registration as r right outer join sm_exhibition  as e on r.event_id=e.event_id
 group by e.event_id having count(*) >100)) as e inner join sm_topics as T on e.topic_id=T.topic_id;
 
 

-- Q3) Correlated subquery 

Select r.room_id as "Room Id",r.room_capacity as "Room Capacity" from sm_study_room r where exists 
(select * from sm_reservations where room_id=r.room_id and (reservation_date <= now() and reservation_date >= DATE_SUB(NOW(), INTERVAL 1 MONTH)) );
  



-- Q4) SET operator query:
select sponsor_id as 'Id',T.Type, org_name as 'Name' from sm_organization,(select 'Organization' as "Type" from dual) as T
where sponsor_id not in (SELECT sponsor_id FROM SM_Seminar_Sponsor) 
union 
select sponsor_id as 'Id',T.Type,CONCAT(first_name," ",last_name) as 'Name' from sm_individual,(select 'Individual' as "Type" from dual) as T
where sponsor_id not in (SELECT sponsor_id FROM SM_Seminar_Sponsor) order by Id;



-- Q5) Query with in line view or WITH clause
with sm_view_rental_payment as
(select a.rental_id,a.invoice_id, a.invoice_amount,COALESCE(sum(b.payment_amount),0) as 'aumout_paid',
(a.invoice_amount - COALESCE(sum(b.payment_amount),0)) as "amount_owed" from sm_invoice a left outer join sm_payment b on a.invoice_id=b.invoice_id
group by a.rental_id)
select b.rental_id  as 'Rental Id',a.cus_id as 'Customer Id',CONCAT(a.f_name,' ',a.l_name) as 'Customer Full Name',a.email_address as "Customer Email Address",
d.invoice_amount as "Total Invoice Amount",d.aumout_paid as "Total Amount Paid",d.amount_owed as "Total Amount Owed"
from sm_customers a join sm_Rental b on a.cus_id=b.cus_id
join sm_view_rental_payment d on d.rental_id=b.rental_id
order by CONCAT(a.f_name,' ',a.l_name);



-- Q6) TOP-N query                  

WITH AuthorRank
AS (     
Select e.author_id as "Author Id" , CONCAT(e.First_Name," ",e.Last_Name) as 'Author Full Name',
e.email as "Author Email",count(b.rental_id) as 'Number of Copies Got Rented',
rank () over (order by count(b.rental_id) desc) as authorRank
	 from sm_Book_Copy a 
     join sm_rental b on a.copy_id=b.copy_id
     join sm_Book c on a.book_id=c.book_id
     join sm_Book_Author d on d.book_id=c.book_id
     join sm_Authors e on d.author_id=e.author_id where  (borrow_date <= now() and borrow_date >= DATE_SUB(NOW(), INTERVAL 6 MONTH)) group by e.author_id)
     select * from AuthorRank where authorRank<3
     

