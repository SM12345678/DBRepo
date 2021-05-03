

--  SQLINES DEMO *** stomers to ensure:  valid id type is one of Passport, SSN, or Driver License:  

alter table sm_customers  add constraint C_sm_customers_id_type check (LOWER(id_type) in ('passport', 'ssn', 'driver license')); 

--  SQLINES DEMO *** _payment to ensure:  payment method type is one of  Cash, Credit, Debit or PayPal:  

alter table sm_payment  add constraint C_sm_payment_payment_method check (LOWER(payment_method) in ('cash', 'credit', 'debit', 'paypal')); 


--  SQLINES DEMO *** _payment to ensure:  card holder name is not null for payment mentod in Credit, Debit or PayPal:  

alter table sm_payment  add constraint C_sm_payment_card_holder_name_notnull
check ( (LOWER(payment_method) in ('cash', 'credit', 'debit', 'paypal') and card_holder_name is not null) or 
 (LOWER(payment_method) = 'cash' and card_holder_name is null) ); 


--  SQLINES DEMO *** reservations to ensure: reservation start time is not greater than reservation end time and reservation’s  time slot for a particular date must fall in following four intervals : 8 AM to 10 AM, 11 AM to 1 PM, 1 PM to 3 PM and 4 PM to 6 PM. 

ALTER TABLE sm_reservations ADD CONSTRAINT C_sm_reservations_time_from_time_to CHECK(time_from <= time_to); 

ALTER TABLE sm_reservations ADD CONSTRAINT C_sm_reservations_time_in_range CHECK(
((DATE_FORMAT(time_from, "%H%i") between TIME_FORMAT('7:59:00','%H%i') and TIME_FORMAT('10:01:00','%H%i')) and (DATE_FORMAT(time_to, '%H%i') between TIME_FORMAT('7:59:00','%H%i') and TIME_FORMAT('10:01:00','%H%i'))) or 

((DATE_FORMAT(time_from, "%H%i") between TIME_FORMAT('10:59:00','%H%i') and TIME_FORMAT('13:01:00','%H%i')) and (DATE_FORMAT(time_to, '%H%i') between TIME_FORMAT('10:59:00','%H%i') and TIME_FORMAT('13:01:00','%H%i'))) or 

((DATE_FORMAT(time_from, "%H%i") between TIME_FORMAT('12:59:00','%H%i') and TIME_FORMAT('15:01:00','%H%i')) and (DATE_FORMAT(time_to, '%H%i') between TIME_FORMAT('12:59:00','%H%i') and TIME_FORMAT('15:01:00','%H%i'))) or 

((DATE_FORMAT(time_from, "%H%i") between TIME_FORMAT('15:59:00','%H%i') and TIME_FORMAT('18:01:00','%H%i')) and (DATE_FORMAT(time_to, '%H%i') between TIME_FORMAT('15:59:00','%H%i') and TIME_FORMAT('18:01:00','%H%i')))
); 

